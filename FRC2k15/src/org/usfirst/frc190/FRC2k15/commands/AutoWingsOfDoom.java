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

// Robot starts backward. Remember this when writing commands for driving in
// auto.
// Chainsaw should start all the way back

// Remember to write a PID command to tilt chainsaw to vertical position after
// the DisableWings() command.

public class AutoWingsOfDoom extends CommandGroup {

	public AutoWingsOfDoom() {

		addParallel(new FireWingsSequence());
		
		// addParallel(new ResetChainsaw());
		
		addSequential(new Delay(1));
		addSequential(new DriveDistDirection(0.4, 24, 0));
		addSequential(new DriveDistDirection(0.4, 48, 0));
		

		// Tote align position is best angle. this brings wings up
		// addSequential(new Delay(1.5));
		addSequential(new LimitedPIDSubsystemSetpointCommand(
				Robot.chainsaw4Bar, Robot.chainsaw4Bar.scoringPosition, 0.4,
				-0.4, false));
		addSequential(new LimitedPIDSubsystemSetpointCommand(
				Robot.chainsaw4Bar, Robot.chainsaw4Bar.collectPositionWide,
				0.4, -0.4, false));
		addSequential(new LimitedPIDSubsystemSetpointCommand(
				Robot.chainsaw4Bar, Robot.chainsaw4Bar.scoringPosition, 0.4,
				-0.4, false));
		addSequential(new LimitedPIDSubsystemSetpointCommand(
				Robot.chainsaw4Bar, Robot.chainsaw4Bar.collectPositionWide,
				0.4, -0.4, false));

	}
}
