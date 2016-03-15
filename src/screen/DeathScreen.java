package screen;
import game.*;
import java.awt.*;
import uicomponent.Button;

public class DeathScreen extends Screen
{
	
	public DeathScreen()
	{
		listOfComponents.add(new Button(-120,100,100,50,"TITLE","TitleScreen"));
		listOfComponents.add(new Button(100,100,150,50,"SUBMIT SCORE","HighScoreScreen"));
	}
	
	public void draw(Graphics g)
	{
		
		//info
		g.setColor(Color.RED);
		g.setFont(new Font("Courier New",Font.BOLD,40));
		g.drawString("You survived " + ((HighScoreScreen)Game.screens.get("HighScoreScreen")).getTicksSurvived() / 60 + " seconds!",-300,0);
		
		//underline and instructions
		g.setColor(Color.WHITE);
		g.drawLine(-Game.WIDTH/4,250,Game.WIDTH/4,250);
		g.drawString(((HighScoreScreen)Game.screens.get("HighScoreScreen")).getName(),-Game.WIDTH/4,240);
		g.setFont(new Font("courier new",Font.BOLD,20));
		g.drawString("Enter your name",-100,280);
		
		super.draw(g);
	}
}