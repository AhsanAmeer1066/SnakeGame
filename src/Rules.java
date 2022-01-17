/*
 * Description: Makes Panel for rules
 */

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.io.*;

import javax.swing.*;

public class Rules extends JPanel{
	
	public JLabel rulesString = new JLabel(); // Creates Jlabel for rules
	public String ruleLine; // Creates string for rules
	
	// Creates Rules constructor
	Rules(){
		this.setSize(new Dimension(900,1200));  // Sets size of rules panel
		this.setBounds(1, 1, 900, 900);
		this.setLayout(null);
		this.setBackground(Color.YELLOW); // Sets background color
		rules(); // Calls rules method to add components
	}
	
	/**
	 * Description: This method Adds the rules from a .txt file
	 * 
	 * @param N/A
	 * @return Void
	 * 
	 */
	
	public void rules() {
		
		// Creates try and catch so there are no errors
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("Rules.txt")); // Declares reader for rules.txt
	
			// Creates for loop that iterates through every line of the rules
			for (int i = 0; i < 7; i++) {
				
				// Creates for loop to shift each line down
				for (int k = -20; k <= 300; k += 50) {
					
					if(k == 0) {
						ruleLine = reader.readLine(); // Reads from txt file
						rulesString = new JLabel(ruleLine);// Reads from txt file
						rulesString.setForeground(Color.BLACK); // Sets color
						rulesString.setFont(new Font("Times New Roman", Font.BOLD, 50)); // Sets style
						rulesString.setBounds(20, k, 1200, 200); // Sets bounds
						this.add(rulesString); // Adds to jpanel
					}
					
					else {
						ruleLine = reader.readLine();// Reads from txt file
						rulesString = new JLabel(ruleLine);// Reads from txt file
						rulesString.setForeground(Color.BLACK);// Sets color
						rulesString.setFont(new Font("Times New Roman", Font.PLAIN, 30));// Sets style
						rulesString.setBounds(20, k, 1200, 200); // Sets bounds
						this.add(rulesString);  // Adds to jpanel
					}
					
				}
				
			}
			
			
		} 
		
		// Catches exception
		catch (IOException iox) {
			
		}
		
	}

}
