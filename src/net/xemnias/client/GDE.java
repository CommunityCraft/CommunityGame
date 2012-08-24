package net.xemnias.client;

public class GDE implements Gestionary 
{
	public void updateEntity(CommunityGame cc) 
	{
		for(int i = 0; i < CommunityGame.entities.size(); i++)
			CommunityGame.entities.get(i).update(cc);
	}
}