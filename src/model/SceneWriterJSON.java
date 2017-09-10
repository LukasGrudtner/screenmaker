package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SceneWriterJSON {
	
	private String filePath;
	private ArrayList<SerializableScene> serializableSceneList;
	
	public SceneWriterJSON(String filePath, ArrayList<SerializableScene> serializableSceneList) {
		this.filePath = filePath;
		this.serializableSceneList = serializableSceneList;
	}
	
	public void write() {
		
		Gson gson = new Gson();
		String stringJson = gson.toJson(serializableSceneList);
		
		try {
			PrintWriter printWriter = new PrintWriter(filePath);
			printWriter.println(stringJson);
			
			printWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		read();
	}
	
	/* Only for tests. */
	private void read() {
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<SerializableScene>>() {}.getType();
		
		ArrayList<SerializableScene> serializableSceneList = null;
		String stringJson = "";
		
		try {
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			stringJson = bufferedReader.readLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		serializableSceneList = gson.fromJson(stringJson, type);
	}
}
