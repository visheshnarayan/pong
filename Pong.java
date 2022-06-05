/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 12/12/22
 * -----------------------------------------------------------
 * Pong
 * Manages Pong game
 * -----------------------------------------------------------
 * Creates Pong class
 * -----------------------------------------------------------
 */
import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;

public class Pong extends Canvas implements KeyListener, Runnable {
	/**
	 * private vars
	 */
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	Map<String, Boolean> keys;
	private BufferedImage back;

	int left;
	int right;

	// true - ball starts towards right, else left
	boolean turn;

	/**
	 * Constructor
	 */
	public Pong() {
		// game variables
		ball = new Ball(400, 200, 10, 10, Color.WHITE);
		leftPaddle = new Paddle(10, 10, 10, 40, Color.RED);
		rightPaddle = new Paddle(750, 10, 10, 40, Color.BLUE);
		
		// Map of keys ==> Stream 2D array of String, Boolean to Map<String, Boolean>
		keys = Stream.of(new Object[][] {
				{ "W", false }, 
				{ "Z", false }, 
				{ "I", false }, 
				{ "M", false },  

				/**
				 * X --> Make paddle size of screen
				 * S --> Stop the ball in air
				 * D --> Resume ball 
				 * A --> Track ball
				 * E --> Make blue paddle invisible (blue user can't see where paddle is) 
				 * G --> Shutdown whole computer (incase things get heated)
				 */
				
				{ "X", false }, 
				{ "S", false },
				{ "D", false },
				{ "A", false },
				{ "E", false },
				{ "G", false }
			}
		).collect(Collectors.toMap(data -> (String) data[0], data -> (Boolean) data[1]));

		// score
		left = 0;
		right = 0;
    
    	setBackground(Color.BLACK);
		setVisible(true);
		
		this.addKeyListener(this);
		new Thread(this).start();
	}
	
	/**
	 * updates window
	 */
    public void update(Graphics window) {
	   paint(window);
	}

