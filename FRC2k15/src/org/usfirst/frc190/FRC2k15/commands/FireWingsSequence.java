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
public class FireWingsSequence extends CommandGroup {
    
    public  FireWingsSequence() {
        addSequential(new FireWings());
        addSequential(new Delay(0.2));
        addSequential(new DisableWings());
        addSequential(new Delay(0.05));
        addSequential(new FireWings());
        addSequential(new Delay(0.25));
        addSequential(new DisableWings());
    }
}
