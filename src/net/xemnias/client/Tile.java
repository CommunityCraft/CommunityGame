package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Tile
{
	private float xPos, yPos, width, height;
	public boolean isBlock, isItem;
	public Rectangle box;
	
	private Item item;
	private Block block;
	public Entity entity;
	
	public Tile(float i, float j, float w, float h,	Block blockP)
	{
		isBlock = true;
		xPos = i;
		yPos = j;
		width = w;
		height = h;
		block = blockP;
		box = new Rectangle(i, j, w, h);
	}
	
	public Tile(float i, float j, float w, float h,	Item itemP)
	{
		isItem = true;
		xPos = i;
		yPos = j;
		width = w;
		height = h;
		item = itemP;
		box = new Rectangle(i, j, w, h);
	}
	
	public Tile(int i, int j, int w, int h, Entity entityP) 
	{
		xPos = i;
		yPos = j;
		width = w;
		height = h;
		entity = entityP;
		box = new Rectangle(i, j, w, h);
		entity.setParentTile(this);
		CommunityGame.entities.add(entity);
	}

	public void render(GameContainer gc, Graphics g)
	{
		if(item != null && isItem)
			item.drawAsIcon(xPos, yPos, g);
		else if(block != null && isBlock)
			block.draw(xPos, yPos, g);
	}
	
	public Block getBlock()
	{
		return block;
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
