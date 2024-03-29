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
 *
 */
public class  ChainsawManualUp extends Command {
	
	private final double motorSpeed = 0.5;

    public ChainsawManualUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chainsaw);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chainsaw.disable();//bypassing the PID system so need to disable
    	VoiceCmds.speak(VoiceCmds.c_m_raiseChainsaw);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chainsaw.setSpeed(motorSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return  Robot.chainsaw.isBroken();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chainsaw.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
