package game;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Cursor;

public class GameApplet extends Applet
{
	private static final long serialVersionUID = 1L;
	public static Game game = new Game();
	
	public void init()
	{
		setSize(Game.WIDTH, Game.HEIGHT);
		setLayout(new BorderLayout());
		add(game, BorderLayout.CENTER);
	}
	
	public void start()
	{
		super.start();
		add(game);
		game.changeCursor(Cursor.CROSSHAIR_CURSOR);
		game.startGame();
	}
	
	public void stop()
	{
		game.stopGame();
	}
}