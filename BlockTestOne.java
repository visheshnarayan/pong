/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 12/12/22
 * -----------------------------------------------------------
 * Block tester class
 * version 1
 * AS OF 12/12/22 NOT NEEDED ==> USE Main.java
 * -----------------------------------------------------------
 * Creates BlockTestOne class
 * -----------------------------------------------------------
 */
import java.awt.Color;

class BlockTestOne {
	public static void main(String args[]) {
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
	}
}