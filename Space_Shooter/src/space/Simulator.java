package space;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Simulator extends JFrame implements KeyListener{

	private Space space = new Space();
	private JPanel bottomPanel = new JPanel();
	private Generator generator = new Generator(space);

	
	public void populateWindow() {
		JButton startButton = new JButton("Start");
		JButton pauseButton = new JButton("Pause");
		JButton resumeButton = new JButton("Resume");
		
		bottomPanel.add(pauseButton);
		bottomPanel.add(startButton);
		bottomPanel.add(resumeButton);
		
		startButton.addActionListener(ae -> {
			space.start();
			generator.startGenerator();
			startButton.setEnabled(false);
			pauseButton.setEnabled(true);
			resumeButton.setEnabled(false);
		});
		
		pauseButton.addActionListener(ae -> {
			pauseButton.setEnabled(false);
			resumeButton.setEnabled(true);
			space.pause();
			generator.pauseGenerator();
			
		});
		
		resumeButton.addActionListener(ae -> {
			pauseButton.setEnabled(true);
			resumeButton.setEnabled(false);
			space.resume();
			generator.resumeGenerator();
			
		});
		
		addKeyListener(this);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				synchronized(this) {
					if (generator != null) {
						generator.stopGenerator();
					}
					if (space != null) {
						space.stop();
					}
				}
				dispose();
			}
			
		});
		
		add(bottomPanel, BorderLayout.SOUTH);
		add(space, BorderLayout.CENTER);
		
	}
	
	public Simulator() {
		setResizable(false);
		setBounds(700, 200, 400, 800);
		setFocusable(true);
		populateWindow();
		setVisible(true);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	
	public static void main(String[] args) {
		new Simulator();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			space.getCraft().moveLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			space.getCraft().moveRight();
		}
		space.getCraft().paintComponent(getGraphics());
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyTyped(KeyEvent e) {}
}
