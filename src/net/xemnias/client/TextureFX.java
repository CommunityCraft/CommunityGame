package net.xemnias.client;

import org.newdawn.slick.Image;

public class TextureFX 
{
	private Animation anim;
	
	public TextureFX(int x, int y, int w, int h, int fxSpeed, int fxCount, String fileName) 
	{
		Image fx = CommunityGame.loader.getImageByName(fileName).getSubImage(x, y, w*fxCount, h);
		anim = new Animation(new org.newdawn.slick.SpriteSheet(fx, w,h), fxSpeed);
	}
	
	public Animation getFXRender()
	{
		return anim;
	}
}
