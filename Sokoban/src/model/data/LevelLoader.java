package model.data;

import java.io.InputStream;

public interface LevelLoader {
	public Level loadLevel(InputStream input) throws Exception;
}
