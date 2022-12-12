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
        // Block Test 1
        // testing Block.toString and Block.equals()
        // ========================================================================//
        /**
		 * one
		 * no arguments
		 */
		Block one = new Block();
		System.out.println(one);

		/**
		 * two
		 * no color
		 */
		Block two = new Block(50, 50, 30 ,30);
		System.out.println(two);

		/**
		 * three
		 * all arguments
		 */
		Block three = new Block(350, 350, 15, 15, Color.RED);
		System.out.println(three);

		/**
		 * four
		 * all arguments
		 */
		Block four = new Block(450, 50, 20, 60, Color.GREEN);
		System.out.println(four);
		
		/**
		 * equals method tester
		 */
		System.out.println(one.equals(two)); // false
		System.out.println(one.equals(one)); // true

        // ========================================================================//
        // Block Test 2
        // testing Block.draw() 
        // ========================================================================//
        Tester run = new Tester();
    }
}