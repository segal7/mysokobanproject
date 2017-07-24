package model.data;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class MyObjLevelLoader implements LevelLoader{

	@Override
	public Level loadLevel(InputStream input) throws IOException, ClassNotFoundException  {
		Level lvl = null;
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(input));
		lvl = (Level)in.readObject();
		in.close();
		return lvl;
	}

}
