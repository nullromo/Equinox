package entity.massContainer.enemy;
import entity.mass.Mass;
import game.*;
import java.awt.*;
import screen.GameScreen;

public class TurretEnemy extends Enemy
{
	private long spawnRate = 250;
	
	public TurretEnemy(double xCoord, double yCoord)
	{
		super(xCoord,yCoord,18, .5 ,2);
		color = new Color(Game.rand.nextInt(64)+192,Game.rand.nextInt(32)+96,Game.rand.nextInt(20));//orange
	}
	
	public boolean update(double delta)
	{
		double dist  = Utility.dist(xCoord, yCoord, ((GameScreen)Game.game.getScreen()).getEquinox().getXCoord(), ((GameScreen)Game.game.getScreen()).getEquinox().getYCoord());
		if(dist > (((GameScreen)Game.game.getScreen()).getEquinox().getRadius() + 153))
		{
			xCoord -= xVel;
			yCoord -= yVel;
		}
		else if(dist < (((GameScreen)Game.game.getScreen()).getEquinox().getRadius() + 147))
		{
			xCoord += xVel;
			yCoord += yVel;
		}
		else if(((GameScreen)Game.game.getScreen()).getGrappleCannon().getGrapple() == null || Utility.dist(((GameScreen)Game.game.getScreen()).getGrappleCannon().getGrapple().getTipX(),((GameScreen)Game.game.getScreen()).getGrappleCannon().getGrapple().getTipY(),xCoord,yCoord) > radius+8)
		{
			angle += xVel / 50;
			xCoord = (((GameScreen)Game.game.getScreen()).getEquinox().getRadius() + 150) * Math.cos(angle);
			yCoord = (((GameScreen)Game.game.getScreen()).getEquinox().getRadius() + 150) * Math.sin(angle);
		}
		
		if(Game.getPlayTicks() % spawnRate == 0)
		{
			for(int i=0; i<3; i++)
				if(listOfMass.size() > 0)
					listOfMass.remove(0);
			Game.game.getScreen().getListOfEntities().add(new FastEnemy(xCoord,yCoord));
			for(int i=0; i<3; i++)
				((Enemy)(Game.game.getScreen().getListOfEntities().get(Game.game.getScreen().getListOfEntities().size()-1))).getListOfMass().remove(0);
		}
		
		if(offScreen())
			return false;
		if(removed) 
			return false;
	
		if (health <= 0)
		{
			for(int i = 0; i < numberOfMasses; i++)
			{
				if(listOfMass.size() > 0)
				{
					Mass mass = removeMass();
					((GameScreen)Game.game.getScreen()).getListOfEntities().add(mass);
					mass.setContainer(null);
				}
			}
			//for(int i = 0; i < numberOfMasses; i++)
			//	Game.game.getScreen().getListOfEntities().add(new Mass(xCoord,yCoord,Math.random()*360));
			return false;
		}
		for(Mass mass : listOfMass)
			mass.update(delta);
		
		massSpeed = radius / 200;
		calcRadius(numberOfMasses);
		return super.update(delta);
		
	}
}
