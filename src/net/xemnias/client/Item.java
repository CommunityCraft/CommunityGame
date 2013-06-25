package net.xemnias.client;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Item extends GameObject
{
	private int coordinateX;
	private int coordinateY;
	private Image skin;
	public String Name;
	public String sufix = "";
	public String prefix = "";
	protected String colorHexa = "";
	public int id;
	public SpriteSheet itemSheet;
	private ItemSlot parentSlot;
	
	public boolean isMagic = false;
	
	public EnchantementType magicType;
	
	public boolean isWeapon = false;
	public boolean isArmor = false;
	public boolean isOther = false;
	public int damage;
	public int armor;
	public int  magicPower;
	
	
	
	public Item(int i, int xCoor, int yCoor, String name)
	{
		itemSheet = new SpriteSheet(32, 32, CommunityGame.loader.getImageByName("item2.png"));
		setCoordinateX(xCoor);
		setCoordinateY(yCoor);
		id = i;
		Name = name;
		skin = itemSheet.getSpriteAt(xCoor, yCoor);
		
		
		for(int z = 0; z < CommunityGame.itemList.size(); z++)
		{
			if(i == CommunityGame.itemList.get(z).id)
			{
				System.err.println("ID item similaire : "+i);
				System.exit(0);
			}
		}
		CommunityGame.itemList.add(this);
	}
	
	public static final ItemIronSword ironSword = new ItemIronSword(0, 0, 0, "Épée");
	public static final ItemIronHammer ironHammer = new ItemIronHammer(1, 1, 0, "Marteau");
	public static final ItemLittleKey key = new ItemLittleKey(2, 2, 0, "clé");
	

	public Item getItemById(int id)
	{
		for(int i = 0; i < CommunityGame.itemList.size(); i++)
		{
			if(CommunityGame.itemList.get(i).id == id)
				return CommunityGame.itemList.get(i);
		}
		return null;
	}
	
	public void renderItem(Item item)
	{
		item.skin.draw(xPos, yPos);
	}
	
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

	public ItemSlot getParentSlot() {
		return parentSlot;
	}

	public void setParentSlot(ItemSlot parentSlot) 
	{
		this.parentSlot = parentSlot;
	}
	
	public String getCompleteName()
	{
		if(!prefix.isEmpty())
			Name.toLowerCase();
		return prefix + Name + sufix;
	}

	public String getCompleteNameWithColor() 
	{
		return colorHexa+getCompleteName();
	}
}
