package model.policy;

import java.util.ArrayList;
import java.util.HashMap;

import model.data.Box;
import model.data.Sokoban;
import model.data.Target;
import model.data.Wall;

public class MySokobanPolicy extends Policy{	
	
	public MySokobanPolicy(){
		//initialize the hash maps
		this.set_canPush(new HashMap<String,ArrayList<String>>());
		this.set_canStepOn(new HashMap<String,ArrayList<String>>());
		
		this.get_canPush().put(new Box().getClass().toString(), new ArrayList<String>());
		this.get_canPush().put(new Target().getClass().toString(), new ArrayList<String>());
		this.get_canPush().put(new Sokoban().getClass().toString(), new ArrayList<String>());
		this.get_canPush().put(new Wall().getClass().toString(), new ArrayList<String>());
		
		this.get_canStepOn().put(new Box().getClass().toString(), new ArrayList<String>());
		this.get_canStepOn().put(new Target().getClass().toString(), new ArrayList<String>());
		this.get_canStepOn().put(new Sokoban().getClass().toString(), new ArrayList<String>());
		this.get_canStepOn().put(new Wall().getClass().toString(), new ArrayList<String>());
		
		//enter the values to the hash map
		this.get_canPush().get(new Sokoban().getClass().toString()).add(new Box().getClass().toString());//the sokoban can push boxes
		this.get_canStepOn().get(new Sokoban().getClass().toString()).add(new Target().getClass().toString());//the sokoban can step on targets
		this.get_canStepOn().get(new Box().getClass().toString()).add(new Target().getClass().toString());//the box can move on targets
	}
}  
