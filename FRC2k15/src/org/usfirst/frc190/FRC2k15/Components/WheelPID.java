package org.usfirst.frc190.FRC2k15.Components;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Timer;
import java.util.TimerTask;

//When using this class put in disabledInit() the disable() function and before use ie TeleopInit() the enable() function
public class WheelPID {
	//TODO: Fix comments
	// Terms for "IF" control
	private double ki, kf; 
	// encoder input for system
	private Encoder inp; 
	// speed controller output
	private SpeedController mtr; 
	// the set speed for the motor
	private double setpoint = 0.0; 
	// frequency of updating speed in milliseconds
	private static final long period = 10; 
	//max and min values for speed controllers
	private static final double maxOut = 1.0; 
	private static final double minOut = -1.0;
	// max and min values for setpoint
	private double minInp; 
	private double maxInp;
	// determines if the controllers are active or not
	private static boolean enabled = false; 
	// the total error used in calculating I
	private double totalError = 0.0; 
	// table names for tables on smartdashboard for I and F values
	private static final String iTableName = "Wheel I"; 
	private static final String fTableName = "Wheel F";
	private String WheelName;
	// Timer to call functions every period seconds
	Timer controlLoop; 
	private static final Object lock = new Object();
	public WheelPID(double iki, double ikf, double mspd, Encoder source,
			SpeedController output) {
		ki = iki;
		kf = ikf;
		inp = source;
		mtr = output;
		minInp = -mspd;
		maxInp = mspd;
		controlLoop = new java.util.Timer();
		// adds the wheeltask to run every period milliseconds
		controlLoop.schedule(new WheelTask(this), 0L, period);
	}
/**
 * 
 * @param nI the I value to set for the IF control
 * @param nF the F value to set for the IF control
 */
	public synchronized void setIF(double nI, double nF) { 
		ki = nI;
		kf = nF;
	}
/**
 * 
 * @param spnt the new speed in inches per second to set the motor to
 */
	public synchronized void setSetPoint(double spnt) {
		if (spnt < minInp) {
			setpoint = minInp; 
		} else if (spnt > maxInp) { 
			setpoint = maxInp; 
		} else { 
			setpoint = spnt;
		}
	}
/**
 * Calculates the speed to set the speed controller to
 */
	private void calculate() {
		boolean c_enabled;
		Double input, err;
		// create local clones for use outside of synchronized context
		synchronized (lock) {
			c_enabled = enabled;
		}
		synchronized(this){
			input = inp.getRate();
		}
		if (c_enabled) {
			err = setpoint - input;
			synchronized (this) {
				 // from PIDController class
				double potentialIGain = (totalError + err) * ki;
				if (potentialIGain < maxOut) {
					if (potentialIGain > minOut) {
						totalError += err;
					} else {
						totalError = minOut / ki;
					}
				} else {
					totalError = maxOut / ki;
				}
				double tempOut = totalError * ki + setpoint * kf;
				if (tempOut > maxOut) {
					tempOut = maxOut;
				} else if (tempOut < minOut) {
					tempOut = minOut;
				}// End of things from PIDController class
				// tests if output speed is same direction as setpoint if not then stop motor
				if (Math.signum(tempOut) != Math.signum(setpoint)) { 
					tempOut = 0;
				}
				mtr.pidWrite(tempOut);// Sets motor to calculated speed
			}
		}
	}
/**
 * Class to run the IF calculations in seperate thread
 * @author Patrick
 *
 */
	private class WheelTask extends TimerTask {
		private WheelPID wheel;
		/**
		 *  initializes a timer with the proper wheelPID object
		 * @param whl the WheelPID object to be used with this class
		 */
		public WheelTask(WheelPID whl) {
			wheel = whl;
		}

		@Override
		public void run() {
			wheel.calculate();
		}

	}
/**
 * Enables the IF controls 
 * Should be called before attempting to use the controllers
 */
	public void enable() { 
		synchronized(lock){
		enabled = true;
		}
	}
/**
 * Disables the IF controls
 * Should be called in disabledinit and any other times when IF should be disabled
 */
	public void disable() { 
		synchronized(this){
			// set speed to 0
			mtr.pidWrite(0);
		}
		synchronized(lock){
		enabled = false;
		}
	}
/**
 * Initializes the SmartDashboard calibration table
 * @param thisWheelName The name of the wheel to go on the table ie right front wheel
 */
	public synchronized void initCalibTable(String thisWheelName) { 
		WheelName = thisWheelName;
		SmartDashboard.putNumber(iTableName + WheelName, ki);
		SmartDashboard.putNumber(fTableName + WheelName, kf);
	}
/**
 * Updates the IF values based on the table in the SmartDashboard
 */
	public synchronized void UpdateCalibTable() { 
		// Makes sure that init has already been called
		if (WheelName != null) {
			ki = SmartDashboard.getNumber(iTableName + WheelName);
			kf = SmartDashboard.getNumber(fTableName + WheelName);
		}

	}
/**
 * gets the setpoint for IF system.
 * @return the setpoint
 */
	public synchronized double getSetpoint() { 
		return setpoint;
	}
	
	public synchronized void reset(){
		disable();
		totalError = 0;
	}
}
