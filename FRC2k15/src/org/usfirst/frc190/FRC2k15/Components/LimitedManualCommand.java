package org.usfirst.frc190.FRC2k15.Components;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Manual Command for a LimitedPIDSubsytem Call in a JoystickButton.whileheld()
 */
public class LimitedManualCommand extends Command {
	private LimitedPIDSubsystem subsystem;
	private double speed;
	private boolean increasing;

	/**
	 * 
	 * @param isubsystem
	 *            the subsystem to use
	 * @param ispeed
	 *            the speed to set
	 */
	public LimitedManualCommand(LimitedPIDSubsystem isubsystem, double ispeed) {
		subsystem = isubsystem;
		speed = ispeed;
		requires(subsystem.getSubSystem());
		if (speed > 0)
			increasing = true;
		else
			increasing = false;
	}

	protected void initialize() {
	}

	protected void execute() {
		if (!limited())
			subsystem.setSpeed(speed);
		else
			subsystem.setSpeed(0);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		subsystem.setSpeed(0);
	}

	protected void interrupted() {
		subsystem.setSpeed(0);
	}

	/**
	 * Determines if the system has reached its limit based on direction of
	 * motion
	 * 
	 * @return true if has reached limit false if has not reached limit
	 */
	private boolean limited() {
		if (increasing)
			return subsystem.atmax();
		else
			return subsystem.atmin();
	}
}
