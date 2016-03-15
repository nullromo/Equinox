package screen;
import game.*;
import java.util.*;
import uicomponent.Button;

public class LevelScreen extends MenuScreen
{
	ArrayList<Level> levels = new ArrayList<Level>();
	
	public LevelScreen()
	{
		levels.add(new Level(10,2,2,2,3,2,2));		//1
		levels.add(new Level(10,25,0,0,3,2,2));
		levels.add(new Level(10,20,10,10,3,2,2));
		levels.add(new Level(10,30,10,10,3,2,2));
		levels.add(new Level(10,30,10,10,3,2,2));		//5
		levels.add(new Level(10,30,10,10,3,2,2));
		levels.add(new Level(10,30,10,10,3,2,2));
		levels.add(new Level(10,40,11,10,3,2,2));
		levels.add(new Level(10,40,11,10,3,2,2));
		levels.add(new Level(10,40,12,10,3,2,2));		//10
		levels.add(new Level(10,40,13,10,3,2,2));
		levels.add(new Level(10,40,40,10,3,2,2));
		levels.add(new Level(10,40,40,10,3,2,2));
		levels.add(new Level(10,40,40,20,3,2,2));
		levels.add(new Level(10,40,40,20,3,2,2));		//15
		levels.add(new Level(10,40,40,20,3,2,2));
		levels.add(new Level(10,50,40,20,3,2,2));
		levels.add(new Level(10,50,40,20,3,2,2));
		levels.add(new Level(10,50,40,30,3,2,2));
		levels.add(new Level(10,50,15,30,3,2,2));		//20
		levels.add(new Level(10,60,50,40,3,2,2));
		levels.add(new Level(10,60,50,40,3,2,2));
		levels.add(new Level(10,60,50,50,3,2,2));
		levels.add(new Level(10,60,60,5,30,2,2));
		levels.add(new Level(10,60,60,50,3,2,2));		//25
		levels.add(new Level(10,60,60,60,3,2,2));
		levels.add(new Level(10,70,70,70,3,2,2));
		levels.add(new Level(10,80,80,80,3,2,2));
		levels.add(new Level(10,90,90,90,3,2,2));
		levels.add(new Level(6400,100,100,100,3,2,2));		//30
		
		for(int i=0; i<10; i++)
		{
			listOfComponents.add(new Button((90*i)-400,-100,50,50,""+(i+1),"AdventureGame",levels.get(i)));
		}
		for(int i=0; i<10; i++)
		{
			listOfComponents.add(new Button((90*i)-400,0,50,50,""+(i+11),"AdventureGame",levels.get(i + 10)));
		}
		for(int i=0; i<10; i++)
		{
			listOfComponents.add(new Button((90*i)-400,100,50,50,""+(i+21),"AdventureGame",levels.get(i + 20)));
		}
		listOfComponents.add(new Button(-Game.WIDTH/2+50,300,100,50,"TITLE","TitleScreen"));
		listOfComponents.add(new Button(0,-300,Game.WIDTH,50,"LEVELS",null,false));
	}
}