package screen;
import java.awt.*;
import entity.*;
import entity.cannon.GrappleCannon;
import entity.cannon.MassCannon;
import entity.massContainer.*;
import game.*;

public class GameScreen extends Screen
{
	protected Equinox equinox;
	protected MassCannon massCannon;
	protected GrappleCannon grappleCannon;
	
	public GameScreen()
	{
		Game.setPlayTicks(0);
		equinox = new Equinox(0, 0);
		
		int cannonWidth =  (int)(.15*equinox.getRadius());
		int cannonHeight = (int)(.32*equinox.getRadius());
		massCannon = new MassCannon(0,0, cannonWidth, cannonHeight);
		grappleCannon = new GrappleCannon(0,0, cannonWidth, cannonHeight);
		
		//listOfEntities.add(massCannon);
		//listOfEntities.add(grappleCannon);
		listOfEntities.add(equinox);
	}
	
	public void update(double delta)
	{
		super.update(delta);
		if(equinox.getListOfMass().size() <= 10)
		{

			Game.screens.put("DeathScreen", new DeathScreen());
			((HighScoreScreen)Game.screens.get("HighScoreScreen")).setTicksSurvived(Game.getPlayTicks());
			Game.screens.put("SurvivalGame",new SurvivalGame());
			Game.setScreen(Game.screens.get("DeathScreen"));
			return;
		}
		
		massCannon.update(delta);
		grappleCannon.update(delta);
		for(int i=0; i<listOfEntities.size(); i++)
		{
			if(!listOfEntities.get(i).update(delta))
			{
				listOfEntities.remove(i);
				i--;
			}
		}
		
	}
	
	public void draw(Graphics g)
	{
		super.draw(g);
		for(Entity e: listOfEntities)
			e.draw(g);
		massCannon.draw(g);
		grappleCannon.draw(g);
		
	}
	
	
	public Equinox getEquinox(){return equinox;}
	public MassCannon getMassCannon(){return massCannon;}
	public GrappleCannon getGrappleCannon(){return grappleCannon;}
}