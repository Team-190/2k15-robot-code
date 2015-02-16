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
import org.usfirst.frc190.FRC2k15.commands.AnalogDriveChainsaw;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Chainsaw extends PIDSubsystem {
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController chainsaw = RobotMap.chainsawchainsaw;
    DigitalInput hookDetector = RobotMap.chainsawhookDetector;
    Encoder chainsawEncoder = RobotMap.chainsawchainsawEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	// Keeps track of PID setpoints for different hook levels
	public double hookSetPoint[] = { 0.0, 0.1, 0.3, 0.5, 0.6, 0.7, 1.0 };
	private int currentHookPosition = 0;
	private int maxHookPosition = hookSetPoint.length - 1;
	// This is the offset for the chainsaw that it lowers by to deliver a stack
	// to the step
	public final double deliveryOffset = -1.0;

	// Initialize your subsystem here
	public Chainsaw() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("Chainsaw", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Chainsaw", "PIDSubsystem Controller", getPIDController());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID

		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
	}

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new AnalogDriveChainsaw());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
        return chainsawEncoder.pidGet();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        chainsaw.pidWrite(output);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
	}

	/**
	 * getHookPosition gets the current hook position
	 * 
	 * @return hook position in preset level units, i.e. 0-5
	 */
	public int getHookPosition() {
		return currentHookPosition;
	}

	/**
	 * set the hook position
	 * 
	 * @param pos
	 *            as a preset level number
	 */
	public void setHookPosition(int pos) {
		currentHookPosition = limitPos(pos);
		applySetpoint();
	}

	/**
	 * increment hook position by 1 level
	 */
	public void incrementHookPosition() {
		currentHookPosition = limitPos(currentHookPosition + 1);
		applySetpoint();
	}

	/**
	 * decrement the hook position by 1 level
	 */
	public void decrementHookPosition() {
		currentHookPosition = limitPos(currentHookPosition - 1);
		applySetpoint();
	}

	/**
	 * Get the hook setpoint
	 * 
	 * @return current setpoint as an analog potentiometer value
	 */
	public double getHookSetPoint() {
		return hookSetPoint[currentHookPosition];
	}

	/**
	 * Limits the chainsaw position to legal values
	 * 
	 * @param temppos
	 *            The proposed value for the chainsaw level
	 * @return limited position between 0 and maxHookPosition
	 */
	private int limitPos(int temppos) {
		if (temppos < 0)
			return 0;
		if (temppos > maxHookPosition)
			return maxHookPosition;
		else
			return temppos;
	}

	/**
	 * Apply the currentHookPosition as a setpoint for the chainsaw
	 */
	private void applySetpoint() {
		setSetpoint(hookSetPoint[currentHookPosition]);
		enable();
	}

	/**
	 * Set the speed of the chainsaw This method is used for jogging the
	 * chainsaw up or down using a trigger with WhileHeld
	 * 
	 * @param speed
	 *            The speed of the chainsaw motor
	 */
	public void setSpeed(double speed) {
		chainsaw.set(-speed);
	}

	/**
	 * Check if the chain saw is at the zero position This method uses a limit
	 * switch to zero the chainsaw
	 * 
	 * @return true if the chainsaw is in the zero position
	 */
	public boolean atZero() {
		return hookDetector.get();
	}

	/**
	 * Reset the encoder to the zero value This is used when homing the chainsaw
	 */
	public void resetEncoder() {
		chainsawEncoder.reset();
	}
}
