package screen;
import entity.*;
import game.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import uicomponent.*;

public class Screen implements KeyListener, MouseListener
{
	protected ArrayList<Entity> listOfEntities = new ArrayList<Entity>();
	protected ArrayList<UIComponent> listOfComponents= new ArrayList<UIComponent>();
	public boolean shaking;
	public long shakeTime;
	
	
	public void update(double delta)
	{
		for(UIComponent ui : listOfComponents)
			ui.update();
		if(System.currentTimeMillis() - shakeTime > 20)
			shaking = false;
	}
	
	public void takeAction(MouseEvent me)
	{
		for(UIComponent ui: listOfComponents)
		{
			if(ui.contains(me.getX() - Game.WIDTH/2,me.getY()- Game.HEIGHT/2))
				ui.click();
		}
	}
	
	public void draw(Graphics g)
	{
		if(shaking)
			g.translate((int)Utility.negToPositive(6),(int) Utility.negToPositive(6));
		for(UIComponent ui: listOfComponents)
			ui.draw(g);
		
	}
	
	public void shakeScreen()
	{
		shaking = true;
		shakeTime = System.currentTimeMillis();
	}

	public void mouseClicked(MouseEvent e)
	{
	}

	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
	}

	public void mousePressed(MouseEvent e)
	{
	}

	public void mouseReleased(MouseEvent e)
	{
	}

	public void keyPressed(KeyEvent e)
	{
	}

	public void keyReleased(KeyEvent e)
	{
	}

	public void keyTyped(KeyEvent e)
	{
	}
	
	public ArrayList<UIComponent> getListOfComponents(){return listOfComponents;}
	public ArrayList<Entity> getListOfEntities(){return listOfEntities;}
}