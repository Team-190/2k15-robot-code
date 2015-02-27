// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc190.FRC2k15;

import org.usfirst.frc190.FRC2k15.Components.LimitedManualCommand;
import org.usfirst.frc190.FRC2k15.Components.LimitedPIDSubsystemSetpointCommand;
import org.usfirst.frc190.FRC2k15.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
//	public Joystick Oper1;
//	public Joystick Oper2;
//	public JoystickButton oToteAlign;
//	public JoystickButton oChainsawPlus;
//	public JoystickButton oChainsawMinus;
//	public JoystickButton oChainsawManualDown;
//	public JoystickButton oChainsawManualUp;
//	public JoystickButton oFourBarScoring;
//	public JoystickButton oFourBarStoring;
//	public JoystickButton oFourBarHuman;
//	public JoystickButton oFourBarManualIn;
//	public JoystickButton oFourBarManualOut;
//	public JoystickButton oChainsawReset;
//	public JoystickButton oAnalogChainsaw;
	
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton resetGyroBtn;
    public JoystickButton robotOrientedBtn;
    public JoystickButton fieldOrientedBtn;
    public JoystickButton linearInputsBtn;
    public JoystickButton squaredInputsBtn;
    public JoystickButton drivingMode0Btn;
    public JoystickButton drivingMode1Btn;
    public JoystickButton drivingMode2Btn;
    public JoystickButton drivingMode3Btn;
    public JoystickButton toteAlignBtn;
    public JoystickButton interruptBtn;
    public Joystick driveJoystick;
    public Joystick secondaryJoystick;
    public JoystickButton chainsawPlusBtn;
    public JoystickButton chainsawMinusBtn;
    public JoystickButton chainsawManualUpBtn;
    public JoystickButton chainsawManualDownBtn;
    public JoystickButton chainsaw4BarManualInBtn;
    public JoystickButton chainsaw4BarManualOutBtn;
    public JoystickButton humanPlayerSequencePlusBtn;
    public JoystickButton humanPlayerSequenceMinusBtn;
    public JoystickButton autoRCCollectDeliverBtn;
    public JoystickButton autoTotePickupBtn;
    public JoystickButton chainsaw4BarStackPositionBtn;
    public JoystickButton chainsaw4BarScorePositionBtn;
    public JoystickButton chainsaw4BarStorePositionBtn;
    public JoystickButton tinesManualInBtn;
    public JoystickButton tinesManualOutBtn;
    public JoystickButton tinesManualUpBtn;
    public JoystickButton tinesManualDownBtn;
    public JoystickButton stowTinesBtn;
    public Joystick console;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	private static double deadzone = 0.08;

	public OI() {
		
		//Use this code in case we are using the old OI (2k14)
//		
//		  console = new Joystick(2);
//        
//        toteAlignConsole = new JoystickButton(console, 14);
//        toteAlignConsole.whenPressed(new ToteAlign());
//        chainsawManualDownBtn = new JoystickButton(console, 4);
//        chainsawManualDownBtn.whileHeld(new ChainsawManualDown());
//        chainsawManualUpBtn = new JoystickButton(console, 3);
//        chainsawManualUpBtn.whileHeld(new ChainsawManualUp());
//        chainsawMinusBtn = new JoystickButton(console, 2);
//        chainsawMinusBtn.whenPressed(new DecreaseChainsawPosition());
//        chainsawPlusBtn = new JoystickButton(console, 1);
//        chainsawPlusBtn.whenPressed(new IncreaseChainsawPosition());
//        secondaryJoystick = new Joystick(1);
		
		console = new Joystick(2);
        
        stowTinesBtn = new JoystickButton(console, 6);
        stowTinesBtn.whenPressed(new StowTines());
        tinesManualDownBtn = new JoystickButton(console, 20);
        tinesManualDownBtn.whileHeld(new TinesManualDown());
        tinesManualUpBtn = new JoystickButton(console, 16);
        tinesManualUpBtn.whileHeld(new TinesManualUp());
        tinesManualOutBtn = new JoystickButton(console, 19);
        tinesManualOutBtn.whileHeld(new TinesManualOut());
        tinesManualInBtn = new JoystickButton(console, 9);
        tinesManualInBtn.whileHeld(new TinesManualIn());
        chainsaw4BarStorePositionBtn = new JoystickButton(console, 14);
        chainsaw4BarStorePositionBtn.whenPressed(new LimitedPIDSubsystemSetpointCommand(Robot.chainsaw4Bar, Robot.chainsaw4Bar.humanPosition, 0.2, -0.2, false));
        chainsaw4BarScorePositionBtn = new JoystickButton(console, 15);
        chainsaw4BarScorePositionBtn.whenPressed(new DeliverStack());
        chainsaw4BarStackPositionBtn = new JoystickButton(console, 17);
        chainsaw4BarStackPositionBtn.whenPressed(new LimitedPIDSubsystemSetpointCommand(Robot.chainsaw4Bar, Robot.chainsaw4Bar.collectPosition, 0.2, -0.2, false));
        autoTotePickupBtn = new JoystickButton(console, 10);
        autoTotePickupBtn.whenPressed(new AutoTotePickup());
        autoRCCollectDeliverBtn = new JoystickButton(console, 11);
        autoRCCollectDeliverBtn.whenPressed(new RCCollectSequence());
        humanPlayerSequenceMinusBtn = new JoystickButton(console, 12);
        humanPlayerSequenceMinusBtn.whenPressed(new DoNothing());
        humanPlayerSequencePlusBtn = new JoystickButton(console, 13);
        humanPlayerSequencePlusBtn.whenPressed(new DoNothing());
        chainsaw4BarManualOutBtn = new JoystickButton(console, 2);
        chainsaw4BarManualOutBtn.whileHeld(new Chainsaw4BarManualOut());
        chainsaw4BarManualInBtn = new JoystickButton(console, 3);
        chainsaw4BarManualInBtn.whileHeld(new Chainsaw4BarManualIn());
        chainsawManualDownBtn = new JoystickButton(console, 4);
        chainsawManualDownBtn.whileHeld(new ChainsawManualDown());
        chainsawManualUpBtn = new JoystickButton(console, 5);
        chainsawManualUpBtn.whileHeld(new ChainsawManualUp());
        chainsawMinusBtn = new JoystickButton(console, 1);
        chainsawMinusBtn.whenPressed(new DecreaseChainsawPosition());
        chainsawPlusBtn = new JoystickButton(console, 8);
        chainsawPlusBtn.whenPressed(new IncreaseChainsawPosition());
        secondaryJoystick = new Joystick(1);
        
		SmartDashboard.putData("FourBarScoringPosition", new LimitedPIDSubsystemSetpointCommand(Robot.chainsaw4Bar,Robot.chainsaw4Bar.scoringPosition, false));
		SmartDashboard.putData("FourBarHumanPosition", new LimitedPIDSubsystemSetpointCommand(Robot.chainsaw4Bar,Robot.chainsaw4Bar.humanPosition, false));
		SmartDashboard.putData("FourBarCollectPosition", new LimitedPIDSubsystemSetpointCommand(Robot.chainsaw4Bar,Robot.chainsaw4Bar.collectPosition, false));
        
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        
        driveJoystick = new Joystick(0);
        
        interruptBtn = new JoystickButton(driveJoystick, 12);
        interruptBtn.whenPressed(new DoNothing());
        toteAlignBtn = new JoystickButton(driveJoystick, 2);
        toteAlignBtn.whenPressed(new ToteAlign());
        drivingMode3Btn = new JoystickButton(driveJoystick, 10);
        drivingMode3Btn.whenPressed(new SetDrivingMode3());
        drivingMode2Btn = new JoystickButton(driveJoystick, 9);
        drivingMode2Btn.whenPressed(new SetDrivingMode2());
        drivingMode1Btn = new JoystickButton(driveJoystick, 8);
        drivingMode1Btn.whenPressed(new SetDrivingMode1());
        drivingMode0Btn = new JoystickButton(driveJoystick, 7);
        drivingMode0Btn.whenPressed(new SetDrivingMode0());
        squaredInputsBtn = new JoystickButton(driveJoystick, 6);
        squaredInputsBtn.whenPressed(new SetSquaredInputs());
        linearInputsBtn = new JoystickButton(driveJoystick, 5);
        linearInputsBtn.whenPressed(new SetLinearInputs());
        fieldOrientedBtn = new JoystickButton(driveJoystick, 4);
        fieldOrientedBtn.whenPressed(new SetFieldOriented());
        robotOrientedBtn = new JoystickButton(driveJoystick, 3);
        robotOrientedBtn.whenPressed(new SetRobotOriented());
        resetGyroBtn = new JoystickButton(driveJoystick, 1);
        resetGyroBtn.whenPressed(new ResetGyro());

	    
        // SmartDashboard Buttons
        SmartDashboard.putData("AnalogDriveChainsaw", new AnalogDriveChainsaw());

        SmartDashboard.putData("Do Nothing", new DoNothing());

        SmartDashboard.putData("DriveTurn", new DriveTurn());

        SmartDashboard.putData("ResetGyro", new ResetGyro());

        SmartDashboard.putData("GetIntoAutoPosition", new GetIntoAutoPosition());

        SmartDashboard.putData("DriveUntilToteDetectedAuto", new DriveUntilToteDetectedAuto());

        SmartDashboard.putData("DriveDistDirection", new DriveDistDirection());

        SmartDashboard.putData("LiftTotes", new LiftTotes());

        SmartDashboard.putData("RegularDrive", new RegularDrive());

        SmartDashboard.putData("SetFieldOriented", new SetFieldOriented());

        SmartDashboard.putData("SetRobotOriented", new SetRobotOriented());

        SmartDashboard.putData("SetSquaredInputs", new SetSquaredInputs());

        SmartDashboard.putData("SetLinearInputs", new SetLinearInputs());

        SmartDashboard.putData("SetDrivingMode0", new SetDrivingMode0());

        SmartDashboard.putData("SetDrivingMode1", new SetDrivingMode1());

        SmartDashboard.putData("SetDrivingMode2", new SetDrivingMode2());

        SmartDashboard.putData("SetDrivingMode3", new SetDrivingMode3());

        SmartDashboard.putData("Delay", new Delay());

        SmartDashboard.putData("SoundCheck", new SoundCheck());

        SmartDashboard.putData("ToteAlign", new ToteAlign());

        SmartDashboard.putData("ResetEncoders", new ResetEncoders());

        SmartDashboard.putData("DriveDistTestSequence", new DriveDistTestSequence());

        SmartDashboard.putData("ResetChainsaw", new ResetChainsaw());

        SmartDashboard.putData("IncreaseChainsawPosition", new IncreaseChainsawPosition());

        SmartDashboard.putData("DecreaseChainsawPosition", new DecreaseChainsawPosition());

        SmartDashboard.putData("DeliverStack", new DeliverStack());

        SmartDashboard.putData("ChainsawDeliverStackPosition", new ChainsawDeliverStackPosition());

        SmartDashboard.putData("AutoYellowToteStack", new AutoYellowToteStack());

        SmartDashboard.putData("AutoDriveForward", new AutoDriveForward());

        SmartDashboard.putData("AutoStealContainers", new AutoStealContainers());

        SmartDashboard.putData("HumanPlayerLoading", new HumanPlayerLoading());

        SmartDashboard.putData("Chainsaw4BarManualIn", new Chainsaw4BarManualIn());

        SmartDashboard.putData("Chainsaw4BarManualOut", new Chainsaw4BarManualOut());

        SmartDashboard.putData("RCCollectSequence", new RCCollectSequence());

        SmartDashboard.putData("AutoTotePickup", new AutoTotePickup());

        SmartDashboard.putData("Chainsaw4BarStackPosition", new Chainsaw4BarStackPosition());

        SmartDashboard.putData("Chainsaw4BarScorePosition", new Chainsaw4BarScorePosition());

        SmartDashboard.putData("Chainsaw4BarStorePosition", new Chainsaw4BarStorePosition());

        SmartDashboard.putData("TinesManualIn", new TinesManualIn());

        SmartDashboard.putData("TinesManualOut", new TinesManualOut());

        SmartDashboard.putData("TinesManualUp", new TinesManualUp());

        SmartDashboard.putData("TinesManualDown", new TinesManualDown());

        SmartDashboard.putData("StowTines", new StowTines());


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
//			Oper1 = new Joystick(3);
//			Oper2 = new Joystick(4);
//		oToteAlign = new JoystickButton(Oper2, 6);
//		oToteAlign.whenPressed(new ToteAlign());
//		oChainsawPlus = new JoystickButton(Oper2, 2);
//		oChainsawPlus.whenPressed(new IncreaseChainsawPosition());
//		oChainsawMinus = new JoystickButton(Oper2, 3);
//		oChainsawMinus.whenPressed(new DecreaseChainsawPosition());
//		oChainsawManualDown = new JoystickButton(Oper2, 5);
//		oChainsawManualDown.whileHeld(new ChainsawManualDown());
//		oChainsawManualUp = new JoystickButton(Oper2, 4);
//		oChainsawManualUp.whileHeld(new ChainsawManualUp());
//		oFourBarScoring = new JoystickButton(Oper2, 11);
//		oFourBarScoring.whenPressed(new LimitedPIDSubsystemSetpointCommand(Robot.chainsaw4Bar,Robot.chainsaw4Bar.scoringPosition, false));
//		oFourBarStoring = new JoystickButton(Oper2, 10);
//		oFourBarStoring.whenPressed(new LimitedPIDSubsystemSetpointCommand(Robot.chainsaw4Bar,Robot.chainsaw4Bar.storagePosition, false));
//		oFourBarHuman = new JoystickButton(Oper2, 9);
//		oFourBarHuman.whenPressed(new LimitedPIDSubsystemSetpointCommand(Robot.chainsaw4Bar,Robot.chainsaw4Bar.humanPosition, false));
//		oFourBarManualIn = new JoystickButton(Oper2, 8);
//		oFourBarManualIn.whileHeld(new LimitedManualCommand(Robot.chainsaw4Bar, -0.2));
//		oFourBarManualOut = new JoystickButton(Oper2, 7);
//		oFourBarManualOut.whileHeld(new LimitedManualCommand(Robot.chainsaw4Bar, 0.2));
//		oChainsawReset = new JoystickButton(Oper1, 1);
//		oChainsawReset.whenPressed(new ResetChainsaw());
//		oAnalogChainsaw = new JoystickButton(Oper1,8);
//		oAnalogChainsaw.whileHeld(new AnalogDriveChainsaw());
//		
	}

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getdriveJoystick() {
        return driveJoystick;
    }

    public Joystick getsecondaryJoystick() {
        return secondaryJoystick;
    }

    public Joystick getConsole() {
        return console;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
	/**
	 * 
	 * @param value
	 *            a double from a joystick
	 * @return The value if absolute value greater than deadzone or 0 if not
	 */
	public static double deadband(double value) {
		if (Math.abs(value) < deadzone)
			return 0;
		else
			return value;
	}
}
