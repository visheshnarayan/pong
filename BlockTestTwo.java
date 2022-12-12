/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 12/12/22
 * -----------------------------------------------------------
 * Block tester class
 * version 2
 * AS OF 12/12/22 NOT NEEDED ==> USE Main.java
 * -----------------------------------------------------------
 * Creates BlockTestTwo class
 * -----------------------------------------------------------
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

public class BlockTestTwo extends Canvas
{

	/**
	 * Constructor
	 */
	public BlockTestTwo() {
		setBackground(Color.WHITE);
	}

	/**
	 * creates and modifies blocks
	 * @param window
	 */
	public void paint(Graphics window) {
		Block one = new Block();
		one.draw(window);

		Block two = new Block(50,50,30,30);
		two.draw(window);

		Block three = new Block(350,350,15,15,Color.RED);
		three.draw(window);

		two.draw(window, Color.white);

		Block four = new Block(450,50,20,60, Color.GREEN);
		four.draw(window);
	}
}