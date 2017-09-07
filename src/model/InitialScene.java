package model;

public class InitialScene extends Scene {
	
	private Scene nextScene;
	
	public InitialScene(String backgroundPath, String text, Transition transition) {
		super(backgroundPath, text, transition);
	}
	
	public Scene getNextScene() {
        return nextScene;
    }
	
	public void setNextScene(Scene nextScene) {
        this.nextScene = nextScene;
    }

}
