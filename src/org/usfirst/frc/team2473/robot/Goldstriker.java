package org.usfirst.frc.team2473.robot;

import customtypes.StatedSubsystem;
import customtypes.Status.RobotStatus;

public class Goldstriker {
	private static Goldstriker theInstance;

	private Goldstriker() {

	}

	static {
		theInstance = new Goldstriker();
	}

	public static Goldstriker getInstance() {
		return theInstance;
	}

	public void update() {
		if (Robot.state == RobotStatus.DISABLED) {
			// robot is in the disabled state
		} else if (Robot.state == RobotStatus.ENABLED) {
			for (StatedSubsystem system : Robot.getSubsystems()) {
				switch (system.getState()) {
				case INITIALIZING:
					system.initializing();
				case RESETTING:
					system.resetting();
				case RUNNING:
					system.running();
				}
			}
		}
	}
}
