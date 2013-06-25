package net.xemnias.client;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public abstract class GuiContainer extends GuiDialog 
{
	protected ArrayList<ItemSlot> slots = new ArrayList<ItemSlot>();
	protected boolean haveItemOnMouse = false;
	protected Item itemOnMouse = null;
	
	public ItemSlot whatCaseClick(GameContainer gc)
	{
		for(int i = 0; i < slots.size(); i++)
		{
			ItemSlot slot = slots.get(i);
			int mouseX = gc.getInput().getMouseX();
			int mouseY = gc.getInput().getMouseY();
			
			if(mouseX > slot.getX() && mouseX < slot.getX() + slot.getWidth() && mouseY > slot.getY() && mouseY < slot.getY() + slot.getHeight())
				return slot;
		}
		return null;
	}
	
	public ItemSlot isMouseOnSlot(GameContainer gc)
	{
		for(int i = 0; i < slots.size(); i++)
		{
			ItemSlot slot = slots.get(i);
			int mouseX = gc.getInput().getMouseX();
			int mouseY = gc.getInput().getMouseY();
			
			if(mouseX > slot.getX() && mouseX < slot.getX() + slot.getWidth() && mouseY > slot.getY() && mouseY < slot.getY() + slot.getHeight())
				return slot;
		}
		return null;
	}
	
	public void clickOnCase(ItemSlot slot)
	{
		if( slot != null)
		{
			if(slot.getItem() != null && !haveItemOnMouse)
			{
				haveItemOnMouse = true;
				itemOnMouse = slot.getItem();
				itemOnMouse.setParentSlot(slot);
				slot.setItemOnMouse(true);
				
			}
			else if(slot.getItem() == null && haveItemOnMouse)
			{
				haveItemOnMouse = false;
				for(int i = 0; i < slots.size(); i++)
				{
					if(slots.get(i).isItemOnMouse())
					{
						slots.get(i).setItemOnMouse(false);
						slots.get(i).setItem(null);
					}
				}
				slot.setItem(itemOnMouse);			
			}
		}
	}
	
	public void drawItemName(GameContainer gc, Graphics g, Item item, CommunityGame sbg)
	{
		String[] infos = new String[4];
		String damage = "Dégats : "+item.damage;
		String protection = "Armure : "+ item.armor;
		String magicType = "Type de magie : "+item.magicType;
		String magicPower = "Puissance magique : "+item.magicPower;
		String name = item.getCompleteName();
		
		if(item.isWeapon)
			infos[0] = damage;
		else if(item.isArmor)
			infos[0] = protection;
		else
			infos[0] = "Objet d'inventaire";
		if(item.isMagic)
		{
			infos[1] = magicType;
			infos[2] = magicPower;
		}
		else
		{
			infos[1] = "";
			infos[2] = "";
		}
		infos[3] = name;
		
		int widthOfBox = 0;
		int heightOfBox = 0;
		
		for(int i = 0; i < infos.length; i++)
		{
			if(g.getFont().getWidth(infos[i]) > widthOfBox)
				widthOfBox = g.getFont().getWidth(infos[i]);
			heightOfBox += g.getFont().getHeight(infos[i]);
		}
		
		g.setColor(new Color(0,0,0,0.85f));
		g.fillRect(sbg.MOUSE_X+2, sbg.MOUSE_Y - heightOfBox -2, widthOfBox+6, heightOfBox+6);
		
		

		g.setColor(Color.white);
		if(item.isMagic)
			g.setColor(Color.decode("#FFA100"));
		g.drawString(item.getCompleteName(), sbg.MOUSE_X+ 5, sbg.MOUSE_Y- heightOfBox);
		

		g.setColor(Color.decode("#E5E5E5"));
		for(int i = 0; i < 3; i++)
		{
			g.drawString(infos[i], sbg.MOUSE_X+ 5, sbg.MOUSE_Y- heightOfBox + 13*i+18);
		}
	}


	public void close() 
	{
		if(haveItemOnMouse)
		{
			itemOnMouse.getParentSlot().setItem(itemOnMouse);
			itemOnMouse.getParentSlot().setItemOnMouse(false);
			itemOnMouse = null;
			haveItemOnMouse = false;
		}
	}
}
