/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 1/5/23
 * -----------------------------------------------------------
 * Child class of Block
 * Simulates Paddle in Pong 
 * -----------------------------------------------------------
 * Creates Paddle class
 * -----------------------------------------------------------
 */
import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block {
    
    /**
     * private vars
     */
    private int speed;

    /**
     * Constructors
     */
    public Paddle() {
        super(10, 10);
        setSpeed(5);
    }

    public Paddle(int xPos, int yPos) {
        super(xPos, yPos);
        setSpeed(5);
      }
  
    public Paddle(int xPos, int yPos, int width) {
        super(xPos, yPos, width);
        setSpeed(5);
    }

    public Paddle(int xPos, int yPos, int width, int height) {
        super(xPos, yPos, width, height);
        setSpeed(5);
    }
     
    public Paddle(int xPos, int yPos, int width, int height, Color color) {
        super(xPos, yPos, width, height, color);
        setSpeed(5);
    }

    public Paddle(int xPos, int yPos, int width, int height, int speed) {
        super(xPos, yPos, width, height);
        setSpeed(speed);
    }

    public Paddle(int xPos, int yPos, int width, int height, Color color, int speed) {
        super(xPos, yPos, width, height, color);
        setSpeed(speed);
    }

    /**
     * Translates paddle upwards to simulate movement 
     * @param window
     */
    public void moveUpAndDraw(Graphics window) {
        // draw at old loc
        draw(window, getColor());
        draw(window, Color.BLACK);

        // update loc
        setPos(getX(), getY()-getSpeed());

        // display new loc
        draw(window, getColor());
    }

    /**
     * Translates paddle downwards to simulate movement 
     * @param window
     */
    public void moveDownAndDraw(Graphics window) {
        // draw at old loc
        draw(window, getColor());
        draw(window, Color.BLACK);

        // update loc
        setPos(getX(), getY()+getSpeed());

        // display new loc
        draw(window, getColor());
    }

    /**
     * returns Paddle speed
     * @return speed
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * sets speed to given value
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
	 * returns String of object if object is printed
	 */
    public String toString() {
        return super.toString()+"::"+getHeight();
    }
}