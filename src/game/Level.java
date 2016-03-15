package game;
import java.awt.*;
import java.util.*;
import entity.massContainer.enemy.*;

public class Level
{
	private ArrayList<Enemy> spawnQueue;
	private int spawnInterval;
	
	public Level(int spawnInterval, int numFast, int numTank, int numGiga,int numLeaky, int numTurret, int numMama)
	{
		this.spawnInterval = spawnInterval;
		Point p;
		spawnQueue = new ArrayList<Enemy>();
		for(int i = 0; i < numFast; i++)
		{
			p = Spawner.selectLocation();
			spawnQueue.add(new FastEnemy(p.x,p.y));
		}
		for(int i=0; i<numTank; i++)
		{
			p = Spawner.selectLocation();
			spawnQueue.add(new TankEnemy(p.x,p.y));
		}
		for(int i=0; i<numGiga; i++)
		{
			p = Spawner.selectLocation();
			spawnQueue.add(new GigaEnemy(p.x,p.y));
		}
		for(int i=0; i<numLeaky; i++)
		{
			p = Spawner.selectLocation();
			spawnQueue.add(new LeakyEnemy(p.x,p.y));
		}
		for(int i=0; i<numTurret; i++)
		{
			p = Spawner.selectLocation();
			spawnQueue.add(new TurretEnemy(p.x,p.y));
		}
		for(int i=0; i<numMama; i++)
		{
			p = Spawner.selectLocation();
			spawnQueue.add(new BigMama(p.x,p.y));
		}
		//scrambled eggs
		for(int i=0; i<200; i++)
		{
			int index = Game.rand.nextInt(spawnQueue.size());
			spawnQueue.add(0,spawnQueue.get(index));
			spawnQueue.remove(index+1);
		}
	}
	
	public int getSpawnInterval(){return spawnInterval;}
	public ArrayList<Enemy> getSpawnQueue(){return spawnQueue;}
}