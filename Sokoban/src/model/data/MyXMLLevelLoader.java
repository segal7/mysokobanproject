package model.data;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class MyXMLLevelLoader implements LevelLoader{
	
	@Override
	public Level loadLevel(InputStream input) 
	{
		 Level lvl=null;
		 XMLDecoder d = new XMLDecoder(new BufferedInputStream(input));
		 lvl = (Level)d.readObject();
		 d.close();
		 return lvl;
	}

}
