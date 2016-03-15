package game;
import java.awt.*;
import entity.massContainer.enemy.*;
import entity.massContainer.*;

public class Spawner
{
	public static final int FAST_ENEMY = 0,
							TANK_ENEMY = 1,
							GIGA_ENEMY = 2,
							LEAKY_ENEMY = 3,
							TURRET_ENEMY = 4,
							BIG_MAMA = 5,
							POWERUP = 6;
	
	public static void spawn(int interval)
	{
		if(interval == 0)
			interval = 1;
		if(Game.getPlayTicks() % interval == 0)
		{
			Point location = selectLocation();
			int type = Game.rand.nextInt(7);
			switch(type)
			{
			case FAST_ENEMY:
				Game.game.getScreen().getListOfEntities().add(new FastEnemy(location.x,location.y));
				break;
			case TANK_ENEMY:
				Game.game.getScreen().getListOfEntities().add(new TankEnemy(location.x,location.y));
				break;
			case POWERUP:
				if(Math.random() > .5 ? true : false)
					Game.game.getScreen().getListOfEntities().add(new PowerUp(15,Game.rand.nextInt(360)));
				break;
			case GIGA_ENEMY:
				if(Math.random() > .9 ? true : false)
					Game.game.getScreen().getListOfEntities().add(new GigaEnemy(location.x,location.y));
				break;
			case LEAKY_ENEMY:
				if(Math.random() > .95 ? true : false)
					Game.game.getScreen().getListOfEntities().add(new LeakyEnemy(location.x,location.y));
				break;
			case TURRET_ENEMY:
				if(Math.random() > .95 ? true : false)
					Game.game.getScreen().getListOfEntities().add(new TurretEnemy(location.x,location.y));
				break;
			case BIG_MAMA:
				if(Math.random() > .999 ? true : false)
					Game.game.getScreen().getListOfEntities().add(new BigMama(location.x,location.y));
				break;
			}
		}
	}
	
	public static void spawn(int interval, int entityType)
	{
		Point location = selectLocation();
		if(interval == 0)
			interval = 1;
		if(Game.getPlayTicks() % interval == 0)
		{
			switch(entityType)
			{
				case FAST_ENEMY:
					Game.game.getScreen().getListOfEntities().add(new FastEnemy(location.x,location.y));
					break;
				case TANK_ENEMY:
					Game.game.getScreen().getListOfEntities().add(new TankEnemy(location.x,location.y));
					break;
				case POWERUP:
					Game.game.getScreen().getListOfEntities().add(new PowerUp(15,Game.rand.nextInt(360)));
					break;
				case GIGA_ENEMY:
					Game.game.getScreen().getListOfEntities().add(new GigaEnemy(location.x,location.y));
					break;
				case LEAKY_ENEMY:
					Game.game.getScreen().getListOfEntities().add(new LeakyEnemy(location.x,location.y));
					break;
				case TURRET_ENEMY:
					Game.game.getScreen().getListOfEntities().add(new TurretEnemy(location.x,location.y));
					break;
				case BIG_MAMA:
						Game.game.getScreen().getListOfEntities().add(new BigMama(location.x,location.y));
					break;
			}
		}
	}
	
	public static void spawn()
	{
		Point location = selectLocation();
		//int interval = (int) (10000/((Game.getPlayTicks()/20) + 1));
		int stretchFactor = 30;
		long interval = (int)((stretchFactor)*(10000))/((Game.getPlayTicks())+(stretchFactor));
		if(interval == 0)
			interval = 1;
		int entityType = Game.rand.nextInt(7);
		if(Game.getPlayTicks() % interval == 0)
		{
			switch(entityType)
			{
			case FAST_ENEMY:
				Game.game.getScreen().getListOfEntities().add(new FastEnemy(location.x,location.y));
				return;
			case TANK_ENEMY:
				Game.game.getScreen().getListOfEntities().add(new TankEnemy(location.x,location.y));
				return;
			case POWERUP:
				if(Math.random() > .5 ? true : false)
				{
					Game.game.getScreen().getListOfEntities().add(new PowerUp(15,Game.rand.nextInt(360)));
					return;
				}
				break;
			case GIGA_ENEMY:
				if(Math.random() > .9 ? true : false)
				{
					Game.game.getScreen().getListOfEntities().add(new GigaEnemy(location.x,location.y));
					return;
				}
				break;
			case LEAKY_ENEMY:
				if(Math.random() > .92 ? true : false)
				{
					Game.game.getScreen().getListOfEntities().add(new LeakyEnemy(location.x,location.y));
					return;
				}
				break;
			case TURRET_ENEMY:
				if(Math.random() > .94 ? true : false)
				{
					Game.game.getScreen().getListOfEntities().add(new TurretEnemy(location.x,location.y));
					return;
				}
				break;
			case BIG_MAMA:
				if(Math.random() > .999 ? true : false)	
				{
					Game.game.getScreen().getListOfEntities().add(new BigMama(location.x,location.y));
					return;
				}
				break;
			}
			if(Math.random() > .8 ? true : false)
			{
				Game.game.getScreen().getListOfEntities().add(new Enemy(location.x,location.y,10,2,14));
				((Enemy)Game.game.getScreen().getListOfEntities().get(Game.game.getScreen().getListOfEntities().size()-1)).setHealth(1);
			
			}
		}	
	}
	
	public static void spawn(Level level)
	{
		if(level.getSpawnQueue().size()>0)
		{
			System.out.println(Game.game.getCurrentTicks() % level.getSpawnInterval());
			if(Game.game.getCurrentTicks() % level.getSpawnInterval() == 0)
			{
				Game.game.getScreen().getListOfEntities().add(level.getSpawnQueue().get(0));
				level.getSpawnQueue().remove(0);
			}
		}
	}
	
	public static Point selectLocation()
	{
		int location = Game.rand.nextInt(4);
		double x = 0;
		double y = 0;
		switch(location)
		{
		case 0:
			//bottom
			x = Utility.negToPositive(Game.WIDTH/2);
			y = Game.HEIGHT/2;	
			break;
		case 1:
			//top
			x = Utility.negToPositive(Game.WIDTH/2);
			y = -Game.HEIGHT/2;	
			break;
		case 2: 
			//left
			x = -Game.WIDTH/2;
			y = Utility.negToPositive(Game.HEIGHT/2);	
			break;
		case 3:
			//right
			x = Game.WIDTH/2;
			y = Utility.negToPositive(Game.HEIGHT/2);
			break;
		}
		return new Point((int)x,(int)y);
	}
}