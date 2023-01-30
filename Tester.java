/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 12/12/22
 * -----------------------------------------------------------
 * Block tester class
 * version 2
 * -----------------------------------------------------------
 * Creates BlockTestTwo class
 * -----------------------------------------------------------
 */
 
import javax.swing.JFrame;

public class Tester extends JFrame {
	/**
	 * private vars
	 */
	private static final int WIDTH = 775;
	private static final int HEIGHT = 500;

	/**
	 * Constructor
	 */
	public Tester() {
		super("PONG TESTER");
		setSize(WIDTH,HEIGHT);
		// getContentPane().add(new BlockTestTwo());
		// getContentPane().add(new BallTestTwo());
		Pong pong = new Pong();
		getContentPane().add(pong);
		pong.setFocusable(true);
		// PaddleTestTwo padTest = new PaddleTestTwo();
		// getContentPane().add(padTest);
		// padTest.setFocusable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * main method ==> test BlockTest2
	 * NOW IN MAIN.JAVA
	 * @param args
	 */
	// public static void main(String args[]) {
	// 	Tester run = new Tester();
	// }
}