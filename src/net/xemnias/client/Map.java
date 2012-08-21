package net.xemnias.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import org.newdawn.slick.SlickException;

public class Map
{
	public ArrayList<Tile> tiles = new ArrayList<Tile>();
	private String Name;
	private String pathToDirectory;
	
	private FileReader reader;
	
	private int[][] map;
	private StringBuilder str;
	
	public Map(String name, CommunityGame parent) throws SlickException
	{
		Name = name;
		pathToDirectory = "data/map/";
		map = new int[19][34];
		str = new StringBuilder();
	}
	
	public void buildMap() throws IOException
	{
		String strMap = str.toString();
		StringReader Sreader = new StringReader(strMap);
		
		for(int i = 0; i < 19; i++)
        {
      		 for(int o = 0; o < 34; o++)
      		 {
      			 map[i][o] = (char)Sreader.read();
      			 char tile = (char) map[i][o];
      			 
      			 if(tile == '0')
      			 {
      				 tiles.add(i, new Tile(o*32, i*32, 32, 32, Block.grass.getBlockById(2)));
      			 }
      			 
      			 if(tile == '1')
      			 {
      				 tiles.add(i, new Tile(o*32, i*32, 32, 32, Block.dirt.getBlockById(5)));
      			 }
      			 if(tile == '4')
      			 {
      				tiles.add(i, new Tile(o*32, i*32, 32, 32, Block.rightGrass.getBlockById(3)));
      			 }
      		 }
        }
	}
	
	public void load() throws SlickException
	{
		File fmap = new File(pathToDirectory+Name);
		try 
		{
			reader = new FileReader(fmap);
			
	         for(int i = 0; i < 19; i++)
	         {
	        	 for(int o = 0; o < 34; o++)
	        	 {
	        		map[i][o] = reader.read();
	 	    		str.append((char)map[i][o]);
	        	 }
	         }
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
