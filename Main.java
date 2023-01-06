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
        // Paddle Test 1
        // testing Paddle constructors and equals()
        // ========================================================================//
        Paddle one = new Paddle();
		System.out.println(one);
		
		Paddle two = new Paddle(100, 90);
		System.out.println(two);
		
		Paddle three = new Paddle(100, 100, 30);
		System.out.println(three);
		
		Paddle four = new Paddle(100, 100, 30, 50, 8);
		System.out.println(four);
		
		Paddle five = new Paddle(100, 100, 30, 20, Color.GREEN, 6);
		System.out.println(five);
		
		System.out.println(five.equals(four));		
		System.out.println(five.equals(five));					

        // ========================================================================//
        // Paddle Test 2
        // testing run()
        // ========================================================================//
        new Tester();
    }
}