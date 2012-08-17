package net.xemnias.client;

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
		
		slots.get(20).setItem(new Item(0,0,0,"Test", cc));
		slots.get(19).setItem(new Item(1,32,0,"Test2", cc));
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
