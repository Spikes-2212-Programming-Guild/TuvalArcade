package org.usfirst.frc.team2212.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.dashboard.ConstantHandler;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

/**
 *
 */
public class DriveWithPathFinder extends Command {

	private final Supplier<Double> KP = ConstantHandler.addConstantDouble("pathfinder - kp", 1.0);
	private final Supplier<Double> KD = ConstantHandler.addConstantDouble("pathfinder - kd", 0.0);
	private final Supplier<Double> KV = ConstantHandler.addConstantDouble("pathfinder - kv", 0.0);
	private final Supplier<Double> KA = ConstantHandler.addConstantDouble("pathfinder - ka", 0.0);
	
	private Trajectory tr;
	private Trajectory left, right;
	private EncoderFollower leftFollower, rightFollower;
	
    public DriveWithPathFinder(Trajectory trj) {
        requires(Robot.drivetrain);
        tr = trj;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	TankModifier modifier = new TankModifier(tr).modify(0.5);

        // Do something with the new Trajectories...
    	left = modifier.getLeftTrajectory();
        right = modifier.getRightTrajectory();
        
    	leftFollower = new EncoderFollower(left);
    	rightFollower = new EncoderFollower(right);
    	
    	leftFollower.configurePIDVA(KP.get(), 0, KD.get(), KV.get(), KA.get());
    	rightFollower.configurePIDVA(KP.get(), 0, KD.get(), KV.get(), KA.get());
    	
    	leftFollower.configureEncoder(0, 360, 6);
    	rightFollower.configureEncoder(0, 360, 6);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.drive(leftFollower.calculate(Robot.LEFT_ENCODER.get()), rightFollower.calculate(Robot.RIGHT_ENCODER.get()));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
