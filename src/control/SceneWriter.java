package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.scenes.SerializableScene;

import org.json.simple.JSONObject;

public class SceneWriter {
	
	private String filePath;
	private ArrayList<SerializableScene> serializableSceneList;
	
	public SceneWriter(String filePath, ArrayList<SerializableScene> serializableSceneList) {
		this.filePath = filePath;
		this.serializableSceneList = serializableSceneList;
	}
	
	public void write() {

		Gson gson = new Gson();
		
		try {
			PrintWriter printWriter = new PrintWriter(filePath);
			
			for (SerializableScene ss: serializableSceneList) {
				String jsonString = gson.toJson(ss);
				System.out.println(jsonString);
				printWriter.println(jsonString);
				
			}
			printWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
