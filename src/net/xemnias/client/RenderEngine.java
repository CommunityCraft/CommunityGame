package net.xemnias.client;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class RenderEngine
{
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	private View camera;
	
	public RenderEngine(CommunityGame cc)
	{
		tiles = cc.world.tiles;
		camera = new View(this);
	}
	
	public void renderView(Graphics g)
	{
		g.setColor(Color.white);
		g.drawRect(camera.getxPos(), camera.getyPos(), camera.getWidth(), camera.getHeight());
	}
	
	public void renderTiles(GameContainer gc, Graphics g)
	{
		for(int i = 0; i < tiles.size(); i++)
		{
			Tile tile = tiles.get(i);
			if(camera.isOnScreen(tile))
			{
				tile.render(gc, g);
			}
		}
	}

	public View getCamera() 
	{
		return camera;
	}
	
	
}
