package net.xemnias.client;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GuiDialogTest extends GuiDialog
{

	public GuiDialogTest()
	{
		control.add(new GuiButton(0, 50, 50));
	}
	
	public void render(GameContainer gc, CommunityGame sbg, Graphics g)
	{
		g.setColor(Color.white);
		g.drawRect(5, 5, 50, 50);
	}

	public void update(GameContainer gc, CommunityGame sbg, int delta)
	{
		

	}

	public void init(GameContainer gc, CommunityGame sbg)
	{
		
	}

	protected void actionPerformed(int id, CommunityGame cc) 
	{
		if(id == 0)
		{
			System.out.println("ok");
		}
	}
	
	

}
