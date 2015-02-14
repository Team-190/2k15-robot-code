package org.usfirst.frc190.FRC2k15.Components;

import java.util.ArrayList;
import java.util.Iterator;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/*
 1 to 1 wheel to encoder rotation
 12.57 in/rev (wheel) *1rev/250pulse = .05 in/pulse
 */
public class EncodedMotor implements SpeedController {
	private Encoder enc;
	public SpeedController mtr;
	private WheelPID cnt;
	private double maxSpd;
	// inches per pulse
	private static final double distPerPulse = 0.05;
	public static ArrayList<EncodedMotor> mtrs = new ArrayList<EncodedMotor>();
	private static boolean closedLoop = true; 

	// Constructor for Class to create an instance
	public EncodedMotor(double Ki, double Kf, Encoder source,
			SpeedController output, double mmaxspd) {
		// creates the IF controller for Closed loop control
		cnt = new WheelPID(Ki, Kf, mmaxspd, source, output);
		enc = source;
		mtr = output;
		// notes the max speed for the object
		maxSpd = mmaxspd;
		// calibrates the encoders to get inches as units
		enc.setDistancePerPulse(distPerPulse);
		// tells the encoder that Rate is the required information for PID
		enc.setPIDSourceParameter(PIDSource.PIDSourceParameter.kRate);
		// adds this EncodedMotor to the EncodedMotor list (used for
		// enable/disable)
		mtrs.add(this);
	}

	// Required function from speed controller implement
	@Override
	public void pidWrite(double output) {
		// not likely to be used but required to have
		set(output);
	}

	// Required function from speed controller implement
	@Override
	public void set(double speed, byte syncGroup) {
		// if closed loop set
		if (closedLoop)
			// set the setpoint to speed * maxspd to get speed in in/s
			cnt.setSetPoint(speed * maxSpd);
		// if not closed loop
		else
			// call the function on the motor
			mtr.set(speed, syncGroup);

	}

	// mostly used during auto for setting a speed in in/s
	// sets a speed in in/s
	public void setSpd(double speed) {
		// if closed loop control is enabled
		if (closedLoop) {
			// Set the closed loop speed control to the speed in in/s
			cnt.setSetPoint(speed);
		}
		// closed loop control disabled
		else {
			// calls the original set function with a properly scaled value
			mtr.set(speed / maxSpd);
			// This really should not be done since defeats the purpose of
			// setSpd()
		}
	}

	// Called to set the speed of motor
	@Override
	public void set(double speed) {
		// if closed loop control is enabled
		if (closedLoop)
			// set the Setpoint on controller to speed (-1.0 to 1.0) * maxspeed
			// to get proper units
			cnt.setSetPoint(speed * maxSpd);
		else
			// No closed loop control
			// set the motor directly to the speed
			mtr.set(speed);

	}

	// gets the controllers setpoint
	public double getSetpoint() {
		return cnt.getSetpoint();
	}

	// gets the speed that the motor is set at
	@Override
	public double get() {
		return mtr.get();
	}

	// when a motor needs to be disabled this function is called
	@Override
	public void disable() {
		// stops the IF controller
		cnt.disable();
		// stops the motor
		mtr.disable();
		// sets the motor to speed 0 (not moving)
		mtr.set(0);
	}

	// called to reenable the closed loop control of motors
	public void enable() {
		// if closed loop is enabled
		if (closedLoop)
			// enable the IF controller
			cnt.enable();
	}

	// sets the closed loop control for all EncodedMotors
	public static void setClosedLoop(boolean closed) {
		closedLoop = closed;
		// if closed loop is enabled
		if (closed) {
			// for all EncodedMotors
			for (EncodedMotor encmtr : mtrs) {
				encmtr.enable();
			}
			// if closed loop is disabled
		} else {
			// for all EncodedMotors
			for (EncodedMotor encmtr : mtrs) {
				encmtr.disable();
			}
		}
	}

}