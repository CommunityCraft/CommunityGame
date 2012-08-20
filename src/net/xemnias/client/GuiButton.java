package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class GuiButton extends GuiCompoment 
{
	protected int id;
	private String displayString;
	
	public GuiButton(int i, float xPos, float yPos, String str)
	{
		id = i;
		x = xPos;
		y = yPos;
		
		displayString = str;
		
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
		int i = 0;
		if(isMouseOnIt(gc.getInput()))
			i+=40;
		drawTexturalQuad(g, CommunityGame.loader.getImageByName("gui.png"),0,i,400,40, x, y);
		drawCenteredString(displayString, x+200, y+20, g);

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