	/**
	 * adds graphical elements
	 */
    public void paint(Graphics window) {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if (back==null) {
			back = (BufferedImage)(createImage(getWidth(), getHeight()));
		}

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		
		/**
		 * in bound vertically
		 */
		if (ball.didCollideLeft(window) || ball.didCollideRight(window)) {
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			ball.setColor(Color.BLACK);
			ball.moveAndDraw(graphToBack);
			if (ball.didCollideLeft(window)) {
				System.out.println("Right scores!");
				turn = false;
				right+=1;
			} else {
				System.out.println("Left scores!");
				turn = true;
				left+=1;
			}
			System.out.println("\nLeft: " + left + "\nRight: " + right + "\n");
			ball.setColor(Color.WHITE);
			ball.setPos(400, 200);
			
			if (turn) {
				ball.setXSpeed(-3);
			} else {
				ball.setXSpeed(3);
			}
			ball.setYSpeed(-1);
		}

		/**
		 * in bound horizontally
		 */
		if (ball.didCollideTop(window) || ball.didCollideBottom(window)) {
			ball.setYSpeed(-ball.getYSpeed());
		}

		/**
		 * check if ball is horizontally in line with left paddle
		 */
		boolean yLeft = ball.getY()>=leftPaddle.getY() &&
						ball.getY()<=leftPaddle.getY()+leftPaddle.getHeight() || 
						ball.getY()+ball.getHeight()>=leftPaddle.getY() && 
						ball.getY()+ball.getHeight()<leftPaddle.getY()+leftPaddle.getHeight();

		/**
		 * check if ball is horizontally in line with left paddle
		 */
		boolean yRight = ball.getY()>=rightPaddle.getY() &&
						 ball.getY()<=rightPaddle.getY()+rightPaddle.getHeight() || 
						 ball.getY()+ball.getHeight()>=rightPaddle.getY() && 
						 ball.getY()+ball.getHeight()<rightPaddle.getY()+rightPaddle.getHeight();
		
		/**
		 * check if ball is vertically in with left paddle
		 */
		boolean xLeft = ball.getX()<=leftPaddle.getX()+leftPaddle.getWidth()+Math.abs(ball.getXSpeed());

		/**
		 * check if ball is vertically in with right paddle
		 */
		boolean xRight = ball.getX()>=rightPaddle.getX()-rightPaddle.getWidth()+Math.abs(ball.getXSpeed());

		//see if the ball hits the left paddle
		if (xLeft && yLeft) {
			if (ball.getX()<=leftPaddle.getX()+leftPaddle.getWidth()-Math.abs(ball.getXSpeed())) {
				ball.setYSpeed(-ball.getYSpeed());
			} else {
				ball.setXSpeed(-ball.getXSpeed());
			}
		}

		//see if the ball hits the right paddle
		if (xRight && yRight) {
			if (ball.getX()>=leftPaddle.getX()-leftPaddle.getWidth()+Math.abs(ball.getXSpeed())) {
				ball.setXSpeed(-ball.getXSpeed());
			} else {
				ball.setYSpeed(-ball.getYSpeed());
			}
		}

		if (keys.get("W")) {
			// move left paddle up
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if (keys.get("Z")) {
			// move left paddle down
			leftPaddle.moveDownAndDraw(graphToBack);
		}
		if (keys.get("I")) {
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if (keys.get("M")) {
			rightPaddle.moveDownAndDraw(graphToBack);
		}

		// left paddle cheats

		// make paddle size of screen
		if (keys.get("X")) {
			leftPaddle.setWidth(30);
			leftPaddle.setHeight(450);
			leftPaddle.setPos(0, 0);
			leftPaddle.moveDownAndDraw(graphToBack);
		}

		// stop ball
		if (keys.get("S")) {
			ball.setXSpeed(0);
			ball.setYSpeed(0);
		}

		// resume ball at high speed towards blue
		if (keys.get("D")) {
			ball.setXSpeed(10);
			ball.setYSpeed(10);
		}

		// aim bot 
		if (keys.get("A")) {
			leftPaddle.setY(ball.getY());
			leftPaddle.moveDownAndDraw(graphToBack);
		}

		// invisible blue paddle 
		if (keys.get("E")) {
			rightPaddle.setColor(getBackground());
		}

		// shutdown 
		if (keys.get("G")) {
			shutdown();
		}
		twoDGraph.drawImage(back, null, 0, 0);
	}

	/**
	 * event listener for key press
	 */
	public void keyPressed(KeyEvent e) {
		switch(toUpperCase(e.getKeyChar())) {
			case 'W' : keys.replace("W", true); break;
			case 'Z' : keys.replace("Z", true); break;
			case 'I' : keys.replace("I", true); break;
			case 'M' : keys.replace("M", true); break;

			// cheats
			case 'X' : keys.replace("X", true); break;
			case 'S' : keys.replace("S", true); break;
			case 'D' : keys.replace("D", true); break;
			case 'A' : keys.replace("A", true); break;
			case 'E' : keys.replace("E", true); break;
			case 'G' : keys.replace("G", true); break;
		}
	}

	private void shutdown() {
		Runtime runtime = Runtime.getRuntime();
		try {
		   System.out.println("Shutting down the PC after 5 seconds.");
		   runtime.exec("shutdown -s -t 5");
		} catch(IOException e) {
		   System.out.println("Exception: " +e);
		}
	}

	/**
	 * event listener for key release
	 */
	public void keyReleased(KeyEvent e) {
		switch(toUpperCase(e.getKeyChar())) {
			case 'W' : keys.replace("W", false); break;
			case 'Z' : keys.replace("Z", false); break;
			case 'I' : keys.replace("I", false); break;
			case 'M' : keys.replace("M", false); break;

			// cheats
			case 'X' : keys.replace("X", false); break;
			case 'S' : keys.replace("S", false); break;
			case 'D' : keys.replace("D", false); break;
			case 'A' : keys.replace("A", false); break;
			case 'E' : keys.replace("E", false); break;
			case 'G' : keys.replace("G", false); break;
		}
	}

	/**
	 * empty function ==> for functionality
	 */
	public void keyTyped(KeyEvent e) {}
	
	/**
	 * refreshes screen for animation
	 */
	public void run() {
		try {
   			while(true) {
   				Thread.sleep(8);
            	repaint();
			}
      	} catch(Exception e) {}
  	}	
}