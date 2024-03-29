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
 *Causes chainsaw to drop and deliver stack
 */
public class  ChainsawDeliverStackPosition extends Command {

    public ChainsawDeliverStackPosition() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chainsaw);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=INITIALIZE
        Robot.chainsaw.enable();
        Robot.chainsaw.setSetpoint(1.0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=INITIALIZE
        Robot.chainsaw.setSetpoint(Robot.chainsaw.getSetpoint() - Robot.chainsaw.deliveryOffset);
        VoiceCmds.speak(VoiceCmds.c_deliverStack);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
        return Robot.chainsaw.onTarget();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
