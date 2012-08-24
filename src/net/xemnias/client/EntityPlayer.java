package net.xemnias.client;

import org.newdawn.slick.Input;

public class EntityPlayer extends Entity 
{


	public EntityPlayer(int i, String name, boolean att)
	{
		super(i, name, att);
		animation = AnimationList.playerStandingRight;
	}

	public void update(CommunityGame cc)
	{
		if(turn == 0)
			animation = AnimationList.playerStandingLeft;
		else if(turn == 1)
			animation = AnimationList.playerStandingRight;
		if(cc.getContainer().getInput().isKeyDown(Input.KEY_Z))
		{
			y--;
		}
		if(cc.getContainer().getInput().isKeyDown(Input.KEY_S))
		{
			y++;
		}
		if(cc.getContainer().getInput().isKeyDown(Input.KEY_Q))
		{
			x--;
			animation = AnimationList.playerRunningLeft;
			turn = 0;
		}
		if(cc.getContainer().getInput().isKeyDown(Input.KEY_D))
		{
			x++;
			animation = AnimationList.playerRunningRight;
			turn = 1;
		}
	}
}
