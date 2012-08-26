package net.xemnias.client;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
public class ScreenMainMenu extends ScreenGui
{
	
	public ScreenMainMenu(CommunityGame cc)
	{
		super(cc);
		control.add(new GuiButton(0, cc.getContainer().getWidth()/2 -200, cc.getContainer().getHeight()/4, "Jouer"));
	}

	public void preLoad(GameContainer gc, CommunityGame cc) 
	{
		
	}

	public void update(GameContainer gc, int delta, CommunityGame cc) 
	{
		updateButton(gc, parent, delta);
		if(gc.getInput().isMousePressed(0))
			checkOnClick(gc, parent);
	}
	
	public void render(GameContainer gc, Graphics g, CommunityGame cc) 
	{
		drawDefaultBackground();
		gui.fillRectWithAlpha(0, 0, 840, 580, Color.black, 0.3f, g);
		drawButton(g, gc, parent);
	}

	public void actionPerformed(int id, CommunityGame cc) 
	{
		if(id == 0)
		{
			parent.switchGuiTo(new ScreenGame(parent));
		}
	}
}
