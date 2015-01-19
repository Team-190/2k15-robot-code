package org.usfirst.frc190.FRC2k15.Components;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

public class EncodedMotor extends PIDController implements SpeedController {
	private Encoder enc;
	public SpeedController mtr;
	private static final double distperpulse = 0.0001466;
	public static ArrayList<EncodedMotor> mtrs = new ArrayList<EncodedMotor>();
	public static boolean closedloop = true;

	public EncodedMotor(double Kp, double Ki, double Kd, Encoder source,
			SpeedController output) {
		super(Kp, Ki, Kd, source, output);
		enc = source;
		mtr = output;
		init();
	}

	public EncodedMotor(double Kp, double Ki, double Kd, Encoder source,
			SpeedController output, double period) {
		super(Kp, Ki, Kd, source, output, period);
		enc = source;
		mtr = output;
		init();
	}

	public EncodedMotor(double Kp, double Ki, double Kd, double Kf,
			Encoder source, SpeedController output) {
		super(Kp, Ki, Kd, Kf, source, output);
		enc = source;
		mtr = output;
		init();
	}

	// Use this one!
	public EncodedMotor(double Kp, double Ki, double Kd, double Kf,
			Encoder source, SpeedController output, double period) {
		super(Kp, Ki, Kd, Kf, source, output, period);
		enc = source;
		mtr = output;
		init();
	}

	private void init() {
		enc.setDistancePerPulse(distperpulse);
		enc.setPIDSourceParameter(PIDSource.PIDSourceParameter.kRate);
		setInputRange(-1.0, 1.0);
		mtrs.add(this);
		enable();
	}

	@Override
	public void pidWrite(double output) {
		setSetpoint(output);
	}

	@Override
	public void set(double speed, byte syncGroup) {
		if (closedloop)
			setSetpoint(speed);
		else
			mtr.set(speed, syncGroup);

	}

	@Override
	public void set(double speed) {
		if (closedloop)
			setSetpoint(speed);
		else
			mtr.set(speed);

	}

}