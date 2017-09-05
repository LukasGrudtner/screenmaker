package model;

public class InitialScene extends Scene {
	
	private Scene nextScene;
	
	public InitialScene(String backgroundPath, String text) {
		super(backgroundPath, text);
	}
	
	public Scene getNextScene() {
        return nextScene;
    }
	
	public void setNextScene(Scene nextScene) {
        this.nextScene = nextScene;
    }

}
