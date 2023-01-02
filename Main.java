/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 12/12/22
 * -----------------------------------------------------------
 * Tester/runner class
 * Merged version of Tester.java and BlockTestOne.java
 * For running tests in IDEs that require Main.java (Repl)
 * -----------------------------------------------------------
 * Runs Pong game files
 * -----------------------------------------------------------
 */
import java.awt.Color;

public class Main {
    public static void main(String [] args) {
        // ========================================================================//
        // BALL Test 1
        // testing Ball constructors and equals()
        // ========================================================================//
        Ball one = new Ball();
		System.out.println(one);
		
		Ball two = new Ball(100,90);
		System.out.println(two);
		
		Ball three = new Ball(100,100,30,50);
		System.out.println(three);
		
		Ball four = new Ball(100,100,30,50,Color.BLUE);
		System.out.println(four);
		
		Ball five = new Ball(100,100,30,50,Color.BLUE,5,6);
		System.out.println(five);
		
		Ball six = new Ball(100,100,30,50,Color.blue,5,6);
		System.out.println(six);		
		
		System.out.println(five.equals(four));		
		
		System.out.println(five.equals(five));										

        // ========================================================================//
        // Ball Test 2
        // testing run()
        // ========================================================================//
        BallTestTwo test = new BallTestTwo();
		test.run();
    }
}