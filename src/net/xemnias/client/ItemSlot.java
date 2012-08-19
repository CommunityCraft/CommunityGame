package net.xemnias.client;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class ItemSlot extends GuiCompoment 
{
	private Item item;
	private boolean itemOnMouse = false;
	public boolean equipedSlot = false;
	
	public ItemSlot(float i, float j)
	{
		x = i;
		y = j;		
		width = 32;
		height = 32;
	}
	
	public void init(GameContainer gc, CommunityGame cc)
	{
		
	}

	public void update(GameContainer gc, CommunityGame cc, int delta) 
	{
		
	}
	
	public void render(GameContainer gc, CommunityGame cc, Graphics g) 
	{	
		Color caseColor = Color.lightGray;
		
		if(mouseOnSlot(gc.getInput()))
		{
			caseColor = Color.gray;
		}
		
		drawRectWithColor(g, x, y, 32, 32, Color.black);
		fillRectWithColor(g, x+1, y+1, 31, 31, caseColor);
		
		if(item != null)
		{
			if(!itemOnMouse)
				item.drawAsIcon(x+1, y+1, g);
			else if(itemOnMouse)
				item.drawAsIcon(gc.getInput().getMouseX()+1, gc.getInput().getMouseY()+1, g);
		}

	}

	private boolean mouseOnSlot(Input input)
	{
		if(input.getMouseX() > x && input.getMouseX() < x + width && input.getMouseY() > y && input.getMouseY() < y + height)
			return true;
		return false;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public boolean isItemOnMouse() {
		return itemOnMouse;
	}

	public void setItemOnMouse(boolean itemOnMouse) {
		this.itemOnMouse = itemOnMouse;
	}

}
