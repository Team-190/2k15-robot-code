package org.usfirst.frc190.FRC2k15.Components;
import edu.wpi.first.wpilibj.I2C;
public class I2Cgyro {
private I2C gyro;
private static final byte address = (byte) 0xD0; //address of the gyro
private static final byte zRateAddress = 33;
private static final byte initializeAddress = 0x16;
private static final byte initializeValue = 0x03;
private static int zRate;
private static I2Cgyro instance;
	private I2Cgyro() {
		gyro = new I2C(I2C.Port.kOnboard, address);
	}
	public static void init(){
		instance = new I2Cgyro();
	}
	private void getZ(){
		byte buf[] = new byte[2];
		gyro.read(zRateAddress, 2, buf);
		zRate = ((int)buf[0])<<8+buf[1];
	}
	public int getZRate(){
		return zRate;
	}
}
