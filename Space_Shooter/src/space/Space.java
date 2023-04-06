package space;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Space extends Canvas implements Runnable{

	private Thread thread = new Thread(this);
	
	private SpaceCraft craft = new SpaceCraft(32, 24);

	private ArrayList<AstronomicalObject> objects = new ArrayList<>();
		
	private int points = -1;
		
	private int change = 5;
	
	private int level = 1;
	
	private boolean colided = false;
	
	public Space() {
		setBackground(Color.black);
		repaint();
	}
	
	@Override
	public void run() {
		try {
			while(!thread.interrupted()) {
				Thread.sleep(50);
				if (change > 0) repaint();
				if (points > 500 * level) {
					change += 2;
					level++;
				}
			}
		}
		catch(InterruptedException e) {}
	}
	
	public synchronized void addObject(AstronomicalObject o) {
		objects.add(o);
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D gr = (Graphics2D)g;
		synchronized (this) {
			gr.setFont(new Font("Courier New", Font.BOLD, 15));
			points++;
			for (AstronomicalObject obj : objects) {
				obj.paintComponent(gr);
				obj.move(change);
				if (craft.overlaps(obj)) {
					if (obj instanceof Comet) {
						colided = true;
						thread.interrupt();
					}
					else {
						points += 100;
					}
				}
			}
			if (colided) {
				gr.setColor(Color.white);
				gr.setFont(new Font("Courier New", Font.BOLD, 30));
				gr.drawString("GAME OVER", 120, 300);
				gr.setColor(Color.black);
				gr.setFont(new Font("Courier New", Font.BOLD, 15));
			}
			
			
			craft.paintComponent(gr);
			gr.setColor(Color.white);
			gr.drawString("Space explored: " + points, 10, 20);
		}
	}
	
	public void start() {
		thread.start();
	}
	
	public void stop() {
		thread.interrupt();
	}
	
	public void pause() {
		change = 0;
		
	}
	
	public void resume() {
		change = 5;
	}
	
	public SpaceCraft getCraft() {
		return craft;
	}
	
}
