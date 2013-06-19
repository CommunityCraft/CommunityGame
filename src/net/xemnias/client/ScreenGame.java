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
			cc.showOrHideDialog(inventory);

		playerBar.update(gc, cc, delta);
		
		cc.gde.updateEntity(cc, delta);
		cc.gde.updateIAPath(delta);
		
	}
	public void render(GameContainer gc, Graphics g, CommunityGame cc)
	{
		cc.render.renderCurrentMapBackGround();
		pInfo.render(gc, cc, g);
		playerBar.render(gc, cc, g);
		
		g.translate(X_TRANSLATE_GRAPHICS, 0);
		g.pushTransform();
		
		cc.render.renderTiles(gc, g);
		cc.render.renderEntities();
		cc.gde.renderAdditionalStuff(g, cc);
		cc.gde.drawIAPath(g);
		
        
	}
	
	public void openInventory()
	{
		parent.showOrHideDialog(inventory);
	}
}
