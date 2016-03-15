package screen;
import game.*;
import java.awt.*;

public class SurvivalGame extends GameScreen
{
	public void update(double delta)
	{
		Spawner.spawn();
		super.update(delta);
	}
	
	public void draw(Graphics g)
	{
		super.draw(g);
		g.setColor(Color.RED);
		g.setFont(new Font("courier new",Font.BOLD,16));
		g.drawString(String.valueOf(Game.getPlayTicks()/60),(-Game.WIDTH/2)+10, Game.HEIGHT/2-10);
	}
}