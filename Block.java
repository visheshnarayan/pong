/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 12/12/22
 * -----------------------------------------------------------
 * Parent class of Paddle and Ball
 * Methods and attributes for movable pieces in game
 * -----------------------------------------------------------
 * Creates Block class
 * -----------------------------------------------------------
 */
import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable {
   /**
	 * private vars
	 */
   private int xPos;
   private int yPos;
   private int width;
   private int height;

	private Color color;

   /**
    * Constructor 
    * No arguments --> defaults to position(0,0) and dimensions(10,10)
    * No Color --> defaults to white
    */
	public Block() {
      setX(10);
      setY(20);
      setWidth(30);
      setHeight(40);
      setColor(Color.WHITE);
	}

	public Block(int xPos, int yPos) {
      setX(xPos);
      setY(yPos);
      setWidth(30);
      setHeight(40);
      setColor(Color.WHITE);
	}

	public Block(int xPos, int yPos, int width) {
      setX(xPos);
      setY(yPos);
      setWidth(width);
      setHeight(40);
      setColor(Color.WHITE);
   }

	public Block(int xPos, int yPos, int width, int height) {
      setX(xPos);
      setY(yPos);
      setWidth(width);
      setHeight(height);
      setColor(Color.WHITE);
   }
   
	public Block(int xPos, int yPos, int width, int height, Color color) {
      setX(xPos);
      setY(yPos);
      setWidth(width);
      setHeight(height);
      setColor(color);
   }

   /**
    * returns current color
    * @return Color
    */
   public Color getColor() {
      return this.color;
   }

   /**
    * returns current x position
    * @return int
    */
   public int getX() {
      return this.xPos;
   }

   /**
    * returns current y position
    * @return int
    */
   public int getY() {
      return this.yPos;
   }

   /**
    * returns current width
    * @return int
    */
   public int getWidth() {
      return this.width;
   }

   /**
    * returns current height
    * @return int
    */
   public int getHeight() {
      return this.height;
   }

   /**
    * sets color to given Color.COLOR (Color.BLACK, Color.BLUE ==> see java.awt.Color documentation for all types)
    * @param col
    * @return void
    */
   public void setColor(Color col) {
      this.color = col;
   }

   /**
    * sets x position to given x-coordinate (integer)
    * @param xPos
    * @return void
    */
   public void setX(int xPos) {
      this.xPos = xPos;
   }

   /**
    * sets y position to given y-coordinate (integer)
    * @param yPos
    * @return void
    */
   public void setY(int yPos) {
      this.yPos = yPos;
   }

   /**
    * Locatable implemented method ==> sets x and y positions
    * @param xPos
    * @param yPos
    */
   public void setPos(int xPos, int yPos) {
      setX(xPos);
      setY(yPos);
   }

   /**
    * sets width to given width (integer)
    * @param width
    * @return void
    */
   public void setWidth(int width) {
      this.width = width;
   }

   /**
    * sets height to given height (integer)
    * @param height
    * @return void
    */
   public void setHeight(int height) {
      this.height = height;
   }

   /**
    * creates window and sets position and color attributes
    * @param window
    */
   public void draw(Graphics window) {
      window.setColor(getColor());
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }


   /**
    * creates window and sets position and color attributes
    * @param window
    * @param col
    */
   public void draw(Graphics window, Color col) {
      window.setColor(col);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
   /**
    * checks if both objects are equal by adding attributes to HashSet and checking if size==5 (number of attributes for Block object)
    * @param block
    * @return
    */
	public boolean equals(Block block) {
      return block.toString().equals(toString());
	}

   /**
    * returns string when object printed
    */
   public String toString() {
      // x::y::w::h::c
      String out = getX()+"::"+getY()+"::"+getWidth()+"::"+getHeight()+"::"+getColor();
      return out;
   }
}