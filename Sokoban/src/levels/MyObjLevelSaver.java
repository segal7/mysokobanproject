package levels;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MyObjLevelSaver implements LevelSaver{

	@Override
	public void saveLevel(Level lvl,String filename) throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename+".obj")));
		out.writeObject(lvl);
		out.close();
	}

	
	
}
