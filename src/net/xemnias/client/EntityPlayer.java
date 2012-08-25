package net.xemnias.client;

import org.newdawn.slick.Input;

public class EntityPlayer extends Entity 
{


	public EntityPlayer(int i, String name, boolean att)
	{
		super(i, name, att);
		animation = AnimationList.playerStandingRight;
	}

	public void update(CommunityGame cc, int delta)
	{
		if(turn == 0)
			animation = AnimationList.playerStandingLeft;
		else if(turn == 1)
			animation = AnimationList.playerStandingRight;
		if(cc.getContainer().getInput().isKeyDown(Input.KEY_Z))
		{
			y-= 100 * delta / 1000f;;
		}
		if(cc.getContainer().getInput().isKeyDown(Input.KEY_S))
		{
			y+= 100 * delta / 1000f;;
		}
		if(cc.getContainer().getInput().isKeyDown(Input.KEY_Q))
		{
			x-= 100 * delta / 1000f;
			animation = AnimationList.playerRunningLeft;
			turn = 0;
		}
		else if(cc.getContainer().getInput().isKeyDown(Input.KEY_D))
		{
			x+= 100 * delta / 1000f;;
			animation = AnimationList.playerRunningRight;
			turn = 1;
		}
	}
}
