package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public abstract class GuiDialog
{

	public abstract void render(GameContainer gc, CommunityGame sbg, Graphics g);
	
	public abstract void update(GameContainer gc, CommunityGame sbg, int delta);
	
	public abstract void init(GameContainer gc, CommunityGame sbg);

}
