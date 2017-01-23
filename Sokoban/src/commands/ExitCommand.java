package commands;

public class ExitCommand implements Command{
	private CLI myCLI;
	
	public ExitCommand(CLI cli){
		this.myCLI = cli;
	}

	@Override
	public void execute() {
		myCLI.set_running(false);
	}
	
	
}
