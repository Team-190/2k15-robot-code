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

import org.usfirst.frc190.FRC2k15.Robot;
import org.usfirst.frc190.FRC2k15.Components.VoiceCmds;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTurn extends Command {

	private double timeout = 3;

	private double Degrees = 0;
	private double tolerance = 2;
	private double error;
	private double Kp = 0.05;

	public DriveTurn() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		setTimeout(timeout);

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drivetrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	public DriveTurn(double inDegrees) {
		setTimeout(timeout);

		Degrees = inDegrees;

		requires(Robot.drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.drivetrain.resetGyro();
		VoiceCmds.speak(VoiceCmds.a_d_turning);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		error = Kp * (Degrees - Robot.drivetrain.getHeading());

		Robot.drivetrain.MecanumDrive(0, 0, error, 0);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut()
				|| Math.abs(Degrees - Robot.drivetrain.getHeading()) <= tolerance;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.resetGyro();
		Robot.drivetrain.MecanumDrive(0, 0, 0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

}
