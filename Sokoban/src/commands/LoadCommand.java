package commands;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import model.data.Level;
import model.data.LevelLoader;
import model.data.MyObjLevelLoader;
import model.data.MyTextLevelLoader;
import model.data.MyXMLLevelLoader;

public class LoadCommand implements Command{
	
	private HashMap<String,LevelLoader> _loaders;
	private Level lvl;
	private String path;
	
	public LoadCommand(){
		_loaders = new HashMap<String,LevelLoader>();
		_loaders.put("txt",new MyTextLevelLoader());
		_loaders.put("xml",new MyXMLLevelLoader());
		_loaders.put("obj", new MyObjLevelLoader());
		lvl = new Level();
	}
	public void set_path(String path){
		this.path = path;
	}
	public LoadCommand(String path){
		_loaders = new HashMap<String,LevelLoader>();
		_loaders.put("txt",new MyTextLevelLoader());
		_loaders.put("xml",new MyXMLLevelLoader());
		_loaders.put("obj", new MyObjLevelLoader());
		this.path = path;
		lvl = new Level();
	}

	@Override
	public void execute() throws Exception {
		String filetype = "";
		int dotidx = path.length();
		if(path.indexOf(".")==-1)
			throw new FileNotFoundException("this file name is invalid");
		while(path.charAt(--dotidx)!='.');//find the index of the "." indicating the file type
		filetype = path.substring(dotidx+1, path.length());
		lvl = _loaders.get(filetype).loadLevel(new BufferedInputStream(new FileInputStream(path)));
	}
	
	public Level get_level(){return lvl;}

}
