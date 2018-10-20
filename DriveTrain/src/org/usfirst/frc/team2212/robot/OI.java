/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.DriveWithPathFinder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI /* GEVALD */ {
	public Joystick joystickL = new Joystick(0);
	public Joystick joystickR = new Joystick(1);
	
	public JoystickButton btn = new JoystickButton(joystickR, 1);
	
	public OI() {
		btn.whenPressed(new DriveWithPathFinder(Robot.trj));
	}
}
