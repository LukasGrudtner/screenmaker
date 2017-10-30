package model;

public class InitialScene extends Scene {
	
	private Scene nextScene;
	
	public InitialScene(SerializableScene inputDataPool) {
		super(inputDataPool);
	}
	
	public Scene getNextScene() {
        return nextScene;
    }
	
	public void setNextScene(Scene nextScene) {
        this.nextScene = nextScene;
    }

}
