package net.xemnias.client;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Block
{
	public int id;
	public Image sprite;
	public String Name;
	public boolean collision = false;
	private Tile parentTile;
	
	public Block(int i, String name)
	{
		id = i;
		Name = name;
		

		sprite = CommunityGame.loader.getTextureById(i);
		
		for(int z = 0; z < CommunityGame.blockList.size(); z++)
		{
			if(i == CommunityGame.blockList.get(z).id)
			{
				System.err.println("ID block similaire : "+i);
				System.exit(0);
			}
		}
		CommunityGame.blockList.add(this);
	}

	public static BlockDirt dirt = new BlockDirt(0, "Terre");
	public static BlockLeftGrass leftGrass = new BlockLeftGrass(1, "Herbe");
	public static BlockGrass grass = new BlockGrass(2, "Herbe");
	public static BlockRightGrass rightGrass = new BlockRightGrass(3, "Herbe");
	public static BlockWoodenBox woodenBox = new BlockWoodenBox(4, "Caisse en bois");
	public static BlockLittlePebble littlePebble = new BlockLittlePebble(5, "Petit cailloux");
	public static BlockRedFlower redFlower = new BlockRedFlower(6, "Fleurs rouge");
	public static BlockYellowFlower yellowFlower = new BlockYellowFlower(7, "Fleurs jaune");
	public static BlockFountain fountain = new BlockFountain(24, "Fontaine");
	
	public void draw(float xPos, float yPos, Graphics g)
	{
		sprite.draw(xPos, yPos);
	}

	public Block getBlockById(int id2)
	{
		for(int i = 0; i < CommunityGame.blockList.size(); i++)
		{
			if(CommunityGame.blockList.get(i).id == id2)
				return CommunityGame.blockList.get(i);
		}
		return null;
	}
	
	public Tile getTileUpTo(Block b)
	{
		if(b.getParentTile().isBlock)
		{
			Tile t = b.getParentTile();
			return getTileAt(t.getxPos(), t.getyPos()-32);
		}
		
		return null;
	}

	
	
	
	private Tile getTileAt(float x, float y) 
	{
		for(int i = 0; i < CommunityGame.world.tiles.size(); i++)
		{
			if(CommunityGame.world.tiles.get(i).getxPos() == x && CommunityGame.world.tiles.get(i).getyPos() == y)
			{
				return CommunityGame.world.tiles.get(i);
			}
		}
		
		return null;
	}

	public Tile getParentTile() {
		return parentTile;
	}

	public void setParentTile(Tile parentTile) {
		this.parentTile = parentTile;
	}

}
