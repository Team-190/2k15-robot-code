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
import org.usfirst.frc190.FRC2k15.Robot;

/**
 *
 */

public class RegularDrive extends Command {

	public RegularDrive() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		requires(Robot.drivetrain);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		double xSpeed;
		double ySpeed;
		double rSpeed;
		double heading = Robot.drivetrain.getHeading();

		switch (Robot.drivetrain.getDrivingMode()) {
		case 0:
			xSpeed = Robot.oi.driveJoystick.getX();
			ySpeed = Robot.oi.driveJoystick.getY();
			rSpeed = Robot.oi.driveJoystick.getZ();
			break;

		case 1:
			xSpeed = Robot.oi.driveJoystick.getX();
			ySpeed = Robot.oi.driveJoystick.getY();
			rSpeed = Robot.oi.secondaryJoystick.getX();
			break;

		case 2:
			xSpeed = Robot.oi.driveJoystick.getX();
			ySpeed = Robot.oi.driveJoystick.getY();
			rSpeed = Robot.oi.secondaryJoystick.getY();
			break;

		case 3:
			xSpeed = Robot.oi.driveJoystick.getX();
			ySpeed = Robot.oi.driveJoystick.getY();
			rSpeed = Robot.oi.secondaryJoystick.getZ();
			break;

		default:
			xSpeed = Robot.oi.driveJoystick.getX();
			ySpeed = Robot.oi.driveJoystick.getY();
			rSpeed = Robot.oi.driveJoystick.getZ();
			break;
		}

		if (Robot.drivetrain.isSquaredInputs()) {
			xSpeed = Math.pow(Math.abs(xSpeed), 2) * Math.signum(xSpeed);
			ySpeed = Math.pow(Math.abs(ySpeed), 2) * Math.signum(ySpeed);
			rSpeed = Math.pow(Math.abs(rSpeed), 2) * Math.signum(rSpeed);
		}

		if (Robot.drivetrain.isFieldOriented()) {
			heading = 0;
		}

		Robot.drivetrain.MecanumDrive(xSpeed, ySpeed, rSpeed, heading);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

}
