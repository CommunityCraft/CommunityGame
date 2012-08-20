package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Tile
{
	private float xPos, yPos, width, height;
	
	private Item item;
	private Block block;
	
	public Tile(float i, float j, float w, float h, int id)
	{
		xPos = i;
		yPos = j;
		width = w;
		height = h;
		
		if(id == 0)
		{
			item = Item.ironHammer.getItemById(id);
		}
		else
		{
			block = Block.grass.getBlockById(id);
		}
	}
	
	public void render(GameContainer gc, Graphics g)
	{
		if(item != null)
			item.drawAsIcon(xPos, yPos, g);
		else if(block != null)
			block.draw(xPos, yPos, g);
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
