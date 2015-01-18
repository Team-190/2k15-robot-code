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
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController drivetrainfrontLeft;
    public static SpeedController drivetrainbackLeft;
    public static SpeedController drivetrainfrontRight;
    public static SpeedController drivetrainbackRight;
    public static RobotDrive drivetrainRobotDrive41;
    public static Encoder drivetrainbackLeftEncoder;
    public static Encoder drivetrainfrontLeftEncoder;
    public static Encoder drivetrainbackRightEncoder;
    public static Encoder drivetrainfrontRightEncoder;
    public static Gyro drivetrainGyro1;
    public static DigitalInput drivetrainleftLimit;
    public static DigitalInput drivetrainrightLimit;
    public static AnalogInput drivetrainfarLeftIR;
    public static AnalogInput drivetrainmidLeftIR;
    public static AnalogInput drivetrainfarRightIR;
    public static AnalogInput drivetrainmidRightIR;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrainfrontLeft = new Victor(0);
        LiveWindow.addActuator("Drivetrain", "frontLeft", (Victor) drivetrainfrontLeft);
        
        drivetrainbackLeft = new Victor(1);
        LiveWindow.addActuator("Drivetrain", "backLeft", (Victor) drivetrainbackLeft);
        
        drivetrainfrontRight = new Victor(2);
        LiveWindow.addActuator("Drivetrain", "frontRight", (Victor) drivetrainfrontRight);
        
        drivetrainbackRight = new Victor(3);
        LiveWindow.addActuator("Drivetrain", "backRight", (Victor) drivetrainbackRight);
        
        drivetrainRobotDrive41 = new RobotDrive(drivetrainfrontLeft, drivetrainbackLeft,
              drivetrainfrontRight, drivetrainbackRight);
        
        drivetrainRobotDrive41.setSafetyEnabled(true);
        drivetrainRobotDrive41.setExpiration(0.1);
        drivetrainRobotDrive41.setSensitivity(0.5);
        drivetrainRobotDrive41.setMaxOutput(1.0);

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
        drivetrainGyro1 = new Gyro(0);
        LiveWindow.addSensor("Drivetrain", "Gyro 1", drivetrainGyro1);
        drivetrainGyro1.setSensitivity(0.007);
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
    }
}
