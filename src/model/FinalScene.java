package model;

public class FinalScene extends Scene {
	
	private Scene previousScene;
	
	public FinalScene(SerializableScene inputDataPool, Transition transition) {
		super(inputDataPool, transition);
	}
	
	public Scene getPreviousScene() {
        return previousScene;
    }

    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }

}
