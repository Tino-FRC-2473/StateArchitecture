package customtypes;

import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class StatedSubsystem extends Subsystem {
	private Status.SubsystemState state;
	
	public void initialize() {
		state = Status.SubsystemState.INITIALIZING;
	}

	public void reset() {
		state = Status.SubsystemState.RESETTING;
	}

	public void run() {
		state = Status.SubsystemState.RUNNING;
	}
	
	public Status.SubsystemState getState() {
		return state;
	}
	
	public abstract void initializing();
	
	public abstract void resetting();
	
	public abstract void running();

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
