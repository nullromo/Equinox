package screen;
import entity.*;
import entity.mass.*;
import entity.massContainer.*;
import entity.massContainer.enemy.*;
import game.*;
import java.awt.*;
import uicomponent.Button;
import uicomponent.*;

public class TutorialScreen extends GameScreen
{
	private int page = 0;
	private int maxPages = 8;
	
	public TutorialScreen(int page)
	{
		this.page = page;
		
		listOfComponents.add(new Button(-Game.WIDTH/2+50,300,100,50,"TITLE","TitleScreen"));
		
		if(page == maxPages)
			listOfComponents.add(new Button(Game.WIDTH/2-100, 300, 200,50,"ENEMY PROFILES","EnemyProfileScreen"));
		
		if(page < maxPages)
			listOfComponents.add(new Button(Game.WIDTH/2-50,300,100,50,"NEXT","TutorialScreen"));
		
		listOfComponents.add(new Button(0,-300,Game.WIDTH,50,"TUTORIAL",null,false));
		
		
		if(3 <= page && page <= 7)
		{
			listOfEntities.add(new TankEnemy(300,0));
			listOfEntities.add(new TankEnemy(-400,50));
			listOfEntities.add(new FastEnemy(-600,-100));
			listOfEntities.add(new TankEnemy(700,-50));
		}
		
		if(page == 8)
		{
			listOfEntities.add(new PowerUp((double)320,(double)-80));
			((MassContainer)listOfEntities.get(listOfEntities.size()-1)).getListOfMass().remove(0);
			((MassContainer)listOfEntities.get(listOfEntities.size()-1)).getListOfMass().add(new TransferSpeedUpMass(((MassContainer)listOfEntities.get(listOfEntities.size()-1))));
			listOfEntities.add(new PowerUp((double)0,(double)-80));
			((MassContainer)listOfEntities.get(listOfEntities.size()-1)).getListOfMass().remove(0);
			((MassContainer)listOfEntities.get(listOfEntities.size()-1)).getListOfMass().add(new GrappleSpeedUpMass(((MassContainer)listOfEntities.get(listOfEntities.size()-1))));
			listOfEntities.add(new PowerUp((double)-320,(double)-80));
			((MassContainer)listOfEntities.get(listOfEntities.size()-1)).getListOfMass().remove(0);
			((MassContainer)listOfEntities.get(listOfEntities.size()-1)).getListOfMass().add(new DamageUpMass(((MassContainer)listOfEntities.get(listOfEntities.size()-1))));
		}
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(-Game.WIDTH/2,-Game.HEIGHT/2,Game.WIDTH,Game.HEIGHT);
		
		for(UIComponent ui: listOfComponents)
			ui.draw(g);
		if(shaking)
			g.translate((int)Utility.negToPositive(6),(int) Utility.negToPositive(6));
		if(page > 2 && page <= 7)
			for(Entity e : listOfEntities)
				e.draw(g);
		
		g.setColor(Color.DARK_GRAY);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(4));	
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("courier new",Font.BOLD,20));
		
		switch(page)
		{
		case 1:
			g.drawString("Welcome to EQUINOX. In this game, your goal is to fend off ravenous enemies",-460,-200);
			g.drawString("that will try to suck the very life out of you. This blue circle is called ",-460,200);
			g.drawString("the EQUINOX. It represents you, the player.",-460,250);
			
			g.setColor(new Color(0,0,255,40));
			g.fillOval((int)(equinox.getXCoord()-equinox.getRadius()), (int)(equinox.getYCoord()-equinox.getRadius()),(int)( equinox.getRadius()*2),(int) (2*equinox.getRadius()));
			g.setColor(Color.BLUE);
			g.drawOval((int)(equinox.getXCoord()-equinox.getRadius()), (int)(equinox.getYCoord()-equinox.getRadius()),(int)( equinox.getRadius()*2),(int) (2*equinox.getRadius()));
			break;
		case 2:
			g.drawString("These balls inside of you are called MASS. The more MASS that are in the",-460,-200);
			g.drawString("EQUINOX, the larger the EQUINOX is. If the EQUINOX shrinks too small, you DIE.",-460,200);
			equinox.draw(g);
			break;
		case 3:
			g.drawString("These balls are called ENEMIES. Hungry, they will approach the EQUINOX. Once",-460,-220);
			g.drawString("they touch it, they will begin to siphon MASS out of the EQUINOX, growing as",-460,-170);
			g.drawString(" they steal it away, and causing the EQUINOX shrink as they do so. Once they",-460,180);
			g.drawString(" have taken their meal, they will drift away with the stolen MASS.",-460,230);
			equinox.draw(g);
			break;
		case 4:
			g.drawString("Luckily, the EQUINOX comes equipped with a MASS CANNON. This CANNON will",-460,-220);
			g.drawString("fire MASS out of the EQUINOX. If this MASS strikes an ENEMY, the ENEMY",-460,-170);
			g.drawString("will take damage. If an ENEMY runs out of HEALTH, it will DIE, releasing",-460,180);
			g.drawString("its MASS into the environment. Use 'A' and 'D' to move; use 'S' to fire!",-460,230);
			g.setColor(Color.RED);
			g.drawString("Try it out now!",-90,280);
			equinox.draw(g);
			massCannon.draw(g);
			break;
		case 5:
			g.drawString("The MASS CANNON is a powerful tool, but use it wisely because every MASS ",-460,-220);
			g.drawString("you fire is a MASS removed from the EQUINOX, and a step towards death.",-460,-170);
			g.drawString("You can also press the space bar to fire a shotgun blast of 5 MASS at a time,",-460,180);
			g.drawString("but remember that doing so will kill the EQUINOX more quickly than normal.",-460,230);
			equinox.draw(g);
			massCannon.draw(g);
			break;
		case 6:
			g.drawString("In order to stay alive, the EQUINOX must fire off its own MASS, which",-460,-220);
			g.drawString("causes it to slowly die. That is why it also comes equipped with a",-460,-170);
			g.drawString("GRAPPLE CANNON. The GRAPPLE CANNON is used to lasso in enemies and leech",-460,210);
			g.drawString("out their MASS. Aim and fire with the mouse!",-460,260);
			g.setColor(Color.RED);
			g.drawString("Try it out now!",80,260);
			equinox.draw(g);
			massCannon.draw(g);
			grappleCannon.draw(g);
			break;
		case 7:
			g.drawString("The GRAPPLE is a powerful but time consuming tool. Taking the right",-460, -210);
			g.drawString("shot could mean the difference between life and death!",-460, -170);
			equinox.draw(g);
			massCannon.draw(g);
			grappleCannon.draw(g);
			break;
		case 8:
			g.drawString("POWERUPS can also be GRAPPLED by the GRAPPLE CANNON. POWERUPS yeild useful",-460,-200);
			g.drawString("bonuses that aid the player in keeping the EQUINOX alive.",-460,-150);
			for(Entity e: listOfEntities)
			{
				if(e instanceof MassContainer)
					if(!((MassContainer)e instanceof Equinox) && !((MassContainer)e instanceof Enemy))
						e.draw(g);
			}
			g.setFont(new Font("Courier new", Font.BOLD, 20));
			g.setColor(Color.GREEN);
			g.drawString("D: increases damage dealt to ENEMIES by the MASS CANNON.",-460,0);
			g.drawString("G: increases grapple movement speed.",-460,50);
			g.drawString("T: increases transfer speed of MASS from ENEMIES to the EQUINOX.",-460,100);
			g.setColor(Color.WHITE);
			g.drawString("POWERUPS will only last for 20 shots of the MASS CANNON, and can be sucked",-460,150);
			g.drawString("away by ENEMIES, so make sure to keep grappling POWERUPS to keep an edge",-460,200);
			g.drawString("on those ENEMIES.",-460,250);
			break;
		
		}
	}
	
	public void update(double delta)
	{
		if(System.currentTimeMillis() - shakeTime > 20)
			shaking = false;
		for(UIComponent ui: listOfComponents)
			ui.update();
		if(page >= 2 && page <= 7)
		{
			for(int i=0; i<listOfEntities.size(); i++)
			{
				if(!listOfEntities.get(i).update(delta))
				{
					listOfEntities.remove(i);
					i--;
				}
			}
		}
		if(page >= 4 && page <= 7)
			massCannon.update(delta);
		if(page >= 6 && page <= 7)
			grappleCannon.update(delta);
		if(page == 8)
		{
			for(Entity e: listOfEntities)
			{
				if(e instanceof MassContainer)
					if(!((MassContainer)e instanceof Equinox) && !((MassContainer)e instanceof Enemy))
						e.update(delta);
			}
		}
	}
	
	public void setPage(int p){page = p;}
	public int getPage(){return page;}
	public int getMaxPages(){return maxPages;}
}