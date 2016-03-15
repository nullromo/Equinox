package screen;
import entity.Entity;
import entity.massContainer.enemy.*;
import game.Game;
import java.awt.*;
import uicomponent.Button;
import uicomponent.UIComponent;

public class EnemyProfileScreen extends MenuScreen
{
	private int page;
	
	public EnemyProfileScreen(int page)
	{
		this.page = page;
		
		listOfComponents.add(new Button(-Game.WIDTH/2+50,300,100,50,"TITLE","TitleScreen"));
		
		if(page < 7)
			listOfComponents.add(new Button(Game.WIDTH/2-50,300,100,50,"NEXT","EnemyProfileScreen"));
		
		listOfComponents.add(new Button(0,-300,Game.WIDTH,50,"ENEMIES",null,false));
		
		switch(page)
		{
		case 1:listOfEntities.add(new Enemy(0,0,10,2,14));
			break;
		case 2:listOfEntities.add(new TankEnemy(0,0));
			break;
		case 3:listOfEntities.add(new FastEnemy(0,0));
			break;
		case 4:listOfEntities.add(new GigaEnemy(0,0));
			break;
		case 5:listOfEntities.add(new LeakyEnemy(0,0));
			break;
		case 6:listOfEntities.add(new TurretEnemy(0,0));
			break;
		case 7:listOfEntities.add(new BigMama(130,40));
			break;
		}
	}
	
	public void draw(Graphics g)
	{
		super.draw(g);
		for(Entity e: listOfEntities)
			e.draw(g);

		g.setFont(new Font("courier new",Font.BOLD,20));
		g.setColor(Color.WHITE);
		switch(page)
		{
		case 1:
			g.drawString("ENEMY",-355,0);
			g.drawString("SPEED: average",-355,60);
			g.drawString("HEALTH: very low",-355,90);
			g.drawString("HUNGER: low",-355,120);
			g.drawString("RARITY: common",-355,150);
			g.drawString("ABILITY: none",-355,180);
			break;
		case 2:
			g.drawString("TANK ENEMY",-355,0);
			g.drawString("SPEED: slow",-355,60);
			g.drawString("HEALTH: medium",-355,90);
			g.drawString("HUNGER: medium",-355,120);
			g.drawString("RARITY: common",-355,150);
			g.drawString("ABILITY: none",-355,180);
			break;
		case 3:
			g.drawString("FAST ENEMY",-355,0);
			g.drawString("SPEED: very fast",-355,60);
			g.drawString("HEALTH: low",-355,90);
			g.drawString("HUNGER: very low",-355,120);
			g.drawString("RARITY: common",-355,150);
			g.drawString("ABILITY: none",-355,180);
			break;
		case 4:
			g.drawString("GIGA ENEMY",-355,0);
			g.drawString("SPEED: very slow",-355,60);
			g.drawString("HEALTH: very high",-355,90);
			g.drawString("HUNGER: very high",-355,120);
			g.drawString("RARITY: rare",-355,150);
			g.drawString("ABILITY: none",-355,180);
			break;
		case 5:
			g.drawString("LEAKY ENEMY",-355,0);
			g.drawString("SPEED: medium",-355,60);
			g.drawString("HEALTH: medium",-355,90);
			g.drawString("HUNGER: very high",-355,120);
			g.drawString("RARITY: rare",-355,150);
			g.drawString("ABILITY: dumps your mass into the environment, absorbing none of it",-355,180);
			break;
		case 6:
			g.drawString("TURRET ENEMY",-355,0);
			g.drawString("SPEED: medium",-355,60);
			g.drawString("HEALTH: medium",-355,90);
			g.drawString("HUNGER: none",-355,120);
			g.drawString("RARITY: rare",-355,150);
			g.drawString("ABILITY: shoots FAST ENEMIES at you while orbiting the EQUINOX",-355,180);
			break;
		case 7:
			g.drawString("BIG MAMA",-450,0);
			g.drawString("SPEED: medium",-450,60);
			g.drawString("HEALTH: extremely high",-450,90);
			g.drawString("HUNGER: extremely high",-450,120);
			g.drawString("RARITY: extremely rare",-450,150);
			g.drawString("ABILITY: none",-450,180);
			break;
		}
		
	}
	
	public void update(double delta)
	{
		for(UIComponent ui: listOfComponents)
			ui.update();
		for(Entity e: listOfEntities)
			if(e instanceof Enemy)
				for(Entity m: ((Enemy) e).getListOfMass())
					m.update(delta);
	}
	
	public int getPage(){return page;}
	public void setPage(int p){page = p;}
}