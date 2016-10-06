import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;



@SuppressWarnings("serial")
public class PongPanel extends JPanel implements ActionListener, KeyListener
{
	//declaring initial conditions for title screen window
	private boolean showTitleScreen = true;
	private boolean playing = false;
	private boolean gameOver = false;
	private Color purple =  new Color(169, 41, 224);
	private Color hotPink = new Color(250, 16, 81);
	private Color importantToLife = purple;



	//declare dem booleans!!
	public boolean flag11;
	public boolean flag12;
	public boolean flag13;
	public boolean flag21;
	public boolean flag22;
	public boolean flag23;
	public boolean flagRainbow;

	//Rainbow colors
	int red = 1;
	int green = 15;
	int blue = 200;


	//TIMER 1 player 1 YOY;
	Timer timer11;
	public ActionListener actListener11 = new ActionListener()//This is the actionListener for the timer
	{
		@Override
		public void actionPerformed(ActionEvent event) //We will perform an action when the timer runs out
		{
			playerOneHeight = 50;
			powerUpArcPlayerOneOneY = powerUpArcPlayerOneOneY - 1000;
			flag11 = false;
			timer11.stop();
		}
	};

	//rainbow timer
	Timer timerRainbow;
	ActionListener actListenerRainbow = new ActionListener()//This is the actionListener for the timer
	{
		@Override
		public void actionPerformed(ActionEvent event) //We will perform an action when the timer runs out
		{
			timerRainbow.start();
			red = (int)(1+255*Math.random());
			green = (int)(1+255*Math.random());
			blue = (int)(1+255*Math.random());
			importantToLife = new Color(red, green, blue);
			repaint();
			flagRainbow = true;

		}
	};



	//TIMER 2 player 1 YOY;
	Timer timer12;
	public ActionListener actListener12 = new ActionListener()//This is the actionListener for the timer
	{
		@Override
		public void actionPerformed(ActionEvent event) //We will perform an action when the timer runs out
		{
			playerOneHeight = 50;
			powerUpArcPlayerOneTwoY = powerUpArcPlayerOneTwoY - 1000;
			flag12 = false;
			timer12.stop();
		}
	};
	//TIMER 3 player 1 YOY;
	Timer timer13;
	public ActionListener actListener13 = new ActionListener()//This is the actionListener for the timer
	{
		@Override
		public void actionPerformed(ActionEvent event) //We will perform an action when the timer runs out
		{
			playerOneHeight = 50;
			powerUpArcPlayerOneThreeY = powerUpArcPlayerOneThreeY - 1000;
			flag13 = false;
			timer13.stop();
		}
	};  
	//TIMER 1 player 2 YOY;
	Timer timer21;
	public ActionListener actListener21 = new ActionListener()//This is the actionListener for the timer
	{
		@Override
		public void actionPerformed(ActionEvent event) //We will perform an action when the timer runs out
		{
			playerTwoHeight = 50;
			powerUpArcPlayerTwoThreeY = powerUpArcPlayerTwoThreeY - 1000;
			flag21 = false;
			timer21.stop();
		}
	};  
	//TIMER 2 player 2 YOY;
	Timer timer22;
	public ActionListener actListener22 = new ActionListener()//This is the actionListener for the timer
	{
		@Override
		public void actionPerformed(ActionEvent event) //We will perform an action when the timer runs out
		{
			playerTwoHeight = 50;
			powerUpArcPlayerTwoTwoY = powerUpArcPlayerTwoTwoY - 1000;
			flag22 = false;
			timer22.stop();
		}
	}; 
	//TIMER 3 player 2 YOY;
	Timer timer23;
	public ActionListener actListener23 = new ActionListener()//This is the actionListener for the timer
	{
		@Override
		public void actionPerformed(ActionEvent event) //We will perform an action when the timer runs out
		{
			playerTwoHeight = 50;
			powerUpArcPlayerTwoOneY = powerUpArcPlayerTwoOneY - 1000;
			flag23 = false;
			timer23.stop();
		}
	};  

