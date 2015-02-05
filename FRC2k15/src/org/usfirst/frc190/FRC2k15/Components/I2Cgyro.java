package org.usfirst.frc190.FRC2k15.Components;

import java.util.Timer;
import java.util.TimerTask;


import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class I2Cgyro {
	private I2C gyro;
	private final int address = 0x68; // address of the gyro
	private final byte zRateAddress = 0x21;
	private final byte initializeAddress = 0x16;
	private final byte initializeValue = 0x18;
	private short zRate;
	private double ZRotateRate = 0;
	private double zAngle = 0;
	private double period = 0.005;// time in seconds between updates
	private final double sensitivity = 14.375; // 14.375 in ZRate = 1 degree /
												// second
	private long lasttime;
	private double deadzone = 1.5;//anything absolute value less than deadzone is ignored
	private static I2Cgyro instance;
	private java.util.Timer integratorThread;
	private I2Cgyro() {
		gyro = new I2C(I2C.Port.kOnboard, address); // gyro is on board I2C port
													// with address
		gyro.write(initializeAddress, initializeValue);// used to initialize the gyro
		integratorThread = new Timer();
		integratorThread.schedule(new Integrator(), 0L,(long) (period*1000));
		lasttime = System.currentTimeMillis();
	}

	public static I2Cgyro getInstance() {
		if (instance == null) {
			instance = new I2Cgyro();
		}
		return instance;
	}
	private void update() {// called every period seconds
		byte buf[] = new byte[2]; // buffer for the data
		SmartDashboard.putBoolean("GettingData?", gyro.read(zRateAddress, 2, buf)); // read the zaxis high and low bytes
		//SmartDashboard.putNumber("idx", (double) idx++);
		zRate = (short) ((buf[0] & 0xFF) << 8 | buf[1] & 0xFF); // convert to a
																// short		
		synchronized (this) {
			ZRotateRate = (double) zRate / sensitivity; // convert to double in
														// degrees/second
			if(Math.abs(ZRotateRate) < deadzone)
				ZRotateRate = 0;
			zAngle += ZRotateRate * (System.currentTimeMillis()-lasttime)/1000;// add the rate*dt to angle
											// (integration)
			lasttime = System.currentTimeMillis();
		}
	}

	public synchronized double getZRate() {
		return ZRotateRate;
	}

	public synchronized double getHeading() {
		return zAngle;
	}
	private class Integrator extends TimerTask{

		@Override
		public void run() {
			update();
			
		}
		
	}
}
