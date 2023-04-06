package svemir;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame {

	private Svemir svemir = new Svemir();
	private Panel donjiPanel = new Panel();
	private Generator generator = new Generator(svemir, getGraphics());
	
	public void populateWindow() {
		Button pokreni = new Button("Pokreni!");
		donjiPanel.add(pokreni);
		
		pokreni.addActionListener((ae)->{
			svemir.pokreni();
			generator.pokreni();
			pokreni.setEnabled(false);
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				synchronized (this) {
					if(generator != null) generator.zaustavi();
					if(svemir != null) svemir.zaustavi();
				}
				dispose();
//				System.exit(0);
			}
		});
		
		
		add(donjiPanel, BorderLayout.SOUTH);
		add(svemir, BorderLayout.CENTER);
	}
	
	public Simulator() {
		setResizable(false); 
		setBounds(700, 200, 200, 400);
		populateWindow();
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Simulator();
	}
}
