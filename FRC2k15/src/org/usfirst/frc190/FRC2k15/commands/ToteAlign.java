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
import org.usfirst.frc190.FRC2k15.Components.VoiceCmds;

/**
 * Automatically aligns to a tote in preparation for pickup.
 */
public class ToteAlign extends Command {
	private boolean finished = false; // controls when command is finished
	/*
	 * 0 is neither switch pressed 1 is left switch pressed right not 2 is right
	 * switch pressed left not 3 is both pressed check which ir sensors are
	 * within range 4 is left ir within range right not 5 is right ir within
	 * range left not 6 is both ir in range align complete
	 */
	private final double drivespeed = -0.125;
	private final double rotatespeed = 0.125;
	private final double strafespeed = 0.1;
	public ToteAlign() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drivetrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		finished = false;
		VoiceCmds.speak(VoiceCmds.d_alignTote);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if(Robot.drivetrain.getLeftBumper()&&Robot.drivetrain.getRightBumper()){
			if(Robot.drivetrain.getLeftIRWithinRange()&&Robot.drivetrain.getRightIRWithinRange())
				finished = true;//Illogical 
			else if(Robot.drivetrain.getLeftIRWithinRange())
				Robot.drivetrain.MecanumDrive(strafespeed, 0, 0, 0);//strafe to left
			else if(Robot.drivetrain.getRightIRWithinRange())
				Robot.drivetrain.MecanumDrive(-strafespeed, 0, 0, 0);//strafe to right
		}
		else if(Robot.drivetrain.getLeftBumper())
			Robot.drivetrain.MecanumDrive(0, 0, -rotatespeed, 0);//rotate to left
		else if(Robot.drivetrain.getRightBumper())
			Robot.drivetrain.MecanumDrive(0, 0, rotatespeed, 0);//rotate to right
		else 
			Robot.drivetrain.MecanumDrive(0, drivespeed, 0, 0);//drive forwards
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
