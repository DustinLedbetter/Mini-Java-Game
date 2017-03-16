//dustin ledbetter
//used for bullets in game


//imports
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

//main class: bullet; which uses GameObject
public class Bullet extends GameObject{
	
	//variables
	//--will be used for making bullet go left or right; 1 = right -1 = left
	private int deltaX;
	private Player player; 
	
	//constructor for player
	// --the "final" aren't necessary,as they don't change anyway, but can have them
	// --X is horizontal. starts at left as 0, then as go right # increases
	// --Y is vertical. starts at top as 0, then as go down # increases
	// --this. looks in entire class for matching variable outside of constructor
	public Bullet(final Player player, final int deltaX, final int xPos, final int yPos, final int width, final int height, final String img)
	{
		
		//constructor variables
		this.player = player;
		this.deltaX = deltaX;
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.rect = new Rectangle(xPos, yPos, width, height);
		this.img = getImage(img);
		
	}

	//deltaX getter and setter
	public int getDeltaX() 
	{
		return deltaX;
	}
	public void setDeltaX(int deltaX) 
	{
		this.deltaX = deltaX;
	}

	//used to draw bullets in game
	@Override
	public void draw(Graphics g)
	{
		g.drawImage(img, xPos, yPos, width, height, null);
	}

	//to update game
	@Override
	void update(final Shooter shooter, final int id) 
	{
		//remove bullets if they hit the player
		if(rect.intersects(player.rect))
		{
			shooter.Bullets.remove(this);
			player.setHealth(player.getHealth() - 1);
		}
		
		//also remove bullets if they go past the player without hitting
		else if(xPos < 5 || xPos > 595)
		{
			shooter.Bullets.remove(this);	
		}
		
		//to make the bullets move forward for player 1
		else
		{
			xPos += deltaX;
			rect.x += deltaX;
		}
	}
	
	//to add image in game
	@Override
	Image getImage(String img) 
	{
		return Toolkit.getDefaultToolkit().getImage(img);
	}

	//Player getter and setter 
	public Player getPlayer()
	{
		return player;
	}
	public void setPlayer(Player player) 
	{
		this.player = player;
	}
	
	
	
}
