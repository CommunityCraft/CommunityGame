package net.xemnias.client;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Item 
{
	private Image skin;
	public String Name;
	public int id;
	
	
	public Item(int i, int xCoor, int yCoor, String name, CommunityGame parent)
	{
		id = i;
		Name = name;
		
		skin = parent.loader.getImageByName("item.png").getSubImage(xCoor, yCoor, 32, 32);
	}
	
	public void drawAsIcon(float x, float y, Graphics g)
	{
		g.drawImage(skin, x, y);
	}
}
