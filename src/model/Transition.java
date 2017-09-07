package model;

public class Transition {
	
	private String imagePath;
	private int x, y, width, height;
	
	public Transition(String imagePath, int x, int y, int width, int height) {
		this.imagePath = imagePath;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

}
