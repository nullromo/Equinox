package screen;
import java.awt.*;
import entity.*;
import entity.mass.*;
import game.*;

public class MenuScreen extends Screen
{
	public void update(double delta)
	{
		super.update(delta);
		for(int i = 0; i < listOfEntities.size(); i++)
			if(!listOfEntities.get(i).update(delta))
				listOfEntities.remove(i);
		if(listOfEntities.size() < 100)
			listOfEntities.add(new Mass(Utility.negToPositive(Game.WIDTH/2),Utility.negToPositive(Game.HEIGHT/2),Math.random()*360));
	}
	
	public void draw(Graphics g)
	{
		g.setColor(new Color(0,0,255,18));
		g.fillRect(-Game.WIDTH/2,-Game.HEIGHT/2,Game.WIDTH,Game.HEIGHT);
		for(Entity e : listOfEntities)
			e.draw(g);
		
		g.setColor(Color.DARK_GRAY);
		super.draw(g);
	}
}