	//initial conditions for movements 
	private boolean upPressed = false;
	private boolean downPressed = false;
	private boolean wPressed = false;
	private boolean sPressed = false;

	//power up conditions p1 1
	private int powerUpArcPlayerOneOneX = 25;
	private int powerUpArcPlayerOneOneY = 10;

	//power up conditions p1 2
	private int powerUpArcPlayerOneTwoX = 50;
	private int powerUpArcPlayerOneTwoY = 10;

	//power up conditions p1 3
	private int powerUpArcPlayerOneThreeX = 75;
	private int powerUpArcPlayerOneThreeY = 10;

	//power up conditions p2 1
	private int powerUpArcPlayerTwoOneY = 10;
	private int powerUpArcPlayerTwoOneX = 450;

	//power up conditions p2 2
	private int powerUpArcPlayerTwoTwoY = 10;
	private int powerUpArcPlayerTwoTwoX = 425;

	//power up conditions p2 3
	private int powerUpArcPlayerTwoThreeY = 10;
	private int powerUpArcPlayerTwoThreeX = 400;

	//general power up conditions
	private int powerUpArcWidth = 20;
	private int powerUpArcHeight = 20;
	private int powerUpArcStartAngle = 45;
	private int powerUpArcAngle = 300;

	//power up box p1 conditions
	private int powerUpRectanglePlayerOneX = 10;
	private int powerUpRectanglePlayerOneY = 5;

	//power up box p2 conditions
	private int powerUpRectanglePlayerTwoX = 380;
	private int powerUpRectanglePlayerTwoY = 5;

	//power up box general conditions
	private int powerUpRectangleWidth = 100;
	private int powerUpRectangleHeight = 30;

	//initial conditions for ball
	//x and y starting ball position
	private int ballX = 175;
	private int ballY = 175;

	//movement and size conditions
	private int diameter = 10;
	private int ballDeltaX = -1;
	private int ballDeltaY = 3;

	//initial conditions for player 1
	// X and Y coordinates
	private int playerOneX = 25;
	private int playerOneY = 250;

	//Size conditions for paddle
	private int playerOneWidth = 10;
	private int playerOneHeight = 50;


	//initial conditions for player 2
	//X and Y coordinates
	private int playerTwoX = 465;
	private int playerTwoY = 250;
	

	//Size Conditions of paddle
	private int playerTwoWidth = 10;
	private int playerTwoHeight = 50;

	//paddle speed
	private int paddleSpeed = 7;

	//initial score
	private int playerOneScore = 0;
	private int playerTwoScore = 0;


	//construct pong panel
	public PongPanel()
	{
		setBackground(Color.BLACK);

		//act upon pressing certain keys
		setFocusable(true);
		addKeyListener(this);

		//call step() 60 fps
		Timer timer = new Timer(1000/60, this);
		timer.start();

		timer11 = new Timer (20000, actListener11);
		timer12 = new Timer (30000, actListener12);
		timer13 = new Timer (40000, actListener13);
		timer21 = new Timer (40000, actListener21);
		timer22 = new Timer (30000, actListener22);
		timer23 = new Timer (20000, actListener23);
		timerRainbow = new Timer (75, actListenerRainbow);

	}

