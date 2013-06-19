package net.xemnias.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

public class EntityPlayer extends Entity 
{
	
	private Rectangle up = new Rectangle(x+1, y, w-2, 1);
	private Rectangle left = new Rectangle(x, y+1, 1, h-2);
	private Rectangle down = new Rectangle(x+1, y+h-10, w-2, 1);
	private Rectangle right = new Rectangle(x+w-1, y+1, 1, h-2);
	
	public Tile collideTile = null;
	public boolean isJumping = false;
	private Timer timer = null;
	
	private Item item;
	public float gravityTimer;
	
	public EntityPlayer(int i, String name, boolean att)
	{
		super(i, name, att);
		animation = AnimationList.playerStandingRight;
		w = 32;
		h = 62;
		
		timer = new Timer(256, new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				isJumping = false;
				timer.stop();
			}
		});
		
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
		gravityTimer += delta/1000f;
		move(cc, delta);
		
		translateMap(delta);
		
		
		
		if(cc.getContainer().getInput().isKeyDown(Input.KEY_T))
		{
			if(!(xp >= nextLevel))
				xp ++;
			else
			{
				xp = 0;
				level++;
				nextLevel = 100*level;
			}
		}
		
		if(cc.getContainer().getInput().isKeyDown(Input.KEY_SPACE) && !timer.isRunning())
		{
			isJumping = true;
			timer.start();
		}
		
		
		
	}

	
	
	
	private void translateMap(int delta) 
	{
		if(x > -1*ScreenGame.X_TRANSLATE_GRAPHICS+832-320)
			ScreenGame.X_TRANSLATE_GRAPHICS--;
		if(ScreenGame.X_TRANSLATE_GRAPHICS !=0)
		{

			if(x < -ScreenGame.X_TRANSLATE_GRAPHICS+32*10)
			{
				ScreenGame.X_TRANSLATE_GRAPHICS++;
			}
		}
	}

	private void move(CommunityGame cc, int delta) 
	{
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
		if(!(cc.getContainer().getInput().isKeyDown(Input.KEY_Z)))
		gravity(delta, cc);	
		
		if(cc.getContainer().getInput().isKeyDown(Input.KEY_Q))
		{
			x-= 100 * delta / 1000f;
			animation = AnimationList.playerRunningLeft;
			turn = 0;
			updateBoxesPos();
			if((collideTile = CollisionManager.checkCollisionTile(left)) != null||x < 0)
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
	}

	private void gravity(int delta, CommunityGame cc) 
	{
		if(!isJumping)
		{
			y+= CommunityGame.world.GRAVITY_CONST*gravityTimer;
			updateBoxesPos();
			if((collideTile = CollisionManager.checkCollisionTile(down)) != null)
			{
				y-= CommunityGame.world.GRAVITY_CONST*gravityTimer;
				gravityTimer = 0;

			}
		}
		else 
		{
			y-= CommunityGame.world.GRAVITY_CONST*gravityTimer;
			updateBoxesPos();
			if((collideTile = CollisionManager.checkCollisionTile(up)) != null)
			{
				y+= CommunityGame.world.GRAVITY_CONST*gravityTimer;

			}
		}
		
		System.out.println(CommunityGame.world.GRAVITY_CONST*gravityTimer);
	}

	private void updateBoxesPos()
	{
		up.setBounds(x+1, y, w-2, 1);
		left.setBounds(x, y+1, 1, h-2);
		down.setBounds(x+1, y+h-1, w-2, 1);
		right.setBounds(x+w-1, y+1, 1, h-2);
	}

	public void setSelectedItem(Item i)
	{
		item = i;
	}
	
	public Item getSelectedItem()
	{
		return item;
	}
}