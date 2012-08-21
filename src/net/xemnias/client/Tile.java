package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Tile
{
	private float xPos, yPos, width, height;
	private boolean isBlock, isItem, isEntity;
	
	
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
	}
	
	public Tile(float i, float j, float w, float h,	Item itemP)
	{
		isItem = true;
		xPos = i;
		yPos = j;
		width = w;
		height = h;
		item = itemP;
	}
	
	public Tile(int i, int j, int w, int h, Entity entityP) 
	{
		isEntity = true;
		xPos = i;
		yPos = j;
		width = w;
		height = h;
		entity = entityP;
	}

	public void render(GameContainer gc, Graphics g)
	{
		if(item != null && isItem)
			item.drawAsIcon(xPos, yPos, g);
		else if(block != null && isBlock)
			block.draw(xPos, yPos, g);
		else if(entity != null && isEntity)
			entity.renderEntityByList(CommunityGame.entities);
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
