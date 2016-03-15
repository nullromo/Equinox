package entity.massContainer.enemy;
import game.Game;
import java.awt.*;

public class BigMama extends Enemy
{
	public BigMama(double xCoord, double yCoord)
	{
		super(xCoord,yCoord,100,.6,500);
	}
	
	public void draw(Graphics g)
	{
		color = new Color(Game.rand.nextInt(256),Game.rand.nextInt(256),Game.rand.nextInt(256));//random color
		super.draw(g);
	}
}