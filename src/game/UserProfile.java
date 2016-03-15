package game;
import java.io.Serializable;

public class UserProfile implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String userName;
//	private String alias;
	
	public UserProfile(String name)
	{
		userName = name;
	}
	
	public String getName(){return userName;}
}