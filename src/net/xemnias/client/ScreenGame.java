package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class ScreenGame extends Screen {

	public GuiInventory inventory = new GuiInventory(parent);
	public GuiBar playerBar = new GuiBar(parent);
	private GuiCompomentPlayerInformation pInfo;
	public static float X_TRANSLATE_GRAPHICS;
	
	public ScreenGame(CommunityGame communityGame)
	{
		super(communityGame);
		pInfo = new GuiCompomentPlayerInformation(communityGame);
	}
	
	public void preLoad(GameContainer gc, CommunityGame cc)
	{
		
	}
	public void update(GameContainer gc, int delta, CommunityGame cc)
	{
		cc.render.getCamera().setxPos(-X_TRANSLATE_GRAPHICS);
		
		
		if(gc.getInput().isKeyPressed(Input.KEY_E))
			openInventory();

		playerBar.update(gc, cc, delta);
		if(!isDialogOpen)
		{
			cc.gde.updateEntity(cc, delta);
			cc.gde.updateIAPath(delta);
		}
	}
	public void render(GameContainer gc, Graphics g, CommunityGame cc)
	{
		cc.render.renderCurrentMapBackGround();
		
		g.translate(X_TRANSLATE_GRAPHICS, 0);
		g.pushTransform();
		
		cc.render.renderTiles(gc, g);
		cc.render.renderEntities(g);
		cc.gde.renderAdditionalStuff(g, cc);
		cc.gde.drawIAPath(g);
		
		g.translate(-X_TRANSLATE_GRAPHICS, 0);
		g.pushTransform();
		pInfo.render(gc, cc, g);
		playerBar.render(gc, cc, g);
        
	}
	
	public void openInventory()
	{

		inventory.close();
		parent.showOrHideDialog(inventory);
	}
}
