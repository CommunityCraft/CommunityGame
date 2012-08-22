package net.xemnias.client;

public class EntityPlayer extends Entity 
{

	public int turn = 0;

	public EntityPlayer(int i, String name, boolean att)
	{
		super(i, name, att);
		animation = AnimationList.playerStandingRight;
	}



}
