package net.xemnias.client;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ScreenInitGame extends ScreenGui 
{
	private Image xemProd;
	public boolean finish = false;
	public ScreenInitGame(CommunityGame cc)
	{
		super(cc);
	}

	public void preLoad(GameContainer gc, CommunityGame cc) 
	{
		try {
			xemProd = new Image("data/image/xemProd.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void update(GameContainer gc, int delta, CommunityGame cc) 
	{
		if(finish)
			parent.switchGuiToOtherGui(new ScreenMainMenu(parent));
	}

	private float a = 1.0f;
	private int loop= 0;
	
	private int side = 0;
	
	public void render(final GameContainer gc, final Graphics g, CommunityGame cc) 
	{
		g.drawImage(xemProd, 0, 0);
		
		if(side == 0)
		{
			if(loop == 30)
			{
				a-= 0.035f;
				loop = 0;
				if((float) a < -0.5f)
					side = 1;
			}
		}
		else if(side == 1)
		{
			if(loop == 30)
			{
				a+= 0.035f;
				loop = 0;
			}
			if(a > 1.2f)
			{
				finish = true;
			}
		}
		gui.fillRectWithAlpha(0, 0, 840, 580, Color.black, a, g);
		loop++;
	}
}
