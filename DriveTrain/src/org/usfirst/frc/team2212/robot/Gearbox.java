package org.usfirst.frc.team2212.robot;

import edu.wpi.first.wpilibj.SpeedController;

public class Gearbox {
	private SpeedController speedCtrler1, speedCtrler2;

	public Gearbox(SpeedController ctrler1, SpeedController ctrler2) {
		this.speedCtrler1 = ctrler1;
		this.speedCtrler2 = ctrler2;
	}

	public void set(double speed) {
		this.speedCtrler1.set(speed);
		this.speedCtrler2.set(speed);
	}

	public double get() {
		return this.speedCtrler1.get();
	}

	public void setInverted(boolean isInverted) {
		this.speedCtrler1.setInverted(isInverted);
		this.speedCtrler2.setInverted(isInverted);
	}

	public boolean getInverted() {
		return this.speedCtrler1.getInverted();
	}

	public void disable() {
		this.speedCtrler1.disable();
		this.speedCtrler2.disable();
	}

	public void stopMotor() {
		this.speedCtrler1.stopMotor();
		this.speedCtrler2.stopMotor();
	}
}
