package net.xemnias.client;

import org.newdawn.slick.geom.Rectangle;

public class CollisionManager 
{

	public static Tile checkCollisionTile(Rectangle rect) 
	{
		for(int i = 0; i < CommunityGame.world.tiles.size(); i++)
		{
			if(CommunityGame.world.tiles.get(i).isBlock)
			{
				if(CommunityGame.world.tiles.get(i).getBlock() != null && CommunityGame.world.tiles.get(i).getBlock().collision)
				{
					Tile tile = CommunityGame.world.tiles.get(i);
					if(tile.box.intersects(rect))
						return tile;
				}
			}
		}
		return null;
	}
	
	public static Entity checkCollisionEntity(Entity e) 
	{
		for(int i = 0; i < CommunityGame.entities.size(); i++)
		{

			if(CommunityGame.entities.get(i) != e)
			{
				Entity tile = CommunityGame.entities.get(i);
				if(tile.box.intersects(e.box))
					return tile;
			}
				
		}
		return null;
	}

}
