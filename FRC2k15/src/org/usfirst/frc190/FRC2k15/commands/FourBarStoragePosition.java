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
public class  FourBarStoragePosition extends Command {
	
	private boolean holdPosition = false;

    public FourBarStoragePosition() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chainsaw4Bar);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

 // Called just before this Command runs the first time
    protected void initialize() {
    	//TODO: Better Implementation
    	//This bit of code drives the fourbar away from the softstops so PID doesn't fail automatically
    	Robot.chainsaw4Bar.disable();
        while(Robot.chainsaw4Bar.getExtended()){
            Robot.chainsaw4Bar.setSpeed(0.2);
        }
        while(Robot.chainsaw4Bar.getRetracted()){
            Robot.chainsaw4Bar.setSpeed(-0.2);
        }
        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=INITIALIZE
        Robot.chainsaw4Bar.enable();
        Robot.chainsaw4Bar.setSetpoint(0.5);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=INITIALIZE
        Robot.chainsaw4Bar.setSetpoint(Robot.chainsaw4Bar.storagePosition);
        VoiceCmds.speak(VoiceCmds.f_storingPosn);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
        return Robot.chainsaw4Bar.onTarget();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(Robot.chainsaw4Bar.getExtended() || Robot.chainsaw4Bar.getRetracted() || !holdPosition){
    		Robot.chainsaw4Bar.disable();
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.chainsaw4Bar.disable();
    }
}
