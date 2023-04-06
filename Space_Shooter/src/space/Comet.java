package space;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Comet extends AstronomicalObject{
	
	private double angle;
	
	public Comet(int x, int y, int radius) {
		super(x, y, Color.gray, radius);
		this.angle = Math.random() * 2 * Math.PI;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D gr = (Graphics2D)g;
		Color prevColor = gr.getColor();
		gr.setColor(Color.gray);
		
		int xArray[] = new int[5];
		int yArray[] = new int[5];
		
		int nextX;
		int x = getX();
		int nextY; 
		int y = getY();
		
		for (int i = 0; i < 5; i++) {
			this.angle = this.angle + (Math.PI * 2 / 5);
			nextX = (int)(x + getRadius() * Math.cos(angle));
			nextY = (int)(y - getRadius() * Math.sin(angle));
			xArray[i] = nextX;
			yArray[i] = nextY;
		}
		gr.fillPolygon(xArray, yArray, 5);
		gr.setColor(prevColor);
	}

	
	
}
