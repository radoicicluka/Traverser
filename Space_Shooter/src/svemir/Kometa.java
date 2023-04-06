package svemir;

import java.awt.Color;
import java.awt.Graphics;

public class Kometa extends NebeskoTelo{
	
	private double ugao;
	
	public Kometa(int x, int y, int r) {
		super(x, y, Color.GRAY, r);
		ugao = Math.random() * 2 * Math.PI;
	}

	@Override
	public synchronized void paint(Graphics g) {
		Color prevColor = g.getColor();
		g.setColor(Color.GRAY);
		
		int xArray[] = new int[5];
		int yArray[] = new int[5];
		
//		double ugao = Math.random() * 2 * Math.PI;
		int nextX;
		int X = getX();
		int nextY;
		int Y = getY();
	
		for (int i = 0; i < 5; i++) {
			ugao = ugao + (Math.PI * 2 / 5);
			nextX = (int)(X + getRadius() * Math.cos(ugao));
			nextY = (int)(Y - getRadius() * Math.sin(ugao));
			xArray[i] = nextX;
			yArray[i] = nextY;
		}

		g.fillPolygon(xArray, yArray, 5);
		g.setColor(prevColor);
	}	
	
}
