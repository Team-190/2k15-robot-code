package org.usfirst.frc190.FRC2k15.Components;

import edu.wpi.first.wpilibj.I2C;

public class VoiceCmds extends I2C {
private static VoiceCmds instance = null;
private static final int address = 2;
public static final byte s_disable = 0x00;
public static final byte s_enable = 0x01;
public static final byte s_alignToTote = 0x02;
	private VoiceCmds(Port port, int deviceAddress) {
		super(port, deviceAddress);
	}
	public static synchronized VoiceCmds getinstance(){
		if(instance == null){
			instance = new VoiceCmds(I2C.Port.kOnboard,  address);
		}
		return instance;
	}
	public synchronized void speak(int command){
		byte[] data = {(byte) (command&0xFF)};
		writeBulk(data);
	}

}
