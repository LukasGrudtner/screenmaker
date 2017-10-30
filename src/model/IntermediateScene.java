package model;

public class IntermediateScene extends Scene {
	
	private Scene previousScene;
	private Scene nextScene;
	
	public IntermediateScene(SerializableScene inputDataPool) {
		super(inputDataPool);
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