	public void actionPerformed(ActionEvent e)
	{
		step();
	}
	public void step()
	{
		if(playing)
		{//set buttons for movement
			if(wPressed)
			{
				if(playerOneY-paddleSpeed > 0)
				{
					playerOneY -= paddleSpeed;
				}
			}
			if(sPressed)
			{
				if(playerOneY + paddleSpeed + playerOneHeight < getHeight())
				{
					playerOneY += paddleSpeed;
				}
			}
			//move player 2
			if(upPressed)
			{//button movement conditions for p2
				if(playerTwoY-paddleSpeed > 0)
				{
					playerTwoY -= paddleSpeed;
				}
			}
			if(downPressed)
			{
				if(playerTwoY + paddleSpeed + playerTwoHeight < getHeight())
				{
					playerTwoY += paddleSpeed;
				}
			}


			//ball movement continues
			int nextBallLeft = ballX + ballDeltaX;
			int nextBallRight = ballX + diameter + ballDeltaX;
			int nextBallTop = ballY + ballDeltaY;
			int nextBallBottom = ballY + diameter + ballDeltaY;
			int color;

			int playerOneRight = playerOneX + playerOneWidth;
			int playerOneTop = playerOneY;
			int playerOneBottom = playerOneY + playerOneHeight;

			float playerTwoLeft = playerTwoX;
			float playerTwoTop = playerTwoY;
			float playerTwoBottom = playerTwoY + playerTwoHeight;


			//if statement for ball bounce boundaries
			if(nextBallTop < 0 || nextBallBottom > getHeight())
			{
				ballDeltaY *= -1;
			}
			//if ball goes off of left side, p2 gets point
			if(nextBallLeft < playerOneRight)
			{
				//make sure it happens only when paddle is missed
				if(nextBallTop > playerOneBottom || nextBallBottom < playerOneTop)
				{
					//ADD TO P2 SCORE
					playerTwoScore++;
					color = (int)(1+12*Math.random());
					if(color == 1)
					{
						importantToLife = Color.BLUE;	
					}
					if(color == 2)
					{
						importantToLife = Color.CYAN;	
					}
					if(color == 3)
					{
						importantToLife = purple;	
					}
					if(color == 4)
					{
						importantToLife = hotPink;	
					}
					if(color == 5)
					{
						importantToLife = Color.GREEN;	
					}
					if(color == 6)
					{
						importantToLife = Color.LIGHT_GRAY;	
					}
					if(color == 7)
					{
						importantToLife = Color.MAGENTA;	
					}
					if(color == 8)
					{
						importantToLife = Color.ORANGE;	
					}
					if(color == 9)
					{
						importantToLife = Color.PINK;	
					}
					if(color == 10)
					{
						importantToLife = Color.RED;	
					}
					if(color == 11)
					{
						importantToLife = Color.WHITE;	
					}
					if(color == 12)
					{
						importantToLife = Color.YELLOW;	
					}
					repaint();

					if(playerTwoScore == 10)
					{
						playing = false;
						gameOver = true;
					}

					ballX = 250;
					ballY = 250;
				}
				else
				{
					ballDeltaX *= -1;
				}
			}
			if(nextBallRight > playerTwoLeft)
			{
				if(nextBallTop > playerTwoBottom || nextBallBottom < playerTwoTop)
				{
					playerOneScore++;
					color = (int)(1+12*Math.random());
					if(color == 1)
					{
						importantToLife = Color.BLUE;	
					}
					if(color == 2)
					{
						importantToLife = Color.CYAN;	
					}
					if(color == 3)
					{
						importantToLife = purple;	
					}
					if(color == 4)
					{
						importantToLife = hotPink;	
					}
					if(color == 5)
					{
						importantToLife = Color.GREEN;	
					}
					if(color == 6)
					{
						importantToLife = Color.LIGHT_GRAY;	
					}
					if(color == 7)
					{
						importantToLife = Color.MAGENTA;	
					}
					if(color == 8)
					{
						importantToLife = Color.ORANGE;	
					}
					if(color == 9)
					{
						importantToLife = Color.PINK;	
					}
					if(color == 10)
					{
						importantToLife = Color.RED;	
					}
					if(color == 11)
					{
						importantToLife = Color.WHITE;	
					}
					if(color == 12)
					{
						importantToLife = Color.YELLOW;	
					}
					repaint();

					if(playerOneScore == 10)
					{
						playing = false;
						gameOver = true;
					}

					ballX = 250;
					ballY = 250;

				}
				else
				{
					ballDeltaX *= -1;
				}

			}



			//move the ball
			ballX += ballDeltaX*2;
			ballY += ballDeltaY*2;
		}
		repaint();
	}
	//paint game screen (make it pretty)
	public void paintComponent(Graphics g)
	{

		super.paintComponent(g);
		g.setColor(importantToLife);


		if(showTitleScreen)
		{

			g.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
			g.drawString("LETS PLAY PONG!!!!! XD", 165, 100 );

			g.setFont(new Font(Font.DIALOG, Font.BOLD, 18));

			g.drawString("Press 'p' to play!", 175, 300);
		}
		else if(playing)
		{
			int playerOneRight = playerOneX + playerOneWidth;
			int playerTwoLeft = playerTwoX;

			//draw midpoint line down center
			for(int lineY = 0; lineY < getHeight(); lineY += 50)
			{
				g.drawLine(250, lineY, 250, lineY+25);
			}

			//draw goal lines on each side
			g.drawLine(playerOneRight, 0, playerOneRight, getHeight());
			g.drawLine(playerTwoLeft, 0, playerTwoLeft, getHeight());

			//draw the scores
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 32));
			g.drawString(String.valueOf(playerOneScore), 100, 100);
			g.drawString(String.valueOf(playerTwoScore), 400, 100);

