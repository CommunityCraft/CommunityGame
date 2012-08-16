package net.xemnias.client;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;

public class Map
{
	public ArrayList<Tile> tiles = new ArrayList<Tile>();
	private CommunityGame cc;
	
	public Map(String name, CommunityGame parent) throws SlickException
	{
		cc = parent;

		
	}
	
	public void load() throws SlickException
	{
		for(int y = 0; y < 19; y++)
		{
			for(int i = 0; i < 34; i++)
			{
					tiles.add(i, new Tile(i*32, y*32,32,32));
					tiles.get(i).bindTexture(cc.loader.getImageByName("grass.png"));
			}
		}
	}
}
