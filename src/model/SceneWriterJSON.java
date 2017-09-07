package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SceneWriterJSON {
	
	private static final String NUMBER_OF_SCENES = "numberOfScenes";
    private static final String SCENE_TYPE = "sceneType";
    private static final String BACKGROUND_PATH = "backgroundPath";
    private static final String TEXT = "text";
    private static final String TRANSITION_IMAGE = "transitionImage";
    private static final String TRANSITION_IMAGE_X = "transitionImageX";
    private static final String TRANSITION_IMAGE_Y = "transitionImageY";
    private static final String TRANSITION_IMAGE_WIDTH = "transitionImageWidth";
    private static final String TRANSITION_IMAGE_HEIGHT = "transitionImageHeight";
	
	private String filePath;
	private ArrayList<Scene> sceneList;
	
	public SceneWriterJSON(String filePath, ArrayList<Scene> sceneList) {
		this.filePath = filePath;
		this.sceneList = sceneList;
	}
	
	public void write() {
		
		JSONObject jsonObject = new JSONObject();
		
		try {
			PrintWriter printWriter = new PrintWriter(filePath);
			jsonObject.put(NUMBER_OF_SCENES, sceneList.size());
			printWriter.println(jsonObject.toJSONString());
			jsonObject.clear();
			
			for (Scene scene : sceneList) {
				jsonObject.put(SCENE_TYPE, scene.getClass().getSimpleName());
				jsonObject.put(BACKGROUND_PATH, scene.getBackground());
				jsonObject.put(TEXT, scene.getText());
				jsonObject.put(TRANSITION_IMAGE, scene.getTransition().getImagePath());
				jsonObject.put(TRANSITION_IMAGE_X, scene.getTransition().getX());
				jsonObject.put(TRANSITION_IMAGE_Y, scene.getTransition().getY());
				jsonObject.put(TRANSITION_IMAGE_WIDTH, scene.getTransition().getWidth());
				jsonObject.put(TRANSITION_IMAGE_HEIGHT, scene.getTransition().getHeight());
				
				printWriter.println(jsonObject.toJSONString());
				jsonObject.clear();
			}
			printWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* Only for tests. */
	public void read() {
		System.out.println(InitialScene.class.getSimpleName());
		ArrayList<Scene> sceneList = new ArrayList<Scene>();

        JSONObject jsonObject;
        JSONParser jsonParser = new JSONParser();

        try {
        	FileReader fileReader = new FileReader(filePath);
        	BufferedReader bufferedReader = new BufferedReader(fileReader);
        	
        	jsonObject = (JSONObject) jsonParser.parse(bufferedReader.readLine());
        	int numberOfScenes = Integer.parseInt(jsonObject.get(NUMBER_OF_SCENES).toString());
        	
        	for (int i = 0; i < numberOfScenes; i++) {
	            String jsonString = bufferedReader.readLine();
	            
	            jsonObject = (JSONObject) jsonParser.parse(jsonString);
	            
	            String sceneType = (String) jsonObject.get(SCENE_TYPE);
	            String backgroundPath = (String) jsonObject.get(BACKGROUND_PATH);
	            String text = (String) jsonObject.get(TEXT);
	            String imagePath = (String) jsonObject.get(TRANSITION_IMAGE);
	            int x = Integer.parseInt(jsonObject.get(TRANSITION_IMAGE_X).toString());
	            int y = Integer.parseInt(jsonObject.get(TRANSITION_IMAGE_Y).toString());
	            int width = Integer.parseInt(jsonObject.get(TRANSITION_IMAGE_WIDTH).toString());
	            int height = Integer.parseInt(jsonObject.get(TRANSITION_IMAGE_HEIGHT).toString());
	            
	            Transition transition = new Transition(imagePath, x, y, width, height);
	            Scene scene = null;
	            
	            if (sceneType.equals(InitialScene.class.getSimpleName()))
	            	scene = new InitialScene(backgroundPath, text, transition);
	            else if (sceneType.equals(IntermediateScene.class.getSimpleName()))
	            	scene = new IntermediateScene(backgroundPath, text, transition);
	            else if (sceneType.equals(FinalScene.class.getSimpleName()))
	            	scene = new FinalScene(backgroundPath, text, transition);
	            
	            sceneList.add(scene);
        	}
        	
        	bufferedReader.close();
        	fileReader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        for (Scene scene : sceneList) {
        	System.out.println("Background: " + scene.getBackground() + " ImagePath: " + scene.getTransition().getImagePath());
        }
	}
}
