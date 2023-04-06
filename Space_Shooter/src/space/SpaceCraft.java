package space;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class SpaceCraft extends SpaceObject {
	
	private int width;
	private int height;
	
	public SpaceCraft(int height, int width) {
		super(200, 700, Color.GREEN);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D gr = (Graphics2D)g;
		Color prevColor = gr.getColor();
		gr.setColor(this.getColor());
		
		int[] xArr = new int[3];
		int[] yArr = new int[3];
		
		xArr[0] = (int)(this.getX() - width / 2);
		xArr[1] = this.getX();
		xArr[2] = (int)(this.getX() + width / 2);
		
		yArr[0] = getY();
		yArr[1] = getY() - height;
		yArr[2] = getY();
		
		gr.fillPolygon(xArr, yArr, 3);

		xArr[0] = (int)(this.getX() - width);
		xArr[1] = this.getX();
		xArr[2] = (int)(this.getX());
		
		yArr[0] = getY() + height / 4;
		yArr[1] = getY() - height / 2;
		yArr[2] = getY();
		
		gr.fillPolygon(xArr, yArr, 3);

		xArr[0] = (int)(this.getX());
		xArr[1] = this.getX();
		xArr[2] = (int)(this.getX() + width);
		
		yArr[0] = getY();
		yArr[1] = getY() - height / 2;
		yArr[2] = getY() + height / 4;
		
		gr.fillPolygon(xArr, yArr, 3);
		
		
		gr.setColor(prevColor);
	}
	
	public boolean overlaps(AstronomicalObject ao) {
		if (this.distance(ao) < ao.getRadius() + width && !(ao.isOverlapped())) {
			ao.setOverlapped(true);
			return true;
		}
		return false;
	}
	
	public void moveRight() {
		if (x < 395)
		x += 20;
	}
	
	public void moveLeft() {
		if (x > 5)
		x -= 20;
	}

}
