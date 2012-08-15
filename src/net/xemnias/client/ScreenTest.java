package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class ScreenTest extends Screen 
{
	
	private GuiDialogTest test;
	
	public ScreenTest(CommunityGame communityGame)
	{
		super(communityGame);
		test = new GuiDialogTest();
		
	}

	public void preLoad(GameContainer gc, CommunityGame cc)
	{
		super.preLoad(gc, cc);
	}

	public void update(GameContainer gc, int delta, CommunityGame cc)
	{
		super.update(gc, delta, cc);
		
		
		if(gc.getInput().isKeyPressed(Input.KEY_E))
			cc.showOrHideDialog(test);
	}

	public void render(GameContainer gc, Graphics g, CommunityGame cc) 
	{
		super.render(gc, g, cc);
	}
	
}
