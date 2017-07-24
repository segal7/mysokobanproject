package model.data;

import java.util.HashMap;

public class GameObjectFactory{
	HashMap<String,Creator> GObjectCreators;
	
		private interface Creator {
			
		public GameObject create ();	
		}
		
		private class BoxCreator implements Creator {
			@Override
			public GameObject create(){
				return new Box();
			}
		}
		
		private class WallCreator implements Creator {
			@Override
			public GameObject create(){
				return new Wall();
			}
		}
		
		private class TargetCreator implements Creator {
			@Override
			public GameObject create(){
				return new Target();
			}
		}
		
		private class SokobanCreator implements Creator {
			@Override
			public GameObject create(){
				return new Sokoban();
			}
			
		}
		public GameObjectFactory()
		{
			GObjectCreators= new HashMap<String,Creator>();
			GObjectCreators.put(new Box().getClass().toString(), new BoxCreator());
			GObjectCreators.put(new Wall().getClass().toString(), new WallCreator());
			GObjectCreators.put(new Target().getClass().toString(), new TargetCreator());
			GObjectCreators.put(new Sokoban().getClass().toString(), new SokobanCreator());
			
			
		}
		public GameObject createObject (String type)
		{
			Creator c=GObjectCreators.get(type);
			if(c!=null)
				return c.create();
			return null;
		}
}

