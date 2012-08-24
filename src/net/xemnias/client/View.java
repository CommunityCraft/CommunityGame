package net.xemnias.client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

public class View
{
	private float xPos, yPos, width, height;
	private RenderEngine render;
	
	public View(RenderEngine render)
	{
		this.render = render;
		xPos = 00;
		yPos = 00;
		width = 840;
		height = 580;
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

	public void move(GameContainer gc) 
	{
		if(Entity.entityPlayer.turn == 1 && !gc.getInput().isKeyDown(Input.KEY_SPACE))
			Entity.entityPlayer.setAnimation(AnimationList.playerStandingRight);
		else if(!gc.getInput().isKeyDown(Input.KEY_SPACE))
			Entity.entityPlayer.setAnimation(AnimationList.playerStandingLeft);
		
		if(gc.getInput().isKeyDown(Input.KEY_S))
			Entity.entityPlayer.setY(Entity.entityPlayer.getY()+1);
		if(gc.getInput().isKeyDown(Input.KEY_Z))
			Entity.entityPlayer.setY(Entity.entityPlayer.getY()-1);
		
		if(gc.getInput().isKeyDown(Input.KEY_Q))
		{
			if(!(Entity.entityPlayer.getX() < 90))
				Entity.entityPlayer.setX(Entity.entityPlayer.getX()-1);
			else
				render.parent.world.getBackGround().moveRight();
			
			Entity.entityPlayer.setAnimation(AnimationList.playerRunningLeft);
			Entity.entityPlayer.turn = 0;
		}
		if(gc.getInput().isKeyDown(Input.KEY_D))
		{

			if(!(Entity.entityPlayer.getX() > 750))
				Entity.entityPlayer.setX(Entity.entityPlayer.getX()+1);
			else
				render.parent.world.getBackGround().moveLeft();
			
			
			Entity.entityPlayer.setAnimation(AnimationList.playerRunningRight);
			Entity.entityPlayer.turn = 1;
		}
		

		if(gc.getInput().isKeyPressed(Input.KEY_SPACE))
		{
			if(Entity.entityPlayer.turn == 0)
			Entity.entityPlayer.setAnimation(AnimationList.playerJumpingLeft);
			else

				Entity.entityPlayer.setAnimation(AnimationList.playerJumpingRight);
		}
	}
	
	
}
