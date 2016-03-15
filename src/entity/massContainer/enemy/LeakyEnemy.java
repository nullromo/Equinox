package entity.massContainer.enemy;
import entity.mass.Mass;
import game.*;
import java.awt.*;
import screen.GameScreen;

public class LeakyEnemy extends Enemy
{
	public LeakyEnemy(double xCoord, double yCoord)
	{
		super(xCoord,yCoord,10,2,30);
		int colorInt = Game.rand.nextInt(155)+100;
		color = new Color(colorInt,0,colorInt);//purple
	}
	
	public void draw(Graphics g)
	{
		super.draw(g);
	}
	
	public boolean update(double delta)
	{
		if(Utility.dist(0, 0, xCoord, yCoord) <= ((GameScreen)Game.game.getScreen()).getEquinox().getRadius() + width/2)
		{
			if(Game.game.getCurrentTicks() % 19 == 0)
			{
				Mass m = listOfMass.get(0);
				listOfMass.remove(0);
				Game.game.getScreen().getListOfEntities().add(m);
				m.setContainer(null);
			}
			xCoord = (((GameScreen)Game.game.getScreen()).getEquinox().getRadius() + radius)*Math.cos(angle); 
			yCoord = (((GameScreen)Game.game.getScreen()).getEquinox().getRadius() + radius)*Math.sin(angle);
		}
		return super.update(delta);
	}
}