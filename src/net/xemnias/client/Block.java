package net.xemnias.client;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Block
{
	public int id;
	public Image sprite;
	public String Name;
	
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

	public static Block dirt = new Block(0, "Terre");
	public static Block leftGrass = new Block(1, "Herbe");
	public static Block grass = new Block(2, "Herbe");
	public static Block rightGrass = new Block(3, "Herbe");
	public static Block woodenBox = new Block(4, "Caisse en bois");
	public static Block littlePebble = new Block(5, "Petit cailloux");
	public static Block redFlower = new Block(6, "Fleurs rouge");
	public static Block yellowFlower = new Block(7, "Fleurs jaune");
	
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

}
