//////////////////////////////////////
//Name: Dustin Ledbetter            //
//Date: 7-18-2016 and 3-16-2017     //
//Purpose: to create simple         //
//shooter mini-game                 //
//////////////////////////////////////

//imports
import javax.swing.JFrame; 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.CopyOnWriteArrayList;

//main class: Shooter; which uses JFrame
public class Shooter extends JFrame implements KeyListener{

	//variables
	//--to remove error message 
	private static final long serialVersionUID = 1L;
    private Player Player1;
    private Player Player2;
    private Image image;
    private Graphics graphics;
	private boolean Player1Up = false;
	private boolean Player1Down = false;
	private boolean Player2Up = false;
	private boolean Player2Down = false;
	//array used for having multiple bullets on the screen
	CopyOnWriteArrayList<Bullet> Bullets = new CopyOnWriteArrayList<Bullet>();
	
	//shooter constructor containing frame for game
	public Shooter()
	{
		setTitle("2d shooter game");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setBackground(Color.BLACK);
		//added so key pressed would be used in program shooter
		addKeyListener(this);
		//always put last in list of sets
		setVisible(true);
		
		//player = (id,x,y,width,height,health,image)
		Player1 = new Player(10,150,20,90,10,"src/images/player1.gif");
		Player2 = new Player(570,150,20,90,10,"src/images/player2.gif");
		
	}
	
	//constructor to be used to deal with screen graphics
	public void paint(Graphics g)
	{
		
		//set up image
		image = createImage(getWidth(),getHeight());
		//set up graphics
		graphics = image.getGraphics();
		//add graphics
		paintComponent(graphics);
		g.drawImage(image, 0, 0, null);
		//repaint for next moment
		repaint();

		
		/**
		 *--example of what can fill with 
		 *--to use uncomment the color import
		//to change color to white or other
		g.setColor(Color.white);
		//the title bar IS taken into height, so think when using.
		g.drawString("title",50,80);
        **/	
	}
	
	//used as a double buffer
	public void paintComponent(Graphics g)
	{
		
		//checks if player's health is above 0
		if(Player1.getHealth() > 0 && Player2.getHealth() > 0)
		{
			//drawing bullets on the screen and updating
			for(Bullet bullet: Bullets)
			{
				bullet.draw(g);
				bullet.update(this, 0);
			}
		}
		
		//if player 1's health = 0
		else if(Player1.getHealth() == 0)
		{
			g.setColor(Color.RED);
			g.drawString("Player 2 Wins", 250, 190);
		}
		
		//if player 2's health = 0
		else if(Player2.getHealth() == 0)
		{
			g.setColor(Color.RED);
			g.drawString("Player 1 Wins", 250, 190);
		}
		
		//draw and update player 1
		Player1.draw(g);
		Player1.update(this, 1);
		
		//draw and update player 2
		Player2.draw(g);
		Player2.update(this, 2);
	}
	
	//key pressed event constructor
	@Override
	public void keyPressed(KeyEvent e) 
	{
		
		//arrow button for up or down pressed for player 2
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
		Player2Up = true;	
		} 
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
		Player2Down = true;	
		}
		
		//letter key for w or s pressed for player 1
		else if(e.getKeyCode() == KeyEvent.VK_W)
		{
		Player1Up = true;	
		}
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
		Player1Down = true;	
		}
	}

	//key released event constructor
	@Override
	public void keyReleased(KeyEvent e)
	{
				
		//arrow button for up or down released for player 2
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
		Player2Up = false;	
		} 
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
		Player2Down = false;	
		}
		
		//letter key for w or s released for player 1
		else if(e.getKeyCode() == KeyEvent.VK_W)
		{
		Player1Up = false;	
		}
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
		Player1Down = false;	
		}
		
		//space button pressed for bullets from player 1
		else if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			Bullet Player1Bullet = new Bullet(Player2, 1, Player1.getxPos() + 20, Player1.getyPos() + 45, 4, 4, "src/images/Bullet.gif");
			Bullets.add(Player1Bullet);
		}
		
		//enter button pressed for bullets from player 1
		else if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			Bullet Player2Bullet = new Bullet(Player1, -1, Player2.getxPos() - 4, Player2.getyPos() + 45, 4, 4, "src/images/Bullet.gif");
			Bullets.add(Player2Bullet);			
		}
		
	}

	//key typed event constructor; unused
	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		//the ; means ended line and can be used, but isn't
		;
	}
	
	//Player1 getter and setter
	public Player getPlayer1() 
	{
		return Player1;
	}
	public void setPlayer1(Player player1)
	{
		Player1 = player1;
	}

	//Player2 getter and setter
	public Player getPlayer2()
	{
		return Player2;
	}
	public void setPlayer2(Player player2) 
	{
		Player2 = player2;
	}

	//getter and setter for Player1Up
	public boolean isPlayer1Up() 
	{
		return Player1Up;
	}
	public void setPlayer1Up(boolean player1Up) 
	{
		Player1Up = player1Up;
	}

	//getter and setter for Player1Down
	public boolean isPlayer1Down() 
	{
		return Player1Down;
	}
	public void setPlayer1Down(boolean player1Down)
	{
		Player1Down = player1Down;
	}

	//getter and setter for Player2Up
	public boolean isPlayer2Up() 
	{
		return Player2Up;
	}
	public void setPlayer2Up(boolean player2Up) 
	{
		Player2Up = player2Up;
	}

	//getter and setter for Player2Down
	public boolean isPlayer2Down() 
	{
		return Player2Down;
	}
	public void setPlayer2Down(boolean player2Down)
	{
		Player2Down = player2Down;
	}

	//main method that then runs shooter contructor which has game frame in it
	public static void main(String[] args)
	{
	 new Shooter();	
	}

	
	
}
