package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class ScreenTest extends Screen 
{
	
	private GuiInventory test;
	
	public ScreenTest(CommunityGame communityGame)
	{
		super(communityGame);
		test = new GuiInventory(communityGame);
		
	}

	public void preLoad(GameContainer gc, CommunityGame cc)
	{
		
	}

	public void update(GameContainer gc, int delta, CommunityGame cc)
	{		
		if(gc.getInput().isKeyDown(Input.KEY_Z))
		{
			cc.render.getCamera().setyPos(cc.render.getCamera().getyPos()-1);
		}
		if(gc.getInput().isKeyDown(Input.KEY_S))
		{
			cc.render.getCamera().setyPos(cc.render.getCamera().getyPos()+1);
		}
		if(gc.getInput().isKeyDown(Input.KEY_Q))
		{
			cc.render.getCamera().setxPos(cc.render.getCamera().getxPos()-1);
		}
		if(gc.getInput().isKeyDown(Input.KEY_D))
		{
			cc.render.getCamera().setxPos(cc.render.getCamera().getxPos()+1);
		}
		
		
		if(gc.getInput().isKeyPressed(Input.KEY_E))
			cc.showOrHideDialog(test);
	}

	public void render(GameContainer gc, Graphics g, CommunityGame cc) 
	{
		
	}
	
}
