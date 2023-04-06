package space;


public class Generator extends Thread {
	
	private Space space;
	
	private boolean stop = false;
	
	public Generator(Space space) {
		super();
		this.space = space;
	}
	
	public void generateComet() {
		int x = (int)(Math.random() * 400);
		int y = 0;
		int r = (int)(Math.random() * 10) + 10;
		space.addObject(new Comet(x, y, r));
	}
	
	public void generatePlanet() {
		int x = (int)(Math.random() * 400);
		int y = 0;
		int r = (int)(Math.random() * 10) + 10; 
		space.addObject(new Planet(x, y, r));
	}
	
	@Override
	public void run() {
		synchronized (this) {
			try {
				while (!interrupted()) {
					if (stop) continue;
					double num = Math.random();
					if (num >= 0.75) {
						generatePlanet();
					}
					else generateComet();
					this.sleep(500);
				}
			}
			catch (InterruptedException e) {}
		}
	}
	
	public void startGenerator() {
		start();
	}
	
	public void stopGenerator() {
		interrupt();
	}

	public void pauseGenerator() {
		stop = true;
	}
	
	public void resumeGenerator() {
		stop = false;
	}
	
}
