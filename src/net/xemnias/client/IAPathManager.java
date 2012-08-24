package net.xemnias.client;

public class IAPathManager extends IAManager
{
	public Location originalLocation;
	public Location futurLocation;
	public boolean goBack;
	
	public boolean isMovingToFutur, isMovingToOriginal;
	
	public IAPathManager(Location loc, Location futurLoc, boolean gb)
	{
		originalLocation = loc;
		futurLocation = futurLoc;
		goBack = gb;
	}
	
	public void moveEntity(Entity en)
	{
		Location loc = new Location(en.x, en.y);
		
		if(originalLocation.x == loc.x && originalLocation.y == loc.y) // si il est la position de départ
		{
			isMovingToFutur = true;
		}
		if(futurLocation.x == loc.x && futurLocation.y == loc.y && goBack) // si on est a la position final && qu'on y retourne
		{
			isMovingToOriginal = true;

		}

		
		if(isMovingToFutur)
		{
			if(loc.x == futurLocation.x && loc.y == futurLocation.y)
			{
				isMovingToFutur = false;
			}
			
			if(originalLocation.x < futurLocation.x && isMovingToFutur)
			{
				en.x+= 0.5f;
			}
			if(originalLocation.x > futurLocation.x && isMovingToFutur)
			{
				en.x-= 0.5f;
			}
			
			if(originalLocation.y < futurLocation.y && isMovingToFutur)
			{
				en.y+= 0.5f;
			}
			if(originalLocation.y > futurLocation.y && isMovingToFutur)
			{
				en.y-= 0.5f;
			}
			
		}
		if(isMovingToOriginal)
		{
			if(loc.x == originalLocation.x && loc.y == originalLocation.y)
			{
				isMovingToOriginal = false;
			}
			if(futurLocation.x < originalLocation.x && isMovingToOriginal)
			{
				en.x+= 0.5f;
			}
			if(futurLocation.x > originalLocation.x && isMovingToOriginal)
			{
				en.x-= 0.5f;
			}
			
			if(futurLocation.y < originalLocation.y && isMovingToOriginal)
			{
				en.y+= 0.5f;
			}
			if(futurLocation.y > originalLocation.y && isMovingToOriginal)
			{
				en.y-= 0.5f;
			}
		}
	}
}
