package model;

public abstract class Scene {
	
	protected String backgroundPath;
	protected String text;
	protected Transition transition;
	
	public Scene(String backgroundPath, String text, Transition transition) {
		this.backgroundPath = backgroundPath;
		this.text = text;
		this.transition = transition;
	}
	
	public String getBackground() {
        return backgroundPath;
    }
	
	public String getText() {
        return text;
    }
	
	public Transition getTransition() {
		return transition;
	}

}
