package gamestate;

import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class GameState {
	
	protected GameStateManager gsm;
	public static double xOffset;
	public static double yOffset;
	
	public GameState(GameStateManager gsm)
	{
		this.gsm = gsm;
		
		xOffset = 0;
		yOffset = 0;
		
		
		init();
	}
	
	public abstract void init();
	public abstract void tick();
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	

}
