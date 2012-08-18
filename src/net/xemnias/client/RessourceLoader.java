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
}
