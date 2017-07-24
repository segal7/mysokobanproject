package commands;

import model.data.Level;

public class DisplayCommand implements Command {
	private Level lvl = null; 
	private LevelDisplayer displayer = null;
	
	public DisplayCommand(LevelDisplayer displayer){
		this.displayer = displayer;
	}
	public DisplayCommand(Level lvl, LevelDisplayer displayer) {
		this.displayer = displayer;
		this.lvl = lvl;
	}
	public void set_level(Level l){
		this.lvl = l;
	}
	@Override
	public void execute() throws Exception{ 
		if(lvl == null)
			throw new NullPointerException("there is no level to display.");
		displayer.display(lvl);
	}
	
	

}
