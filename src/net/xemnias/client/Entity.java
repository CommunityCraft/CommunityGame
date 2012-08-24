package net.xemnias.client;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class Entity
{
	public int id;
	public String Name;
	public boolean Passive;

	public int turn = 0;
	
	protected float x, y;
	protected int life = 100;
	
	protected Animation animation;

	public static final EntityPlayer entityPlayer = new EntityPlayer(0, "Xemnias", false);
	
	public Entity(int i, String name, boolean att)
	{
		id = i;
		Name = name;
		Passive = att;
		
		
		for(int z = 0; z < CommunityGame.entities.size(); z++)
		{
			if(i == CommunityGame.entities.get(z).id)
			{
				System.err.println("ID item similaire : "+i);
				System.exit(0);
			}
		}
		CommunityGame.entities.add(this);
	}
	
	protected void update(CommunityGame cc)
	{
		
	}
	
	protected void render(CommunityGame cc, Graphics g)
	{
		
	}
	
	public void renderEntityByList(ArrayList<Entity> entities)
	{
		for(int i = 0; i < entities.size(); i++)
			renderEntity(entities.get(i));
	}

	public void renderEntity(Entity entity)
	{
		if(entity.animation != null)
		entity.animation.draw(entity.getX(), entity.getY());
	}
	
	public void setAnimationSprite(Image imageByName)
	{
		org.newdawn.slick.SpriteSheet sheet = new SpriteSheet(imageByName, 32, 64);
		animation = new Animation(sheet, 200);
	}
	
	public void setAnimation(Animation anim)
	{
		animation = anim;
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
	
	public boolean isAlive()
	{
		if(life > 0)
			return true;
		else
			return false;
	}

	public void setParentTile(Tile tile) 
	{
		setX(tile.getxPos());
		setY(tile.getyPos());
	}
	
}