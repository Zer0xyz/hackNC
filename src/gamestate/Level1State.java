package gamestate;

import entities.EnemyHorizontal;
import entities.Player;
import hackNC.GamePanel;
import objects.Block;

import java.awt.*;

public class Level1State extends GameState {
	
	private Player player;
	
	private Block[] b;
	private EnemyHorizontal e;

	public Level1State(GameStateManager gsm) {
		super(gsm);
		init();
	}

	public void init() {
		
		player = new Player(30, 30);
		
		b = new Block[3];
		
		b[0] = new Block(500, 400);
		b[1] = new Block(450, 450);
		b[2] = new Block(400, 500);
		
		e = new EnemyHorizontal(200, 200);
	}

	public void tick() {
		
		for (int i = 0; i < b.length; i++)
		{
			b[i].tick();
		}
		
		player.tick(b);
		e.tick();
		
	}


	public void draw(Graphics g) {

		player.draw(g);
		e.draw(g);
		
		for (int i = 0; i < b.length; i++)
		{
			b[i].draw(g);
		}
	}


	public void keyPressed(int k) {
		
		player.keyPressed(k);
		
	}

	public void keyReleased(int k) {
		
		player.keyReleased(k);
	}


	
	

}
