package entity.mass;
import java.awt.*;
import entity.massContainer.*;

public class GrappleSpeedUpMass extends Mass
{
	public GrappleSpeedUpMass(double xCoord, double yCoord, MassContainer container)
	{
		super(xCoord,yCoord,container);
		radius = (int)(((Math.random()*4) + 11) / 2);
	}
	
	public GrappleSpeedUpMass(double xCoord, double yCoord,double angle)
	{
		super(xCoord,yCoord,angle);
		radius = (int)(((Math.random()*4) + 11) / 2);
	}
	
	public GrappleSpeedUpMass(MassContainer container)
	{
		super(container);
		radius = (int)(((Math.random()*4) + 11) / 2);
	}
	
	public void draw(Graphics g)
	{
		g.setFont(new Font("Courier New",Font.BOLD,(int)(radius*3.5)));
		g.setColor(Color.GREEN);
		g.drawString("G",(int)(xCoord-radius),(int)(yCoord+radius));
	}
}