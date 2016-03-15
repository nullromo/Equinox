package entity.massContainer.enemy;
import java.awt.*;

public class TankEnemy extends Enemy
{
	public TankEnemy(double xCoord, double yCoord)
	{
		super(xCoord,yCoord,10,1,20);
		color = new Color((int)(Math.random()*64)+192, (int)(Math.random()*20),(int)(Math.random()*70));//red

	}
}