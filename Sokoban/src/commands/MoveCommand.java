package commands;
import java.awt.Point;

import gameObjects.GameObject;
import levels.Level;

public class MoveCommand implements Command {

	String _direction;
	Level _lvl;
	Policy _policy;
	GameObject _obj;
	
	public MoveCommand(GameObject obj,String direction,Level lvl,Policy policy){
		this._direction=direction;
		this._lvl=lvl;
		this._obj=obj;
		this._policy=policy;
	}
	
	
	private boolean move(Level lvl, String direction, GameObject obj) throws Exception{
		boolean willmove = false;
		Point currentLocation = obj.get_location();
		Point nextLocation = nextPoint(currentLocation,direction);
		GameObject nextObj = lvl.get_layout().get(nextLocation);
		
		if(_policy.canStepOn(obj, nextObj))
			willmove = true;
		else if(_policy.canPush(obj, nextObj))
			if(move(lvl,direction,nextObj))
				willmove = true;
		
		if(willmove)
		{
			GameObject host = obj.get_host();
			lvl.placeObject(obj,nextLocation);
			lvl.placeObject(host, currentLocation);
		}
		
		return willmove;
	}
	@Override
	public void execute() throws Exception {
		if(_lvl == null)
			throw new NullPointerException("there is no level to move in");
		move(_lvl,_direction,_obj);
	}

	private Point nextPoint(Point p,String toDirection) throws Exception{
		Point res = (Point) p.clone();
		switch (toDirection.toLowerCase())
		 {
		
		  case ("up") :
			  res.setLocation((p.getX()),(p.getY()-1));
			  break;
		  case ("down"):
			  res.setLocation((p.getX()),(p.getY()+1));
		       break;
		  case ("left"):
			  res.setLocation((p.getX()-1),(p.getY()));
		  	   break;
		  case ("right"):
			  res.setLocation((p.getX()+1),(p.getY()));
		  	   break;
		  default:
			  throw new Exception("no such direction");
		 }
		return res;
	}	
	
}
