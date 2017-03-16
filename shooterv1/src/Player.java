//Dustin Ledbetter
//player code for game


//imports
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

//main class: Player; which uses GameObject
public class Player extends GameObject{
	
	//constructor for player
	// --the "final" aren't necessary,as they don't change anyway, but can have them
	// --X is horizontal. starts at left as 0, then as go right # increases
	// --Y is vertical. starts at top as 0, then as go down # increases
	// --this. looks in entire class for matching variable outside of constructor
	//--when type /**, then hit enter above the constructor it auto makes comment like below
	/**
	 * 
	 * @param xPos
	 * @param yPos
	 * @param width
	 * @param height
	 * @param health
	 * @param img
	 */
	public Player(final int xPos, final int yPos, final int width, final int height, final int health,final String img)
	{
		
		//constructor variables
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.health = health;
		this.rect = new Rectangle(xPos, yPos, width, height);
		this.img = getImage(img);
	
	}
	
	//used to draw player in game
	@Override
	public void draw(Graphics g)
	{
		g.drawImage(img, xPos, yPos, width, height, null);
	}
	
	//to update game
	@Override
	void update(final Shooter shooter, final int id) 
	{
	
		//player 1 update
		if (id == 1)
		{
			//update the going up direction
			if(shooter.isPlayer1Up())
			{
				if(!(yPos < 26))
				{
					yPos --;
					rect.y --;
				}
			}
			//update the going down direction
			else if(shooter.isPlayer1Down())
			{	
			    if(!(yPos > shooter.getHeight() - 96))
				{
					yPos ++;
					rect.y ++;
				}
			}
		}
		
		//player 2 update
		if (id == 2)
		{
			//update the going up direction
			if(shooter.isPlayer2Up())
			{
				if(!(yPos < 26))
				{
					yPos --;
					rect.y --;
				}
			}
			//update the going down direction
			else if(shooter.isPlayer2Down())
			{	
			    if(!(yPos > shooter.getHeight() - 96))
				{
					yPos ++;
					rect.y ++;
				}
			}
		}
	}

	//to add image in game
	@Override
	Image getImage(String img) 
	{
		return Toolkit.getDefaultToolkit().getImage(img);
	}
	
}


		