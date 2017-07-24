package model.data;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MyTextLevelLoader implements LevelLoader {

	private HashMap<Character,String> _dictionary;
	
	public MyTextLevelLoader(){
		_dictionary = new HashMap<Character,String>();
		_dictionary.put('#', new Wall().getClass().toString());
		_dictionary.put('A', new Sokoban().getClass().toString());
		_dictionary.put(' ', null);
		_dictionary.put('@', new Box().getClass().toString());
		_dictionary.put('o', new Target().getClass().toString());
	}
	
	@Override
	public Level loadLevel(InputStream input) throws IOException {
		
		Level lvl = new Level();
		GameObjectFactory factory = new GameObjectFactory();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		
		String line = in.readLine();
		int j_idx = 0;
		while(line != null){
			for(int i = 0; i < line.length(); ++i)
			{
				lvl.placeObject(factory.createObject(_dictionary.get(line.charAt(i))),new Point(i,j_idx));
			}
			line = in.readLine();
			++j_idx;
		}
		
		 
		
		in.close();
		return lvl;
	}

}
