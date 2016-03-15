package screen;
import java.awt.*;
import uicomponent.Button;

public class TitleScreen extends MenuScreen
{
	public TitleScreen()
	{
		listOfComponents.add(new Button(0,100,100,50,"PLAY","SurvivalGame"));
		listOfComponents.add(new Button(100,200,100,50,"OPTIONS","OptionScreen"));
		listOfComponents.add(new Button(-100,200,100,50,"TUTORIAL","TutorialScreen"));
		listOfComponents.add(new Button(0,300,150,50,"HIGH SCORES","HighScoreScreen"));
//		listOfComponents.add(new Button(0,300,100,50,"LEVELS",null,false));
	}
	
	public void draw(Graphics g)
	{
		super.draw(g);
		
		g.setColor(new Color(10,179,100));
		g.drawLine(-290,-150,250,-150);
		g.setColor(Color.DARK_GRAY);
		
		g.setFont(new Font("Courier New",Font.BOLD,130));
		//g.drawString("Equinox", -340, -160);
		g.drawString("Equinox",-290,-160);
		
		g.setFont(new Font("Courier New",Font.PLAIN,50));
		g.drawString("By Collin and Kyle", -290, 50);
		
//		g.setColor(Color.RED);
//		g.setFont(new Font("courier new",Font.BOLD,15));
//		g.drawString("COMING SOON",-50,315);
		
		g.setColor(Color.CYAN);
		g.setFont(new Font("Courier new",Font.BOLD,20));
		
	}
}