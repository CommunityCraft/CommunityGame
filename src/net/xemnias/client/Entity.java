package net.xemnias.client;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public class Entity extends GameObject
{
	public int id;
	public String Name;
	public boolean Passive;
	public Rectangle box;

	public int turn = 0;
	
	protected float x, y, w, h;
	protected int life = 100;
	protected int mana = 100;
	protected int xp = 0;
	protected int nextLevel = 100;
	protected int level = 1;
	
	protected Animation animation;

	public static final EntityPlayer entityPlayer = new EntityPlayer(0, "Xemnias", false);
	public static final EntityCorruptedSoul corruptedSoul = new EntityCorruptedSoul(11, "Soul", true);
	
	protected IAPathManager IAPath;
	
	public Entity(int i, String name, boolean att)
	{
		id = i;
		Name = name;
		Passive = att;
		box = new Rectangle(x, y, w, h);
		
		
		for(int z = 0; z < CommunityGame.loadedEntities.size(); z++)
		{
			if(i == CommunityGame.loadedEntities.get(z).id)
			{
				System.err.println("ID entity similaire : "+i);
				System.exit(0);
			}
		}
		CommunityGame.loadedEntities.add(this);
	}
	
	protected void update(CommunityGame cc, int delta)
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
	
	protected void collideWithEntity(Entity e)
	{
		
	}

	protected void collideWithTile(Tile t)
	{
		
	}
	
	public Entity getEntityById(int id)
	{
		for(int i = 0; i < CommunityGame.loadedEntities.size(); i++)
		{
			if(CommunityGame.loadedEntities.get(i).id == id)
				return CommunityGame.loadedEntities.get(i);
		}
		return null;
	}
	
	public void die(EntityPlayer p) 
	{
		p.addXp(xp);
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

	
	public IAPathManager getIAPath() 
	{
		
		return IAPath;
	}

	public void setIAPath(IAPathManager iAPath) {
		IAPath = iAPath;
	}

	public float getX() {
		return x;
	}
	
	public int getNextLevel()
	{
		return nextLevel;
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