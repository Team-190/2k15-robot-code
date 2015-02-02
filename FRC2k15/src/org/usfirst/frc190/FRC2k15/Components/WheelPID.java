package org.usfirst.frc190.FRC2k15.Components;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Timer;
import java.util.TimerTask;
//When using this class put in disabledInit() the disable() function and before use ie TeleopInit() the enable() function
public class WheelPID{
private double ki, kf; //Terms for "IF" control
private Encoder inp; //encoder input for system
private SpeedController mtr; //speed controller output
private double setpoint = 0.0; //the set speed for the motor
private static final long period = 10; //frequency of updating speed in milliseconds
private static final double maxOut = 1.0; //max and min values for speed controllers
private static final double minOut = -1.0;
private double minInp; //max and min values for setpoint
private double maxInp;
private static boolean enabled = false; //determines if the controllers are active or not
private double totalError = 0.0; //the total error used in calculating I 
private static final String iTableName = "Wheel I"; //table names for tables on smartdashboard for I and F values
private static final String fTableName = "Wheel F";
private String WheelName;
Timer controlLoop; //Timer to call functions every period seconds
	public WheelPID(double iki, double ikf, double mspd, Encoder source, SpeedController output){
		ki = iki;
		kf = ikf;
		inp = source;
		mtr = output;
		minInp = -mspd;
		maxInp = mspd;
		controlLoop = new java.util.Timer();
		controlLoop.schedule(new WheelTask(this), 0L, period);//adds the wheeltask to run every period milliseconds
	}
	public synchronized void setIF(double nI, double nF){ //set the IF values for the control loop
		ki = nI;
		kf = nF;
	}
	 public synchronized void setSetPoint(double spnt){//called to set the setpoint to a new value
		 if(spnt<minInp){//if setpoint is below min input
			 setpoint = minInp; //set setpoint to min input
		 }
		 else if(spnt>maxInp){ //if setpoint is above max input
			 setpoint = maxInp; //set setpoint to max input
		 }
		 else{ //otherwise setpoint is right value
		 setpoint = spnt;
		 }
	 }
	 private void calculate(){//calculates IF and sets speedcontroller to speed
		 boolean c_enabled;
		 Double input, err;
		 synchronized(this){
			 c_enabled = enabled;//create local clones for use outside of synchronized context
			 input = inp.getRate();
		 }
		 if(c_enabled){//if controller is enabled
			 err = setpoint-input;
			 synchronized(this){ //from PIDController class
                 double potentialIGain = (totalError + err) * ki;
                 if (potentialIGain < maxOut) {
                     if (potentialIGain > minOut) {
                         totalError += err;
                     } else {
                         totalError = minOut / ki;
                     }
                 } else {
                     totalError = maxOut / ki;
                 }
                 double tempOut = totalError*ki+setpoint*kf;
                 if(tempOut>maxOut){
                	 tempOut = maxOut;
                 }
                 else if(tempOut<minOut){
                	 tempOut = minOut;
                 }//End of things from PIDController class
                 if(Math.signum(tempOut)!=Math.signum(setpoint)){ //tests if output speed is same direction as setpoint if not then stop motor
                	 tempOut = 0;
                 }
                 mtr.pidWrite(tempOut);//Sets motor to calculated speed
			 }
		 }
	 }
	 private class WheelTask extends TimerTask{
		 private WheelPID wheel;
		public WheelTask(WheelPID whl){//initializes a timer with the proper wheelPID object
			wheel = whl;
		}
		 @Override
		public void run() {//called every period milliseconds to set mtr output to correct speed
				wheel.calculate();
		}
		 
	 }
	 public synchronized void enable(){ //enables the controller should be called before attempting to use ie TeleOpInit()
		 enabled = true;
	 }
	 public synchronized void disable(){ //disables the controller should be called in disabled init and any other time that the IF system is to be disabled
		 mtr.pidWrite(0);//set speed to 0
		 enabled = false;
	 }
	 public void initCalibTable(String thisWheelName){ //initializes the calibration table for IF on SmartDashboard
		 WheelName = thisWheelName;
		 SmartDashboard.putNumber(iTableName+WheelName, ki);
		 SmartDashboard.putNumber(fTableName+WheelName, kf);
	 }
	 public synchronized void UpdateCalibTable(){ //updates the IF values based on data in the table on SmartDashboard
		 if(WheelName != null){//Makes sure that init has already been called
		 ki = SmartDashboard.getNumber(iTableName+WheelName);
		 kf = SmartDashboard.getNumber(fTableName+WheelName);
		 }
		 
	 }
	 public synchronized double getSet(){//gets the setpoint for IF system.
		 return setpoint;
	 }
}
