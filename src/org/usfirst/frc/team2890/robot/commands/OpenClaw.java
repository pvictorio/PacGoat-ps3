package org.usfirst.frc.team2890.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2890.robot.Robot;

/**
 * Opens the claw
 */
public class OpenClaw extends Command {
	public OpenClaw() {
		requires(Robot.collector);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.collector.open();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Robot.collector.isOpen();
	}
}
