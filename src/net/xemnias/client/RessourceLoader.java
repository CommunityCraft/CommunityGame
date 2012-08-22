package net.xemnias.client;

import java.io.File;
import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class RessourceLoader
{
	private ArrayList<Image> imageList = new ArrayList<Image>();
	public RessourceLoader() throws SlickException
	{
		
	}
	
	public void bindImageDirectoryToList(String str) throws SlickException
	{
		File path = new File(str);
		
		if (path.isDirectory()) 
		{
			File[] flist = path.listFiles();
            
            if (flist != null)
            {
                for ( int i = 0; i < flist.length; i++) 
                {
                	imageList.add(i, new Image(flist[i].getPath()));
                	imageList.get(i).setName(flist[i].getName());
                } 
            }
            else 
            {
            	System.err.println(path + " : Erreur de lecture.");
            }
		}
	}
	
	public Image getImageByName(String str)
	{
		for(int i = 0; i < imageList.size(); i++)
		{
			if(imageList.get(i).getName().equalsIgnoreCase(str))
				return imageList.get(i);
		}
		return null;
	}
	
	public Image getSpriteWithSheet(String sheetName, int id, int id2)
	{
		for(int i = 0; i < imageList.size(); i++)
		{
			if(imageList.get(i).getName().equalsIgnoreCase(sheetName))
				return imageList.get(i).getSubImage(id*32, id2*32, 32, 32);
		}
		return null;
	}

	public Image getTextureById(int i) 
	{
		SpriteSheet terrainSheet = new SpriteSheet(32, 32, getImageByName("spritesheet.png"));
		if(i == 0)
			return terrainSheet.getSpriteAt(0, 0);
		if(i == 1)
			return terrainSheet.getSpriteAt(1, 0);
		if(i == 2)
			return terrainSheet.getSpriteAt(2, 0);
		if(i == 3)
			return terrainSheet.getSpriteAt(3, 0);
		if(i == 4)
			return terrainSheet.getSpriteAt(4, 0);
		if(i == 5)
			return terrainSheet.getSpriteAt(5, 0);
		if(i == 6)
			return terrainSheet.getSpriteAt(6, 0);
		if(i == 7)
			return terrainSheet.getSpriteAt(7, 0);
		if(i == 8)
			return terrainSheet.getSpriteAt(0, 1);
		if(i == 9)
			return terrainSheet.getSpriteAt(1, 1);
		if(i == 10)
			return terrainSheet.getSpriteAt(2, 1);
		if(i == 11)
			return terrainSheet.getSpriteAt(3, 1);
		if(i == 12)
			return terrainSheet.getSpriteAt(4, 1);
		if(i == 13)
			return terrainSheet.getSpriteAt(5, 1);
		if(i == 14)
			return terrainSheet.getSpriteAt(6, 1);
		if(i == 15)
			return terrainSheet.getSpriteAt(7, 2);
		if(i == 16)
			return terrainSheet.getSpriteAt(0, 2);
		if(i == 17)
			return terrainSheet.getSpriteAt(1, 2);
		if(i == 18)
			return terrainSheet.getSpriteAt(2, 2);
		if(i == 19)
			return terrainSheet.getSpriteAt(3, 2);
		if(i == 20)
			return terrainSheet.getSpriteAt(4, 2);
		if(i == 21)
			return terrainSheet.getSpriteAt(5, 2);
		if(i == 22)
			return terrainSheet.getSpriteAt(6, 3);
		if(i == 23)
			return terrainSheet.getSpriteAt(7, 3);
		if(i == 24)
			return terrainSheet.getSpriteAt(0, 3);
		if(i == 25)
			return terrainSheet.getSpriteAt(1, 3);
		if(i == 26)
			return terrainSheet.getSpriteAt(2, 3);
		if(i == 27)
			return terrainSheet.getSpriteAt(3, 3);
		if(i == 28)
			return terrainSheet.getSpriteAt(4, 3);
		if(i == 29)
			return terrainSheet.getSpriteAt(5, 4);
		if(i == 30)
			return terrainSheet.getSpriteAt(6, 4);
		if(i == 31)
			return terrainSheet.getSpriteAt(7, 4);
		if(i == 32)
			return terrainSheet.getSpriteAt(0, 4);
		if(i == 33)
			return terrainSheet.getSpriteAt(1, 4);
		if(i == 34)
			return terrainSheet.getSpriteAt(2, 4);
		if(i == 35)
			return terrainSheet.getSpriteAt(3, 4);
		if(i == 36)
			return terrainSheet.getSpriteAt(4, 5);
		if(i == 37)
			return terrainSheet.getSpriteAt(5,5);
		if(i == 38)
			return terrainSheet.getSpriteAt(6, 5);
		if(i == 39)
			return terrainSheet.getSpriteAt(7, 5);
		if(i == 40)
			return terrainSheet.getSpriteAt(0, 05);
		if(i == 41)
			return terrainSheet.getSpriteAt(1, 05);
		if(i == 42)
			return terrainSheet.getSpriteAt(2, 5);
		if(i == 43)
			return terrainSheet.getSpriteAt(3, 6);
		if(i == 44)
			return terrainSheet.getSpriteAt(4, 6);
		if(i == 45)
			return terrainSheet.getSpriteAt(5, 6);
		if(i == 46)
			return terrainSheet.getSpriteAt(6, 6);
		if(i == 47)
			return terrainSheet.getSpriteAt(7, 6);
		if(i == 48)
			return terrainSheet.getSpriteAt(0, 7);
		if(i == 49)
			return terrainSheet.getSpriteAt(1, 7);
		if(i == 50)
			return terrainSheet.getSpriteAt(2, 7);
		if(i == 51)
			return terrainSheet.getSpriteAt(3, 7);
		if(i == 52)
			return terrainSheet.getSpriteAt(4, 7);
		if(i == 53)
			return terrainSheet.getSpriteAt(5, 7);
		if(i == 54)
			return terrainSheet.getSpriteAt(6, 7);
		if(i == 55)
			return terrainSheet.getSpriteAt(7, 7);
		return null;
	}

	public Image getAnimationByName(String string)
	{
		try {
			return new Image("data/entity/animation/"+string);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		return null;
	}
}
