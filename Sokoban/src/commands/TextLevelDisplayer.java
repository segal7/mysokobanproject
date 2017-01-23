package commands;

import java.awt.Point;
import java.util.HashMap;

import gameObjects.Box;
import gameObjects.GameObject;
import gameObjects.Sokoban;
import gameObjects.Target;
import gameObjects.Wall;
import levels.Level;

public class TextLevelDisplayer implements LevelDisplayer {

	HashMap<String,Character> _dictionary;
	
	public TextLevelDisplayer() {
		_dictionary = new HashMap<String,Character>();
		_dictionary.put(new Wall().getClass().toString(), '#');
		_dictionary.put(new Sokoban().getClass().toString(), 'A');
		_dictionary.put(null, ' ');
		_dictionary.put(new Box().getClass().toString(), '@');
		_dictionary.put(new Target().getClass().toString(), 'o');
	}
	
	@Override
	public void display(Level l) {
		HashMap<Point, GameObject> layout= l.get_layout();
		int maxX = 0,maxY = 0;
		for(Point p: layout.keySet())
		{
			if(maxX < p.getX())
				maxX = (int) p.getX();
			if(maxY < p.getY())
				maxY = (int) p.getY();
		}
		for(int j = 0; j < maxY+1; j++)
		{
			for(int i = 0; i < maxX+1; i++)
			{
				if(layout.get(new Point(i,j))!=null)
					System.out.print(_dictionary.get(layout.get(new Point(i,j)).getClass().toString())); 
				else
					System.out.print(" ");
			}	
			System.out.println("");
		}	
	}
}
