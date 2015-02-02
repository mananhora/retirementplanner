import javax.swing.JFrame;
import javax.swing.SpringLayout;

import java.awt.*;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Graphics;
public class Test extends JPanel {
	static JFrame frame = new JFrame();

	public static void main(String[] args) {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 500);
		frame.setLocation(200,50);
		new RetirementPanel();
		frame.add(new RetirementPanel()); 		
		frame.setVisible(true);
	
		
		
	}

}
