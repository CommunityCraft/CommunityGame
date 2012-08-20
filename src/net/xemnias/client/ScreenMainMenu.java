package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class ScreenMainMenu extends ScreenGui
{
	
	public ScreenMainMenu(CommunityGame cc)
	{
		super(cc);

		control.add(new GuiButton(0, cc.getContainer().getWidth()/2 -200, cc.getContainer().getHeight()/2 - 40, "Jouer"));
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
