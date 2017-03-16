//dustin ledbetter
//code used in both bullets and players

//imports
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Rectangle;

//main class: GameObject 
// --abstract class means can't be an instantiated 
public abstract class GameObject {
	
	//data variables
	protected Rectangle rect;
	protected int xPos;
	protected int yPos;
	protected int width;
	protected int height;
	protected int health;
	//object variables
	protected Image img;
	
	//abstract methods since aren't being used to create and instance can end with no {}
	abstract void draw(Graphics g);

	abstract void update(final Shooter shooter, final int id);
	
	abstract Image getImage(String img);
	
	//xPos getter and setter
	public int getxPos() 
	{
		return xPos;
	}
	public void setxPos(int xPos) 
	{
		this.xPos = xPos;
	}

	//yPos getter and setter
	public int getyPos() 
	{
		return yPos;
	}
	public void setyPos(int yPos) 
	{
		this.yPos = yPos;
	}

	//width getter and setter
	public int getWidth()
	{
		return width;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}

	//height getter and setter
		public int getHeight() 
		{
			return height;
		}
		public void setHeight(int height) 
		{
			this.height = height;
		}

	//health getter and setter
		public int getHealth()
		{
			return health;
		}
		public void setHealth(int health)
		{
			this.health = health;
		}

	//img getter and setter
	public Image getImg() 
	{
		return img;
	}
	public void setImg(Image img)
	{
		this.img = img;
	}
	
	
	
}
