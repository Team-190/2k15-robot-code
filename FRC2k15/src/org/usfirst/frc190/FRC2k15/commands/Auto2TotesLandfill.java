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
public class Auto2TotesLandfill extends CommandGroup {

	public Auto2TotesLandfill() {

		addSequential(new ResetChainsaw());

		// Wide tote align

		addSequential(new AutoTotePickupWide(), 5.0);

		// Chainsaw goes up to next level (next set-point)

		addSequential(new IncreaseChainsawPosition());

		// New Command to increase speed of auto
		addSequential(new DriveDistDirection(0.2, 10, 0), 1);
		addSequential(new AutoTotePickupWide(), 5.0);
		addSequential(new IncreaseChainsawPosition());

		// Robot drives backwards (first command) and then drives left towards
		// the second
		// set of wide totes
		addSequential(new DriveDistDirection(0.6, 36, 180));
		addSequential(new DriveDistDirection(0.5, 85, 270));
		
//		This makes the robot drive forward and do the second set of tote pick ups in auto
		
		addSequential(new DriveDistDirection(0.4, 24, 0),2);
		addSequential(new AutoTotePickupWide(), 5.0);
		addSequential(new IncreaseChainsawPosition());
		addSequential(new DriveDistDirection(0.2, 10, 0), 1);
		addSequential(new AutoTotePickupWide(), 3.0);
		addSequential(new IncreaseChainsawPosition());
		
		
	}
}
