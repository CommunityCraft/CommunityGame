package net.xemnias.client;

public class EntitySpawner 
{
	private float x, y;
	private int id;
	private Entity entity;
	
	public EntitySpawner(int a, float i, float j)
	{
		setX(i);
		setY(j);
		a = id;
		entity = Entity.entityPlayer.getEntityById(id);
	}
	
	public void spawnEntity(CommunityGame cc)
	{
		cc.gde.registerEntity(entity);
	}
	
	public Entity getEntity(float x, float y, int id)
	{
		return entity;
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
}
