package model;

public class IntermediateScene extends Scene {
	
	private Scene previousScene;
	private Scene nextScene;
	
	public IntermediateScene(String backgroundPath, String text) {
		super(backgroundPath, text);
	}
	
	public Scene getPreviousScene() {
        return previousScene;
    }

    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }
	
	public Scene getNextScene() {
        return nextScene;
    }
	
	public void setNextScene(Scene nextScene) {
        this.nextScene = nextScene;
    }
}
