/*
 * Name: Ahsan and Elaine
 * Most recent edit: 2021-12-20
 * Description: ICS Final Culminating, Snake Game
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

class SnakeGame {
	
	public static JFrame frame = new JFrame("Snake Game"); // Initializes frame


	public static void main(String[] args) {
		
		// Creates initial frame
		frame.setSize(1200, 700);
		frame.getContentPane().setBackground(Color.YELLOW); // Sets menu background
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); // Sets frame to visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initial(); // Calls initial startup
	}
	
	public static void initial() {
		// Creates Panel for main menu
		JPanel mainMenu = new JPanel();
		mainMenu.setBounds(360,150,650,550);
		mainMenu.setBackground(Color.YELLOW);
		((FlowLayout)mainMenu.getLayout()).setHgap(60);

		// Creates start button
		JButton start = new JButton("Start");
		start.setBounds(60, 200, 160, 60);
		start.setBackground(Color.white);

		// Creates title
		JLabel title_str = new JLabel("SNAKE GAME");
		title_str.setBounds(0, 70, 800, 60);
		title_str.setFont(new Font("Monospaced", Font.PLAIN, 80));
		title_str.setForeground(Color.WHITE);

		// Creates rules button
		JButton rules = new JButton("Rules");
		rules.setBounds(250, 200, 160, 60);
		rules.setBackground(Color.white);

		// Creates exit button
		JButton exit = new JButton("Return"); // Creates button

		// Adds title and menu
		mainMenu.add(title_str);
		mainMenu.add(start);
		mainMenu.add(rules);

		// Adds panel
		frame.add(mainMenu);

		// Adds action for exit or return button
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.repaint();
				initial();
			}
		});

		// Adds action for start
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new GameFrame();
			}
		});

		// Adds action for rules
		rules.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				// Removes previous content
				frame.getContentPane().removeAll();
				frame.repaint();

				// Adds return button
				exit.setBounds(1105,575,75,75); // Sets bounds
				exit.setBackground(Color.lightGray);// Sets color
				frame.add(exit); // Adds button

				// Adds rules
				frame.add(new Rules());


			}
		});
	}
			
			
			
			
			

		

		

	

	
	
}
