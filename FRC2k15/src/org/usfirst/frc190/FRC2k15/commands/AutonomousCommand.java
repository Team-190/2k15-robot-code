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

import org.usfirst.frc190.FRC2k15.Components.VoiceCmds;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

	double distanceToAutozone = 6; // ft
	double speedToAutozone = 0.5; // 50% power
	double headingToAutozone = 0;
	double autoRotation = 90; // degrees turned to face autozone
	double distanceBetweenTotes = 2;// ft

	double timeout = 5.00;

	public AutonomousCommand() {
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.

		// Timeouts on everything to avoid running out of time.

		addSequential(new GetIntoAutoPosition(), timeout);
		int numtotes = 3;
		for (int i = 0; i < numtotes; i++) {
			addSequential(new DriveUntilToteDetectedAuto(), timeout);
			addSequential(
					new SetTinesPosition(/* put tine position number here */),
					timeout);
			addParallel(new LiftTotes(), timeout);
			if (i < numtotes - 1) {
				// Re-open tines and anything else that you need to do.
				addSequential(new SetTinesPosition(/*
													 * put tine position number
													 * here
													 */), timeout);
			}
		}

		// Delay to allow Totes to be lifted
		// May be replaced with a check function later
		addSequential(new Delay(1));

		addSequential(new DriveTurn(autoRotation), timeout);
		addSequential(new DriveDistDirection(speedToAutozone,
				distanceToAutozone, headingToAutozone), timeout);

		addSequential(new DeliverStack(), timeout);

		addSequential(new DriveDistDirection(-0.5, 0.75, 0), timeout);
	}
}
