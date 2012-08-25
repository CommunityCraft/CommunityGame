package net.xemnias.client;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ScreenGui extends Screen
{
	protected ArrayList<GuiButton> control = new ArrayList<GuiButton>();
	protected Gui gui = new Gui();
	
	public ScreenGui(CommunityGame communityGame)
	{
		super(communityGame);
	}
	
	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException
	{
		currentstate.preLoad(arg0, parent);
	}
	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException
	{
		currentstate.render(arg0, arg2, parent);
		drawButton(arg2, arg0, parent);
	}
	
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException
	{
		currentstate.update(arg0, arg2, parent);

	}
	
	public void actionPerformed(int id, CommunityGame cc) {
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
				Sound.button.play();
			}
		}
	}
	
	public void preLoad(GameContainer gc, CommunityGame cc)
	{
		
	}
	public void update(GameContainer gc, int delta, CommunityGame cc)
	{
		
	}
	public void render(GameContainer gc, Graphics g, CommunityGame cc){
		
	}
}
