package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Tile
{
	private float xPos, yPos, width, height;
	private Image skin;
	
	public Tile(float i, float j, float w, float h)
	{
		xPos = i;
		yPos = j;
		width = w;
		height = h;
	}
	
	public void render(GameContainer gc, Graphics g)
	{
		skin.draw(xPos, yPos);
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

	public void bindTexture(Image image)
	{
		skin = image;
	}
	
	
}
