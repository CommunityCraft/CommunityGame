package net.xemnias.client;

import org.newdawn.slick.Image;

public class AnimationList 
{
	public static Animation playerStandingRight;
	public static Animation playerStandingLeft;
	public static Animation playerRunningRight;
	public static Animation playerRunningLeft;
	public static Animation playerJumpingLeft;
	public static Animation playerJumpingRight;
	public static Animation attackRight;
	public static Animation attackLeft;
	public static Animation fallingRight;
	public static Animation fallingLeft;

	public static Animation corruptedSoulStantingRight;
	
	public static void init()
	{
		playerStandingRight = new Animation(new org.newdawn.slick.SpriteSheet(CommunityGame.loader.getAnimationByName("playerStandingRight.png"), 32,64), 150);
		playerStandingLeft = new Animation(new org.newdawn.slick.SpriteSheet(CommunityGame.loader.getAnimationByName("playerStandingLeft.png"), 32,64), 150);
		playerRunningRight = new Animation(playerRunningRightSprite(), 100);
		playerRunningLeft = new Animation(playerRunningLeftSprite(), 100);
		playerJumpingRight = new Animation(playerJumpingRightSprite(), 70);
		playerJumpingLeft = new Animation(playerJumpingLeftSprite(), 70);
		attackRight = new Animation(playerAttackRight(), 100);
		attackLeft = new Animation(playerAttackLeft(), 100);
		fallingRight = new Animation(new Image[]{CommunityGame.loader.getAnimationByName("falling.png")}, 100);
		fallingLeft = new Animation(new Image[]{fallingRight.getCurrentFrame()}, 100);
		
		corruptedSoulStantingRight = new Animation(corruptedSoulStandingRight(), 200);
	}
	
	private static Image[] corruptedSoulStandingRight() 
	{
		Image[] img = new Image[4];
		
		img[0] = CommunityGame.loader.getAnimationByName("corruptedSoulStandingRight.png").getSubImage(0, 0, 41, 32);
		img[1] = CommunityGame.loader.getAnimationByName("corruptedSoulStandingRight.png").getSubImage(41, 0, 41, 32);
		img[2] = CommunityGame.loader.getAnimationByName("corruptedSoulStandingRight.png").getSubImage(82, 0, 43, 32);
		img[3] = CommunityGame.loader.getAnimationByName("corruptedSoulStandingRight.png").getSubImage(125, 0, 40, 32);
		
		return img;
	}

	private static Image[] playerJumpingRightSprite()
	{
		Image[] img = new Image[17];
		
		img[0] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(0, 0, 25, 64);
		img[1] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(25, 0, 39, 64);
		img[2] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(64, 0, 32, 64);
		img[3] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(96, 0, 31, 64);
		img[4] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(127, 0, 31, 64);
		img[5] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(158, 0, 39, 64);
		img[6] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(197, 0, 40, 64);
		img[7] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(237, 0, 39, 64);
		img[8] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(276, 0, 39, 64);
		img[9] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(315, 0, 39, 64);
		img[10] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(354, 0, 35, 64);
		img[11] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(389, 0, 37, 64);
		img[12] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(426, 0, 32, 64);
		img[13] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(458, 0, 35, 64);
		img[14] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(493, 0, 29, 64);
		img[15] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(522, 0, 34, 64);
		img[16] = CommunityGame.loader.getAnimationByName("playerJumpingRight.png").getSubImage(556, 0, 29, 64);
		
		return img;
	}
	
	private static Image[] playerJumpingLeftSprite()
	{
		Image[] img = new Image[17];
		for(int i = 0; i < playerJumpingRight.getFrameCount(); i++)
		{
			img[i] = playerJumpingRight.getImage(i).getFlippedCopy(true, false);
		}
		return img;
	}
	
	private static Image[] playerRunningRightSprite()
	{
		Image[] img = new Image[8];
		
		img[0] = CommunityGame.loader.getAnimationByName("playerRunningRight.png").getSubImage(0, 0, 32, 64);
		img[1] = CommunityGame.loader.getAnimationByName("playerRunningRight.png").getSubImage(32, 0, 32, 64);
		img[2] = CommunityGame.loader.getAnimationByName("playerRunningRight.png").getSubImage(64, 0, 46, 64);
		img[3] = CommunityGame.loader.getAnimationByName("playerRunningRight.png").getSubImage(110, 0, 40, 64);
		img[4] = CommunityGame.loader.getAnimationByName("playerRunningRight.png").getSubImage(150, 0, 32, 64);
		img[5] = CommunityGame.loader.getAnimationByName("playerRunningRight.png").getSubImage(182, 0, 32, 64);
		img[6] = CommunityGame.loader.getAnimationByName("playerRunningRight.png").getSubImage(214, 0, 38, 64);
		img[7] = CommunityGame.loader.getAnimationByName("playerRunningRight.png").getSubImage(252, 0, 44, 64);
		
		return img;
	}
	
	private static Image[] playerRunningLeftSprite()
	{
		Image[] img = new Image[8];
		for(int i = 0; i < playerRunningRight.getFrameCount(); i++)
		{
			img[i] = playerRunningRight.getImage(i).getFlippedCopy(true, false);
		}
		return img;
	}
	
	private static Image[] playerAttackRight()
	{
		Image[] img = new Image[2];
		
		img[0] = CommunityGame.loader.getAnimationByName("attack.png").getSubImage(0, 0, 42, 66);
		img[1] = CommunityGame.loader.getAnimationByName("attack.png").getSubImage(42, 0, 71, 66);
		
		return img;
	}
	
	private static Image[] playerAttackLeft()
	{
		Image[] img = new Image[2];
		for(int i = 0; i < attackRight.getFrameCount(); i++)
		{
			img[i] = attackRight.getImage(i).getFlippedCopy(true, false);
		}
		return img;
	}
}
