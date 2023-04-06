package space;

import java.awt.Color;
import java.awt.Graphics;

public abstract class AstronomicalObject extends SpaceObject {
	
	private int radius;
	
	private boolean overlapped;

	
	public AstronomicalObject(int x, int y, Color color, int radius) {
		super(x, y, color);
		this.radius = radius;
		this.overlapped = false;
	}

	int getRadius() { return radius; }
	
	@Override
	public abstract void paintComponent(Graphics g);

	public boolean isOverlapped() {
		return overlapped;
	}
	
	public void setOverlapped(boolean b) {
		overlapped = b;
	}
	
}
