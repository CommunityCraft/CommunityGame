package net.xemnias.client;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

public class EntityPlayer extends Entity 
{
	
	private Rectangle up = new Rectangle(x+1, y, w-2, 1);
	private Rectangle left = new Rectangle(x, y+1, 1, h-2);
	private Rectangle down = new Rectangle(x+1, y+h-10, w-2, 1);
	private Rectangle right = new Rectangle(x+w-1, y+1, 1, h-2);
	
	public Tile collideTile = null;
	public Entity collideEntity = null;
	private boolean isJumping = false;
	private boolean canJump = true;
	private TimerMillis timer = null;
	
	private Item item;
	public float gravityTimer;
	private Attack attack;
	
	public EntityPlayer(int i, String name, boolean att)
	{
		super(i, name, att);
		w = 32;
		h = 62;
		
		init();
	}
		
	private void init() 
	{
		animation = AnimationList.playerStandingRight;
		attack = new Attack(200, 50, 30, AnimationList.attackRight);
		timer = new TimerMillis(300, new Action()
		{
			
			public void actionPerformed() 
			{
				isJumping = false;
			}
		});
	}

	public void update(CommunityGame cc, int delta)
	{
		updateAnimation();

		move(cc, delta);
		
		translateMap(delta);
		
		toBetterUp(cc, delta);

		jumpCheck(cc);

		attack(cc);
	}
	
	
	
	
	
	
	
	
	
	
	
	private void attack(CommunityGame cc) 
	{
		if(cc.MOUSE_BUTTON_0 && !attack.RUNNING && clickOnGame(cc))
		{
			attack.start(cc, turn);
			animation = attack.getAnimation();

		}
		if(attack.RUNNING && !attack.TOUCH)
		{
			if((collideEntity = CollisionManager.checkCollisionEntity(this)) != null)
			{
				collideEntity.life -= attack.calculDamage(this);
				collideEntity.haveDamage(true);
				attack.setTouchedEntity(collideEntity);
				attack.TOUCH = true;
			}
		}
	}

	private boolean clickOnGame(CommunityGame cc) 
	{
		
		return cc.MOUSE_X > 0 && cc.MOUSE_X < 832 && cc.MOUSE_Y>0 && cc.MOUSE_Y < 580-64;
	}

	private void jumpCheck(CommunityGame cc)
	{
		if(cc.getContainer().getInput().isKeyDown(Input.KEY_SPACE) && !isJumping && canJump)
		{
			isJumping = true;
			timer.start();
		}
	}
	
	private void toBetterUp(CommunityGame cc, int delta) 
	{
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
		
	}

	private void updateAnimation() 
	{
		if(turn == 0 && !attack.RUNNING)
		{
			animation = AnimationList.playerStandingLeft;
			attack.setAnimation(AnimationList.attackLeft);
		}
		else if(turn == 1 && !attack.RUNNING)
		{
			animation = AnimationList.playerStandingRight;
			attack.setAnimation(AnimationList.attackRight);
		}
	}

	private void translateMap(int delta) 
	{
		if(x > -1*ScreenGame.X_TRANSLATE_GRAPHICS+832-320)
			ScreenGame.X_TRANSLATE_GRAPHICS-= 100 * delta / 1000f;
		if(ScreenGame.X_TRANSLATE_GRAPHICS !=0)
		{

			if(x < -ScreenGame.X_TRANSLATE_GRAPHICS+32*10)
			{
				ScreenGame.X_TRANSLATE_GRAPHICS+= 100 * delta / 1000f;
			}
		}
	}

	private void move(CommunityGame cc, int delta) 
	{
		// ############################## MOVE ##############################
		gravityTimer += delta/1000f;
		
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
			if(!attack.RUNNING)
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
			if(!attack.RUNNING)
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
			//animation = AnimationList.fallingRight;
			updateBoxesPos();
			if((collideTile = CollisionManager.checkCollisionTile(down)) != null)
			{
				updateAnimation();
				y-= CommunityGame.world.GRAVITY_CONST*gravityTimer;
				gravityTimer = 0;
				canJump = true;
			}
		}
		else
		{
			gravityTimer = 0;
			canJump = false;
			y-= 32*4 * delta / 1000f;;
			updateBoxesPos();
			if((collideTile = CollisionManager.checkCollisionTile(up)) != null)
			{
				isJumping = false;
				
				
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

	public void setSelectedItem(Item i)
	{
		item = i;
	}
	
	public Item getSelectedItem()
	{
		return item;
	}

	
	public void addXp(int p)
	{
		xp += p;
	}
}