package screen;
import game.*;
import uicomponent.Button;

public class ProfileScreen extends MenuScreen
{
	public ProfileScreen()
	{
		for(int i=0; i<8; i++)
		{
			listOfComponents.add(new Button(0,-(70*i-300),400,50,"User" + (8-i),"TitleScreen"));
		}
		listOfComponents.add(new Button(0,-300,Game.WIDTH,50,"SELECT PROFILE",null,false));
	}
	
	public void createProfile()
	{
		Utility.saveProfile(new UserProfile("User"));
	}
}