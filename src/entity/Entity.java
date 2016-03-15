package entity;
import java.awt.*;
import java.awt.image.*;
import game.*;

public abstract class Entity
{
	protected double xCoord, yCoord;
	protected int width, height;
	protected BufferedImage skin;
	protected Rectangle bounds;
	public boolean removed;
	
	public Entity(double xCoord, double yCoord, int width, int height)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.width = width;
		this.height = height;
		bounds = new Rectangle(width,height);
	}
	
	public Entity(double xCoord, double yCoord, int radius)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.width = radius*2;
		this.height = radius*2;
		bounds = new Rectangle(width,height);
	}
	
	public abstract void draw(Graphics g);
	
	public abstract boolean update(double delta);
	
	public boolean offScreen()
	{
		if(xCoord < -(Game.WIDTH/2) - 500 || xCoord > (Game.WIDTH/2) + 500)
			return true;
		if(yCoord < -(Game.HEIGHT/2) - 500 || yCoord > (Game.HEIGHT/2) + 500)
			return true;
		return false;
	}
	
	public boolean collidesWith(Entity other)
	{
		return this.bounds.intersects(other.bounds);
	}

	public double getXCoord(){return xCoord;}
	public void setXCoord(double xCoord){this.xCoord = xCoord;}
	public double getYCoord(){return yCoord;}
	public void setYCoord(double yCoord){this.yCoord = yCoord;}
	public int getHeight(){return height;}
	public int getWidth(){return width;}
	public void setWidth(int w){width = w;}
	public void setHeight(int h){height = h;}
}