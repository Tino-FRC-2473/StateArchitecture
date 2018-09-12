package customtypes;

import java.io.IOException;
import java.util.ArrayList;

import org.usfirst.frc.team2473.robot.Goldstriker;

import customtypes.Status.RobotStatus;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;


public abstract class StatedRobot extends IterativeRobot {
	public boolean isNetworking;

	public static RobotStatus state = RobotStatus.DISABLED;


	protected abstract Thread jetsonThread() throws IOException;

	@SuppressWarnings("unchecked")
	private static ArrayList<StatedSubsystem> subsystems = new ArrayList();

	public static ArrayList<StatedSubsystem> getSubsystems() {
		return subsystems;
	}

	@Override
	public void robotInit() {
		if(isNetworking)
			try {
				jetsonThread().start();				
			} catch(IOException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {

	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

	}

	@Override
	public void teleopPeriodic() {
		Goldstriker.getInstance().update();
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}