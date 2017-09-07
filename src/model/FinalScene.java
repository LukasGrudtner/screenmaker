package model;

public class FinalScene extends Scene {
	
	private Scene previousScene;
	
	public FinalScene(String backgroundPath, String text, Transition transition) {
		super(backgroundPath, text, transition);
	}
	
	public Scene getPreviousScene() {
        return previousScene;
    }

    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }

}
