package net.xemnias.client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.xemnias.lib.XMLMap;
import net.xemnias.lib.XMLMapLoader;

import org.jdom2.DataConversionException;
import org.jdom2.Element;
import org.newdawn.slick.SlickException;

public class Map
{
	public ArrayList<Tile> tiles = new ArrayList<Tile>();
	private String Name;
	private String pathToDirectory;
	private BackGround backGround;
	private XMLMap xmlMap;
	private XMLMapLoader mapLoader;
	private File mapFile;
	private List<?> mapDataBlock;
	private List<?> mapDataItem;
	private List<?> mapDataEntity;
	public float GRAVITY_CONST = 1.05f;
	
	public Map(String name, CommunityGame parent) throws SlickException
	{
		Name = name;
		pathToDirectory = "data/map/";
		mapFile = new File(pathToDirectory+Name);
		xmlMap = new XMLMap(mapFile);
		mapLoader = new XMLMapLoader(xmlMap);
	}
	
	public void buildMap() throws IOException
	{
		
		Iterator<?> i = mapDataBlock.iterator();
		while(i.hasNext())
		{
			Element block = (Element)i.next();
			int x = readX(block);
			int y = readY(block);
			int id = readID(block);
			if(id!=-1)
			tiles.add(new Tile(x, y, 32, 32, Block.dirt.getBlockById(id)));
		}
		
		Iterator<?> i2 = mapDataItem.iterator();
		while(i2.hasNext())
		{
			Element item = (Element)i2.next();
			int x = readX(item);
			int y = readY(item);
			int id = readID(item);
			
			tiles.add(new Tile(x, y, 32, 32, Item.ironHammer.getItemById(id)));
		}
		
		Iterator<?> i3 = mapDataEntity.iterator();
		while(i3.hasNext())
		{
			Element entity = (Element)i3.next();
			int x = readX(entity);
			int y = readY(entity);
			int id = readID(entity);
			tiles.add(new Tile(x, y, 32, 32, Entity.entityPlayer.getEntityById(id)));
		}
	}

	
	public void load() throws SlickException
	{
		mapLoader.parseMap();
		mapDataBlock = mapLoader.getElementListByChildren("block");
		mapDataItem = mapLoader.getElementListByChildren("item");
		mapDataEntity = mapLoader.getElementListByChildren("entity");
	}
	
	
	
	
	
	
	
	
	
	
	
	public void bindBackGround(BackGround bg)
	{
		backGround = bg;
	}

	public BackGround getBackGround() {
		return backGround;
	}

	private int readX(Element e)
	{
		try 
		{
			return e.getAttribute("x").getIntValue();
		} 
		catch (DataConversionException e1)
		{
			e1.printStackTrace();
		}
		return -1;
	}
	
	private int readY(Element e)
	{
		try 
		{
			return e.getAttribute("y").getIntValue();
		} 
		catch (DataConversionException e1)
		{
			e1.printStackTrace();
		}
		return -1;
	}
	
	private int readID(Element e)
	{
		return Integer.parseInt(e.getText());
	}
}
