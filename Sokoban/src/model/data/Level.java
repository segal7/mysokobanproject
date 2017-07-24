package model.data;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Level implements Serializable {
	//data members:
	private int _score;
	private HashMap<Point,GameObject> _layout;
	
	private ArrayList<Box> _boxes;
	private ArrayList<Target> _targets;
	private ArrayList<Sokoban> _sokobans;
	private ArrayList<Wall> _walls;
	//Default contractor
	public Level()
	{
		_layout = new HashMap<Point,GameObject>();
		_boxes = new ArrayList<Box>();
		_targets = new ArrayList<Target>();
		_sokobans = new ArrayList<Sokoban>();
		_walls = new ArrayList<Wall>();
	}
	
	//methods:
	//setters and getters

	public int get_score() {
		return _score;
	}
	public void set_score(int score) {
		this._score = score;
	}
	public HashMap<Point, GameObject> get_layout() {
		return _layout;
	}
	public void set_layout(HashMap<Point, GameObject> _layout) {
		this._layout = _layout;
	}
	public ArrayList<Box> get_boxes() {
		return _boxes;
	}
	public void set_boxes(ArrayList<Box> _boxes) {
		this._boxes = _boxes;
	}
	public ArrayList<Target> get_targets() {
		return _targets;
	}
	public void set_targets(ArrayList<Target> _targets) {
		this._targets = _targets;
	}
	public ArrayList<Sokoban> get_sokobans() {
		return _sokobans;
	}
	public void set_sokobans(ArrayList<Sokoban> _sokobans) {
		this._sokobans = _sokobans;
	}
	public ArrayList<Wall> get_walls() {
		return _walls;
	}
	public void set_walls(ArrayList<Wall> _walls) {
		this._walls = _walls;
	}
	
	
	public void placeObject(GameObject obj,Point position){
			
		if(obj == null)
		{
			_layout.put(position, null);
			return;
		}
		obj.set_host(_layout.get(position));
		_layout.put(position, obj);
		obj.set_location(position);
		
		//////////add to appropriate list/////////////
		switch(obj.getClass().getSimpleName()){
		case "Box":
			if(!_boxes.contains(obj))
				_boxes.add((Box) obj); 
			break;
		case "Target": 
			if(!_targets.contains(obj))
				_targets.add((Target)obj); 
			break;
		case "Sokoban": 
			if(!_sokobans.contains(obj))
				_sokobans.add((Sokoban)obj); 
			break;
		case "Wall": 
			if(!_walls.contains(obj))
				_walls.add((Wall)obj); 
			break;
		}
		
	}
	public void removeObject(Point position){
		_layout.remove(position);
	}
	
	public int boxesInPlace(){
		int count = 0;
		for(Box b:_boxes){
			for(Target t:_targets)
				if(t.get_location().equals(b.get_location()))
					count++;
		}
		
		return count;
	}
	public int boxesNotInPlace(){
		return _boxes.size() - boxesInPlace();
	}
	
}
