package org.usfirst.frc190.FRC2k15.Components;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

public class EncodedMotor implements SpeedController {
	private Encoder enc;
	public SpeedController mtr;
	private PIDController cnt;
	private static final double distperpulse = 0.0001466;
	public static ArrayList<EncodedMotor> mtrs = new ArrayList<EncodedMotor>();
	public static boolean closedloop = true;

	public EncodedMotor(double Kp, double Ki, double Kd, double Kf,
			Encoder source, SpeedController output, double period) {
		cnt = new PIDController(Kp, Ki, Kd, Kf, source, output, period);
		enc = source;
		mtr = output;
		init();
	}

	private void init() {
		enc.setDistancePerPulse(distperpulse);
		enc.setPIDSourceParameter(PIDSource.PIDSourceParameter.kRate);
		cnt.setInputRange(-1.0, 1.0);
		mtrs.add(this);
		cnt.enable();
	}

	@Override
	public void pidWrite(double output) {
		cnt.setSetpoint(output);
	}

	@Override
	public void set(double speed, byte syncGroup) {
		if (closedloop)
			cnt.setSetpoint(speed);
		else
			mtr.set(speed, syncGroup);

	}

	@Override
	public void set(double speed) {
		if (closedloop)
			cnt.setSetpoint(speed);
		else
			mtr.set(speed);

	}

	@Override
	public double get() {
		return mtr.get();
	}

	@Override
	public void disable() {
		cnt.disable();
		mtr.disable();
	}

	public void enable() {
		cnt.enable();
	}

}