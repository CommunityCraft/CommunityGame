package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class ScreenGame extends Screen {

	private GuiInventory inventory = new GuiInventory(parent);
	private GuiBar playerBar = new GuiBar(parent);
	private GuiCompomentPlayerInformation pInfo;
	public ScreenGame(CommunityGame communityGame)
	{
		super(communityGame);
		pInfo = new GuiCompomentPlayerInformation(communityGame);
		parent.gde.registerEntity(Entity.entityPlayer);
		parent.gde.registerEntity(Entity.corruptedSoul);
		Entity.corruptedSoul.setX(75);
		Entity.corruptedSoul.setY(215);
		Entity.corruptedSoul.setIAPath(new IAPathManager(new Location(Entity.corruptedSoul.x, Entity.corruptedSoul.y), new Location(250, 215), true));
	}
	
	public void preLoad(GameContainer gc, CommunityGame cc)
	{
		
	}
	public void update(GameContainer gc, int delta, CommunityGame cc)
	{
		if(gc.getInput().isKeyPressed(Input.KEY_E))
			cc.showOrHideDialog(inventory);

		playerBar.update(gc, cc, delta);
		
		cc.gde.updateEntity(cc, delta);
		cc.gde.updateIAPath(delta);
		
	}
	public void render(GameContainer gc, Graphics g, CommunityGame cc)
	{
		cc.render.renderCurrentMapBackGround();
		cc.render.renderTiles(gc, g);
		cc.render.renderEntities();
		cc.gde.renderAdditionalStuff(g, cc);
		pInfo.render(gc, cc, g);
		cc.gde.drawIAPath(g);
	}
}
