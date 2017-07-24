package commands;

import java.util.ArrayList;
import java.util.HashMap;

import gameObjects.GameObject;

public abstract class Policy {
	private HashMap<String,ArrayList<String>> _canStepOn;
	private HashMap<String,ArrayList<String>> _canPush;
	
	
	
	public HashMap<String, ArrayList<String>> get_canStepOn() {
		return _canStepOn;
	}
	public void set_canStepOn(HashMap<String, ArrayList<String>> _canStepOn) {
		this._canStepOn = _canStepOn;
	}
	public HashMap<String, ArrayList<String>> get_canPush() {
		return _canPush;
	}
	public void set_canPush(HashMap<String, ArrayList<String>> _canPush) {
		this._canPush = _canPush;
	}
	
	public boolean canPush(GameObject o1,GameObject o2){ // can obj1 push obj2
		if(o1 == null) //an empty space can't move
			return false;
		if(o2 == null) //no one can push an empty space
			return false;
		if(this.get_canPush().get(o1.getClass().toString()).contains(o2.getClass().toString()))
			return true;
		return false;
	}
	
	public boolean canStepOn(GameObject o1,GameObject o2){ // can obj1 step on obj2
		if(o1 == null)//an empty space can't move
			return false;
		if(o2 == null)//everyone can step on an empty space
			return true;
		if(this.get_canStepOn().get(o1.getClass().toString()).contains(o2.getClass().toString()))
			return true;
		return false;
	}
}
