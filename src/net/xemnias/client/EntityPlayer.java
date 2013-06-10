package net.xemnias.client;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

public class EntityPlayer extends Entity 
{
	private Rectangle up = new Rectangle(x+1, y, w-2, 1);
	private Rectangle left = new Rectangle(x, y+1, 1, h-2);
	private Rectangle down = new Rectangle(x+1, y+h-1, w-2, 1);
	private Rectangle right = new Rectangle(x+w-1, y+1, 1, h-2);
	
	public Tile collideTile = null;
	
	public EntityPlayer(int i, String name, boolean att)
	{
		super(i, name, att);
		animation = AnimationList.playerStandingRight;
		w = 32;
		h = 62;
	}
	
	public void collideWithTile(Tile t, int delta)
	{
		
	}
		
	public void update(CommunityGame cc, int delta)
	{
		if(turn == 0)
			animation = AnimationList.playerStandingLeft;
		else if(turn == 1)
			animation = AnimationList.playerStandingRight;
		
		// ############################## MOVE ##############################
		
		
		if(cc.getContainer().getInput().isKeyDown(Input.KEY_Z))
		{
			y-= 100 * delta / 1000f;;
			updateBoxesPos();
			if((collideTile = CollisionManager.checkCollisionTile(up)) != null)
			{
				y+= 100 * delta / 1000f;;
			}
		}
		if(cc.getContainer().getInput().isKeyDown(Input.KEY_S))
		{
			y+= 100 * delta / 1000f;;
			updateBoxesPos();
			if((collideTile = CollisionManager.checkCollisionTile(down)) != null)
			{
				y-= 100 * delta / 1000f;;
			}
			
		}
		if(cc.getContainer().getInput().isKeyDown(Input.KEY_Q))
		{
			x-= 100 * delta / 1000f;
			animation = AnimationList.playerRunningLeft;
			turn = 0;
			updateBoxesPos();
			if((collideTile = CollisionManager.checkCollisionTile(left)) != null)
			{
				x+= 100 * delta / 1000f;
			}
			
		}
		if(cc.getContainer().getInput().isKeyDown(Input.KEY_D))
		{
			x+= 100 * delta / 1000f;
			animation = AnimationList.playerRunningRight;
			turn = 1;
			updateBoxesPos();
			if((collideTile = CollisionManager.checkCollisionTile(right)) != null)
			{
				x-= 100 * delta / 1000f;
			}
		}
		

		// ############################## END MOVE ##############################
		
		if(cc.getContainer().getInput().isKeyDown(Input.KEY_T))
		{
			if(!(xp >= nextLevel))
				xp ++;
			else
			{
				xp = 0;
				level++;
				nextLevel = 100*level;
				System.out.println("L : "+level+ "     N : "+nextLevel);
			}
		}
	}

	private void updateBoxesPos()
	{
		up.setBounds(x+1, y, w-2, 1);
		left.setBounds(x, y+1, 1, h-2);
		down.setBounds(x+1, y+h-1, w-2, 1);
		right.setBounds(x+w-1, y+1, 1, h-2);
	}
}
