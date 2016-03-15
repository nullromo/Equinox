package uicomponent;
import game.*;

import java.awt.*;
import screen.*;

public class Button extends UIComponent
{
	private static final long serialVersionUID = 1L;
	private String message, targetScreen;
	private Level level;
	
	public Button(int xCoord, int yCoord, int width, int height, String message, String targetScreen)
	{
		super(xCoord,yCoord,width,height,true);
		this.message = message;
		this.targetScreen = targetScreen;
	}
	
	public Button(int xCoord, int yCoord, int width, int height, String message, String targetScreen,  boolean clickable)
	{
		this(xCoord,yCoord,width,height,message,targetScreen);
		this.clickable = clickable;
	}
	
	public Button(int xCoord, int yCoord, int width, int height, String message, String targetScreen, Level level)
	{
		this(xCoord, yCoord, width, height, message, targetScreen);
		this.level = level;
	}
	
	public void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setFont(new Font("Courier New",Font.PLAIN,20));
		int textWidth = g.getFontMetrics().stringWidth(message) / 2;
        
		g2d.setColor(backgroundColor);
		g2d.fillRect((int)(xCoord-width/2), (int)(yCoord-height/2),width,height);
		
		g2d.setColor(textColor);
		g.drawString(message, xCoord - textWidth, yCoord);
		
		g2d.setStroke(new BasicStroke(6));
		g2d.setColor(edgeColor);
		g2d.drawRect((int)(xCoord-width/2), (int)(yCoord-height/2),width,height);
	}
	
	public void click()
	{
		if(targetScreen == null)
			return;
		super.click();
		
		if(targetScreen.equals("HighScoreScreen") && Game.game.getScreen() instanceof DeathScreen)
			Game.screens.put("HighScoreScreen", new HighScoreScreen(((HighScoreScreen)(Game.screens.get("HighScoreScreen"))).getName(),((HighScoreScreen)(MenuScreen)(Game.screens.get("HighScoreScreen"))).getTicksSurvived(),((HighScoreScreen)Game.screens.get("HighScoreScreen")).getHacker()));
		if(targetScreen.equals("AdventureGame"))
			Game.screens.put("AdventureGame", new AdventureGame(level));
		if(targetScreen.equals("TutorialScreen"))
		{
			if(((TutorialScreen)Game.screens.get("TutorialScreen")).getPage() == ((TutorialScreen)Game.screens.get("TutorialScreen")).getMaxPages() || !(Game.game.getScreen() instanceof TutorialScreen))
				((TutorialScreen)Game.screens.get("TutorialScreen")).setPage(0);
			Game.screens.put("TutorialScreen",new TutorialScreen(((TutorialScreen)Game.screens.get("TutorialScreen")).getPage()+1));
		}
		if(targetScreen.equals("EnemyProfileScreen"))
		{
			if(((EnemyProfileScreen)Game.screens.get("EnemyProfileScreen")).getPage() == 7 || !(Game.game.getScreen() instanceof EnemyProfileScreen))
				((EnemyProfileScreen)Game.screens.get("EnemyProfileScreen")).setPage(0);
			Game.screens.put("EnemyProfileScreen",new EnemyProfileScreen(((EnemyProfileScreen)Game.screens.get("EnemyProfileScreen")).getPage()+1));
		}
		if(targetScreen != null)
			Game.setScreen(Game.screens.get(targetScreen));
	}
}