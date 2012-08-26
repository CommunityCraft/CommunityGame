package net.xemnias.client;

import org.newdawn.slick.Graphics;

public class GDE implements Gestionary 
{
	public void updateEntity(CommunityGame cc, int delta) 
	{
		for(int i = 0; i < CommunityGame.entities.size(); i++)
			CommunityGame.entities.get(i).update(cc, delta);
	}
	
	public void registerEntity(Entity en)
	{
		CommunityGame.entities.add(en);
	}
	
	public void updateIAPath(int delta)
	{
		for(int i = 0; i < CommunityGame.entities.size(); i++)
		{
			if(CommunityGame.entities.get(i).getIAPath() != null)
				CommunityGame.entities.get(i).getIAPath().moveEntity(CommunityGame.entities.get(i), delta);
		}
	}
	
	public void drawIAPath(Graphics g)
	{
		for(int i = 0; i < CommunityGame.entities.size(); i++)
		{
			if(CommunityGame.entities.get(i).getIAPath() != null)
				CommunityGame.entities.get(i).getIAPath().drawPath(g);
		}
	}
	
	public void renderAdditionalStuff(Graphics g, CommunityGame cc)
	{
		for(int i = 0; i < CommunityGame.entities.size(); i++)
			CommunityGame.entities.get(i).render(cc, g);
	}
}