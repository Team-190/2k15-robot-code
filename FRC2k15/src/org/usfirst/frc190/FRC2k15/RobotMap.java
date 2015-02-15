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

import org.usfirst.frc190.FRC2k15.Components.EncodedMotor;
import org.usfirst.frc190.FRC2k15.Components.I2Cgyro;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final double maxDriveSpeed = 108.0;
	private static final double ki = 0.0;	 //0.001;
	private static final double kf = 0.007;
	
	private static final double driveObjectExpiration = 0.1;
	private static final double driveObjectSensitivity = 0.5;
	private static final double driveObjectMaxOutput = 1.0;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Encoder drivetrainbackLeftEncoder;
    public static Encoder drivetrainfrontLeftEncoder;
    public static Encoder drivetrainbackRightEncoder;
    public static Encoder drivetrainfrontRightEncoder;
    public static Gyro drivetrainGyro;
    public static DigitalInput drivetrainleftLimit;
    public static DigitalInput drivetrainrightLimit;
    public static AnalogInput drivetrainLeftIR;
    public static AnalogInput drivetrainRightIR;
    public static SpeedController tineGrippergripper;
    public static AnalogPotentiometer tineGrippergripperPot;
    public static DigitalInput tineGripperopen;
    public static DigitalInput tineGripperclosed;
    public static AnalogPotentiometer tineElevatorelevatorPot;
    public static SpeedController tineElevatorelevator;
    public static DigitalInput tineElevatortopLimit;
    public static DigitalInput tineElevatorlowerLimit;
    public static SpeedController chainsawchainsaw;
    public static DigitalInput chainsawhookDetector;
    public static Encoder chainsawchainsawEncoder;
    public static AnalogPotentiometer chainsaw4BarfourBarPot;
    public static SpeedController chainsaw4BarfourBar;
    public static DigitalInput chainsaw4BarfourBarExtended;
    public static DigitalInput chainsaw4BarfourBarRetracted;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public static EncodedMotor drivetrainfrontLeft;
	public static EncodedMotor drivetrainbackLeft;
	public static EncodedMotor drivetrainfrontRight;
	public static EncodedMotor drivetrainbackRight;
	public static RobotDrive drivetrainRobotDriveObject;
	public static I2Cgyro gyro;
	public static void init() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrainbackLeftEncoder = new Encoder(4, 5, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "backLeftEncoder", drivetrainbackLeftEncoder);
        drivetrainbackLeftEncoder.setDistancePerPulse(1.0);
        drivetrainbackLeftEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivetrainfrontLeftEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "frontLeftEncoder", drivetrainfrontLeftEncoder);
        drivetrainfrontLeftEncoder.setDistancePerPulse(1.0);
        drivetrainfrontLeftEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivetrainbackRightEncoder = new Encoder(6, 7, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "backRightEncoder", drivetrainbackRightEncoder);
        drivetrainbackRightEncoder.setDistancePerPulse(1.0);
        drivetrainbackRightEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivetrainfrontRightEncoder = new Encoder(3, 2, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "frontRightEncoder", drivetrainfrontRightEncoder);
        drivetrainfrontRightEncoder.setDistancePerPulse(1.0);
        drivetrainfrontRightEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivetrainGyro = new Gyro(0);
        LiveWindow.addSensor("Drivetrain", "Gyro", drivetrainGyro);
        drivetrainGyro.setSensitivity(0.007);
        drivetrainleftLimit = new DigitalInput(14);
        LiveWindow.addSensor("Drivetrain", "leftLimit", drivetrainleftLimit);
        
        drivetrainrightLimit = new DigitalInput(13);
        LiveWindow.addSensor("Drivetrain", "rightLimit", drivetrainrightLimit);
        
        drivetrainLeftIR = new AnalogInput(1);
        LiveWindow.addSensor("Drivetrain", "LeftIR", drivetrainLeftIR);
        
        drivetrainRightIR = new AnalogInput(3);
        LiveWindow.addSensor("Drivetrain", "RightIR", drivetrainRightIR);
        
        tineGrippergripper = new Victor(4);
        LiveWindow.addActuator("TineGripper", "gripper", (Victor) tineGrippergripper);
        
        tineGrippergripperPot = new AnalogPotentiometer(5, 1.0, 0.0);
        LiveWindow.addSensor("TineGripper", "gripperPot", tineGrippergripperPot);
        
        tineGripperopen = new DigitalInput(15);
        LiveWindow.addSensor("TineGripper", "open", tineGripperopen);
        
        tineGripperclosed = new DigitalInput(16);
        LiveWindow.addSensor("TineGripper", "closed", tineGripperclosed);
        
        tineElevatorelevatorPot = new AnalogPotentiometer(6, 1.0, 0.0);
        LiveWindow.addSensor("TineElevator", "elevatorPot", tineElevatorelevatorPot);
        
        tineElevatorelevator = new Victor(5);
        LiveWindow.addActuator("TineElevator", "elevator", (Victor) tineElevatorelevator);
        
        tineElevatortopLimit = new DigitalInput(10);
        LiveWindow.addSensor("TineElevator", "topLimit", tineElevatortopLimit);
        
        tineElevatorlowerLimit = new DigitalInput(11);
        LiveWindow.addSensor("TineElevator", "lowerLimit", tineElevatorlowerLimit);
        
        chainsawchainsaw = new Victor(6);
        LiveWindow.addActuator("Chainsaw", "chainsaw", (Victor) chainsawchainsaw);
        
        chainsawhookDetector = new DigitalInput(12);
        LiveWindow.addSensor("Chainsaw", "hookDetector", chainsawhookDetector);
        
        chainsawchainsawEncoder = new Encoder(17, 18, false, EncodingType.k4X);
        LiveWindow.addSensor("Chainsaw", "chainsawEncoder", chainsawchainsawEncoder);
        chainsawchainsawEncoder.setDistancePerPulse(1.0);
        chainsawchainsawEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        chainsaw4BarfourBarPot = new AnalogPotentiometer(2, 1.0, 0.0);
        LiveWindow.addSensor("Chainsaw4Bar", "fourBarPot", chainsaw4BarfourBarPot);
        
        chainsaw4BarfourBar = new Victor(7);
        LiveWindow.addActuator("Chainsaw4Bar", "fourBar", (Victor) chainsaw4BarfourBar);
        
        chainsaw4BarfourBarExtended = new DigitalInput(8);
        LiveWindow.addSensor("Chainsaw4Bar", "fourBarExtended", chainsaw4BarfourBarExtended);
        
        chainsaw4BarfourBarRetracted = new DigitalInput(9);
        LiveWindow.addSensor("Chainsaw4Bar", "fourBarRetracted", chainsaw4BarfourBarRetracted);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        //Robot motors listed below
        
        final int backRightMotorPin = 9; // right rear 9
        final int frontRightMotorPin = 1; // front right 1
        final int backLeftMotorPin = 8; //left rear 8
        final int frontLeftMotorPin = 2; // left front 2
        
		drivetrainfrontLeft = new EncodedMotor(ki , kf,
				drivetrainfrontLeftEncoder, new Victor(frontLeftMotorPin), maxDriveSpeed);
		LiveWindow.addActuator("Drivetrain", "frontLeft",
				(Victor) drivetrainfrontLeft.mtr);

		drivetrainbackLeft = new EncodedMotor(ki, kf,
				drivetrainbackLeftEncoder, new Victor(backLeftMotorPin), maxDriveSpeed);
		LiveWindow.addActuator("Drivetrain", "backLeft",
				(Victor) drivetrainbackLeft.mtr);

		drivetrainfrontRight = new EncodedMotor(ki , kf,
				drivetrainfrontRightEncoder, new Victor(frontRightMotorPin), maxDriveSpeed);
		LiveWindow.addActuator("Drivetrain", "frontRight",
				(Victor) drivetrainfrontRight.mtr);

		drivetrainbackRight = new EncodedMotor(ki , kf,
				drivetrainbackRightEncoder, new Victor(backRightMotorPin), maxDriveSpeed);
		LiveWindow.addActuator("Drivetrain", "backRight",
				(Victor) drivetrainbackRight.mtr);

		drivetrainRobotDriveObject = new RobotDrive(drivetrainfrontLeft,
				drivetrainbackLeft, drivetrainfrontRight, drivetrainbackRight);

		drivetrainRobotDriveObject.setSafetyEnabled(true);
		drivetrainRobotDriveObject.setExpiration(driveObjectExpiration);
		drivetrainRobotDriveObject.setSensitivity(driveObjectSensitivity);
		drivetrainRobotDriveObject.setMaxOutput(driveObjectMaxOutput);
		drivetrainRobotDriveObject.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		drivetrainRobotDriveObject.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

		EncodedMotor.setClosedLoop(true); //tells encodedMotor that motors are closed loop controlled
		gyro = I2Cgyro.getInstance();
	}
}
