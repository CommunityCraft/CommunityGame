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
	private ArrayList<Object> ids = new ArrayList<Object>();
	
	public Item(int i, int xCoor, int yCoor, String name)
	{
		setCoordinateX(xCoor);
		setCoordinateY(yCoor);
		id = i;
		Name = name;
		skin = CommunityGame.loader.getImageByName("item.png").getSubImage(xCoor, yCoor, 32, 32);

		
		if(ids.contains(id))
		{
			System.err.println("ID déjà utilisé : "+id);
			System.exit(0);
		}
		else
		{
			ids.add(id);
		}
	}
	
	
	public static final ItemIronSword ironSword = new ItemIronSword(0, 0, 0, "Épée en fer");
	public static final ItemRedSword redSword = new ItemRedSword(1, 32, 0, "Épée rouge");
	
	
	
	
	
	
	
	
	public void drawAsIcon(float x, float y, Graphics g)
	{
		g.drawImage(skin, x, y);
	}
	
	public void setCoor(int x, int y)
	{
		skin = CommunityGame.loader.getImageByName("item.png").getSubImage(x, y, 32, 32);
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
}
