package commands;

import java.util.Scanner;

import gameObjects.Sokoban;
import levels.Level;

public class CLI {
	
	private Level _loadedlvl;
	boolean _running;

	Sokoban sok;
	
	public CLI(){

		_running = false;
	}
	
	public boolean is_running() {
		return _running;
	}

	public void set_running(boolean _running) {
		this._running = _running;
	}

	public void start(){
		_running = true;
		String line = "";
		String filename="";
		Scanner input = new Scanner(System.in);
		MySokobanPolicy policy = new MySokobanPolicy();
		do{
			System.out.print("enter your command(help for info):: ");
			line = input.nextLine();
			String cmd = "";
			if(line.indexOf(" ")!= -1)
				cmd = line.substring(0,line.indexOf(" "));
			else
				cmd = line;
			try{
				switch(cmd.toLowerCase()){
				case "load":
					if(line.indexOf(" ")==-1)
						throw new Exception("you need to designate a level to load from");
					filename = line.substring(line.indexOf(" ")+1);
					LoadCommand load_cmd = new LoadCommand(filename); 
					load_cmd.execute();
					_loadedlvl = load_cmd.get_level();
					sok = _loadedlvl.get_sokobans().get(0);
					break;
				case "save":		
					if(line.indexOf(" ")==-1)
						throw new Exception("you need to choose a destination for saving");
					filename = line.substring(line.indexOf(" ")+1);
					SaveCommand save_cmd = new SaveCommand(_loadedlvl,filename);
					save_cmd.execute();
					break;
				case "display":
					DisplayCommand display_cmd = new DisplayCommand(_loadedlvl,new TextLevelDisplayer());
					display_cmd.execute();
					break;
				case "move":
					String dir = line.substring(line.indexOf(" ")+1);
					MoveCommand move_cmd = new MoveCommand(sok,dir,_loadedlvl,policy);
					move_cmd.execute();
					
					if(_loadedlvl.boxesInPlace() == _loadedlvl.get_boxes().size())
						System.out.println("CONGRATULATIONS!!!!! YOUU WONNN!!!!!!");
					break;					
				case "exit":
					ExitCommand exit_cmd = new ExitCommand(this);
					exit_cmd.execute();
					break;
				case "help":
					System.out.println("the avilable commands are:");
					System.out.println("load level_path - loads a level into the game");
					System.out.println("save save_path - saves the loaded level with its current situation in save_path");
					System.out.println("display - displays the current level");
					System.out.println("move {up,down,right,left} - moves the sokoban into the specified direction");
					System.out.println("exit - exits the game");
				default:
					System.out.println("no such command, please re-enter the command.");
					break;
			}
			}
			catch(Exception e) { System.out.println(e.getMessage());}
		}while(_running);
		
		input.close();
	}
}
