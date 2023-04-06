package svemir;

import java.awt.Color;
import java.awt.Graphics;

public abstract class NebeskoTelo extends Objekat{

	private int radius;
	
	public NebeskoTelo(int x, int y, Color c, int radius) {
		super(x, y, c);
		this.radius = radius;
	}
	
	int getRadius() { return radius; }

	@Override
	public abstract void paint(Graphics g);


}
