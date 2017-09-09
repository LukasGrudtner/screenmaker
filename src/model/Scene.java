package model;

public abstract class Scene {
	
	protected SerializableScene serializableScene;
	protected Transition transition;
	
	public Scene(SerializableScene inputDataPool, Transition transition) {
		this.serializableScene = inputDataPool;
		this.transition = transition;
	}
	
	public SerializableScene getSerializableScene() {
        return serializableScene;
    }
	
	public Transition getTransition() {
		return transition;
	}

}
