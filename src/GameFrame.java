
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Description: Makes frame for single player mode
 */

public class GameFrame extends JFrame{
	
	public JFrame snakeFrame = new JFrame("Snake Game"); // Initializes JFrame
	
	// Makes constructor
	GameFrame(){
		// Connects Gameoperations class 
		snakeFrame.add(new GameOperations());
		snakeFrame.setSize(815, 615); // Sets size
		snakeFrame.setResizable(false); // Disables full screen
		snakeFrame.setLocationRelativeTo(null); // Sets location
		snakeFrame.setVisible(true); // Makes frame visible
		snakeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Orders frame to close when the X button is clicked
	}
}