			//draw the power ups
			g.fillArc(powerUpArcPlayerOneOneX, powerUpArcPlayerOneOneY, powerUpArcWidth, powerUpArcHeight, powerUpArcStartAngle, powerUpArcAngle);
			g.fillArc(powerUpArcPlayerOneTwoX, powerUpArcPlayerOneTwoY, powerUpArcWidth, powerUpArcHeight, powerUpArcStartAngle, powerUpArcAngle);
			g.fillArc(powerUpArcPlayerOneThreeX, powerUpArcPlayerOneThreeY, powerUpArcWidth, powerUpArcHeight, powerUpArcStartAngle, powerUpArcAngle);
			g.fillArc(powerUpArcPlayerTwoOneX, powerUpArcPlayerTwoOneY, powerUpArcWidth, powerUpArcHeight, powerUpArcStartAngle, powerUpArcAngle);
			g.fillArc(powerUpArcPlayerTwoTwoX, powerUpArcPlayerTwoTwoY, powerUpArcWidth, powerUpArcHeight, powerUpArcStartAngle, powerUpArcAngle);
			g.fillArc(powerUpArcPlayerTwoThreeX, powerUpArcPlayerTwoThreeY, powerUpArcWidth, powerUpArcHeight, powerUpArcStartAngle, powerUpArcAngle);

			//draw power up boxes
			g.drawRect(powerUpRectanglePlayerOneX, powerUpRectanglePlayerOneY, powerUpRectangleWidth, powerUpRectangleHeight);
			g.drawRect(powerUpRectanglePlayerTwoX, powerUpRectanglePlayerTwoY, powerUpRectangleWidth, powerUpRectangleHeight);

			//draw the ball
			g.fillOval(ballX, ballY, diameter, diameter);

