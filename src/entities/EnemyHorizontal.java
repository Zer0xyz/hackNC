package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import gamestate.GameState;
import objects.Block;

public class EnemyHorizontal{

	private double x, y;
	private int width;
	private int height;
	public int counter = 0;
	
	public EnemyHorizontal(int x, int y) 
	{
		this.x = x;
		this.y = y;
		this.width = 50;
		this.height = 50;
	}
	
	public void tick()
	{
		
		if(counter <= 300)
		{
			x++;
			counter++;
		}
		if(counter == 300)
		{	
			counter = 600;
		}
		if(counter > 300)
		{
			x--;
			counter--;
		}
		if(counter == 302)
		{
			counter = 0;
		}
					
	}
		
	
	
	
	public void draw(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect((int)x - (int)GameState.xOffset, (int)y - (int)GameState.yOffset, width, height);
		
	}
	
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}

}
