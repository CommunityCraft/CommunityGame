package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GuiCompoment extends Gui
{
	protected float x;
	protected float y;
	protected float width;
	protected float height;
	
	protected void render(GameContainer gc, CommunityGame sbg, Graphics g)
	{
		
	}
	
	protected void init(GameContainer gc, CommunityGame sbg)
	{
		
	}

	protected void update(GameContainer gc, CommunityGame sbg, int delta)
	{
		
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
}
