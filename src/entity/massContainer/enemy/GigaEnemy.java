package entity.massContainer.enemy;
import game.Game;

import java.awt.*;

public class GigaEnemy extends Enemy
{
	public GigaEnemy(double xCoord, double yCoord)
	{
		super(xCoord,yCoord,40,.2,60);
		int colorInt = Game.rand.nextInt(192)+64;
		color = new Color(colorInt,colorInt,colorInt);//gray
	}
}