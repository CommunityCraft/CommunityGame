package net.xemnias.client;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class CommunityGame extends StateBasedGame
{
	private static int height, width;
	
	private Screen currentScreen;
	
	public RenderEngine render;
	
	Map map;
	public CommunityGame(String name, int i, int j) throws SlickException 
	{
		super(name);
		
		currentScreen = new Screen(this);
		currentScreen.currentstate = new ScreenTest(this);

		addState(currentScreen);
		
		width = i;
		height = j;
	}

	public void initStatesList(GameContainer arg0) throws SlickException 
	{
		this.getState(0).init(arg0, this);
		enterState(0);

	}
	
	public static void main(String[] args) throws SlickException
	{
		CommunityGame game = new CommunityGame("CommunityGame - alpha", 1080, 580);
		AppGameContainer app = new AppGameContainer(game);
		app.setDisplayMode(width, height, false);
		app.start();
		
	}

	/**
	 * Affiche une boite de dialogue 
	 * @param g
	 */
	public void showDialog(GuiDialog g)
	{
		currentScreen.dialog = g;
		currentScreen.isDialogOpen = true;
	}
	
	/**
	 * Affiche ou retire une boite de dialogue (selon si elle l'est déjà ou pas)
	 * 
	 * Le graphics du rendu
	 * @param g
	 */

	public void showOrHideDialog(GuiDialog g) 
	{
		if(currentScreen.isDialogOpen == false)
		{
			currentScreen.dialog = g;
			currentScreen.isDialogOpen = true;
			return;
		}
		
		else if(currentScreen.isDialogOpen == true)
		{
			if(currentScreen.dialog.equals(g))
			{
				currentScreen.isDialogOpen = false;
				currentScreen.dialog = null;
			}
		}
	}
	

	public static int getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		CommunityGame.height = height;
	}

	public static int getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		CommunityGame.width = width;
	}
	
}
