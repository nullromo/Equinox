package entity.massContainer;
import java.awt.*;
import java.util.*;
import java.util.List;
import entity.*;
import entity.mass.*;
import game.*;

public abstract class MassContainer extends Entity
{
	protected double xVel = 0, yVel = 0;
	protected double moveSpeed;
	protected double angle;
	protected double health = 1;
	protected int radius;
	protected double massSpeed;
	protected int totalMassRadius;
	protected List<Mass> listOfMass = new ArrayList<Mass>();
	protected int numberOfMasses;
	protected Color color;
	
	public MassContainer(double xCoord, double yCoord, int width, int height, double moveSpeed)
	{
		super(xCoord,yCoord,width,height);
		angle = Math.atan2(yCoord,xCoord);
		xVel = moveSpeed*Math.cos(angle);
		yVel = moveSpeed*Math.sin(angle);
		this.moveSpeed = moveSpeed;
		massSpeed = 5;
	}
	
	public MassContainer(double xCoord, double yCoord, int radius, double moveSpeed)
	{
		this(xCoord,yCoord,radius*2,radius*2,moveSpeed);
		this.radius = radius;
	}
	
	//calculates rraaddiiuuss by adding up each mass's circumference.
	public void calcRadius(int mass, double ratio)
	{
		totalMassRadius = 0;
		for(Mass m: listOfMass)
			totalMassRadius += m.getRadius();
		radius = (int)(totalMassRadius/ratio);
		width = radius*2;
		height = radius*2;
	}
	
	//randomizes the locations of mass produced by getInitialMass
	public void setMass()
	{
		for(Mass m: listOfMass)
		{
			m.setXCoord(Utility.negToPositive(radius/2) + xCoord);
			m.setYCoord(Utility.negToPositive(radius/2) + yCoord);
		}
	}
	
	//adds masses to calculate diameter
	public void genInitialMass(int mass)
	{
		for(int i = 0; i < mass; i++)
			listOfMass.add(new Mass(this));
	}
	
	//adds a new mass with random location
	public void addMass()
	{
		listOfMass.add(new Mass(Utility.negToPositive(radius/2) + xCoord,
								Utility.negToPositive(radius/2) + yCoord,this));
	}
	
	//removes first occurrence of mass and returns it
	public Mass removeMass()
	{
		if(listOfMass.size() > 0)
			return listOfMass.remove(0);
		System.out.println("not greater than 0");
		return null;
	}
	
	public void draw(Graphics g)
	{
		for(Mass mass : listOfMass)
			mass.draw(g);
	}
	
	public boolean update(double delta)
	{
		for(Mass mass: listOfMass)
			mass.update(delta);
		return true;
	}
	
	public List<Mass> getListOfMass(){return listOfMass;}
	public double getXVel(){return xVel;}
	public double getYVel(){return yVel;}
	public double getRadius(){return radius;}
	public double getMassSpeed(){return massSpeed;}
	public void setXVel(double v){xVel = v;}
	public void setYVel(double v){yVel = v;}
	public double getHealth(){return health;}
	public void setHealth(double health){this.health = health;}
	public Color getColor(){return color;}
}