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

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import edu.wpi.first.wpilibj.Encoder;

import org.usfirst.frc190.FRC2k15.Components.EncodedMotor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	private static final double distperpulse = 0.0001466;
	private static final double kp = 0.0;
	private static final double ki = 0.0;
	private static final double kd = 0.0;
	private static final double kf = 1.0;
	private static final double driveLoopPeriod = 0.005;
	
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Encoder drivetrainbackLeftEncoder;
    public static Encoder drivetrainfrontLeftEncoder;
    public static Encoder drivetrainbackRightEncoder;
    public static Encoder drivetrainfrontRightEncoder;
    public static Gyro drivetrainGyro;
    public static DigitalInput drivetrainleftLimit;
    public static DigitalInput drivetrainrightLimit;
    public static AnalogInput drivetrainfarLeftIR;
    public static AnalogInput drivetrainmidLeftIR;
    public static AnalogInput drivetrainfarRightIR;
    public static AnalogInput drivetrainmidRightIR;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public static EncodedMotor drivetrainfrontLeft;
    public static EncodedMotor drivetrainbackLeft;
    public static EncodedMotor drivetrainfrontRight;
    public static EncodedMotor drivetrainbackRight;
    public static RobotDrive drivetrainRobotDriveObject;
    
	public static void init() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrainbackLeftEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "backLeftEncoder", drivetrainbackLeftEncoder);
        drivetrainbackLeftEncoder.setDistancePerPulse(1.0);
        drivetrainbackLeftEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivetrainfrontLeftEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "frontLeftEncoder", drivetrainfrontLeftEncoder);
        drivetrainfrontLeftEncoder.setDistancePerPulse(1.0);
        drivetrainfrontLeftEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivetrainbackRightEncoder = new Encoder(4, 5, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "backRightEncoder", drivetrainbackRightEncoder);
        drivetrainbackRightEncoder.setDistancePerPulse(1.0);
        drivetrainbackRightEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivetrainfrontRightEncoder = new Encoder(6, 7, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "frontRightEncoder", drivetrainfrontRightEncoder);
        drivetrainfrontRightEncoder.setDistancePerPulse(1.0);
        drivetrainfrontRightEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivetrainGyro = new Gyro(0);
        LiveWindow.addSensor("Drivetrain", "Gyro", drivetrainGyro);
        drivetrainGyro.setSensitivity(0.007);
        drivetrainleftLimit = new DigitalInput(8);
        LiveWindow.addSensor("Drivetrain", "leftLimit", drivetrainleftLimit);
        
        drivetrainrightLimit = new DigitalInput(9);
        LiveWindow.addSensor("Drivetrain", "rightLimit", drivetrainrightLimit);
        
        drivetrainfarLeftIR = new AnalogInput(4);
        LiveWindow.addSensor("Drivetrain", "farLeftIR", drivetrainfarLeftIR);
        
        drivetrainmidLeftIR = new AnalogInput(1);
        LiveWindow.addSensor("Drivetrain", "midLeftIR", drivetrainmidLeftIR);
        
        drivetrainfarRightIR = new AnalogInput(2);
        LiveWindow.addSensor("Drivetrain", "farRightIR", drivetrainfarRightIR);
        
        drivetrainmidRightIR = new AnalogInput(3);
        LiveWindow.addSensor("Drivetrain", "midRightIR", drivetrainmidRightIR);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        drivetrainfrontLeft = new EncodedMotor(kp, ki, kd, kf,
				drivetrainfrontLeftEncoder, new Victor(1), driveLoopPeriod);
		LiveWindow.addActuator("Drivetrain", "frontLeft",
				(Victor) drivetrainfrontLeft.mtr);

		drivetrainbackLeft = new EncodedMotor(kp, ki, kd, kf,
				drivetrainbackLeftEncoder, new Victor(0), driveLoopPeriod);
		LiveWindow.addActuator("Drivetrain", "backLeft",
				(Victor) drivetrainbackLeft.mtr);

		drivetrainfrontRight = new EncodedMotor(kp, ki, kd, kf,
				drivetrainfrontRightEncoder, new Victor(3), driveLoopPeriod);
		LiveWindow.addActuator("Drivetrain", "frontRight",
				(Victor) drivetrainfrontRight.mtr);

		drivetrainbackRight = new EncodedMotor(kp, ki, kd, kf,
				drivetrainbackRightEncoder, new Victor(2), driveLoopPeriod);
		LiveWindow.addActuator("Drivetrain", "backRight",
				(Victor) drivetrainbackRight.mtr);
		
		
        
        drivetrainRobotDriveObject = new RobotDrive(drivetrainfrontLeft, drivetrainbackLeft,
              drivetrainfrontRight, drivetrainbackRight);
        
        drivetrainRobotDriveObject.setSafetyEnabled(true);
        drivetrainRobotDriveObject.setExpiration(0.1);
        drivetrainRobotDriveObject.setSensitivity(0.5);
        drivetrainRobotDriveObject.setMaxOutput(1.0);
        drivetrainRobotDriveObject.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drivetrainRobotDriveObject.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);

	}
}
