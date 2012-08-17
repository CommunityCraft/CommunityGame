package net.xemnias.client;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Item 
{
	private int coordinateX;
	private int coordinateY;
	private Image skin;
	public String Name;
	public int id;
	private CommunityGame cc;
	
	public Item(int i, int xCoor, int yCoor, String name, CommunityGame parent)
	{
		setCoordinateX(xCoor);
		setCoordinateY(yCoor);
		id = i;
		Name = name;
		cc = parent;
		skin = parent.loader.getImageByName("item.png").getSubImage(xCoor, yCoor, 32, 32);
	}
	
	public void drawAsIcon(float x, float y, Graphics g)
	{
		g.drawImage(skin, x, y);
	}
	
	public void setCoor(int x, int y)
	{
		skin = cc.loader.getImageByName("item.png").getSubImage(x, y, 32, 32);
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
}
