/*
 * Description: Code for multiplayer panel
 */

// Importing of libraries needed for the program
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;


// Class extends to JPanel and implements the functionality of ActionListener
public class GameOperations_Multiplayer extends JPanel implements ActionListener {
	
	// Declares Variables
	public final int snake_size = (800*600)/(25*25); // Sets largest size for snake body
	public int initialBody = 5; // Sets the size of the body starting out
	public int initialBody2 = 5; // Sets the size of the body starting out
	public int score = 0; // Sets the score
	public int score2 = 0; // Sets the score for the other snake
	public int winner = 0;
	public int fruitX, fruitY; // Sets variables for x and y coordinates for fruits
	public int movement = 1; // variable for moving
	public int mover = 5; // variable for moving second snake
	public int snake_x[] = new int[snake_size]; // X coordinates for snake
	public int snake_y[] = new int[snake_size]; // Y Coordinates for snake
	public int snake_x2[] = new int[snake_size]; // X coordinates for snake2
	public int snake_y2[] = new int[snake_size]; // Y Coordinates for snake2
	public boolean running = false; // Allows program to run
	private Random random = new Random(); // Sets randomizer variable
	private Timer timer = new Timer(75, this); // Sets timer to control snake speed
	
	// GameOperations Constructor
	GameOperations_Multiplayer(){
		this.setFocusable(true); // Allows snake to move (Focuses on the snake)
		this.setSize(new Dimension(800,600));  // Sets size of game panel
		this.addKeyListener(new InputReceiver()); // Adds keylistener to move the snake
		this.setBackground(Color.black); // Sets background color
		starting(); // Calls starting method that generates fruits and starts the game, and it's timer
		
		
	}
	
	/**
	 * Description: This method initiates the game, by generating the fruit and 
	 * setting running to true, and starting the timer.
	 * 
	 * @param void
	 * @return Starts game
	 * 
	 */
	
	public void starting() {
		running = true; // Sets running to true
		stop();
		randomFruits(); // Calls random fruit method
		timer.start(); // Starts timer
	
	}
	
	/**
	 * Description: This method adds a pause functionality
	 * 
	 * @param void
	 * @return Pauses game
	 * 
	 */
	
