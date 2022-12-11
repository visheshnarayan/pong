/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 12/12/22
 * -----------------------------------------------------------
 * Block tester class
 * version 1
 * -----------------------------------------------------------
 * Creates BlockTestOne class
 * -----------------------------------------------------------
 */
import static java.lang.System.*;
import java.awt.Color;

class BlockTestOne {
	public static void main(String args[]) {
		/**
		 * one
		 * no arguments
		 */
		Block one = new Block();
		out.println(one);

		/**
		 * two
		 * no color
		 */
		Block two = new Block(50, 50, 30 ,30);
		out.println(two);

		/**
		 * three
		 * all arguments
		 */
		Block three = new Block(350, 350, 15, 15, Color.RED);
		out.println(three);

		/**
		 * four
		 * all arguments
		 */
		Block four = new Block(450, 50, 20, 60, Color.GREEN);
		out.println(four);
		
		/**
		 * equals method tester
		 */
		out.println(one.equals(two)); // false
		out.println(one.equals(one)); // true
	}
}