// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc190.FRC2k15.subsystems;

import org.usfirst.frc190.FRC2k15.RobotMap;
import org.usfirst.frc190.FRC2k15.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Drivetrain extends Subsystem {
	
	private boolean isFieldOriented = true;
	private boolean isSquaredInputs = false;
	private int drivingMode = 0;
		//0 = One Joystick
		//1 = Two Joysticks, second joystick has X for Rotation
		//2 = Two Joysticks, second joystick has Y for Rotation
		//3 = Two Joysticks, second joystick has Z for Rotation
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController frontLeft = RobotMap.drivetrainfrontLeft;
    SpeedController backLeft = RobotMap.drivetrainbackLeft;
    SpeedController frontRight = RobotMap.drivetrainfrontRight;
    SpeedController backRight = RobotMap.drivetrainbackRight;
    RobotDrive robotDriveObject = RobotMap.drivetrainRobotDriveObject;
    Encoder backLeftEncoder = RobotMap.drivetrainbackLeftEncoder;
    Encoder frontLeftEncoder = RobotMap.drivetrainfrontLeftEncoder;
    Encoder backRightEncoder = RobotMap.drivetrainbackRightEncoder;
    Encoder frontRightEncoder = RobotMap.drivetrainfrontRightEncoder;
    Gyro gyro = RobotMap.drivetrainGyro;
    DigitalInput leftLimit = RobotMap.drivetrainleftLimit;
    DigitalInput rightLimit = RobotMap.drivetrainrightLimit;
    AnalogInput farLeftIR = RobotMap.drivetrainfarLeftIR;
    AnalogInput midLeftIR = RobotMap.drivetrainmidLeftIR;
    AnalogInput farRightIR = RobotMap.drivetrainfarRightIR;
    AnalogInput midRightIR = RobotMap.drivetrainmidRightIR;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new RegularDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void MecanumDrive(double xSpeed, double ySpeed, double rSpeed, double heading){
    	robotDriveObject.mecanumDrive_Cartesian(xSpeed, ySpeed, rSpeed, heading);
    }
    
    public double getHeading(){
    	return gyro.getAngle();
    }
    
    public void resetGyro(){
    	gyro.reset();
    }
    
    
    
    public void setDrivingMode(int inDrivingMode){
    	drivingMode = inDrivingMode;
    }
    
    public int getDrivingMode(){
    	return drivingMode;
    }
    
    
    
    public boolean getLeftBumper(){
    	return leftLimit.get();
    }
    
    public boolean getRightBumper(){
    	return rightLimit.get();
    }
    
    
    
    public void setFieldOriented(){
    	isFieldOriented = true;
    }
    
    public void setFieldOriented(boolean inIsFieldOriented){
    	isFieldOriented = inIsFieldOriented;
    }
    
    public void setRobotOriented(){
    	isFieldOriented = false;
    }
    
    public boolean isFieldOriented(){
    	return isFieldOriented;
    }
    
    
    
    public void setSquaredInputs(boolean inSquaredInputs){
    	isSquaredInputs = inSquaredInputs;
    }
    
    public boolean isSquaredInputs(){
    	return isSquaredInputs;
    }
}

