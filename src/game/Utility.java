package game;
import java.awt.*;
import java.awt.image.*;

public class Utility
{
	public static double dist(double x1,double y1,double x2,double y2)
	{
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}
	
	public static double negToPositive(double d) 
	{
	    return (Math.random() * 2*d) - d;
	}
	
	public static Image makeColorTransparent(BufferedImage im, final Color color)
	{
    	ImageFilter filter = new RGBImageFilter()
	    	{
	    		public int markerRGB = color.getRGB() | 0xFF000000;
	    		public final int filterRGB(int x, int y, int rgb)
	    		{
	    			if ((rgb | 0xFF000000) == markerRGB)
	    				return 0x00FFFFFF & rgb;
	    			else
	    				return rgb;
	    		}
	    	};
    	ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
    	return Toolkit.getDefaultToolkit().createImage(ip);
    }
}