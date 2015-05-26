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
import org.usfirst.frc190.FRC2k15.Components.LimitedPIDSubsystemSetpointCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTotePickupWideDriving extends CommandGroup {
    
    public  AutoTotePickupWideDriving() {
//    	addSequential(new LimitedPIDSubsystemSetpointCommand(Robot.chainsaw4Bar, Robot.chainsaw4Bar.alignPosition, 0.2, -0.2, false));
    	addSequential(new LimitedPIDSubsystemSetpointCommand(Robot.chainsaw4Bar, Robot.chainsaw4Bar.toteAlignPosition, 0.2, -0.2, false));
    	addSequential(new RegularDriveToLimit());
    	addSequential(new ToteAlignNoIR());
//    	addSequential(new LimitedPIDSubsystemSetpointCommand(Robot.chainsaw4Bar, Robot.chainsaw4Bar.collectPositionWide, 0.2, -0.2, false));
    	addSequential(new LimitedPIDSubsystemSetpointCommand(Robot.chainsaw4Bar, Robot.chainsaw4Bar.totePickupPosition, 0.2, -0.2, false));
    	addParallel(new DriveSpeed(-0.05, 1.0));
    	addSequential(new IncreaseChainsawPosition());
//    	addSequential(new Delay(0.5));
    	addSequential(new LimitedPIDSubsystemSetpointCommand(Robot.chainsaw4Bar, Robot.chainsaw4Bar.toteAlignPosition, 0.2, -0.2, false));
    }
}