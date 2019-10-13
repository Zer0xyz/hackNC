package hackNC;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.JPanel;

import gamestate.GameStateManager;


public class GamePanel extends JPanel implements Runnable, KeyListener{
	
	//panel dimensions
	public static final int WIDTH = 900;
	public static final int HEIGHT = 500;
	public static final int SCALE = 2;
	
	//game thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	// image
	private BufferedImage image;
	private Graphics2D g;
	
	// game state manager
	private GameStateManager gsm;
	
	// other
	private boolean recording = false;
	private int recordingCount = 0;
	private boolean screenshot;
	
	public GamePanel() {
		
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addKeyListener(this);
		setFocusable(true);
		requestFocus();
		
		
		
		start();
	}
	
	private void init() {
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		/*g.setRenderingHint(
			RenderingHints.KEY_TEXT_ANTIALIASING,
			RenderingHints.VALUE_TEXT_ANTIALIAS_ON
		);*/
		
		gsm = new GameStateManager();
		running = true;
		
		
	}
	
	public void start()
	{
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() 
	{
		init();
		
		long start;
		long elapsed;
		long wait;
		
		while(running)
		{
			start = System.nanoTime();
			tick();
			repaint();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			
			if (wait < 0) { 
				wait = 5;
			}
			
			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public void tick()
	{
		gsm.tick();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.clearRect(0, 0, WIDTH, HEIGHT);
		
		gsm.draw(g);
	}
	
	public void keyPressed(KeyEvent key) 
	{
		gsm.keyPressed(key.getKeyCode());
	}
	
	public void keyReleased(KeyEvent key) 
	{
		gsm.keyReleased(key.getKeyCode());
	}
	
	public void keyTyped(KeyEvent key) 
	{

	}
}
