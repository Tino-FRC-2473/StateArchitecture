package org.usfirst.frc.team2473.robot;

import customtypes.StatedRobot;
import framework.DatabaseAndPingThread;
import java.io.IOException;

public class Robot extends StatedRobot {

	@Override
	protected Thread jetsonThread() throws IOException {
		// TODO Auto-generated method stub
		return (isNetworking) ? new DatabaseAndPingThread(RobotMap.IP, RobotMap.PORT, false) : null;
	}
	
	@Override
	public void robotInit() {
	}
}