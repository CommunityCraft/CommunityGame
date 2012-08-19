package net.xemnias.client;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Item 
{
	private int coordinateX;
	private int coordinateY;
	private Image skin;
	public String Name;
	public int id;
	private ArrayList<Item> items = new ArrayList<Item>();
	SpriteSheet itemSheet;
	
	
	public Item(int i, int xCoor, int yCoor, String name)
	{
		itemSheet = new SpriteSheet(32, 32, CommunityGame.loader.getImageByName("item2.png"));
		setCoordinateX(xCoor);
		setCoordinateY(yCoor);
		id = i;
		Name = name;
		skin = itemSheet.getSpriteAt(xCoor, yCoor);

		
		
		for(int z = 0; z < items.size(); z++)
		{
			if(i == items.get(z).id)
			{
				System.err.println("ID item similaire : "+i);
				System.exit(0);
			}
		}
		items.add(this);
	}
	
	public static final ItemIronSword ironSword = new ItemIronSword(0, 0, 0, "Épée en fer");
	public static final ItemIronHammer ironHammer = new ItemIronHammer(1, 1, 0, "Marteau en fer");
	public static final ItemLittleKey key = new ItemLittleKey(2, 2, 0, "Petite clé");
	
	
	
	
	public void drawAsIcon(float x, float y, Graphics g)
	{
		g.drawImage(skin, x, y);
	}
	
	public void setCoor(int x, int y)
	{
		skin = itemSheet.getSpriteAt(x, y);
	}

	public int getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}

	public int getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}

	public Image getSkin() {
		return skin;
	}

	public void setSkin(Image skin) {
		this.skin = skin;
	}
	
	public void getInitializeMessage()
	{
		System.out.println("Item ok");
	}
}
