/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 12/12/22
 * -----------------------------------------------------------
 * BallTestTwo
 * Tests graphical capabilities of Ball class
 * -----------------------------------------------------------
 * Creates testing class
 * -----------------------------------------------------------
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

class BallTestTwo extends Canvas implements Runnable {
	/**
	 * private vars
	 */
	private Ball ball;

	/**
	 * Constructor
	 */
	public BallTestTwo() {
		// create canvas
		setBackground(Color.BLACK);
		setVisible(true);

		// new Ball
		this.ball = new Ball();

		// print current state of ball
		System.out.println(ball);

		// change attributes
		ball.setX(4);
		ball.setY(4);
		ball.setHeight(4);
		ball.setWidth(4);
		ball.setColor(Color.CYAN);
		ball.setXSpeed(4);
		ball.setYSpeed(4);

		// print new state
		System.out.println(ball);

		// constructors test
		ball = new Ball(100,90);
		ball = new Ball(100,100,30,50);
		ball = new Ball(100,100,30,50,Color.BLUE);
		ball = new Ball(100,100,30,50,Color.BLUE,5,6);

		// change to testing ball
		ball = new Ball();

		// start thread ==> used as timer for movement loop
		new Thread(this).start();
	}
	
	/**
	 * Updates window
	 */
	public void update(Graphics window) {
		paint(window);
	}

	/**
	 * Simulates movement in window
	 */
	public void paint(Graphics window) {
		ball.moveAndDraw(window);

		// if ball out of bounds ==> flip speed
		if(!(ball.getX()>=10 && ball.getX()<=550)) {
			ball.setXSpeed(-ball.getXSpeed());
		}

		if(!(ball.getY()>=10 && ball.getY()<=450)) {
			ball.setYSpeed(-ball.getYSpeed());
		}
	}
	
	/**
	 * runs tester
	 */
	public void run() {
		// error handling
   		try {
   			while(true) {
				// pause thread and update (repaint)
				Thread.sleep(19);
				repaint();
         	}	
      	} catch(Exception e) {
			System.out.println("Thread failed at "+Thread.currentThread().getState());
		}
  	}	
}