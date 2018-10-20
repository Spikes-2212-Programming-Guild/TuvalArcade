package org.usfirst.frc.team2212.robot.subsystems;


import org.usfirst.frc.team2212.robot.Gearbox;
import org.usfirst.frc.team2212.robot.commands.DriveArcade;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	private Gearbox motorL, motorR;

	public Drivetrain(Gearbox motorL, Gearbox motorR) {
		this.motorL = motorL;
		this.motorR = motorR;
	}

	public void drive(double speedL, double speedR) {
		this.motorL.set(speedL);
		this.motorR.set(speedR);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveArcade());
	}
}
