package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class GuiButton extends GuiCompoment 
{
	protected int id;
	
	public GuiButton(int i, float xPos, float yPos)
	{
		id = i;
		x = xPos;
		y = yPos;
		
		width = 400;
		height = 40;
	}

	public GuiButton(int i, float xPos, float yPos, float w, float h)
	{

		id = i;
		x = xPos;
		y = yPos;
		width = w;
		height = h;
	}
	
	protected void render(GameContainer gc, CommunityGame cc, Graphics g)
	{
		drawTexturalQuad(g, cc.loader.getImageByName("gui.png"),0,0,400,40, x, y);
	}

	protected void init(GameContainer gc, CommunityGame sbg)
	{
		
	}

	protected void update(GameContainer gc, CommunityGame sbg, int delta) 
	{
		
	}
	
	public boolean isMouseOnIt(Input input)
	{
		if(input.getMouseX() > x && input.getMouseX() < x + width && input.getMouseY() > y && input.getMouseY() < y + height)
			return true;
		return false;
	}
	
}
