package net.xemnias.client;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public abstract class GuiContainer extends GuiDialog 
{
	protected ArrayList<ItemSlot> slots = new ArrayList<ItemSlot>();
	protected boolean haveItemOnMouse = false;
	protected Item itemOnMouse = null;
	
	public ItemSlot whatCaseClick(GameContainer gc)
	{
		for(int i = 0; i < slots.size(); i++)
		{
			ItemSlot slot = slots.get(i);
			int mouseX = gc.getInput().getMouseX();
			int mouseY = gc.getInput().getMouseY();
			
			if(mouseX > slot.getX() && mouseX < slot.getX() + slot.getWidth() && mouseY > slot.getY() && mouseY < slot.getY() + slot.getHeight())
				return slot;
		}
		return null;
	}
	
	public void clickOnCase(ItemSlot slot)
	{
		if( slot != null)
		{
			if(slot.getItem() != null && !haveItemOnMouse)
			{
				haveItemOnMouse = true;
				itemOnMouse = slot.getItem();
				slot.setItemOnMouse(true);
				
			}
			else if(slot.getItem() == null && haveItemOnMouse)
			{
				haveItemOnMouse = false;
				for(int i = 0; i < slots.size(); i++)
				{
					if(slots.get(i).isItemOnMouse())
					{
						slots.get(i).setItemOnMouse(false);
						slots.get(i).setItem(null);
					}
				}
				slot.setItem(itemOnMouse);			
			}
		}
	}
	
	public void drawItemName(GameContainer gc, Graphics g)
	{
		int mouseX = gc.getInput().getMouseX();
		int mouseY = gc.getInput().getMouseY();
		for(int i = 0; i < slots.size(); i++)
		{
			ItemSlot slot = slots.get(i);
			if(mouseX > slot.getX() && mouseX < slot.getX() + slot.getWidth() && mouseY > slot.getY() && mouseY < slot.getY() + slot.getHeight())
			{
				if(slot.getItem() != null)
				{
					g.setColor(new Color(0,0,0,0.5f));
					g.fillRect(mouseX+2, mouseY - g.getFont().getHeight(slot.getItem().Name) -2, g.getFont().getWidth(slot.getItem().Name)+6, g.getFont().getHeight(slot.getItem().Name)+6);
					g.setColor(Color.white);
					g.drawString(slot.getItem().Name, mouseX+ 5, mouseY- g.getFont().getHeight(slot.getItem().Name));
				}
			}
		}
	}
}
