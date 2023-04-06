package space;

import java.awt.Color;
import java.awt.Graphics;

public abstract class SpaceObject {
	protected int x, y;
	protected Color color;
	
	public SpaceObject(int x, int y, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	

	
	public void move(int change) {
		this.y += change;
	}
	
	public void setColor(Color c) {
		this.color = c;
	}
	
	public Color getColor() {
		return color;
	}
	
	public double distance(SpaceObject so) {
		return Math.sqrt(Math.pow((x - so.getX()), 2) + Math.pow((y - so.getY()), 2));
	}
	
	public abstract void paintComponent(Graphics g);
	
	
}
