package model;

public abstract class Scene {
	
	protected String backgroundPath;
	protected String text;
	
	public Scene(String backgroundPath, String text) {
		this.backgroundPath = backgroundPath;
		this.text = text;
	}
	
	public String getBackground() {
        return backgroundPath;
    }
	
	public String getText() {
        return text;
    }

}
