package game;
import java.awt.event.*;
import screen.*;

public class Input implements KeyListener, MouseListener, MouseMotionListener
{
	public boolean[] keys = new boolean[526];
	public static int mouseX,mouseY;
	public boolean  left, right, fire,
					grappleLeft, grappleRight, grapple,
					addMass, subtractMass,pause,shotgun;
	
	public void keyPressed(KeyEvent e)
	{
		keys[e.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent e)
	{
		keys[e.getKeyCode()] = false;
	}
	
	public void keyTyped(KeyEvent e)
	{
		if(Game.game.getScreen() instanceof GameScreen)
			if(e.getKeyChar() == KeyEvent.VK_9 || e.getKeyChar() == KeyEvent.VK_0)
				((HighScoreScreen)Game.screens.get("HighScoreScreen")).setHacker(true);
		
		if(Game.game.getScreen() instanceof DeathScreen)
		{
			if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
			{
				if(((HighScoreScreen)(Game.screens.get("HighScoreScreen"))).getName().length() > 0)
					((HighScoreScreen)(Game.screens.get("HighScoreScreen"))).setName(((HighScoreScreen)(Game.screens.get("HighScoreScreen"))).getName().substring(0,((HighScoreScreen)(Game.screens.get("HighScoreScreen"))).getName().length()-1));
			}
			else if (e.getKeyChar() == KeyEvent.VK_ENTER)
			{
				Game.screens.put("HighScoreScreen", new HighScoreScreen(((HighScoreScreen)(Game.screens.get("HighScoreScreen"))).getName(),((HighScoreScreen)(Game.screens.get("HighScoreScreen"))).getTicksSurvived(),((HighScoreScreen)Game.screens.get("HighScoreScreen")).getHacker()));
				Game.setScreen(Game.screens.get("HighScoreScreen"));
			}
			else if(Character.isDigit(e.getKeyChar()))
				return;
			else if(((HighScoreScreen)(Game.screens.get("HighScoreScreen"))).getName().length()<21)
				((HighScoreScreen)(Game.screens.get("HighScoreScreen"))).setName(((HighScoreScreen)(Game.screens.get("HighScoreScreen"))).getName() + e.getKeyChar());
		}
	}
	
	public void updateKeys()
	{
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		fire = keys[KeyEvent.VK_S];
		shotgun = keys[KeyEvent.VK_SPACE];
		grappleLeft = keys[KeyEvent.VK_J];
		grappleRight = keys[KeyEvent.VK_L];
		addMass = keys[KeyEvent.VK_9] ;
		subtractMass = keys[KeyEvent.VK_0];
		pause = keys[KeyEvent.VK_ESCAPE];
	}
	
	public void releaseAllKeys()
	{
		for(int i=0; i<keys.length; i++)
			keys[i] = false;
	}
	
	public void mouseClicked(MouseEvent me)
	{
	}
	
	public void mouseEntered(MouseEvent me)
	{
	}
	
	public void mouseExited(MouseEvent me)
	{
	}
	
	public void mousePressed(MouseEvent me)
	{
		if(Game.game.getScreen() instanceof GameScreen  && !(Game.game.getScreen() instanceof TutorialScreen))
			((GameScreen) Game.game.getScreen()).getGrappleCannon().fire();
		else if((Game.game.getScreen() instanceof TutorialScreen) && (((TutorialScreen)Game.game.getScreen()).getPage() == 6 || ((TutorialScreen)Game.game.getScreen()).getPage() == 7))
		{
			Game.game.getScreen().takeAction(me);
			((TutorialScreen) Game.game.getScreen()).getGrappleCannon().fire();
		}
		else
			Game.game.getScreen().takeAction(me);
	}
	
	public void mouseReleased(MouseEvent me)
	{
		//grapple = false;
	}
	
	public void mouseDragged(MouseEvent e)
	{
		mouseMoved(e);
	}
	
	public void mouseMoved(MouseEvent e)
	{
		mouseX = e.getX() - Game.WIDTH/2;
		mouseY = e.getY() - Game.HEIGHT/2;
	}
}