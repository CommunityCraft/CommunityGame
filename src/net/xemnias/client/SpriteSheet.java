package net.xemnias.client;

import org.newdawn.slick.Image;

public class SpriteSheet
{
	private int w, h;
	private Image Sheet;
	
	public SpriteSheet(int wP, int hP, Image s)
	{
		w = wP;
		h = hP;
		Sheet = s;
	}
	
	public Image getSpriteAt(int x, int y)
	{
		return Sheet.getSubImage(x*32, y*32, w, h);
	}
}
