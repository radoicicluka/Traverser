package svemir;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Svemir extends Canvas implements Runnable {

	private Thread nit = new Thread(this);
	
	private ArrayList<NebeskoTelo> tela = new ArrayList<>();
	
	public Svemir() {
		setBackground(Color.BLACK);
		repaint();
	}
	
	@Override
	public void run() {
		try {
			while(!nit.interrupted()) {
				Thread.sleep(100);
				repaint();
			}
			
		} catch (InterruptedException e) {}
		
	}

	public synchronized void dodajNebeskoTelo(NebeskoTelo telo) {
		tela.add(telo);
	}
	
	@Override
	public void paint(Graphics g) {
		synchronized (this) {
			for(NebeskoTelo t : tela) {
				t.paint(g);
				t.promeniY();
			}
		}
		
	}
	
	public void pokreni() {
		nit.start();
	}
	
	public void zaustavi() {
		nit.interrupt();
//		System.out.println("Zaustavljen svemir");
	}
	
	
}