			//draw the paddle 
			g.fillRect(playerOneX, playerOneY, playerOneWidth, playerOneHeight);
			g.fillRect(playerTwoX, playerTwoY, playerTwoWidth, playerTwoHeight);
		}
		else if(gameOver)
		{
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
			g.drawString(String.valueOf(playerOneScore), 100, 100);
			g.drawString(String.valueOf(playerTwoScore), 400, 100);

			g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));

			if(playerOneScore > playerTwoScore)
			{
				g.drawString("Player One Wins!!! XDDD", 30, 220);
			}
			else
			{
				g.drawString("Player Two Wins!!! XDDD", 30, 220);
			}
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
			g.drawString("Press space to restart...", 150, 400);
		}
	}
	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e)
	{
		if(showTitleScreen)
		{
			if(e.getKeyCode() == KeyEvent.VK_P)
			{
				showTitleScreen = false;
				playing = true;
				powerUpArcPlayerOneOneY = 10;
				powerUpArcPlayerOneTwoY = 10;
				powerUpArcPlayerOneThreeY = 10;
				powerUpArcPlayerTwoOneY = 10;
				powerUpArcPlayerTwoTwoY = 10;
				powerUpArcPlayerTwoThreeY = 10;
				playerOneHeight = 50;
				playerTwoHeight = 50;


			}
		}
		else if (playing)
		{
			if(e.getKeyCode() == KeyEvent.VK_UP)
			{
				upPressed = true;
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				downPressed = true;
			}
			else if(e.getKeyCode() == KeyEvent.VK_W)
			{
				wPressed = true;
			}
			else if(e.getKeyCode() == KeyEvent.VK_S)
			{
				sPressed = true;
			}
			else if(e.getKeyCode() == KeyEvent.VK_A)
			{			
				playerOneHeight = 500;
			}
			else if(e.getKeyCode() == KeyEvent.VK_LEFT)
			{			
				playerTwoHeight = 500;
			}
			else if(e.getKeyCode() == KeyEvent.VK_L)
			{			
				playerOneHeight = 50;
				playerTwoHeight = 50;
			}
			else if(e.getKeyCode() == KeyEvent.VK_R)
			{
				timerRainbow.start();
			}
			else if(e.getKeyCode() == KeyEvent.VK_F)
			{

				importantToLife = purple;
				flagRainbow = false;
				timerRainbow.stop();

			}

			else if(e.getKeyCode() == KeyEvent.VK_1)
			{
				if(!flag11)
				{
					//use power up code
					timer11.start();
					playerOneHeight = 80;
					powerUpArcPlayerOneOneY = powerUpArcPlayerOneOneY + 1000;
					flag11 = true;
				}
			}
			else if(e.getKeyCode() == KeyEvent.VK_2)
			{
				if(!flag12)
				{
					//use power up code
					timer12.start();
					playerOneHeight = 100;
					powerUpArcPlayerOneTwoY = powerUpArcPlayerOneTwoY + 1000;
					flag12 = true;
				}
			}
			else if(e.getKeyCode() == KeyEvent.VK_3)
			{

				if(!flag13)
				{
					//use power up code
					timer13.start();
					playerOneHeight = 150;
					powerUpArcPlayerOneThreeY = powerUpArcPlayerOneThreeY + 1000;
					flag13 = true;
				}
			}

			else if(e.getKeyCode() == KeyEvent.VK_8)
			{

				if(!flag21)
				{
					//use power up code
					timer21.start();
					playerTwoHeight = 80;
					powerUpArcPlayerTwoThreeY = powerUpArcPlayerTwoThreeY + 1000;
					flag21 = true;
				}
			}
			else if(e.getKeyCode() == KeyEvent.VK_9)
			{

				if(!flag22)
				{
					//use power up code
					timer22.start();
					playerTwoHeight = 100;
					powerUpArcPlayerTwoTwoY = powerUpArcPlayerTwoTwoY + 1000;
					flag22 = true;
				}
			}
			else if(e.getKeyCode() == KeyEvent.VK_0)
			{

				if(!flag23)
				{
					//use power up code
					timer23.start();
					playerTwoHeight = 150;
					powerUpArcPlayerTwoOneY = powerUpArcPlayerTwoOneY + 1000;
					flag23 = true;
				}
			}
		}
		else if(gameOver)
		{
			if(e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				gameOver = false;
				showTitleScreen = true;

				playerOneY = 250;
				playerTwoY = 250;

				ballX = 250;
				ballY = 250;

				playerOneScore = 0;
				playerTwoScore = 0;
			}
		}
	}

	public void keyReleased(KeyEvent e)
	{
		if(playing)
		{
			if(e.getKeyCode() == KeyEvent.VK_UP)
			{
				upPressed = false;
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				downPressed = false;
			}
			else if(e.getKeyCode() == KeyEvent.VK_W)
			{
				wPressed = false;
			}
			else if(e.getKeyCode() == KeyEvent.VK_S)
			{
				sPressed = false;
			}
		}
	}


}


