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
	private static boolean closedloop = true;
	

	public EncodedMotor(double Kp, double Ki, double Kd, double Kf,
			Encoder source, SpeedController output, double period, double mmaxspd) {
		cnt = new WheelPID(Ki,Kf,source,output);
		enc = source;
		mtr = output;
		maxspd = mmaxspd;
		init();
	}

	private void init() {
		enc.setDistancePerPulse(distperpulse);
		enc.setPIDSourceParameter(PIDSource.PIDSourceParameter.kRate);
		//cnt.setInputRange(-maxspd, maxspd);
		mtrs.add(this);
		cnt.enable();
	}

	@Override
	public void pidWrite(double output) {
		set(output);
	}

	@Override
	public void set(double speed, byte syncGroup) {
		if (closedloop)
			cnt.setSetPoint(speed*maxspd);
		else
			mtr.set(speed, syncGroup);

	}
	//mostly used during auto for setting a speed in in/s
public void setSpd(double speed){
	if(closedloop){
		cnt.setSetPoint(speed);
	}
	else {
		mtr.set(speed/maxspd);
	}
}
	@Override
	public void set(double speed) {
		if (closedloop)
			cnt.setSetPoint(speed*maxspd);
		else
			mtr.set(speed);

	}
	public double getSet(){
		return cnt.getSet();
	}
	@Override
	public double get() {
		return mtr.get();
	}

	@Override
	public void disable() {
		cnt.disable();
		mtr.disable();
		mtr.set(0);
	}

	public void enable() {
		if (closedloop)
			cnt.enable();
	}
	
	public static void setClosedLoop(boolean closed) {
		closedloop = closed;
		Iterator<EncodedMotor> itr = mtrs.iterator();
		if (closed) {
			while (itr.hasNext())
				itr.next().cnt.enable();
		} else {
			while (itr.hasNext()) {
				itr.next().cnt.disable();
			}
		}
	}

}