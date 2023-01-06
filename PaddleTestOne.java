/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 1/5/23
 * -----------------------------------------------------------
 * PaddleTestOne
 * Tests constructors and equals()
 * -----------------------------------------------------------
 * Runs Pong game files
 * -----------------------------------------------------------
 */
import static java.lang.System.*;
import java.awt.Color;

class PaddleTestOne {
	public static void main( String args[] ) {
		Paddle one = new Paddle();
		out.println(one);
		
		Paddle two = new Paddle(100,90);
		out.println(two);
		
		Paddle three = new Paddle(100,100,30);
		out.println(three);
		
		Paddle four = new Paddle(100,100,30,50,8);
		out.println(four);
		
		Paddle five = new Paddle(100,100,30,20, Color.GREEN,6);
		out.println(five);
		
		
		out.println(five.equals(four));		
		
		out.println(five.equals(five));										
	}
}