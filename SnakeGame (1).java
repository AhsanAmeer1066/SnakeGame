/*
 * Name: Ahsan and Elaine
 * Most recent edit: 2021-12-20
 * Description: ICS Final Culminating, Snake Game
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SnakeGame {
	public static void main(String[] args) {
		
		// Creates initial frame
		JFrame frame = new JFrame("Snake Game");
		frame.setSize(1200, 1200);
		frame.getContentPane().setBackground(Color.YELLOW); // Sets menu background
		frame.setLayout(null);
		Image img = Toolkit.getDefaultToolkit().getImage("E:\\rahul.jpg");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Creates Panel for main menu
		JPanel mainMenu = new JPanel();
		mainMenu.setBounds(350,250,550,550);
		mainMenu.setBackground(Color.YELLOW);
		((FlowLayout)mainMenu.getLayout()).setHgap(60);
		
		// Creates start button
		JButton start = new JButton("Start");
		start.setBounds(250, 200, 160, 60);
		start.setBackground(Color.white);
		
		// Creates title
		JLabel title_str = new JLabel("SNAKE GAME");
		title_str.setBounds(10, 200, 160, 60);
		title_str.setFont(new Font("Monospaced", Font.PLAIN, 80));
		
		// Creates rules button
		JButton rules = new JButton("Rules");
		rules.setBounds(250, 200, 160, 60);
		rules.setBackground(Color.white);
		
		mainMenu.add(title_str);
		mainMenu.add(start);
		mainMenu.add(rules);
		
		// Adds panel
		frame.add(mainMenu);
		
		frame.setVisible(true); // Sets frame to visible
		
		
		
		
		
	}
	
}

