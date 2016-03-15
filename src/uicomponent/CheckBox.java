package uicomponent;
import game.*;
import java.awt.*;

public class CheckBox extends UIComponent
{
	private static final long serialVersionUID = 1L;
	private boolean checked;
	private String setting;
	
	public CheckBox(int xCoord, int yCoord, boolean checked, String setting)
	{
		super(xCoord,yCoord,50,50,true);
		if(setting!=null)
			this.checked = Game.settings.get(setting);
		this.setting = setting;
	}
	
	public CheckBox(int xCoord, int yCoord, boolean checked, String setting, boolean clickable)
	{
		this(xCoord,yCoord,checked,setting);
	}
	
	public void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(backgroundColor);
		g2d.fillRect((int)(xCoord-width/2), (int)(yCoord-height/2),width,height);
		g2d.setColor(textColor);
		g2d.setStroke(new BasicStroke(2));
		if(checked)
		{
			g.setColor(Color.WHITE);
			g.drawLine(xCoord-width/2, yCoord-height/2, xCoord+width/2, yCoord+height/2);
			g.drawLine(xCoord-width/2, yCoord+height/2, xCoord+width/2, yCoord-height/2);
		}
		g2d.setStroke(new BasicStroke(6));
		g2d.setColor(edgeColor);
		g2d.drawRect((int)(xCoord-width/2), (int)(yCoord-height/2),width,height);
	}

	public void update()
	{
		super.update();
		Game.settings.put(setting,checked);
	}
	
	public void click()
	{
		super.click();
		checked = !checked;
	}
	
	public boolean getChecked(){return checked;}
}