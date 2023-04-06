package svemir;

import java.awt.Graphics;

public class Generator extends Thread{

	private Svemir svemir;
	private Graphics g;

	public Generator(Svemir svemir, Graphics g) {
		this.svemir = svemir;
		this.g = g;
	}
	
	public void napraviKometu() {
		int x = (int)(Math.random() * 200);
		int y = 0;
		int r = (int)(Math.random() * 20) + 10;
		svemir.dodajNebeskoTelo(new Kometa(x, y, r));
	}

	@Override
	public void run() {
		synchronized (this) {
			try {
				while(!interrupted()) {
					napraviKometu();
					this.sleep(900);
				}
			} catch(InterruptedException e) {}
		}
		
	}
	
	public void pokreni() {
		start();
	}
	
	public void zaustavi() {
		interrupt();
//		System.out.println("Zaustavljen generator");
	}
	
}	
