/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 12/12/22
 * -----------------------------------------------------------
 * PaddleTestTwo
 * -----------------------------------------------------------
 * Tests graphical capabilities of Paddle
 * -----------------------------------------------------------
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Map;

public class PaddleTestTwo extends Canvas implements KeyListener, Runnable {
	
	/**
	 * private vars
	 */
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;

	// using Map instead of array
	Map<String, Boolean> keys;

	/**
	 * Constructor
	 */
	public PaddleTestTwo() {
		// game variables
		ball = new Ball(200, 200, 10, 10, Color.WHITE);
		leftPaddle = new Paddle(10, 10, 10, 40, Color.RED);
		rightPaddle = new Paddle(750, 10, 10, 40, Color.BLUE);
		
		// Map of keys ==> Stream 2D array of String, Boolean to Map<String, Boolean>
		keys = Stream.of(new Object[][] {
				{ "W", false }, 
				{ "Z", false }, 
				{ "I", false }, 
				{ "M", false }, 
			}
		).collect(Collectors.toMap(data -> (String) data[0], data -> (Boolean) data[1]));

		//set up the Canvas
		setBackground(Color.BLACK);
		setVisible(true);

		this.addKeyListener(this);
		new Thread(this).start();
	}
	
	/**
	 * updates windows to current conditions
	 */
	public void update(Graphics window) {
		paint(window);
	}

	/**
	 * draws objects in game
	 */
	public void paint(Graphics window)
	{
		ball.moveAndDraw(window);
		leftPaddle.draw(window);

		if(!(ball.getX()>=10 && ball.getX()<=750)) {
			ball.setXSpeed(-ball.getXSpeed());
		}
		if(!(ball.getY()>=10 && ball.getY()<=450)) {
			ball.setYSpeed(-ball.getYSpeed());
		}

		if(keys.get("W")) {
			// move left paddle up
			leftPaddle.moveUpAndDraw(window);
		}
		if(keys.get("Z")) {
			// move left paddle down
			leftPaddle.moveDownAndDraw(window);
		}
		if(keys.get("I")) {
			rightPaddle.moveUpAndDraw(window);
		}
		if(keys.get("M")) {
			rightPaddle.moveDownAndDraw(window);
		}
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
		}
	}

	/**
	 * empty function ==> for functionality
	 */
	public void keyTyped(KeyEvent e) {}
	
    public void run() {
		try {
			while(true) {
				Thread.sleep(8);
				repaint();
         	}
    	} catch (Exception e) {}
  	}		
}