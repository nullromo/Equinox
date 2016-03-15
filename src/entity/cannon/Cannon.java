package entity.cannon;
import java.awt.*;
import java.awt.geom.*;

import entity.Entity;

public abstract class Cannon extends Entity
{
	protected double rotVel = 0.0;
	protected double angle = Math.toRadians(-90);
	protected double fireRate = 5;//per second
	
	public Cannon(double xCoord, double yCoord, int width, int height)
	{
		super(xCoord,yCoord,width,height);
	}
	
	public void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		
		AffineTransform original = g2d.getTransform();
		
		g2d.translate(xCoord,yCoord);
		
		g2d.rotate(angle + Math.toRadians(90));
		
		g2d.setStroke(new BasicStroke(4));
		g2d.drawRect(0,-height, width, height);
		Color c = new Color(g2d.getColor().getRed(),g2d.getColor().getGreen(),g2d.getColor().getBlue(),40);
		g2d.setColor(c);
		g2d.fillRect(0,-height, width, height);
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(2,-3,width-3,6);
		g2d.setColor(c);
		g2d.fillRect(2,-3,width-3,6);
		
		g2d.setTransform(original);
	}
	
	public abstract boolean update(double delta);
	
	public void moveCounterClock()
	{
		rotVel-=.01;
	}
	
	public void moveClock()
	{
		rotVel+=.01;
	}
	
	public abstract void fire();
	
	public double getAngle(){return angle;}
}