/*
 * Name: Ahsan and Elaine
 * Most recent edit: 2021-12-20
 * Description: ICS Final Culminating, Snake Game
 */

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

class SnakeGame {
	
	public static JFrame frame = new JFrame("Snakes"); // Initializes frame


	public static void main(String[] args) {
		
		// Creates initial frame
		frame.setSize(1200, 650);
		frame.setContentPane(new JLabel(new ImageIcon("images//mainmenu.jpg")));
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
		introtit.setBounds(415, 10, 500, 500);
		frame.getContentPane().add(introtit);
		
		// Creates start button
		JButton startGame = new JButton("Start Game");
		startGame.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		startGame.setBounds(500, 340, 200, 100);
		startGame.setBackground(Color.pink);
		frame.getContentPane().add(startGame);
		
		JLabel ahsan = new JLabel();
		ImageIcon img1 = new ImageIcon(new ImageIcon("images//Ahsan.png").getImage().getScaledInstance(90, 65, Image.SCALE_DEFAULT));
		ahsan.setIcon(img1);
		ahsan.setBounds(375, 520, 90, 65);
		frame.getContentPane().add(ahsan);
		
		JLabel elaine = new JLabel();
		ImageIcon img2 = new ImageIcon(new ImageIcon("images//Elaine.png").getImage().getScaledInstance(90, 65, Image.SCALE_DEFAULT));
		elaine.setIcon(img2);
		elaine.setBounds(480, 520, 90, 65);
		frame.getContentPane().add(elaine);
		
		JLabel msxie = new JLabel();
		ImageIcon img3 = new ImageIcon(new ImageIcon("images//Msxie.png").getImage().getScaledInstance(90, 65, Image.SCALE_DEFAULT));
		msxie.setIcon(img3);
		msxie.setBounds(630, 520, 90, 65);
		frame.getContentPane().add(msxie);
		
		JLabel course = new JLabel();
		ImageIcon img4 = new ImageIcon(new ImageIcon("images//Class.png").getImage().getScaledInstance(90, 65, Image.SCALE_DEFAULT));
		course.setIcon(img4);
		course.setBounds(735, 520, 90, 65);
		frame.getContentPane().add(course);
		
		
		frame.setVisible(true);
		
	
		// Adds action for start main menu
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
		mainMenu.setOpaque(false);
		((FlowLayout)mainMenu.getLayout()).setHgap(60);
		
		// Creates start button
		JButton multi = new JButton("Double");
		multi.setBounds(250, 200, 160, 60);
		Color lightcyan = new Color(224, 255, 255);
		multi.setBackground(lightcyan);

		// Creates start button
		JButton start = new JButton("Single");
		start.setBounds(60, 200, 160, 60);
		start.setBackground(lightcyan);

		// Creates title
		JLabel title_str = new JLabel("SNAKEs");
		title_str.setBounds(370, 70, 800, 60);
		title_str.setFont(new Font("Monospaced", Font.PLAIN, 80));
		title_str.setForeground(Color.WHITE);
		

		// Creates rules button
		JButton rules = new JButton("Rules");
		rules.setBounds(440, 200, 160, 60);
		rules.setBackground(lightcyan);
		
		// Creates rules button
		JButton exit = new JButton("Quit");
		exit.setBounds(820, 200, 160, 60);
		Color skyblue = new Color(135, 206, 235);
		exit.setBackground(skyblue);
		
		// Creates Leader board button
		JButton leaderBoard = new JButton("Leaderboard");
		leaderBoard.setBounds(630, 200, 160, 60);
		leaderBoard.setBackground(lightcyan);
		
		//Creates Return button
		JButton returner = new JButton("Return");
		
		//Creates Back button
		JButton back = new JButton("Back");
		back.setBounds(5, 5, 75, 75);
		back.setBackground(lightcyan);
		
		JLabel snake1 = new JLabel();
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("images//snake1.png").getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT));
		snake1.setIcon(imageIcon);
		snake1.setBounds(625, 450, 150, 100);
		frame.getContentPane().add(snake1);
		
		JLabel snake2 = new JLabel();
		ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("images//snake2.png").getImage().getScaledInstance(125, 100, Image.SCALE_DEFAULT));
		snake2.setIcon(imageIcon1);
		snake2.setBounds(485, 450, 125, 100);
		frame.getContentPane().add(snake2);
		

		// Adds title and menu
		mainMenu.add(title_str);
		mainMenu.add(multi);
		mainMenu.add(start);
		mainMenu.add(rules);
		mainMenu.add(leaderBoard);
		mainMenu.add(exit);

		// Adds panel
		frame.add(mainMenu);
		frame.add(back);
		
		

		
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
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.repaint();
				initial1();
			}
		});

		// Adds action for leaderboard
		leaderBoard.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				// Removes previous content
				frame.getContentPane().removeAll();
				frame.repaint();

				// Adds return button
				returner.setBounds(1090,520,75,75); // Sets bounds
				returner.setBackground(Color.white);// Sets color
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
				returner.setBounds(1090,520,75,75); // Sets bounds
				returner.setBackground(Color.white);// Sets color
				frame.add(returner); // Adds button

				// Adds rules
				frame.add(new Rules());


			}
		});
	}
			
			
			
			
			

		

		

	

	
	
}

