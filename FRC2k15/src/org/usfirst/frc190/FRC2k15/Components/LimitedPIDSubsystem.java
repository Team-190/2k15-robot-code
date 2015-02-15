package org.usfirst.frc190.FRC2k15.Components;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * An interface for all subsystems with PID control and limit switches
 * Note positive speeds should move towards the max position
 * and negative speeds should move towards the min position
 * @author Patrick
 *
 */
public interface LimitedPIDSubsystem {
	/**
	 * Used for Commands requires(Subsystem);
	 * @return The subsystem this LimitedPIDSubsytem is part of
	 */
	public PIDSubsystem getSubSystem();
	/**
	 * 
	 * @return true if at max position false if not
	 */
	public boolean atmax();

	/**
	 * 
	 * @return true if at min position false if not
	 */
	public boolean atmin();

	/**
	 * Disables the PID system then sets the motor to given speed
	 * 
	 * @param speed
	 *            the speed to power the motor at
	 */
	public void setSpeed(double speed);

	/**
	 * Enables the PID system and sets the setpoint
	 * 
	 * @param setpoint
	 *            The point to set the PID system to
	 */
	public void setPosition(double setpoint);

	/**
	 * 
	 * @return the pidsystems atTarget(); function
	 */
	public boolean atPosition();
}
