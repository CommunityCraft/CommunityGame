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

}
