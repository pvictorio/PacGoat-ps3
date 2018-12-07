package org.usfirst.frc.team2890.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team2890.robot.subsystems.Collector;
import org.usfirst.frc.team2890.robot.subsystems.Pivot;

/**
 * Spit the ball out into the low goal assuming that the robot is in front of
 * it.
 */
public class LowGoal extends CommandGroup {
	public LowGoal() {
		addSequential(new SetPivotSetpoint(Pivot.kLowGoal));
		addSequential(new SetCollectionSpeed(Collector.kReverse));
		addSequential(new ExtendShooter());
	}
}
