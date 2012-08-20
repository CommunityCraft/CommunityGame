package net.xemnias.client;

import org.newdawn.slick.geom.Rectangle;

public class View
{
	private float xPos, yPos, width, height;
	//private RenderEngine render;
	
	public View(RenderEngine render)
	{
		//this.render = render;
		xPos = 150;
		yPos = 80;
		width = 256;
		height = 380/2;
	}

	public boolean isOnScreen(Tile tile)
	{
		Rectangle r = new Rectangle(xPos, yPos, width, height);
		Rectangle r2 = new Rectangle(tile.getxPos(), tile.getyPos(), tile.getWidth(), tile.getHeight());
		
		return r.intersects(r2);
	}

	public float getxPos() {
		return xPos;
	}

	public void setxPos(float xPos) {
		this.xPos = xPos;
	}

	public float getyPos() {
		return yPos;
	}

	public void setyPos(float yPos) {
		this.yPos = yPos;
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
