package org.usfirst.frc190.FRC2k15.Components;

import edu.wpi.first.wpilibj.I2C;

public class VoiceCmds{
	private static I2C roboDuino;
	private static final int address = 2; //the I2C address of the roboDuino
	//Each command for the roboDuino has a set value defined in this list
	//format for creating command is:
	//r_ is robot things
	//d_ is drivetrain things
	//c_ is chainsaw things
	//f_ is fourbar things
	//t_ is tines things
	//e_ is tine elevator things
	//g_ is for a group command
	//a_ is auto 
	//note auto will be a_x_ where x is the subsystem used
	//m_ is manual control
	//will be x_m_ where x is the subsystem used
	public static final byte r_disable = 0x00;
	public static final byte r_enable = 0x01;
	public static final byte a_d_turning = 0x02;//Auto Section
	public static final byte a_d_driving = 0x03;
	public static final byte a_r_autoBeginning = 0x04;
	public static final byte a_d_gettingIntoPosn = 0x05;
	public static final byte a_d_lookingForTote = 0x06;
	public static final byte a_d_toteFound = 0x07;
	public static final byte d_alignTote = 0x08;//Drivetrain Section
	public static final byte d_teleDrive = 0x09;
	public static final byte d_reset = 0x0A;
	public static final byte d_resetGyro = 0x0B;
	public static final byte c_liftTote = 0x0C; //Chainsaw Section
	public static final byte c_deliverStack = 0x0D;
	public static final byte c_decreasePosn = 0x0E;
	public static final byte c_increasePosn = 0x0F;
	public static final byte c_reset = 0x10;
	public static final byte c_setPosn = 0x11;
	public static final byte c_m_lowerChainsaw = 0x12;
	public static final byte c_m_raiseChainsaw = 0x13;
	public static final byte f_humanPosn = 0x14;//Fourbar Section
	public static final byte f_scoringPosn = 0x15;
	public static final byte f_storingPosn = 0x16;
	public static final byte f_m_in = 0x17;
	public static final byte f_m_out = 0x18;
	public static final byte t_rC = 0x19; //Tines Section
	public static final byte t_narrowTote = 0x1A;
	public static final byte t_open = 0x1B;
	public static final byte t_wideTote = 0x1C;
	public static final byte t_m_in = 0x1D;
	public static final byte t_m_out = 0x1E;
	public static final byte e_bottom = 0x1F; //Tine Elevator Section
	public static final byte e_top = 0x20;
	public static final byte e_human = 0x21;
	public static final byte e_m_up = 0x22;
	public static final byte e_m_down = 0x23;
	public static final byte g_deliverStack = 0x24; //Command Group Section
	public static final byte g_liftTote = 0x25;
	public static final byte r_teleopBeginning = 0x26;
	public static final byte r_delay = 0x27;
	public static final byte r_dm0 = 0x28;
	public static final byte r_dm1 = 0x29;
	public static final byte r_dm2 = 0x2A;
	public static final byte r_dm3 = 0x2B;
	public static final byte r_fieldOrient = 0x2C;
	public static final byte r_robotOrient = 0x2D;
	public static final byte r_linearInps = 0x2E;
	public static final byte r_squaredInps = 0x2F;
	public static final byte r_turningOn = (byte) 0xFE;
	public static final byte r_test = (byte) 0xFF;
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
