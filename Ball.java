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
import java.awt.Color;

public class Ball extends Block {
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
		super(200, 200, 5, 5);
		setXSpeed(3);
		setYSpeed(1);
	}

	public Ball(int xPos, int yPos) {
		super(xPos, yPos, 5, 5);
		setXSpeed(3);
		setYSpeed(1);
	}

	public Ball(int xPos, int yPos, int width, int height) {
		super(200, 200, width, height);
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
	
	/**
	 * displays ball movement
	 * @param window
	 */
	public void moveAndDraw(Graphics window) {
		// old loc 
		draw(window, Color.WHITE);
		
		// update loc
		setX(getX()+xSpeed);
		setY(getY()+ySpeed);

		// display new loc
		draw(window, Color.WHITE);
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