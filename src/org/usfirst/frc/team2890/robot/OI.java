package org.usfirst.frc.team2890.robot;

import org.usfirst.frc.team2890.robot.commands.Collect;
import org.usfirst.frc.team2890.robot.commands.DriveForward;
import org.usfirst.frc.team2890.robot.commands.LowGoal;
import org.usfirst.frc.team2890.robot.commands.SetCollectionSpeed;
import org.usfirst.frc.team2890.robot.commands.SetPivotSetpoint;
import org.usfirst.frc.team2890.robot.commands.Shoot;
import org.usfirst.frc.team2890.robot.subsystems.Collector;
import org.usfirst.frc.team2890.robot.subsystems.Pivot;
import org.usfirst.frc.team2890.robot.triggers.DoubleButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The operator interface of the robot, it has been simplified from the real
 * robot to allow control with a single PS3 joystick. As a result, not all
 * functionality from the real robot is available.
 */
public class OI {
	public Joystick joystick = new Joystick(1); // see jstest-gtk for PS3 Controller #

	public OI() {
		new JoystickButton(joystick, 6).whenPressed(new LowGoal());	//6=PS3-R1
		new JoystickButton(joystick, 1).whenPressed(new Collect());	// 1=PS3-X-button

		new JoystickButton(joystick, 4).whenPressed(new SetPivotSetpoint(Pivot.kShoot)); // 4=PS3-Square-button
		new JoystickButton(joystick, 2).whenPressed(new SetPivotSetpoint(Pivot.kShootNear)); //2=PS3-Circle-button

		//new DoubleButton(joystick, 2, 3).whenActive(new Shoot());  // PS3 is Triangle+Circle buttons.
		new JoystickButton(joystick, 3).whenPressed(new Shoot());  // 3=PS3-Triangle-button buttons.

		
		// SmartDashboard Buttons
		SmartDashboard.putData("Drive Forward", new DriveForward(2.25));
		SmartDashboard.putData("Drive Backward", new DriveForward(-2.25));
		SmartDashboard.putData("Start Rollers", new SetCollectionSpeed(Collector.kForward));
		SmartDashboard.putData("Stop Rollers", new SetCollectionSpeed(Collector.kStop));
		SmartDashboard.putData("Reverse Rollers", new SetCollectionSpeed(Collector.kReverse));
	}

	public Joystick getJoystick() {
		return joystick;
	}
}
