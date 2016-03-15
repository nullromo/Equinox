package entity.mass;
import entity.massContainer.*;
import java.awt.*;

public class TransferSpeedUpMass extends Mass
{
	public TransferSpeedUpMass(double xCoord, double yCoord, MassContainer container)
	{
		super(xCoord,yCoord,container);
		radius = (int)(((Math.random()*4) + 11) / 2);
	}
	
	public TransferSpeedUpMass(double xCoord, double yCoord,double angle)
	{
		super(xCoord,yCoord,angle);
		radius = (int)(((Math.random()*4) + 11) / 2);
	}
	
	public TransferSpeedUpMass(MassContainer container)
	{
		super(container);
		radius = (int)(((Math.random()*4) + 11) / 2);
	}
	
	public void draw(Graphics g)
	{
		g.setFont(new Font("Courier New",Font.BOLD,(int)(radius*3.5)));
		g.setColor(Color.GREEN);
		g.drawString("T",(int)(xCoord-radius),(int)(yCoord+radius));
	}
}