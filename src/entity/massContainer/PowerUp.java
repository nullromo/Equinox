package entity.massContainer;
import entity.mass.*;
import game.*;
import java.awt.*;
import screen.GameScreen;

public class PowerUp extends MassContainer
{
	public PowerUp(int radius, double angle)
	{
		super(0,0, radius, .002);
		Equinox equinox = ((GameScreen)Game.game.getScreen()).getEquinox();
		
		double xSpawnPoint = (equinox.getRadius() + 500) * Math.cos(Math.toRadians(angle));
		double ySpawnPoint = (equinox.getRadius() + 500) * Math.sin(Math.toRadians(angle));	
		xCoord = xSpawnPoint;
		yCoord = ySpawnPoint;
		
		double xTarget = (equinox.getRadius()*2+20) * Math.cos(Math.toRadians(angle) + Math.toRadians(90));
		double yTarget = (equinox.getRadius()*2+20) * Math.sin(Math.toRadians(angle) + Math.toRadians(90));
		xVel = moveSpeed * (xSpawnPoint-xTarget);
		yVel = moveSpeed * (ySpawnPoint-yTarget);
		
		numberOfMasses = 1;
		health = numberOfMasses;
		genInitialMass(numberOfMasses);
		calcRadius(numberOfMasses);
		setMass();
		color = new Color(200,200,0);//yellow
	}
	
	public PowerUp(double xCoord, double yCoord)
	{
		this(50,0);
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.xVel = 0;
		this.yVel = 0;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(color);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(4));
		
		g2d.setColor(new Color(100,100,0));
		g2d.fillOval((int)(xCoord-radius),(int)(yCoord-radius),width,height);
		
		g2d.setColor(new Color(255,255,(int)(Math.random()*256)));
		g2d.drawOval((int)(xCoord-radius),(int)(yCoord-radius),width,height);
		
		g2d.setColor(new Color(g2d.getColor().getRed(),g2d.getColor().getBlue(),g2d.getColor().getGreen(),40));
		g2d.fillOval((int)(xCoord-radius),(int)(yCoord-radius),width,height);
		
		for(Mass mass: listOfMass)
			mass.draw(g);
	}

	public boolean update(double delta)
	{
		xCoord-=xVel;
		yCoord-=yVel;
		super.update(delta);
		bounds.setBounds((int)xCoord,(int) yCoord,(int) width/2,(int) height/2);

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
			return false;
		}
		massSpeed = radius/200;
		calcRadius(numberOfMasses);
		return true;
	}
	
	//adds masses to calculate diameter
	public void genInitialMass(int mass)
	{
		for(int i = 0; i < mass; i++)
		{
			int type = (Game.rand.nextInt(3));
			switch(type)
			{
			case 0:
				listOfMass.add(new GrappleSpeedUpMass(this));
				break;
			case 1:
				listOfMass.add(new TransferSpeedUpMass(this));
				break;
			case 2:
				listOfMass.add(new DamageUpMass(this));
				break;
			default:
				listOfMass.add(new Mass(this));
				break;
			}
		}
	}
	
	//calculates radius by adding up each mass's circumference.
	public void calcRadius(int mass)
	{
		double ratio = 1.0/4.0;
		super.calcRadius(mass, ratio);
	}
}