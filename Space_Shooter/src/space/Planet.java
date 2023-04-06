package space;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Planet extends AstronomicalObject {

	private boolean hasRing = false;
	
	public Planet(int x, int y, int radius) {
		super(x, y, Color.black, radius);
		double num = Math.random();
		if (num >= 0.75) this.setColor(Color.GREEN);
		else if (num >= 0.5) this.setColor(Color.BLUE);
		else if (num >= 0.25) this.setColor(Color.YELLOW);
		else this.setColor(Color.RED);
		num = Math.random();
		if (num >= 0.75) hasRing = true;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D gr = (Graphics2D)g;
		Color prevColor = gr.getColor();
		gr.setColor(this.getColor());
		gr.fillOval(getX() - getRadius(), getY() - getRadius(), 2 * getRadius(), 2 * getRadius());
		if (hasRing) gr.drawOval(getX() - getRadius() * 2, getY() - getRadius() * 2, 4 * getRadius(), getRadius() * 4);
		gr.setColor(prevColor);

	}

}
