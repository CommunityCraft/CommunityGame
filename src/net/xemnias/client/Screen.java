package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Screen extends BasicGameState
{
	
	public boolean isDialogOpen = false;
	public GuiDialog dialog;
	public CommunityGame parent;
	
	public Screen currentstate;

	public Screen(CommunityGame communityGame) 
	{
		parent = communityGame;
	}

	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException
	{
		currentstate.preLoad(arg0, parent);
	}

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException
	{
		parent.render.renderTiles(arg0, arg2);
		currentstate.render(arg0, arg2, parent);
		if(isDialogOpen)
		{
			dialog.render(arg0,parent, arg2);
			dialog.drawButton(arg2, arg0, parent);
		}
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException
	{
		currentstate.update(arg0, arg2, parent);
		System.out.println(arg2);
		if(isDialogOpen)
		{
			dialog.update(arg0,parent,arg2);
			dialog.updateButton(arg0, parent, arg2);
			
			if(arg0.getInput().isMousePressed(0))
				dialog.checkOnClick(arg0, parent);
		}
	}

	public int getID() 
	{
		return 0;
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
