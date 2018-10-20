package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveArcade extends Command {

	public DriveArcade() {
		requires(Robot.drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.err.println("Drive arcade init");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.err.println(Robot.speedLX.get() + ", " + Robot.speedLY.get() + ", " + Robot.speedR.get());
		if(Robot.speedLX.get() == 0) {
			Robot.drivetrain.drive(Robot.speedR.get(), Robot.speedR.get());
		}
		else if(Robot.speedR.get() == 0) {
			Robot.drivetrain.drive(Robot.speedLX.get(), -Robot.speedLX.get());
		}
		else if(Robot.speedLX.get() > 0) {
			Robot.drivetrain.drive(Robot.speedR.get(), Robot.speedR.get() * (1 - Robot.speedLX.get()));
		}
		else if(Robot.speedLX.get() < 0) {
			Robot.drivetrain.drive(Robot.speedR.get() * (1 + Robot.speedLX.get()), Robot.speedR.get());
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
