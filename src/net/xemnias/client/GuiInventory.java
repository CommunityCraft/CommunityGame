package net.xemnias.client;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GuiInventory extends GuiContainer
{
	private int selectedCase;
	private ArrayList<ItemSlot> equipeSlots = new ArrayList<ItemSlot>();
	public Item equipedItem;
	
	public GuiInventory(CommunityGame cc)
	{
		for(int x = 0; x < 7; x++)
		{
			for(int y = 0; y < 3; y++)
			{
				slots.add(new ItemSlot((270) + x*32, (270) +  y*32));
			}
		}
		
		int z = 0;
		
		for(int i = 21; i <28; i++)
		{
			slots.add(i, new ItemSlot((270) + z*32, 398));
			slots.get(i).equipedSlot = true;
			z++;
		}
		z=0;
		for(int i = 0; i < slots.size(); i++)
		{
			if(slots.get(i).equipedSlot)
			{
				equipeSlots.add(z, slots.get(i));
				z++;
			}
		}
		
		slots.get(5).setItem(Item.ironSword);
		slots.get(6).setItem(Item.ironHammer);
		slots.get(7).setItem(Item.key);
	}
	
	public void init(GameContainer gc, CommunityGame sbg)
	{

	}

	public void update(GameContainer gc, CommunityGame sbg, int delta)
	{
		
		if(sbg.MOUSE_BUTTON_0)
		{
			ItemSlot s = whatCaseClick(gc);
			clickOnCase(s);
			
			equipedItem = equipeSlots.get(selectedCase).getItem();

			sbg.getPlayer().setSelectedItem(equipedItem);
			if(equipedItem != null)
			{
				sbg.screenGame.playerBar.nameDrawed=false;
			}
		}
		
	}
	
	public void scrollSelectionBarDown(CommunityGame sbg)
	{
			selectedCase--;
			if(selectedCase < 0)
				selectedCase = 6;
			
			equipedItem = equipeSlots.get(selectedCase).getItem();
			if(equipedItem != null)
			{
				System.out.println("Équipé de : " + equipedItem.getCompleteName());
			}
			sbg.getPlayer().setSelectedItem(equipedItem);
	}
	
	public void scrollSelectionBarUp(CommunityGame sbg)
	{
			selectedCase++;
			if(selectedCase > 6)
				selectedCase = 0;
			
			equipedItem = equipeSlots.get(selectedCase).getItem();
			if(equipedItem != null)
			{
				System.out.println("Équipé de : " + equipedItem.getCompleteName());
			}
			sbg.getPlayer().setSelectedItem(equipedItem);
	}

	public void render(GameContainer gc, CommunityGame sbg, Graphics g) 
	{

		fillRectWithColor(g, 250, 240, 270, 150, Color.gray);
		drawRectWithColor(g, 250, 240, 270, 150, Color.black);
		fillRectWithColor(g, 330, 100, 100, 150, Color.gray);
		drawRectWithColor(g, 330, 100, 100, 140, Color.black);
		drawRectWithColor(g, 340, 110, 80, 120, Color.black);
		fillRectWithColor(g, 345, 115, 70, 110, Color.darkGray);
		

		
		
		for(int i = 0; i < slots.size(); i++)
		{
			if(!slots.get(i).isItemOnMouse())
				slots.get(i).render(gc, sbg, g);
		}
		for(int i = 0; i < slots.size(); i++)
		{
			if(slots.get(i).isItemOnMouse())
				slots.get(i).render(gc, sbg, g);
		}
		
		g.drawImage(CommunityGame.loader.getImageByName("gui.png").getSubImage(400, 0, 35, 35),(270) + selectedCase*32 -1, 397);
		
		if(isMouseOnSlot(gc) != null)
			if(isMouseOnSlot(gc).getItem() != null)
				drawItemName(gc, g, isMouseOnSlot(gc).getItem(), sbg);
	}
}
