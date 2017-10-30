package model;

public abstract class Scene {
	
	protected SerializableScene serializableScene;
	
	public Scene(SerializableScene inputDataPool) {
		this.serializableScene = inputDataPool;
	}
	
	public SerializableScene getSerializableScene() {
        return serializableScene;
    }
}
