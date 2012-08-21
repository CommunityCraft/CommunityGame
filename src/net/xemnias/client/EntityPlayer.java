package net.xemnias.client;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

public class EntityPlayer extends Entity 
{

	public EntityPlayer(int i, String name, boolean att)
	{
		super(i, name, att);
		org.newdawn.slick.SpriteSheet sheet = new SpriteSheet(CommunityGame.loader.getImageByName("playerAnimation.png"), 32, 64);
		animation = new Animation(sheet, 200);
	}


}
