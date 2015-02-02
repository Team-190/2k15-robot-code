// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc190.FRC2k15.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc190.FRC2k15.Robot;
import org.usfirst.frc190.FRC2k15.RobotMap;

/**
 * Automatically aligns to a tote in preparation for pickup.
 */
public class ToteAlign extends Command {
	private boolean finished = false; // controls when command is finished
	private byte state = 0;
	/*
	 * 0 is neither switch pressed 1 is left switch pressed right not 2 is right
	 * switch pressed left not 3 is both pressed check which ir sensors are
	 * within range 4 is left ir within range right not 5 is right ir within
	 * range left not 6 is both ir in range align complete
	 */
	private final double drivespeed = -0.05;
	private final double rotatespeed = 0.05;
	private final double strafespeed = 0.05;

	public ToteAlign() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drivetrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		setLimitState();
		finished = false;
	}

	private void setLimitState() { // sets state based on pressed limit switches
		if (Robot.drivetrain.getLeftBumper()) {
			if (Robot.drivetrain.getRightBumper()) {
				state = 3;
			} else
				state = 1;
		} else if (Robot.drivetrain.getRightBumper()) {
			state = 2;
		} else {
			state = 0;
		}
	}

	private void setIRState() {// sets state based on triggered ir sensors
		if (Robot.drivetrain.getLeftIRWithinRange()) {
			if (Robot.drivetrain.getRightIRWithinRange()) {
				state = 6;
			} else
				state = 4;
		} else if (Robot.drivetrain.getRightIRWithinRange()) {
			state = 5;
		} else
			state = 3; // if this happens kind of an issue
		// (means bumpers pressed but tote detected by both ir)
		// might later replace with displaying info to driverstation so drivers
		// know there is an error

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putNumber("Tote Align State", state);
		if (Robot.oi.toteAlignInterupt.get()) {// cancels this command
			finished = true;
		}
		switch (state) {
		case 0:// not on switches drive forwards
			Robot.drivetrain.MecanumDrive(0.0, drivespeed, 0, 0);
			setLimitState();
			break;
		case 1:// left switch pressed right not
			Robot.drivetrain.MecanumDrive(0, 0, -rotatespeed,// turn to hit
																// right switch
					RobotMap.drivetrainGyro.getAngle());
			setLimitState();
			break;
		case 2:// right switch pressed left not
			Robot.drivetrain.MecanumDrive(0, 0, rotatespeed, // turn to hit left
																// switch
					RobotMap.drivetrainGyro.getAngle());
			setLimitState();
			break;
		case 3: // both switches pressed check IR states
			Robot.drivetrain.MecanumDrive(0, 0, 0, 0);
			setIRState();
			break;
		case 4: // left ir clear of tote right not move to right
			Robot.drivetrain.MecanumDrive(strafespeed, 0, 0, 0);
			setIRState();
			break;
		case 5: // right ir clear of tote left not move to left
			Robot.drivetrain.MecanumDrive(-strafespeed, 0, 0, 0);
			setIRState();
			break;
		case 6: // both ir clear of tote finished
			finished = true;
			break;
		default: // should never occur but just in case end the command
			finished = true;
			break;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.MecanumDrive(0, 0, 0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
