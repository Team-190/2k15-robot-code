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
import org.usfirst.frc190.FRC2k15.Components.VoiceCmds;
import org.usfirst.frc190.FRC2k15.commands.AutoYellowToteStack;
import org.usfirst.frc190.FRC2k15.commands.AutoStealContainers;
import org.usfirst.frc190.FRC2k15.commands.AutoDriveForward;
import org.usfirst.frc190.FRC2k15.commands.DoNothing;
import org.usfirst.frc190.FRC2k15.subsystems.Chainsaw;
import org.usfirst.frc190.FRC2k15.subsystems.Chainsaw4Bar;
import org.usfirst.frc190.FRC2k15.subsystems.Drivetrain;
import org.usfirst.frc190.FRC2k15.subsystems.TineElevator;
import org.usfirst.frc190.FRC2k15.subsystems.TineGripper;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Command autonomousCommand;

	public static OI oi;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Drivetrain drivetrain;
    public static TineGripper tineGripper;;
    public static TineElevator tineElevator;;
    public static Chainsaw chainsaw;;
    public static Chainsaw4Bar chainsaw4Bar;;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public SendableChooser autoChooser;
    //This function is run when the robot is first started up and should be
    //used for any initialization code.
    
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		VoiceCmds.init();	//For some reason needs to be initialized before Commands or else 
							//null pointer exception will be thrown.
		RobotMap.init();
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrain = new Drivetrain();
        tineGripper = new TineGripper();
        tineElevator = new TineElevator();
        chainsaw = new Chainsaw();
        chainsaw4Bar = new Chainsaw4Bar();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();
		

		// instantiate the command used for the autonomous period
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        disableDriveTrain();
        
        //This code sets up the sendable chooser on the smart dashboard
        //It allows the driver to select which auto mode to run prior to the match
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Yellow Tote Stack", new AutoYellowToteStack());
        autoChooser.addObject("Steal Containers", new AutoStealContainers());
        autoChooser.addObject("Drive to Autozone", new AutoDriveForward());
        autoChooser.addObject("Do Nothing", new DoNothing());
        SmartDashboard.putData("Auto Mode", autoChooser);
        
        VoiceCmds.speak(VoiceCmds.r_turningOn);
        SmartDashboard.putData(Scheduler.getInstance());
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {
		disableDriveTrain();
		VoiceCmds.speak(VoiceCmds.r_disable);
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		enableDriveTrain();
		
		//This gets the auto command chosen by the drivers and starts it
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
        
		VoiceCmds.speak(VoiceCmds.a_r_autoBeginning);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		enableDriveTrain();
		VoiceCmds.speak(VoiceCmds.r_teleopBeginning);
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putBoolean("HookDetector", chainsaw.atZero());
		SmartDashboard.putNumber("Chainsaw Encoder", RobotMap.chainsawchainsawEncoder.getDistance());
		SmartDashboard.putNumber("Chainsaw Error" , chainsaw.getPIDController().getError());
		
		SmartDashboard.putNumber("FL Encoder", RobotMap.drivetrainfrontLeftEncoder.getDistance());
		SmartDashboard.putNumber("FR Encoder", RobotMap.drivetrainfrontRightEncoder.getDistance());
		SmartDashboard.putNumber("BL Encoder", RobotMap.drivetrainbackLeftEncoder.getDistance());
		SmartDashboard.putNumber("BR Encoder", RobotMap.drivetrainbackRightEncoder.getDistance());
		
		SmartDashboard.putNumber("FL Encoder Speed", RobotMap.drivetrainfrontLeftEncoder.getRate());
		SmartDashboard.putNumber("FR Encoder Speed", RobotMap.drivetrainfrontRightEncoder.getRate());
		SmartDashboard.putNumber("BL Encoder Speed", RobotMap.drivetrainbackLeftEncoder.getRate());
		SmartDashboard.putNumber("BR Encoder Speed", RobotMap.drivetrainbackRightEncoder.getRate());
		
		SmartDashboard.putNumber("Joystick X", Robot.oi.driveJoystick.getX());
		SmartDashboard.putNumber("Joystick Y", Robot.oi.driveJoystick.getY());
	}
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();		
	}
	public void testInit(){
		LiveWindow.setEnabled(true);
	}
	/**
	 * Disables the drivetrain IF controls
	 */
	private void disableDriveTrain() {
		for(EncodedMotor enc: EncodedMotor.mtrs){
			enc.disable();
		}
	}
	/**
	 * Enables the drivetrain IF controls
	 */
	private void enableDriveTrain() {
		for(EncodedMotor enc: EncodedMotor.mtrs){
			enc.enable();
		}
	}
}
