package screen;
import uicomponent.Button;
import game.*;

public class OptionScreen extends MenuScreen
{
	public OptionScreen()
	{
		listOfComponents.add(new Button(-300,-50,150,50,"SOUND","SoundScreen"));
		listOfComponents.add(new Button(0,-50,150,50,"CREDITS","CreditsScreen"));
		listOfComponents.add(new Button(300,-50,150,50,"GRAPHICS","GraphicsScreen"));
		listOfComponents.add(new Button(Game.WIDTH/2-50,300,100,50,"PLAY","SurvivalGame"));
		listOfComponents.add(new Button(-Game.WIDTH/2+50,300,100,50,"TITLE","TitleScreen"));
		listOfComponents.add(new Button(0,-300,Game.WIDTH,50,"OPTIONS",null,false));
	}
}