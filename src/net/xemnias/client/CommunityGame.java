package net.xemnias.client;

import java.io.IOException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class CommunityGame extends StateBasedGame
{
	private static int height, width;
	private Screen currentScreen;
	public RenderEngine render;
	public Map world;
	public RessourceLoader loader;
	
	public CommunityGame(String name, int i, int j) throws SlickException 
	{
		super(name);
		width = i;
		height = j;
	}


	private void initGame(GameContainer arg0) throws SlickException, IOException
	{
		currentScreen = new Screen(this);
		currentScreen.currentstate = new ScreenTest(this);
		
		world = new Map("test.map", this);
		loader = new RessourceLoader();
		loader.bindImageDirectoryToList("data/tiles/");
		world.load();
		world.buildMap();
		render = new RenderEngine(this);
	}
	
	
	public void initStatesList(GameContainer arg0) throws SlickException 
	{
		try {
			initGame(arg0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addState(currentScreen);
		getState(0).init(arg0, this);
		enterState(0);
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

	public void closeOpenDialog()
	{
		currentScreen.isDialogOpen = false;
	}
	

	public static void main(String[] args) throws SlickException
	{
		CommunityGame game = new CommunityGame("CommunityGame - alpha", 1080, 580);
		AppGameContainer app = new AppGameContainer(game);
		app.setDisplayMode(width, height, false);
		app.start();
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
