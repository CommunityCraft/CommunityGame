package net.xemnias.client;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Gui 
{
	public void drawTexturalQuad(Graphics g, Image texture, int x, int y, int w, int h, float drawx, float drawy)
	{
		texture.getSubImage(x, y, w, h).draw(drawx, drawy);
	}
	
	public void drawTexturalQuad(Graphics g, Image texture, int x, int y, int w, int h, float drawx, float drawy, float drawwidth, float drawheight)
	{
		texture.getSubImage(x, y, w, h).draw(drawx, drawy, drawwidth, drawheight);
	}
}
