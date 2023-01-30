/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 12/12/22
 * -----------------------------------------------------------
 * Child class of Block
 * Simulates Ball in Pong 
 * -----------------------------------------------------------
 * Creates Ball class
 * -----------------------------------------------------------
 */
import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable {
	/**
	 * private vars
	 */
	private int xSpeed;
	private int ySpeed;

	/**
	 * Constructor
	 * Default position (200, 200)
	 * Default size 5 * 5
	 * Optional: length, height, xSpeed, ySpeed
	 */
	public Ball() {
		super(200, 200, 10, 10);
		setXSpeed(3);
		setYSpeed(1);
	}

	public Ball(int xPos, int yPos) {
		super(xPos, yPos, 10, 10);
		setXSpeed(3);
		setYSpeed(1);
	}

	public Ball(int xPos, int yPos, int width, int height) {
		super(xPos, yPos, width, height);
		setXSpeed(3);
		setYSpeed(1);
	}

	public Ball(int xPos, int yPos, int width, int height, Color color) {
		super(xPos, yPos, width, height, color);
		setXSpeed(3);
		setYSpeed(1);
	}

	public Ball(int xPos, int yPos, int width, int height, Color color, int xSpeed, int ySpeed) {
		super(xPos, yPos, width, height, color);
		setXSpeed(xSpeed);
		setYSpeed(ySpeed);
	}

	/**
	 * returns int xSpeed
	 * @return int
	 */
	public int getXSpeed() {
		return xSpeed;
	}

	/**
	 * returns int ySpeed
	 * @return int
	 */
	public int getYSpeed() {
		return ySpeed;
	}
	  
   /**
	* sets value of xSpeed
	* @param xSpeed
    */
	public void setXSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	/**
	 * sets value of ySpeed
	 * @param ySpeed
	 */
	public void setYSpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

	// did ball collide left side
	public boolean didCollideLeft(Object obj) {
		return getX()<=10;
	}

	// did ball collide right side
	public boolean didCollideRight(Object obj) {
		return getX()>=780;
	}

	public boolean didCollideTop(Object obj) {
		return getY()<=10;
	}

	public boolean didCollideBottom(Object obj) {
		return getY()>=450;
	}
	
	/**
	 * displays ball movement
	 * @param window
	 */
	public void moveAndDraw(Graphics window) {
		// draw ball at old loc 
		draw(window, getColor());
		draw(window, Color.BLACK);

		// update loc
		setPos(getX()+xSpeed, getY()+ySpeed);

		// draw ball at new loc
		draw(window, getColor());
	}
   
	/**
	 * checks if objects are equal with Block.equals() and checking Ball attributes
	 * @param obj
	 * @return
	 */
	public boolean equals(Ball obj) {
		return obj.toString().equals(toString());
	}

	/**
	 * returns String of object if object is printed
	 */
	public String toString() {
		return super.toString()+"::"+getXSpeed()+"::"+getYSpeed();
	}
}