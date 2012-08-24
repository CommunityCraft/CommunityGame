package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class GuiCompomentPlayerInformation extends GuiCompoment 
{
	private Image skin;
	private CommunityGame cc;
	
	public GuiCompomentPlayerInformation(CommunityGame parent)
	{
		cc = parent;
		skin = CommunityGame.loader.getImageByName("guiCompomentPlayerInfo.png");
		x = cc.getContainer().getWidth() - skin.getWidth();
		y = 0;
	}
	
	public void render(GameContainer gc, CommunityGame sbg, Graphics g)
	{
		skin.draw(x,y);
	}
}
