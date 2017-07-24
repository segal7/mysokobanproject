package model.data;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MyXMLLevelSaver implements LevelSaver{
	
	@Override
	public void saveLevel(Level lvl,String filename) throws FileNotFoundException
	{
		XMLEncoder e=new XMLEncoder(new BufferedOutputStream( new FileOutputStream(filename+".xml")));
		e.writeObject(lvl);
		e.close();
		
	}
	
}
