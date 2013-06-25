package net.xemnias.client;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class RenderEngine
{
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	private View camera;
	public CommunityGame parent;
	
	public RenderEngine(CommunityGame cc)
	{
		tiles = CommunityGame.world.tiles;
		parent = cc;
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
	
	public void renderEntityByList(ArrayList<Entity> entities)
	{
		for(int i = 0; i < entities.size(); i++)
			renderEntity(entities.get(i));
	}

	public void renderEntity(Entity entity)
	{
		entity.animation.draw(entity.getX(), entity.getY());
	}
	
	public View getCamera() 
	{
		return camera;
	}

	public void renderEntities(Graphics g) 
	{
		for(int i = 0; i < CommunityGame.entities.size(); i++)
		{
			CommunityGame.entities.get(i).renderEntity(CommunityGame.entities.get(i));
		}
	}

	public void renderCurrentMapBackGround() 
	{
		CommunityGame.world.getBackGround().draw(-500, 0);
	}
	
	
}
