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
		frame.setSize(1200, 650);
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		initial1(); // Calls initial startup 
		 
	}
	
	
	/**
	 * Description: This method creates start menu
	 * 
	 * @param N/A
	 * @return Void
	 * 
	 */
	
	public static void initial1() {
		
		// Creates title
		JLabel introtit = new JLabel();
		introtit.setIcon(new ImageIcon("images//title.png"));
		introtit.setBounds(350, 50, 500, 500);
		frame.getContentPane().add(introtit);
		
		// Creates start button
		JButton startGame = new JButton("Start Game");
		startGame.setBounds(500, 400, 200, 100);
		startGame.setBackground(Color.ORANGE);
		frame.getContentPane().add(startGame);
		
		//Creates Names
		JLabel ahsan = new JLabel();
		ahsan.setIcon(new ImageIcon("images//Ahsan.gif"));
		ahsan.setBounds(980, 0, 350, 50);
		frame.getContentPane().add(ahsan);
		
		JLabel elaine = new JLabel();
		elaine.setIcon(new ImageIcon("images//Elaine.gif"));
		elaine.setBounds(980, 50, 340, 50);
		frame.getContentPane().add(elaine);
		
		JLabel msxie = new JLabel();
		msxie.setIcon(new ImageIcon("images//Msxie.gif"));
		msxie.setBounds(980, 100, 340, 50);
		frame.getContentPane().add(msxie);
		
		JLabel course = new JLabel();
		course.setIcon(new ImageIcon("images//Class.gif"));
		course.setBounds(980, 150, 340, 50);
		frame.getContentPane().add(course);
		
		
		frame.setVisible(true);
		
	
		// Adds action for start mainmenu
		startGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				// Removes previous content
				frame.getContentPane().removeAll();
				frame.repaint();
				initial();


			}
		});
		
	}
	
	/**
	 * Description: This method creates the main menu
	 * 
	 * @param N/A
	 * @return Void
	 * 
	 */
	
	public static void initial() {
		
		// Creates Panel for main menu
		JPanel mainMenu = new JPanel();
		mainMenu.setBounds(100,150,1000,800);
		mainMenu.setBackground(Color.YELLOW);
		((FlowLayout)mainMenu.getLayout()).setHgap(60);
		
		// Creates start button
		JButton multi = new JButton("Double");
		multi.setBounds(60, 200, 160, 60);
		multi.setBackground(Color.white);

		// Creates start button
		JButton start = new JButton("Single");
		start.setBounds(250, 200, 160, 60);
		start.setBackground(Color.white);

		// Creates title
		JLabel title_str = new JLabel("SNAKE GAME");
		title_str.setBounds(280, 70, 800, 60);
		title_str.setFont(new Font("Monospaced", Font.PLAIN, 80));
		title_str.setForeground(Color.WHITE);
		

		// Creates rules button
		JButton rules = new JButton("Rules");
		rules.setBounds(440, 200, 160, 60);
		rules.setBackground(Color.white);
		
		// Creates rules button
		JButton exit = new JButton("Quit");
		exit.setBounds(820, 200, 160, 60);
		exit.setBackground(Color.white);
		
		// Creates Leaderboard button
		JButton leaderBoard = new JButton("Leaderboard");
		leaderBoard.setBounds(630, 200, 160, 60);
		leaderBoard.setBackground(Color.white);
		
		//Creates Return button
		JButton returner = new JButton("Return");

		// Adds title and menu
		mainMenu.add(title_str);
		mainMenu.add(multi);
		mainMenu.add(start);
		mainMenu.add(rules);
		mainMenu.add(leaderBoard);
		mainMenu.add(exit);

		// Adds panel
		frame.add(mainMenu);
		
		// Adds action for exit or return button
		multi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new GameFrame_Multiplayer();
			}
		});

		// Adds action for exit or return button
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		// Adds action for return
		returner.addActionListener(new ActionListener(){
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

		// Adds action for leaderboard
		leaderBoard.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				// Removes previous content
				frame.getContentPane().removeAll();
				frame.repaint();

				// Adds return button
				returner.setBounds(1105,520,75,75); // Sets bounds
				returner.setBackground(Color.lightGray);// Sets color
				frame.add(returner); // Adds button

				// Adds leaderboard
				frame.add(new Leaderboard());


			}
		});
		
		// Adds action for rules
		rules.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				// Removes previous content
				frame.getContentPane().removeAll();
				frame.repaint();

				// Adds return button
				returner.setBounds(1105,520,75,75); // Sets bounds
				returner.setBackground(Color.lightGray);// Sets color
				frame.add(returner); // Adds button

				// Adds rules
				frame.add(new Rules());


			}
		});
	}
			
			
			
			
			

		

		

	

	
	
}
