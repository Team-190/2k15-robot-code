package org.usfirst.frc190.FRC2k15.Components;

import edu.wpi.first.wpilibj.I2C;

public class VoiceCmds{
	private static I2C roboDuino;
	private static final int address = 2; //the I2C address of the roboDuino
	//Each command for the roboDuino has a set value defined in this list
	public static final byte s_disable = 0x00;
	public static final byte s_enable = 0x01;
	public static final byte s_alignToTote = 0x02;
	public static final byte s_liftingTote = 0x03;
	public static final byte s_extendingChainsaw = 0x04;
	public static final byte s_deliveringStack = 0x05;
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
	public static final byte s_autoBeginning = 0x10;
	public static final byte s_teleOpBeginning = 0x11;
	public static final byte s_test = (byte) 0xFF;
	private VoiceCmds() {//all methods static so no need to use the constructor 
	}

	public static synchronized void init() {//call this before attempting to use speak()
			roboDuino = new I2C(I2C.Port.kMXP, address);//initializes the roboDuino I2C object
	}

	public static synchronized void speak(byte command) {//sends a byte indicating a particular file for the roboDuino to play 
		byte[] data = { command }; //creates an array of size one for the writeBulk function
		roboDuino.writeBulk(data); //sends the data over I2C to the roboduino
	}

}
