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
public class  TinesManualUp extends Command {

	private final double motorSpeed = 0.6;

    public TinesManualUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.tineElevator);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.tineElevator.disable();//bypassing the PID system so need to disable
    	//TODO: this needs to be updated
    	//VoiceCmds.speak(VoiceCmds.c_m_raiseChainsaw);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!Robot.tineElevator.getLowerLimit()){
    		Robot.tineElevator.setSpeed(motorSpeed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.tineElevator.getLowerLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.tineElevator.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}