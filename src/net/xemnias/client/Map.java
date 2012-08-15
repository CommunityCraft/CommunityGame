package net.xemnias.client;

import java.util.ArrayList;
import org.newdawn.slick.SlickException;

public class Map
{
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	public Map(String name) throws SlickException
	{
		

		
	}
	
	public void load()
	{
		for(int y = 0; y < 19; y++)
		{
			for(int i = 0; i < 34; i++)
			{

					tiles.add(i, new Tile(i*32, y*32,32,32));
			}
		}
	}
}
