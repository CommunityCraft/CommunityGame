package net.xemnias.client;

public class GDE implements Gestionary 
{
	public void updateEntity(CommunityGame cc) 
	{
		for(int i = 0; i < CommunityGame.entities.size(); i++)
			CommunityGame.entities.get(i).update(cc);
	}
	
	public void registerEntity(Entity en)
	{
		CommunityGame.entities.add(en);
	}
	
	public void updateIAPath()
	{
		for(int i = 0; i < CommunityGame.entities.size(); i++)
		{
			if(CommunityGame.entities.get(i).getIAPath() != null)
				CommunityGame.entities.get(i).getIAPath().moveEntity(CommunityGame.entities.get(i));
		}
	}
}