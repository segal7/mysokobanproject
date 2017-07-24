package model.data;

import java.awt.Point;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class MyTextLevelSaver implements LevelSaver{

	HashMap<String,Character> _dictionary;
	
	public MyTextLevelSaver()
	{
		_dictionary = new HashMap<String,Character>();
		_dictionary.put(new Wall().getClass().toString(), '#');
		_dictionary.put(new Sokoban().getClass().toString(), 'A');
		_dictionary.put(null, ' ');
		_dictionary.put(new Box().getClass().toString(), '@');
		_dictionary.put(new Target().getClass().toString(), 'o');
	}
	
	@Override
	public void saveLevel(Level lvl,String filename) throws IOException
	{
		HashMap<Point,GameObject> layout = lvl.get_layout();
		
		PrintWriter out = new PrintWriter( new FileWriter(filename+".txt"));
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
				if(layout.get(new Point(i,j))!=null)
				{
					out.print(_dictionary.get(layout.get(new Point(i,j)).getClass().toString()));
				}
				else
					out.print(_dictionary.get(null));
			out.print("\r\n");
		}
				
		
		out.close();
	}
}
