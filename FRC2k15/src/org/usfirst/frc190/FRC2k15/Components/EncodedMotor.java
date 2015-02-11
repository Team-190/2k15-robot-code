package org.usfirst.frc190.FRC2k15.Components;

import java.util.ArrayList;
import java.util.Iterator;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
/*
1.72 in encoder shaft - 5.40 in cir 
1.6 in wheel shaft - 5.03 in cir
6 in wheels - 18.85 in cir 

shaft is rotating at 5.03/5.40 times the speed of wheel
0.93 times the speed
9ft/s max
9ft/s -> 9*12in/1ft = 108 in/s 
108in/s * 1 revolution/18.85 in = 5.73 rev/s
5.73rev/s (wheel) * 0.93 speed ratio (unitless) = 5.33 rev/s 
5.33 rev/s (encoder) *1000pulse / rev
5330 pulses/second at max speed

18.85 in/rev (wheel) *.93 (wheelspeed/shaftspeed ratio) = 17.5 in/rev (encoder)
17.5in/rev (encoder) *1rev/1000pulse = 0.0175 in/pulse
 */
public class EncodedMotor implements SpeedController {
	private Encoder enc;
	public SpeedController mtr;
	private WheelPID cnt;
	private double maxspd;
	private static final double distperpulse = 0.135;//inches per pulse 
	//doesn't follow the math but by testing with a wheel this is much closer to proper number
	public static ArrayList<EncodedMotor> mtrs = new ArrayList<EncodedMotor>();
	private static boolean closedloop = false; //true;
	
//Constructor for Class to create an instance
	public EncodedMotor(double Ki, double Kf,
			Encoder source, SpeedController output, double mmaxspd) {
		cnt = new WheelPID(Ki,Kf,mmaxspd,source,output); //creates the IF controller for Closed loop control
		enc = source;//saves the encoder in a class variable
		mtr = output;//saves the motor in a class variable
		maxspd = mmaxspd; //notes the max speed for the object
		enc.setDistancePerPulse(distperpulse); //calibrates the encoders to get inches as units
		enc.setPIDSourceParameter(PIDSource.PIDSourceParameter.kRate); //tells the encoder that Rate is the required information for PID
		mtrs.add(this);//adds this EncodedMotor to the EncodedMotor list (used for enable/disable)
		//cnt.enable(); //enables the IF controller
	}

	@Override
	public void pidWrite(double output) { //Required function from speed controller implement
		set(output); //not likely to be used but required to have
	}

	@Override
	public void set(double speed, byte syncGroup) { //Required function from speed controller implement
		if (closedloop) //if closed loop set 
			cnt.setSetPoint(speed*maxspd); //set the setpoint to speed * maxspd to get speed in in/s
		else //if not closed loop
			mtr.set(speed, syncGroup); //call the function on the motor

	}
	//mostly used during auto for setting a speed in in/s
public void setSpd(double speed){ //sets a speed in in/s
	if(closedloop){ //if closed loop control is enabled
		cnt.setSetPoint(speed); //Set the closed loop speed control to the speed in in/s
	}
	else { //closed loop control disabled
		mtr.set(speed/maxspd); //calls the original set function with a properly scaled value
	} //This really should not be done since defeats the purpose of setSpd()
}
	@Override
	public void set(double speed) {//Called to set the speed of motor
		if (closedloop) //if closed loop control is enabled
			cnt.setSetPoint(speed*maxspd); //set the Setpoint on controller to speed (-1.0 to 1.0) * maxspeed to get proper units
		else //No closed loop control
			mtr.set(speed); //set the motor directly to the speed

	}
	public double getSet(){ //gets the controllers setpoint
		return cnt.getSet();
	}
	@Override
	public double get() { //gets the speed that the motor is set at
		return mtr.get();
	}

	@Override
	public void disable() { //when a motor needs to be disabled this function is called
		cnt.disable(); //stops the IF controller 
		mtr.disable(); //stops the motor
		mtr.set(0); //sets the motor to speed 0 (not moving)
	}

	public void enable() { //called to reenable the closed loop control of motors
		if (closedloop) //if closed loop is enabled
			cnt.enable(); //enable the IF controller
	}
	
	public static void setClosedLoop(boolean closed) { //sets the closed loop control for all EncodedMotors
		closedloop = closed; //sets the class variable to the input variable
		Iterator<EncodedMotor> itr = mtrs.iterator(); //gets an iterator containing all EncodedMotors
		if (closed) { //if closed loop is enabled
			while (itr.hasNext()) //for all EncodedMotors
				itr.next().cnt.enable(); //enable the closed loop control
		} else { //if closed loop is disabled
			while (itr.hasNext()) { //for all EncodedMotors
				itr.next().cnt.disable(); //disable the closed loop control
			}
		}
	}

}