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
    public JoystickButton fourBarScoringBtn;
    public JoystickButton fourBarStoringBtn;
    public JoystickButton fourBarHumanBtn;
    public JoystickButton fourBarManualPlusBtn;
    public JoystickButton fourBarManualMinusBtn;
    public JoystickButton tinesInManualBtn;
    public JoystickButton tinesOutManualBtn;
    public JoystickButton tinesUpManualBtn;
    public JoystickButton tinesDownManualBtn;
    public JoystickButton toteAlignConsole;
    public Joystick console;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private static double deadzone = 0.08;
	public OI() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        console = new Joystick(2);
        
        toteAlignConsole = new JoystickButton(console, 1);
        toteAlignConsole.whenPressed(new ToteAlign());
        tinesDownManualBtn = new JoystickButton(console, 1);
        tinesDownManualBtn.whileHeld(new DoNothing());
        tinesUpManualBtn = new JoystickButton(console, 1);
        tinesUpManualBtn.whileHeld(new DoNothing());
        tinesOutManualBtn = new JoystickButton(console, 1);
        tinesOutManualBtn.whileHeld(new DoNothing());
        tinesInManualBtn = new JoystickButton(console, 1);
        tinesInManualBtn.whileHeld(new DoNothing());
        fourBarManualMinusBtn = new JoystickButton(console, 1);
        fourBarManualMinusBtn.whileHeld(new DoNothing());
        fourBarManualPlusBtn = new JoystickButton(console, 1);
        fourBarManualPlusBtn.whileHeld(new DoNothing());
        fourBarHumanBtn = new JoystickButton(console, 6);
        fourBarHumanBtn.whenPressed(new FourBarHumanLoadingPosition());
        fourBarStoringBtn = new JoystickButton(console, 5);
        fourBarStoringBtn.whenPressed(new FourBarStoragePosition());
        fourBarScoringBtn = new JoystickButton(console, 4);
        fourBarScoringBtn.whenPressed(new FourBarScoringPosition());
        chainsawManualDownBtn = new JoystickButton(console, 1);
        chainsawManualDownBtn.whileHeld(new DoNothing());
        chainsawManualUpBtn = new JoystickButton(console, 1);
        chainsawManualUpBtn.whileHeld(new DoNothing());
        chainsawMinusBtn = new JoystickButton(console, 2);
        chainsawMinusBtn.whenPressed(new DecreaseChainsawPosition());
        chainsawPlusBtn = new JoystickButton(console, 1);
        chainsawPlusBtn.whenPressed(new IncreaseChainsawPosition());
        secondaryJoystick = new Joystick(1);
        
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
        SmartDashboard.putData("Do Nothing", new DoNothing());

        SmartDashboard.putData("DriveTurn", new DriveTurn());

        SmartDashboard.putData("ResetGyro", new ResetGyro());

        SmartDashboard.putData("AutonomousCommand", new AutonomousCommand());

        SmartDashboard.putData("GetIntoAutoPosition", new GetIntoAutoPosition());

        SmartDashboard.putData("DriveUntilToteDetectedAuto", new DriveUntilToteDetectedAuto());

        SmartDashboard.putData("SetTinesPosition", new SetTinesPosition());

        SmartDashboard.putData("DriveDistDirection", new DriveDistDirection());

        SmartDashboard.putData("AutoYToteCollect", new AutoYToteCollect());

        SmartDashboard.putData("DeliverStack", new DeliverStack());

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

        SmartDashboard.putData("TinesWideTote", new TinesWideTote());

        SmartDashboard.putData("TinesNarrowTote", new TinesNarrowTote());

        SmartDashboard.putData("TinesContainer", new TinesContainer());

        SmartDashboard.putData("TinesOpen", new TinesOpen());

        SmartDashboard.putData("TineElevatorBottom", new TineElevatorBottom());

        SmartDashboard.putData("TineElevatorTop", new TineElevatorTop());

        SmartDashboard.putData("TineElevatorHumanLoad", new TineElevatorHumanLoad());

        SmartDashboard.putData("FourBarScoringPosition", new FourBarScoringPosition());

        SmartDashboard.putData("FourBarStoragePosition", new FourBarStoragePosition());

        SmartDashboard.putData("FourBarHumanLoadingPosition", new FourBarHumanLoadingPosition());

        SmartDashboard.putData("ToteAlign", new ToteAlign());

        SmartDashboard.putData("ResetEncoders", new ResetEncoders());

        SmartDashboard.putData("DriveDistTestSequence", new DriveDistTestSequence());

        SmartDashboard.putData("ResetChainsaw", new ResetChainsaw());

        SmartDashboard.putData("IncreaseChainsawPosition", new IncreaseChainsawPosition());

        SmartDashboard.putData("DecreaseChainsawPosition", new DecreaseChainsawPosition());


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        SmartDashboard.putData("90 degree Turn", new TurnAngle(90));
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
    public static double deadband(double value){
    	if(Math.abs(value)<deadzone)
    		return 0;
    	else
    	return value;
    }
}
