import javax.swing.JFrame;
/*
 * Makes frame for multiplayer
 */

public class GameFrame_Multiplayer {
	
	public JFrame snakeFramemulti = new JFrame("Snake Game Multiplayer"); // Initializes JFrame
	
	// Makes constructor
	GameFrame_Multiplayer(){
		// Connects Gameoperations class 
		snakeFramemulti.add(new GameOperations_Multiplayer());
		snakeFramemulti.setSize(815, 615); // Sets size
		snakeFramemulti.setResizable(false); // Disables full screen
		snakeFramemulti.setLocationRelativeTo(null); // Sets location
		snakeFramemulti.setVisible(true); // Makes frame visible
		snakeFramemulti.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Orders frame to close when the X button is clicked
	}

}
