package screen;
import java.awt.Color;
import java.awt.Graphics;
import game.Game;
import uicomponent.*;

public class GraphicsScreen extends MenuScreen
{
	public GraphicsScreen()
	{
	//	listOfComponents.add(new CheckBox(-100,0,false,null));
		listOfComponents.add(new CheckBox(0,0,true,"antialiasing"));
		listOfComponents.add(new CheckBox(100,0,true,"fps"));
	//	listOfComponents.add(new CheckBox(100,0,false,null));
		listOfComponents.add(new Button(Game.WIDTH/2-50,300,100,50,"BACK","OptionScreen"));
		listOfComponents.add(new Button(0,-300,Game.WIDTH,50,"GRAPHICS",null,false));
	}
	
	public void draw(Graphics g)
	{
		super.draw(g);
		g.setColor(Color.WHITE);
		g.drawString("AA",-25,50);
		g.drawString("FPS",75,50);
	}
}