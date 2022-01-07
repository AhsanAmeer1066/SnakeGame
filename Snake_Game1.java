import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
public class Snake_Game1 extends JFrame{
	
	JLabel L1;
	
	public Snake_Game1() {
		setSize(1200, 1200);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
	
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\catel\\OneDrive\\Desktop\\ICS3U7\\Snake_Game1\\Background.jpg")));
		setLayout(new FlowLayout());
		L1 = new JLabel();
		add(L1);
		setSize(1200, 1200);
	}
	
	
	public static void main(String[]args) {
		
		JFrame frame = new JFrame("Snake Game");

		new Snake_Game1();
	}

}
