package screen;
import game.Game;
import uicomponent.Button;
import uicomponent.CheckBox;

public class SoundScreen extends MenuScreen
{
	public SoundScreen()
	{
		listOfComponents.add(new CheckBox(0,0,true,"sound"));
		listOfComponents.add(new Button(Game.WIDTH/2-50,300,100,50,"BACK","OptionScreen"));
		listOfComponents.add(new Button(0,-300,Game.WIDTH,50,"SOUND",null,false));
	}
}