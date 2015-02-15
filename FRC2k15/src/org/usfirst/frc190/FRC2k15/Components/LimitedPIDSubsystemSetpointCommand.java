package org.usfirst.frc190.FRC2k15.Components;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * General class for manipulating PID subsystems with max and min position limit
 * switches
 */
public class LimitedPIDSubsystemSetpointCommand extends Command {
	private double decreaseSpeed = -0.2;
	private double increaseSpeed = 0.2;
	private LimitedPIDSubsystem subSystem;
	private double setpoint;
	private boolean holdPosition = false;

	/**
	 * The states used in the state machine for the system
	 * 
	 * @author Patrick
	 *
	 */
	private enum State {
		MINLIM, MAXLIM, SETTING, FINISHED
	}

	State state;

	/**
	 * 
	 * @param iSubSystem
	 *            the subsystem to manipulate
	 * @param isetpoint
	 *            the setpoint to set
	 * @param plusSpeed
	 *            the speed for manual increase of position away from limit
	 * @param minusSpeed
	 *            the speed for manual decrease of position away from limit
	 */
	public LimitedPIDSubsystemSetpointCommand(LimitedPIDSubsystem iSubSystem,
			double isetpoint, double plusSpeed, double minusSpeed) {
		subSystem = iSubSystem;
		setpoint = isetpoint;
		increaseSpeed = plusSpeed;
		decreaseSpeed = minusSpeed;
		requires(subSystem.getSubSystem());
	}
	
	/**
	 * 
	 * @param iSubSystem
	 *            the subsystem to manipulate
	 * @param isetpoint
	 *            the setpoint to set
	 * @param plusSpeed
	 *            the speed for manual increase of position away from limit
	 * @param minusSpeed
	 *            the speed for manual decrease of position away from limit
	 * @param iHoldPosition
	 * 			  the boolean for whether PID control should hold the position after the command ends
	 */
	public LimitedPIDSubsystemSetpointCommand(LimitedPIDSubsystem iSubSystem,
			double isetpoint, double plusSpeed, double minusSpeed, boolean iHoldPosition) {
		subSystem = iSubSystem;
		setpoint = isetpoint;
		increaseSpeed = plusSpeed;
		decreaseSpeed = minusSpeed;
		holdPosition = iHoldPosition;
		requires(subSystem.getSubSystem());
	}

	/**
	 * 
	 * @param iSubSystem
	 *            the subsystem to manipulate
	 * @param isetpoint
	 *            the setpoint to set
	 */
	public LimitedPIDSubsystemSetpointCommand(LimitedPIDSubsystem iSubSystem,
			double isetpoint) {
		subSystem = iSubSystem;
		setpoint = isetpoint;
		requires(subSystem.getSubSystem());
	}
	
	/**
	 * 
	 * @param iSubSystem
	 *            the subsystem to manipulate
	 * @param isetpoint
	 *            the setpoint to set
	 * @param iHoldPosition
	 * 			  the boolean for whether PID control should hold the position after the command ends
	 */
	public LimitedPIDSubsystemSetpointCommand(LimitedPIDSubsystem iSubSystem,
			double isetpoint, boolean iHoldPosition) {
		subSystem = iSubSystem;
		setpoint = isetpoint;
		holdPosition = iHoldPosition;
		requires(subSystem.getSubSystem());
	}

	protected void initialize() {
		setState();
	}

	protected void execute() {
		switch (state) {
		case MAXLIM:
			subSystem.setSpeed(decreaseSpeed);
			setState();
			break;
		case MINLIM:
			subSystem.setSpeed(increaseSpeed);
			setState();
			break;
		case SETTING:
			subSystem.setPosition(setpoint);
			state = State.FINISHED;
			break;
		case FINISHED:
			break;
		default:
			break;

		}
	}

	protected boolean isFinished() {
		return subSystem.atPosition()||(isLimited() && state == State.FINISHED);
	}

	protected void end() {
		if(isLimited()||!holdPosition){
			subSystem.setSpeed(0);
		}
	}

	protected void interrupted() {
		subSystem.setSpeed(0);
	}
	
private boolean isLimited(){
	boolean limited = subSystem.atmax()||subSystem.atmin();
	SmartDashboard.putBoolean("Min", subSystem.atmin());
	SmartDashboard.putBoolean("Max", subSystem.atmax());
	SmartDashboard.putBoolean("Limited", limited);
	return limited;
}
	/**
	 * Used to set the state for the subSystem
	 */
	private void setState() {
		if (subSystem.atmin()) {
			state = State.MINLIM;
		} else if (subSystem.atmax()) {
			state = State.MAXLIM;
		} else {
			state = State.SETTING;
		}
	}
}
