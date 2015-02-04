package org.usfirst.frc190.FRC2k15.Components;

import edu.wpi.first.wpilibj.I2C;

public class I2Cgyro {
	private I2C gyro;
	private final byte address = (byte) 0xD0; // address of the gyro
	private final byte zRateAddress = 33;
	private final byte initializeAddress = 0x16;
	private final byte initializeValue = 0x18;
	private short zRate;
	private double ZRotateRate = 0;
	private double zAngle = 0;
	private double period = 0.02;// time in seconds between updates
	private final double sensitivity = 14.375; // 14.375 in ZRate = 1 degree /
												// second
	private static I2Cgyro instance;

	private I2Cgyro() {
		gyro = new I2C(I2C.Port.kOnboard, address); // gyro is on board I2C port
													// with address
		gyro.write(initializeAddress, initializeValue);// used to initialize the
														// gyro
	}

	public static I2Cgyro getInstance() {
		if (instance == null) {
			instance = new I2Cgyro();
		}
		return instance;
	}

	public void update() {// called every period seconds
		byte buf[] = new byte[2]; // buffer for the data
		gyro.read(zRateAddress, 2, buf); // read the zaxis high and low bytes
		zRate = (short) ((buf[0] & 0xFF) << 8 | buf[1] & 0xFF); // convert to a
																// short
		synchronized (this) {
			ZRotateRate = (double) zRate / sensitivity; // convert to double in
														// degrees/second
			zAngle += ZRotateRate * period;// add the rate*dt to angle
											// (integration)
		}
	}

	public synchronized double getZRate() {
		return ZRotateRate;
	}

	public synchronized double getHeading() {
		return zAngle;
	}
}
