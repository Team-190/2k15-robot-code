package org.usfirst.frc190.FRC2k15.commands;

import org.usfirst.frc190.FRC2k15.Components.VoiceCmds;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Speak extends Command {
private byte speak_cmd;
    public Speak(byte cmd){
    	speak_cmd = cmd;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	VoiceCmds.speak(speak_cmd);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
