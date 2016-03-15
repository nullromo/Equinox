package screen;
import game.*;
import java.awt.*;

public class AdventureGame extends GameScreen
{
	private Level currentLevel;
	
	public AdventureGame(Level level)
	{
		currentLevel = level;
	}
	
	public void update(double delta)
	{
		super.update(delta);
		Spawner.spawn(currentLevel);
	}
	
	public void draw(Graphics g)
	{
		super.draw(g);
	}
}