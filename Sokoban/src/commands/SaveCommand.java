package commands;

import java.io.FileNotFoundException;
import java.util.HashMap;

import model.data.Level;
import model.data.LevelSaver;
import model.data.MyObjLevelSaver;
import model.data.MyTextLevelSaver;
import model.data.MyXMLLevelSaver;

public class SaveCommand implements Command {

	private HashMap<String,LevelSaver> _savers;
	private Level lvl;
	private String fileName;
	public SaveCommand ()
	{
		_savers = new HashMap<String,LevelSaver>();
		_savers.put("txt", new MyTextLevelSaver());
		_savers.put("obj", new MyObjLevelSaver());
		_savers.put("xml", new MyXMLLevelSaver());
	}
	public SaveCommand(Level l,String file){
		_savers = new HashMap<String,LevelSaver>();
		_savers.put("txt", new MyTextLevelSaver());
		_savers.put("obj", new MyObjLevelSaver());
		_savers.put("xml", new MyXMLLevelSaver());
		lvl = l;
		fileName = file;
	}
	public void set_level(Level l){
		this.lvl = l;
	}
	public void set_filename(String name){
		this.fileName = name;
	}
	@Override
	public void execute() throws Exception {
		if(lvl == null)
			throw new NullPointerException("no lvl to save");
		String filetype = "";
		int dotidx = fileName.length();
		if(fileName.indexOf(".")==-1)
			throw new FileNotFoundException("invalid file name");
		while(fileName.charAt(--dotidx)!='.');//find the index of the "." indicating the file type
		filetype = fileName.substring(dotidx+1, fileName.length());
		_savers.get(filetype).saveLevel(lvl, fileName.substring(0, dotidx));
	}

}
