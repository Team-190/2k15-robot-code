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

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class  TineElevatorBottom extends Command {
	
	// Leave this true is you want the robot to hold the position
	// after the command ends
	private boolean holdPosition = true;

    public TineElevatorBottom() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.tineElevator);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=INITIALIZE
        Robot.tineElevator.enable();
        Robot.tineElevator.setSetpoint(0.0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=INITIALIZE
        Robot.tineElevator.setSetpoint(Robot.tineElevator.bottomPosition); 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.tineElevator.onTarget() || Robot.tineElevator.getTopLimit() || Robot.tineElevator.getLowerLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
    	s
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.tineElevator.disable();
    }
}
