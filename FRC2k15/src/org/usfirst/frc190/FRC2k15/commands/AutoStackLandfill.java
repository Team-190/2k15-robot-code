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
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoStackLandfill extends CommandGroup {
    
    public  AutoStackLandfill() {

    	
    	
    	
    	addSequential(new ResetChainsaw());
// Wide tote pickup   	
    	addSequential(new AutoTotePickupWide());
// Increases the chainsaw position by one setpoint
    	addSequential(new IncreaseChainsawPosition());
// Aligns to wide tote but does not pickup
    	addSequential(new ToteAlignNoIR());
// Brings chainsaw down to drop first tote on top of the tote in front.    	
    	addSequential(new DecreaseChainsawPosition());
// Robot drives backwards
    	addSequential(new DriveDistDirection(0.2, 6, 180));
// Chainsaw comes down 
    	addSequential(new DecreaseChainsawPosition());
    	addSequential(new AutoTotePickupWide());
    	
//    	addSequential(new DriveDistDirection(0.3, 36, 180));
//    	addSequential(new DriveDistDirection(0.3, 54, 180));
//    	
//    	addSequential(new AutoTotePickupWide());
//    	addSequential(new IncreaseChainsawPosition());
//    	addSequential(new AutoTotePickupWide());
//    	addSequential(new IncreaseChainsawPosition());
    }
}
