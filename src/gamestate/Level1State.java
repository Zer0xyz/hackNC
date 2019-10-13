package gamestate;

import TileMap.*;
import entities.Player;
import hackNC.GamePanel;

import java.awt.*;

public class Level1State extends GameState {
	
	private Player player;

	public Level1State(GameStateManager gsm) {
		super(gsm);
		init();
	}

	public void init() {
		
		player = new Player(30, 30);
	}

	public void tick() {
		
		player.tick();
		
	}


	public void draw(Graphics g) {

		player.draw(g);
	}


	public void keyPressed(int k) {
		
		player.keyPressed(k);
		
	}

	public void keyReleased(int k) {
		
		player.keyReleased(k);
	}


	
	

}
