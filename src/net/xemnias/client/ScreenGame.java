package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class ScreenGame extends Screen {

	private GuiInventory inventory = new GuiInventory(parent);
	
	public ScreenGame(CommunityGame communityGame)
	{
		super(communityGame);
		CommunityGame.entities.add(Entity.entityPlayer);
		CommunityGame.entities.add(Entity.corruptedSoul);
	}
	
	public void preLoad(GameContainer gc, CommunityGame cc)
	{
		
	}
	public void update(GameContainer gc, int delta, CommunityGame cc)
	{
		if(gc.getInput().isKeyPressed(Input.KEY_E))
			cc.showOrHideDialog(inventory);
		
		cc.gde.updateEntity(cc);
		
	}
	public void render(GameContainer gc, Graphics g, CommunityGame cc)
	{
		cc.render.renderCurrentMapBackGround();
		cc.render.renderTiles(gc, g);
		cc.render.renderEntities();
	}
}
