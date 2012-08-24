package net.xemnias.client;

import java.io.IOException;
import java.util.ArrayList;

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
	public GDE gde = new GDE();
	public static RessourceLoader loader;
	
	public static ArrayList<Item> itemList;
	public static ArrayList<Block> blockList;
	public static ArrayList<Entity> entities;
	
	public CommunityGame(String name, int i, int j) throws SlickException
	{
		super(name);
		width = i;
		height = j;
		itemList = new ArrayList<Item>();
		blockList = new ArrayList<Block>();
		entities = new ArrayList<Entity>();
	}


	private void initGame(GameContainer arg0) throws SlickException, IOException
	{
		loader = new RessourceLoader();
		loader.bindImageDirectoryToList("data/tiles/");
		
		AnimationList.init();
		
		currentScreen = new Screen(this);
		currentScreen.currentGuiState = new ScreenMainMenu(this);
		
		world = new Map("test.map", this);
		world.load();
		world.buildMap();
		
		world.bindBackGround(new BackGround(loader.getBackgroundByName("test.png")));
		
		render = new RenderEngine(this);
	}
	
	
	public void initStatesList(GameContainer arg0) throws SlickException 
	{
		try {
			initGame(arg0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addState(currentScreen);
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
		CommunityGame game = new CommunityGame("CommunityGame - alpha", 840, 580);
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


	public void switchGuiTo(Screen screenGame) 
	{
		currentScreen.isGui = false;
		currentScreen.currentGuiState = null;
		currentScreen.currentstate = screenGame;
		
		currentScreen.currentstate.preLoad(getContainer(), this);
	}

}