	public void stop() {
		
		// Creates pause button
		JButton pause = new JButton("Pause");
		pause.setBounds(720, 0, 80, 50);
		pause.setBorderPainted(false);
		pause.setBackground(new Color(0, 0, 0, 50));
		pause.setForeground(Color.red);
		this.setLayout(null);
		this.add(pause);
		
		// Creates resume button
		JButton resume = new JButton("Resume");
		resume.setBounds(710, 0, 90, 50);
		resume.setBackground(new Color(80, 149, 149));
		
		// Adds action for pause
		pause.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				remove(pause);
				add(resume);
				
			}
		});
		
		// Adds action for resume
		resume.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				timer.start();
				remove(resume);
				add(pause);
				
			}
		});
	
	}
	
	
	
	/**
	 * Description: This method makes the game over screen
	 * 
	 * @param Graphics g (Variable to draw graphical objects on panel)
	 * @return Game over screen
	 * 
	 */
	
	public void lose(Graphics g) {
		
		// Outputs game over string
		g.setColor(Color.CYAN); // Sets color of game over to cyan
		g.setFont(new Font("Algerian", Font.BOLD, 75)); // Sets font, style and size of text
		g.drawString("GAME OVER", 175, 300); // Finally draws the string at (175,300)
	
		// Outputs winner 
		if (winner == 0) {
			g.setColor(Color.ORANGE); // Sets color of game over to orange
			g.setFont(new Font("Times New Roman", Font.BOLD, 30)); // Sets font, style and size of text
			g.drawString("TIE!",350, 400); // Finally draws the string at (350,400)
		}
				
		// Outputs winner 
		if (winner == 1) {
			g.setColor(Color.ORANGE); // Sets color of game over to orange
			g.setFont(new Font("Times New Roman", Font.BOLD, 30)); // Sets font, style and size of text
			g.drawString("SNAKE 1 WINS",275, 400); // Finally draws the string at (350,400)
		}
		
		if (winner == 2) {
			g.setColor(Color.ORANGE); // Sets color of game over to orange
			g.setFont(new Font("Times New Roman", Font.BOLD, 30)); // Sets font, style and size of text
			g.drawString("SNAKE 2 WINS",275, 400); // Finally draws the string at (350,400)
		}
		
		
		// Creates return to main menu button
		JButton exit = new JButton("Exit"); // Creates button
		exit.setBounds(710,483,75,75); // Sets bounds
		exit.setBackground(Color.RED); // Sets color
		this.add(exit); // Adds button
		
		// Gives button functionality
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Window frame = SwingUtilities.getWindowAncestor(exit); // Gets frame in which the game was added
				frame.dispose(); // Closes the frame
			}
		});
		
	}
	
	/**
	 * Description: This method makes it possible for the snake and other objects
	 * to be drawn to the screen. Also this method replaces the paintComponent() method 
	 * in the JPanel class
	 * 
	 * @param Graphics g (Variable to draw graphical objects on panel)
	 * @return Graphical objects on game panel
	 * 
	 */
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Enables objects to be painted on the panel
		draw_objects(g); // Calls draw_objects() to draw fruits, snake, etc.
	}
	
	/**
	 * Description: This method checks if the snake is touching anything
	 * such as the fruit, its body, or the boundaries
	 * 
	 * @param void
	 * @return void
	 * 
	 */
	
	public void objectDetection() {
		
		// Creates an if statement that checks if the snake has eaten a fruit
		if ((snake_x[0] == fruitX) && (snake_y[0] == fruitY)) // Checks if coordinates are the same
		{
			initialBody++; // Increases the body by one unit
			score++; // Increases the score by 1
			randomFruits(); // Generates another fruit for the player to get
		}
		
		// Creates an if statement that checks if the snake2 has eaten a fruit
		if ((snake_x2[0] == fruitX) && (snake_y2[0]+300 == fruitY)) // Checks if coordinates are the same
		{
			initialBody2++; // Increases the body by one unit
			score2++; // Increases the score by 1
			randomFruits(); // Generates another fruit for the player to get
		}
		
		// Creates for loop that checks if the head of the snake hits it's own body
		for(int i = initialBody; i >= 1; i--) {
			
			if((snake_x[0] == snake_x[i]) && (snake_y[0] == snake_y[i])) // Checks if x,y coordinates of head are the same as the body
			{
				
				running = false; // Sets running to false
				timer.stop(); // Stops timer
				System.out.println(1);
				winner = 2;
				
			}
			
			if((snake_x2[0] == snake_x[i]) && (snake_y2[0]+300 == snake_y[i])) {
				
				running = false; // Sets running to false
				timer.stop(); // Stops timer
				System.out.println(1);
				winner = 1;

			}
		}
		
		// Checks for head collision
		if ((snake_y[0]== snake_y2[0]+300) && (snake_x[0] == snake_x2[0])){
			
			running = false; // Sets running to false
			timer.stop(); // Stops timer
			System.out.println(1);
		}
		
		// Creates for loop that checks if the head of the snake hits it's own body
		for(int i = initialBody2; i >= 1; i--) {

			if((snake_x2[0] == snake_x2[i]) && (snake_y2[0] == snake_y2[i]))// Checks if x,y coordinates of head are the same as the body
			{

				running = false; // Sets running to false
				timer.stop(); // Stops timer
				System.out.println(1);
				winner = 1;

			}
			
			if((snake_y[0] == snake_y2[i]+300) && (snake_x[0] == snake_x2[i])) {
				running = false; // Sets running to false
				timer.stop(); // Stops timer
				System.out.println(1);
				winner = 2;
			}
		}
				
		
		
		
		// Checks if snake head touched the left wall
		if (snake_x[0] < 0) {
			
			running = false; // Sets running to false
			timer.stop(); // Stops timer
			System.out.println(2);
			winner = 2;
			
		}
		
		// Checks if snake head touched the right wall
		if (snake_x[0] >= 800) {
			
			running = false; // Sets running to false
			timer.stop(); // Stops timer
			System.out.println(3);
			winner = 2;
			
		}
		
		// Checks if snake head touched the top 
		if (snake_y[0] < 0) {
			
			running = false; // Sets running to false
			timer.stop(); // Stops timer
			System.out.println(4);
			winner = 2;
			
		}
		
		// Checks if snake head touched the bottom
		if (snake_y[0] >= 575) {
			
			running = false; // Sets running to false
			timer.stop(); // Stops timer
			System.out.println(5);
			winner = 2;
		}
		
		// Checks if snake head touched the left wall
		if (snake_x2[0] < 0) {
			
			running = false; // Sets running to false
			timer.stop(); // Stops timer
			System.out.println(6);
			winner = 1;
		}

		// Checks if snake head touched the right wall
		if (snake_x2[0] >= 800) {

			running = false; // Sets running to false
			timer.stop(); // Stops timer
			System.out.println(7);
			winner = 1;

		}

		// Checks if snake head touched the top 
		if (snake_y2[0]+300 < 0) {

			running = false; // Sets running to false
			timer.stop(); // Stops timer
			System.out.println(8);
			winner = 1;

		}

		// Checks if snake head touched the bottom
		if (snake_y2[0]+300 >= 575) {

			running = false; // Sets running to false
			timer.stop(); // Stops timer
			System.out.println(9);
			winner = 1;

		}
		
	}
	
	/**
	 * Description: This method generates new x,y coordinates for the fruits throughout the game
	 * 
	 * @param void
	 * @return void
	 * 
	 */
	
	public void randomFruits() {
		
		fruitX = random.nextInt((int)(800/50))*25; // Generates new x coordinates within the panel
		fruitY = random.nextInt((int)(600/50))*25; // Generates new y coordinates within the panel
	
	}

	/**
	 * Description: This method is responsible for drawing everything in the game
	 * 
	 * @param Graphics g (Variable to draw graphical objects on panel)
	 * @return void
	 * 
	 */
	
	public void draw_objects(Graphics g) {
		
		// Checks to see if the game is still running and the player hasn't lost
		if (running == true) {
			
			// This peice of code draws the fruit repeatedly
			g.setColor(Color.GREEN); // Sets color of fruit
			g.fillOval(fruitX, fruitY, 25, 25); // Sets shape, size and coords of fruit
			repaint(); // Repaints the fruit when the snake eats it
			
			// Creates a for loop to create the snakes body, this loop keeps on iterating and when another apple is eaten it adds another body part
			for(int i = 0; i < initialBody; i++) {
				
				// Creates an if statement for the head
				if(i == 0) {
					
					g.setColor(Color.BLUE); // Sets snake to blue
					g.drawRect(snake_x[0], snake_y[0], 25, 25); // Draws head outline
					g.fillRect(snake_x[0], snake_y[0], 25, 25); // Fills in head
					repaint(); // Repaints every time the head moves
					
				}
				
				// Creates else statement for body parts
				else {
					
					g.setColor(Color.CYAN); // Sets body color to cyan
					g.drawOval(snake_x[i], snake_y[i], 25, 25); // Draws an oval
					repaint(); // Repaints every time body moves
				}
				
			}
			
			// Creates a for loop to create the second snakes body
			for(int i = 0; i < initialBody2; i++) {

				// Creates an if statement for the head
				if(i == 0) {

					g.setColor(Color.RED); // Sets snake to blue
					g.drawRect(snake_x2[0], snake_y2[0]+300, 25, 25); // Draws head outline
					g.fillRect(snake_x2[0], snake_y2[0]+300, 25, 25); // Fills in head
					repaint(); // Repaints every time the head moves

				}

				// Creates else statement for body parts
				else {

					g.setColor(Color.MAGENTA); // Sets body color to cyan
					g.drawOval(snake_x2[i], snake_y2[i]+300, 25, 25); // Draws an oval
					repaint(); // Repaints every time body moves
				}

			}
			
			// Keeps Score
			g.setColor(Color.BLUE); // Sets color to orange
			g.setFont(new Font("Times New Roman", Font.BOLD, 30)); // Sets font, size and style
			g.drawString("PLAYER 1: " + score, 25, 560); // Draws "Score: "
			
			g.setColor(Color.RED); // Sets color to orange
			g.setFont(new Font("Times New Roman", Font.BOLD, 30)); // Sets font, size and style
			g.drawString("PLAYER 2: " + score2, 600, 560); // Draws "Score: " 
			
			
		}
		
		
		// Creates else statement that calls shows losing screen if running == false
		else {
			lose(g); // Calls lose() method for gameover sceen
		}
		
	}
	
	/**
	 * Description: This method is responsible for moving the snake
	 * 
	 * @param void
	 * @return void
	 * 
	 */
	
	public void moveSnake() {
		
		// Creates a for loop moves the rest of the body according to where the head moves
		for (int i = initialBody; i>=1 ; i--) {
			
			// This code shifts the body parts into the parts in front of them
			snake_x[i] = snake_x[i-1]; // Sets the current body part's x coords to the part in front of it
			snake_y[i] = snake_y[i-1]; // Sets the current body part's y coords to the part in front of it
			
		}
		
		// Creates a for loop moves the rest of the body 2 according to where the head 2 moves
		for (int i = initialBody2; i>=1 ; i--) {

			// This code shifts the body parts into the parts in front of them
			snake_x2[i] = snake_x2[i-1]; // Sets the current body part's x coords to the part in front of it
			snake_y2[i] = snake_y2[i-1]; // Sets the current body part's y coords to the part in front of it

		}
		
		
		
		// Creates if statement that moves head of snake (the for loop above moves the body)
		if (true) {
			
			// Creates if statement that moves head up
			if (movement == 3) {
				snake_y[0] = snake_y[0] - 25; // Subtracts y coords by 25
			}
		
			// Creates else if statement that moves head down
			else if (movement == 4) {
				snake_y[0] = snake_y[0] + 25; //Adds y coords by 25
			}
			
			// Creates else if statement that moves head right
			else if (movement == 1) {
				snake_x[0] = snake_x[0] + 25; //Adds x coords by 25
			}
			
			// Creates else if statement that moves head left
			else if (movement == 2) {
				snake_x[0] = snake_x[0] - 25; //Subtracts x coords by 25
			}
			
			// Creates if statement that moves head up
			if (mover == 7) {
				snake_y2[0] = snake_y2[0]-25; // Subtracts y coords by 25
				System.out.println(20);
			}

			// Creates else if statement that moves head down
			else if (mover == 8) {
				snake_y2[0] = snake_y2[0]+25; //Adds y coords by 25
				System.out.println(30);
			}

			// Creates else if statement that moves head right
			else if (mover == 5) {
				snake_x2[0] = snake_x2[0] + 25; //Adds x coords by 25
			}

			// Creates else if statement that moves head left
			else if (mover == 6) {
				snake_x2[0] = snake_x2[0] - 25; //Subtracts x coords by 25

			}
			
		}
		
	}
	
	/**
	 * Description: This method is responsible for moving the snake everytime the user 
	 * enters a key or does an action
	 * 
	 * @param ActionEvent e (Default params for this method)
	 * @return void
	 * 
	 */
	
	public void actionPerformed(ActionEvent e) {
		
		// Creates if statement to check if game is still active
		if (running == true) {
			
			moveSnake(); // Calls moveSnake method so snake could move when keys are entered
			objectDetection(); // Calls objectDetection so the program checks for contact
			
		}
		repaint(); // Repaints the graphical objects on the panel for continuous animation
		
	}
	
	/*
	 * Inner Class: InputReceiver
	 * Description: This inner class receives key input from the user and sets values to the
	 * variable movement for the moveSnake() method, so the snake can move
	 * 
	 */
	public class InputReceiver extends KeyAdapter{

		
		// Creates a method to check for pressed keys
		public void keyPressed(KeyEvent e) {
			
			// Creates if statement to check if left key is pressed
			if(KeyEvent.VK_LEFT == e.getKeyCode()) {
				if (movement != 1) // Creates if statement that checks if the snake is going right
				{
					movement = 2; // Sets direction to left
				}
			}
				
			// Creates if statement to check if right key is pressed
			else if(KeyEvent.VK_RIGHT == e.getKeyCode()) {
				if (movement != 2) // Creates if statement that checks if the snake is going left
				{
					movement = 1; // Sets direction to right
				}
			}
			
			// Creates if statement to check if up key is pressed
			else if (KeyEvent.VK_UP == e.getKeyCode()) {
				if (movement != 4) // Creates if statement that checks if the snake is going down
				{
					movement = 3; // Sets direction to up
				}
			}
				
			// Creates if statement to check if down key is pressed
			else if (KeyEvent.VK_DOWN == e.getKeyCode()) {
				if (movement != 3)  // Creates if statement that checks if the snake is going up
				{
					movement = 4; // Sets direction to down
				} 
			}
			 
			// Creates if statement to check if a key is pressed
			if(KeyEvent.VK_A == e.getKeyCode()) {
				if (mover != 5) // Creates if statement that checks if the snake is going right
				{
					mover = 6; // Sets direction to left
				}
			}

			// Creates if statement to check if d is pressed
			else if(KeyEvent.VK_D == e.getKeyCode()) {
				if (mover != 6) // Creates if statement that checks if the snake is going left
				{
					mover = 5; // Sets direction to right
				}
			}

			// Creates if statement to check if w is pressed
			else if (KeyEvent.VK_W == e.getKeyCode()) {
				if (mover != 8) // Creates if statement that checks if the snake is going down
				{
					mover = 7; // Sets direction to up
				}
			}

			// Creates if statement to check if s is pressed
			else if (KeyEvent.VK_S == e.getKeyCode()) {
				if (mover != 7)  // Creates if statement that checks if the snake is going up
				{
					mover = 8; // Sets direction to down
				} 
			}
			
		}
	}
	
}
