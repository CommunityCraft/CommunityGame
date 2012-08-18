package net.xemnias.client;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GuiInventory extends GuiContainer
{
	
	public GuiInventory(CommunityGame cc)
	{
		for(int x = 0; x < 7; x++)
		{
			for(int y = 0; y < 3; y++)
			{
				slots.add(new ItemSlot((270) + x*32, (270) +  y*32));
			}
		}
		
		slots.get(5).setItem(Item.ironSword);
		slots.get(6).setItem(Item.ironHammer);
		slots.get(7).setItem(Item.key);
	}
	
	public void init(GameContainer gc, CommunityGame sbg)
	{

	}

	public void update(GameContainer gc, CommunityGame sbg, int delta)
	{
		if(gc.getInput().isMousePressed(0))
		{
			clickOnCase(whatCaseClick(gc));
		}
	}

	public void render(GameContainer gc, CommunityGame sbg, Graphics g) 
	{

		fillRectWithColor(g, 250, 240, 270, 150, Color.gray);
		drawRectWithColor(g, 250, 240, 270, 150, Color.black);
		fillRectWithColor(g, 330, 100, 100, 150, Color.gray);
		drawRectWithColor(g, 330, 100, 100, 140, Color.black);
		drawRectWithColor(g, 340, 110, 80, 120, Color.black);
		fillRectWithColor(g, 345, 115, 70, 110, Color.darkGray);
		
		for(int i = 0; i < slots.size(); i++)
		{
			if(!slots.get(i).isItemOnMouse())
				slots.get(i).render(gc, sbg, g);
		}
		for(int i = 0; i < slots.size(); i++)
		{
			if(slots.get(i).isItemOnMouse())
				slots.get(i).render(gc, sbg, g);
		}
		drawItemName(gc, g);
	}
}
