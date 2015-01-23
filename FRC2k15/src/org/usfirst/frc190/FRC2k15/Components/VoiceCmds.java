package org.usfirst.frc190.FRC2k15.Components;

import edu.wpi.first.wpilibj.I2C;

public class VoiceCmds{
	private static VoiceCmds instance = null;
	private static I2C roboDuino;
	private static final int address = 2;
	public static final byte s_disable = 0x00;
	public static final byte s_enable = 0x01;
	public static final byte s_alignToTote = 0x02;
	public static final byte s_liftingTote = 0x03;
	public static final byte s_extendingChainsaw = 0x04;
	public static final byte s_droppingStack = 0x05;
	public static final byte s_retractingChainsaw = 0x06;
	public static final byte s_grabbingRecyclingContainer = 0x07;
	public static final byte s_liftingRecyclingContainer = 0x08;
	public static final byte s_loweringTines = 0x09;
	public static final byte s_gettingIntoAutoPosition = 0x0A;
	public static final byte s_lookingForTote = 0x0B;
	public static final byte s_toteFound = 0x0C;
	public static final byte s_grabbingTote = 0x0D;
	public static final byte s_turning = 0x0E;
	public static final byte s_driving = 0x0F;
	public static final byte s_deliveringStack = 0x10;

	private VoiceCmds() {
		roboDuino = new I2C(I2C.Port.kMXP, address);
	}

	public static synchronized VoiceCmds getInstance() {
		if (instance == null) {
			instance = new VoiceCmds();
		}
		return instance;
	}

	public synchronized void speak(byte command) {
		byte[] data = { command };
		roboDuino.writeBulk(data);
	}

}
