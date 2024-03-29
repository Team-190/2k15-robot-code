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

import java.text.Normalizer.Form;

import org.usfirst.frc190.FRC2k15.Robot;
import org.usfirst.frc190.FRC2k15.RobotMap;
import org.usfirst.frc190.FRC2k15.commands.RegularDrive;

import com.kauailabs.nav6.frc.IMU;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Relay;

/**
 *
 */
public class Drivetrain extends Subsystem {
	private boolean isFieldOriented = false;
	private boolean isSquaredInputs = true;
	// 0 = One Joystick
	// 1 = Two Joysticks, second joystick has X for Rotation
	// 2 = Two Joysticks, second joystick has Y for Rotation
	// 3 = Two Joysticks, second joystick has Z for Rotation
	private int drivingMode = 3;

	// voltage of the ir when within range (greater than this tote in range)
	private double IRRangeLimit = 1.0;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    Encoder backLeftEncoder = RobotMap.drivetrainbackLeftEncoder;
    Encoder frontLeftEncoder = RobotMap.drivetrainfrontLeftEncoder;
    Encoder backRightEncoder = RobotMap.drivetrainbackRightEncoder;
    Encoder frontRightEncoder = RobotMap.drivetrainfrontRightEncoder;
    DigitalInput leftLimit = RobotMap.drivetrainleftLimit;
    DigitalInput rightLimit = RobotMap.drivetrainrightLimit;
    AnalogInput leftIR = RobotMap.drivetrainLeftIR;
    AnalogInput rightIR = RobotMap.drivetrainRightIR;
    Relay wings = RobotMap.drivetrainWings;
    Gyro gyro = RobotMap.drivetrainGyro;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	RobotDrive robotDriveObject = RobotMap.drivetrainRobotDriveObject;
	
	// Initialize IMU
	IMU imu;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new RegularDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
        
        //Set the relay for the wings to act in the forward direction
        wings.setDirection(Relay.Direction.kForward);
        
        // Initilize IMU
        imu = new IMU(new SerialPort(57600, SerialPort.Port.kMXP));
	}

	// field oriented mecanum drive
	public void MecanumDrive(double xSpeed, double ySpeed, double rSpeed,
			double heading) {
		//If the robot is told to go at 0 speed, then it resets the Integral value
		if(xSpeed == 0 && ySpeed == 0 && rSpeed == 0){
			RobotMap.drivetrainbackLeft.reset();
			RobotMap.drivetrainbackRight.reset();
			RobotMap.drivetrainfrontLeft.reset();
			RobotMap.drivetrainfrontRight.reset();
			
			RobotMap.drivetrainbackLeft.enable();
			RobotMap.drivetrainbackRight.enable();
			RobotMap.drivetrainfrontLeft.enable();
			RobotMap.drivetrainfrontRight.enable();
		}
		robotDriveObject
				.mecanumDrive_Cartesian(xSpeed, ySpeed, rSpeed, heading);
	}

	// non field oriented mecanum drive
	public void MecanumDrivePolar(double speed, double direction,
			double rotation) {
		robotDriveObject.mecanumDrive_Polar(speed, direction, rotation);
	}

	// gets the angle of the gyroscope
	public double getHeading() {
//		return imu.getYaw();
		return gyro.getAngle();
	}

	// resets the gyroscope angle
	public void resetGyro() {
//		imu.zeroYaw();
		gyro.reset();
	}

	// sets the driving mode for tele operated drive
	public void setDrivingMode(int inDrivingMode) {
		if (0 <= inDrivingMode && inDrivingMode <= 3) {
			drivingMode = inDrivingMode;
		}
	}

	// gets the driving mode for tele operated drive
	public int getDrivingMode() {
		return drivingMode;
	}

	// returns the left bumper
	// true if pressed false if not
	public boolean getLeftBumper() {
		return leftLimit.get();
	}

	// returns the right bumper
	// true if pressed false if not
	public boolean getRightBumper() {
		return rightLimit.get();
	}

	// sets the teleoperated drive to field oriented
	public void setFieldOriented() {
		isFieldOriented = true;
	}

	// sets the teleoperated drive to robot oriented
	public void setRobotOriented() {
		isFieldOriented = false;
	}

	// sets the teleoperated drive to inIsFieldOriented
	// true is field oriented false is not
	public void setFieldOriented(boolean inIsFieldOriented) {
		isFieldOriented = inIsFieldOriented;
	}

	// returns the field oriented status of the robot
	// true is field oriented false is not
	public boolean isFieldOriented() {
		return isFieldOriented;
	}

	// sets the teleoperated drive inputs to squared
	// true is squared false is non squared
	public void setSquaredInputs(boolean inIsSquredInputs) {
		isSquaredInputs = inIsSquredInputs;
	}

	// returns the squared inputs status
	// true is squared false is non squared
	public boolean isSquaredInputs() {
		return isSquaredInputs;
	}

	// displays the sensor data to the SmartDashboard
	public void displaySensorData() {
		SmartDashboard.putNumber("Left IR", leftIR.getVoltage());
		SmartDashboard.putNumber("Right IR", rightIR.getVoltage());
		SmartDashboard.putBoolean("Left Bumper", leftLimit.get());
		SmartDashboard.putBoolean("Right bumper", rightLimit.get());
	}
	
	public double getLeftIR(){
		return leftIR.getVoltage();
	}
	
	public double getRightIR(){
		return rightIR.getVoltage();
	}

	// returns if the left ir is clear (false means tote within range)
	public boolean getLeftIRWithinRange() {
		return leftIR.getVoltage() > IRRangeLimit;
	}

	// returns if the right ir is clear (false means tote within range)
	public boolean getRightIRWithinRange() {
		return rightIR.getVoltage() > IRRangeLimit;
	}

	public void resetEncoders() {
		backLeftEncoder.reset();
		backRightEncoder.reset();
		frontLeftEncoder.reset();
		frontRightEncoder.reset();
	}

	// returns the distance the robot has traveled in inches
	// assumes the robot hasn't rotated
	// only returns a positive number
	//TODO: Explain Math
	public double getDistance() {

		double a = frontLeftEncoder.getDistance();
		double b = frontRightEncoder.getDistance();
		double c = backLeftEncoder.getDistance();
		double d = backRightEncoder.getDistance();

		double dist = (0.25) * (Math.sqrt(Math.pow((a - c), 2)
				+ Math.pow((a + c), 2)) + Math.sqrt(Math.pow((b - d), 2)
				+ Math.pow((b + d), 2)));

		SmartDashboard.putNumber("Current Distance", dist);

		return dist;
	}
	
	public void fireWings () {
		wings.set(Relay.Value.kOn);
	}
	
	public void disableWings (){
		wings.set(Relay.Value.kOff);
	}
	
}
