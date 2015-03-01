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
import org.usfirst.frc190.FRC2k15.Components.VoiceCmds;

/**
 *
 */
public class  IncreaseChainsawPosition extends Command {

    public IncreaseChainsawPosition() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chainsaw);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	if(Robot.chainsaw.isBroken()){
    		Robot.chainsaw.incrementHookPosition();
//    	}
    	
    	VoiceCmds.speak(VoiceCmds.c_increasePosn);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.chainsaw.onTarget(); // || Robot.chainsaw.isBroken();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.chainsaw.disable();
    }
}
