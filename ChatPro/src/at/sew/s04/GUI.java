package at.sew.s04;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * JFrame
 * 
 * @author Seyyid Tiryaki
 * @version 16.11.2014
 */
public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Initialisiert das JFrame
	 * 
	 * @param v
	 *            View
	 */
	public GUI(View v) {
		Container c = this.getContentPane();
		this.setSize(new Dimension(1000, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.add(v);
		setTitle("Chat");
		this.setLocationRelativeTo(null);
		this.getRootPane().setDefaultButton(v.getBSend());
		setVisible(true);
	}
}
