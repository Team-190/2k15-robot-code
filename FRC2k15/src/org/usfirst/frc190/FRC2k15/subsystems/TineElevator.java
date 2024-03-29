// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc190.FRC2k15.subsystems;

import org.usfirst.frc190.FRC2k15.RobotMap;
import org.usfirst.frc190.FRC2k15.Components.LimitedPIDSubsystem;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class TineElevator extends PIDSubsystem implements LimitedPIDSubsystem{
	// TODO: Update These
	public final double bottomPosition = 91.9; // Tines are all the way at the bottem
	public final double topPosition = 0.0; // The tines are all the way at the top
	public final double humanLoadPosition = 0.0; // Human load position for tines. Never used
	public final double aboveStorePosition = 63.6; // Tines a slight distance above the two bumps that make them from going out
	public final double storePosition = 76.9; // Store position for tines
	public final double midPosition = 40.0; // Arbritary position for tines. Used in auto to pick up one RC

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    AnalogPotentiometer elevatorPot = RobotMap.tineElevatorelevatorPot;
    SpeedController elevator = RobotMap.tineElevatorelevator;
    DigitalInput topLimit = RobotMap.tineElevatortopLimit;
    DigitalInput lowerLimit = RobotMap.tineElevatorlowerLimit;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	// Initialize your subsystem here
	public TineElevator() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("TineElevator", -0.5, 0.0, 0.0);
        setAbsoluteTolerance(0.5);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("TineElevator", "PIDSubsystem Controller", getPIDController());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
	}

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	}

	protected double returnPIDInput() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
        return elevatorPot.get();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
	}

	protected void usePIDOutput(double output) {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        elevator.pidWrite(output);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
	}
	
	public double getPotValue(){
		return elevatorPot.get();
	}

	/**
	 * @param speed
	 *            Speed to set the motor to
	 */
	public void setSpeed(double speed) {
		disable();
		elevator.set(speed);
	}

	public boolean getTopLimit() {
		return topLimit.get();
//		return false;
	}

	public boolean getLowerLimit() {
		return lowerLimit.get();
//		return false;
	}

	@Override
	public boolean atmax() {
		return getTopLimit();
	}

	@Override
	public boolean atmin() {
		return getLowerLimit();
	}

	@Override
	public void setPosition(double setpoint) {
		setSetpoint(setpoint);
		enable();
	}

	@Override
	public boolean atPosition() {
		return onTarget();
	}

	@Override
	public PIDSubsystem getSubSystem() {
		return this;
	}
}
