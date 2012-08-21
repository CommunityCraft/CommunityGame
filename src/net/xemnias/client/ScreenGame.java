package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class ScreenGame extends Screen {

	private GuiInventory inventory = new GuiInventory(parent);
	
	public ScreenGame(CommunityGame communityGame)
	{
		super(communityGame);
	}
	
	public void preLoad(GameContainer gc, CommunityGame cc)
	{
		
	}
	public void update(GameContainer gc, int delta, CommunityGame cc)
	{
		cc.render.getCamera().move(gc);
		
		if(gc.getInput().isKeyPressed(Input.KEY_E))
			cc.showOrHideDialog(inventory);
		
		if(gc.getInput().isKeyPressed(Input.KEY_LEFT))
		{
			Entity.entityPlayer.setAnimationSprite(CommunityGame.loader.getImageByName("playerAnimation2.png"));
		}
		if(gc.getInput().isKeyPressed(Input.KEY_RIGHT))
		{
			Entity.entityPlayer.setAnimationSprite(CommunityGame.loader.getImageByName("playerAnimation.png"));
		}
		
	}
	public void render(GameContainer gc, Graphics g, CommunityGame cc)
	{
		cc.render.renderTiles(gc, g);
		cc.render.renderEntities();
	}
}
