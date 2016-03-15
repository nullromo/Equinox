package entity.mass;
import entity.massContainer.*;
import java.awt.*;

public class DamageUpMass extends Mass
{
	public DamageUpMass(double xCoord, double yCoord, MassContainer container)
	{
		super(xCoord,yCoord,container);
		radius = (int)(((Math.random()*4) + 11) / 2);
	}
	
	public DamageUpMass(double xCoord, double yCoord,double angle)
	{
		super(xCoord,yCoord,angle);
		radius = (int)(((Math.random()*4) + 11) / 2);
	}
	
	public DamageUpMass(MassContainer container)
	{
		super(container);
		radius = (int)(((Math.random()*4) + 11) / 2);
	}
	
	public void draw(Graphics g)
	{
		g.setFont(new Font("Courier New",Font.BOLD,(int)(radius*3.5)));
		g.setColor(Color.GREEN);
		g.drawString("D",(int)(xCoord-radius),(int)(yCoord+radius));
	}
}