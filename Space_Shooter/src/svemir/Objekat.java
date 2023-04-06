package svemir;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Objekat {

	private int x, y;
	protected Color color;

	public Objekat(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		this.color = c;
	}

//	public void promeniX() {
//		x += 5;
//	}

	public void promeniY() {
		y += 5;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public abstract void paint(Graphics g);
}
