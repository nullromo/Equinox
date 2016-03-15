package entity.massContainer;
import game.*;
import java.awt.*;

public class Equinox extends MassContainer
{
	public Equinox(double xCoord, double yCoord)
	{
		super(xCoord,yCoord,0,0);
		numberOfMasses = 200;
		
		genInitialMass(numberOfMasses);
		calcRadius(numberOfMasses,6);
		setMass();
		
		color = new Color(0xFFFFF);
	}
	
	public Equinox(int numberOfMasses)
	{
		super(0,0,0,0);

		genInitialMass(numberOfMasses);
		calcRadius(numberOfMasses,6);
		setMass();
		
		color = new Color(0xFFFFF);
	}
	
	public void draw(Graphics g)
	{
		super.draw(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(4));
		g.setColor(new Color(0,0,255,40));
		g.fillOval((int)(-getRadius()), (int)(-getRadius()), (int)(radius*2), (int)(radius*2));
		g.setColor(Color.BLUE);
		g.drawOval((int)(-getRadius()), (int)(-getRadius()), (int)(radius*2), (int)(radius*2));
	}
	
	public boolean update(double delta)
	{
		super.update(delta);
		
		if(Game.game.input.addMass)
			addMass();
		if(Game.game.input.subtractMass)
			removeMass();
		calcRadius(listOfMass.size(),6);
		
		massSpeed = radius/200;
		return true;
	}
}

