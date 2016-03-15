package entity.massContainer.enemy;
import game.*;
import java.awt.*;

public class FastEnemy extends Enemy
{
	public FastEnemy(double xCoord, double yCoord)
	{
		super(xCoord,yCoord,6,4,9);
		color = new Color(Game.rand.nextInt(64),Game.rand.nextInt(64)+192,Game.rand.nextInt(128),255);//green
	}
}