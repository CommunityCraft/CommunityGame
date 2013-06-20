package net.xemnias.client;

public class ItemIronSword extends Item 
{
	public ItemIronSword(int i, int xCoor, int yCoor, String name)
	{
		super(i, xCoor, yCoor, name);
		isWeapon = true;
		damage = 40;
	}
}
