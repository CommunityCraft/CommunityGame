package net.xemnias.client;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public abstract class GuiDialog extends Gui
{
	protected ArrayList<GuiButton> control = new ArrayList<GuiButton>();
	
	public abstract void render(GameContainer gc, CommunityGame sbg, Graphics g);
	
	public abstract void update(GameContainer gc, CommunityGame sbg, int delta);
	
	public abstract void init(GameContainer gc, CommunityGame sbg);

	protected void actionPerformed(int id, CommunityGame cc)
	{
		
	}
	
	public void drawButton(Graphics g, GameContainer gc, CommunityGame cc)
	{
		for(int i = 0; i < control.size(); i++)
		{
			control.get(i).render(gc, cc, g);
		}
	}
	
	public void updateButton(GameContainer gc, CommunityGame cc, int delta)
	{
		for(int i = 0; i < control.size(); i++)
		{
			control.get(i).update(gc, cc, delta);
		}
	}
	
	public void checkOnClick(GameContainer gc ,CommunityGame cc)
	{
		for(int i = 0; i < control.size(); i++)
		{
			if(control.get(i).isMouseOnIt(gc.getInput()))
			{
				actionPerformed(control.get(i).id, cc);
			}
		}
	}
}
