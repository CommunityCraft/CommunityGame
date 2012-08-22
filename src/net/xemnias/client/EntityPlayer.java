package net.xemnias.client;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

public class EntityPlayer extends Entity 
{

	public EntityPlayer(int i, String name, boolean att)
	{
		super(i, name, att);
		org.newdawn.slick.SpriteSheet sheet = new SpriteSheet(CommunityGame.loader.getImageByName("playerAnimation.png"), 32, 64);
		/*
		Image[] img = new Image[8];
		
		img[0] = CommunityGame.loader.getImageByName("playerAnimationRun.png").getSubImage(0, 0, 32, 64);
		img[1] = CommunityGame.loader.getImageByName("playerAnimationRun.png").getSubImage(32, 0, 32, 64);
		img[2] = CommunityGame.loader.getImageByName("playerAnimationRun.png").getSubImage(64, 0, 46, 64);
		img[3] = CommunityGame.loader.getImageByName("playerAnimationRun.png").getSubImage(110, 0, 40, 64);
		img[4] = CommunityGame.loader.getImageByName("playerAnimationRun.png").getSubImage(150, 0, 32, 64);
		img[5] = CommunityGame.loader.getImageByName("playerAnimationRun.png").getSubImage(182, 0, 32, 64);
		img[6] = CommunityGame.loader.getImageByName("playerAnimationRun.png").getSubImage(214, 0, 38, 64);
		img[7] = CommunityGame.loader.getImageByName("playerAnimationRun.png").getSubImage(252, 0, 44, 64);
		*/
		animation = new Animation(sheet, 120);
	}


}
