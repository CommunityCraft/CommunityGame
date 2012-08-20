package net.xemnias.client;

import org.newdawn.slick.Color;
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
	
	public void drawRectWithColor(Graphics g, float x, float y, int w, int h, Color black)
	{
		g.setColor(black);
		g.drawRect(x, y, w, h);
	}
	
	public void fillRectWithColor(Graphics g, float f, float g2, int w, int h, Color display)
	{
		g.setColor(display);
		g.fillRect(f, g2, w, h);
	}
	
	public void drawCenteredString(String displayString2, float x, float y, Graphics g)
	{
		g.drawString(displayString2, x- g.getFont().getWidth(displayString2)/2, y-g.getFont().getHeight(displayString2)/2);
	}
}
