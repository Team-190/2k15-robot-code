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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;

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
    public JoystickButton joystickButton1;
    public JoystickButton joystickButton3;
    public JoystickButton joystickButton4;
    public JoystickButton joystickButton5;
    public JoystickButton joystickButton6;
    public JoystickButton joystickButton7;
    public JoystickButton joystickButton8;
    public JoystickButton joystickButton9;
    public JoystickButton joystickButton10;
    public Joystick driveJoystick;
    public Joystick secondaryJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public OI() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        secondaryJoystick = new Joystick(1);
        
        driveJoystick = new Joystick(0);
        
        joystickButton10 = new JoystickButton(driveJoystick, 10);
        joystickButton10.whenPressed(new SetDrivingMode3());
        joystickButton9 = new JoystickButton(driveJoystick, 9);
        joystickButton9.whenPressed(new SetDrivingMode2());
        joystickButton8 = new JoystickButton(driveJoystick, 8);
        joystickButton8.whenPressed(new SetDrivingMode1());
        joystickButton7 = new JoystickButton(driveJoystick, 7);
        joystickButton7.whenPressed(new SetDrivingMode0());
        joystickButton6 = new JoystickButton(driveJoystick, 6);
        joystickButton6.whenPressed(new SetSquaredInputs());
        joystickButton5 = new JoystickButton(driveJoystick, 5);
        joystickButton5.whenPressed(new SetLinearInputs());
        joystickButton4 = new JoystickButton(driveJoystick, 4);
        joystickButton4.whenPressed(new SetFieldOriented());
        joystickButton3 = new JoystickButton(driveJoystick, 3);
        joystickButton3.whenPressed(new SetRobotOriented());
        joystickButton1 = new JoystickButton(driveJoystick, 1);
        joystickButton1.whenPressed(new ResetGyro());

	    
        // SmartDashboard Buttons
        SmartDashboard.putData("DriveTurn", new DriveTurn());

        SmartDashboard.putData("SpeedControlledDrive", new SpeedControlledDrive());

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

        SmartDashboard.putData("Do Nothing", new DoNothing());

        SmartDashboard.putData("SetSquaredInputs", new SetSquaredInputs());

        SmartDashboard.putData("SetLinearInputs", new SetLinearInputs());

        SmartDashboard.putData("SetDrivingMode0", new SetDrivingMode0());

        SmartDashboard.putData("SetDrivingMode1", new SetDrivingMode1());

        SmartDashboard.putData("SetDrivingMode2", new SetDrivingMode2());

        SmartDashboard.putData("SetDrivingMode3", new SetDrivingMode3());

        SmartDashboard.putData("Delay", new Delay());


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
	}

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getdriveJoystick() {
        return driveJoystick;
    }

    public Joystick getsecondaryJoystick() {
        return secondaryJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
