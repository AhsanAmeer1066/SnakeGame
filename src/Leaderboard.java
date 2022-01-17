import java.awt.Color;


import java.io.*;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.awt.*;

import javax.swing.*;

/*
 * 
 * This creates the leader board
 */

public class Leaderboard extends JPanel{

					
	// Creates constructor for leaderboard
	Leaderboard(){
		
		this.setSize(new Dimension(900,1200));  // Sets size of leaderboard panel
		this.setBounds(1, 1, 900, 900); // Sets bounds
		this.setLayout(null);
		this.setBackground(Color.YELLOW); // Sets background color
		leaderboard(); // Calls leaderboard method to add components
		
	}
	
	/**
	 * Description: This method Adds the leaderboard from a .txt file
	 * 
	 * @param N/A
	 * @return Void
	 * 
	 */
	
	public void leaderboard() {
		
		// Adds title
		JLabel leader = new JLabel("Leaderboard"); // Sets leaderboard
		leader.setFont(new Font("Times New Roman", Font.BOLD, 50)); // Sets font
		leader.setBounds(450, 10, 400, 100); // Sets bounds
		this.add(leader); // Adds to main menu
		
		// Sets variables to find the lowest score
		int low = 0; 
		int lowIndex = 0;
		
		// Creates try and catch so there are no errors
		try {

			// Declares reader
			BufferedReader reader = new BufferedReader(new FileReader("Scores.txt")); // For scores 
			BufferedReader reader2 = new BufferedReader(new FileReader("Usernames.txt")); // For usernames
			
			// Creates series of arraylist
			ArrayList<Integer> highest = new ArrayList<Integer>(); // Highest scores
			ArrayList<Integer> lstScores = new ArrayList<Integer>(); // All the scores
			ArrayList<Integer> userIndex = new ArrayList<Integer>(); // Stores indexes of top users
			ArrayList<Integer> highestscoresUNSORTED = new ArrayList<Integer>(); // High score sorted
			ArrayList<Integer> highestscoresSORTED = new ArrayList<Integer>(); // High scores unsorted
			ArrayList<String> userNames = new ArrayList<String>(); // Stores usernames
			ArrayList<String> highuserNames = new ArrayList<String>(); // Stores high score usernames
			JLabel highScores = new JLabel(); // Displays highscores
			
			
			
			String scores = reader.readLine(); // Reads scores
			String users = reader2.readLine(); // Reads usernames
			
			String[] temp = scores.split("-"); // Splits scores
			String[] temp2 = users.split("-"); // Splits usernames
			
			// Creates a for loop for scores
			for (int i = 0; i <= temp.length-1; i++) {
				
				lstScores.add(Integer.parseInt(temp[i])); // Adds score
				
			}
			
			// Creates a for loop for users
			for (int i = 0; i <= temp2.length-1; i++) {
				
				userNames.add(temp2[i]); // Adds username
				
			}
			
			// Creates a for loop to find top 5 highest
			for(int i = 0; i <= lstScores.size()-1; i++) {
				
				// Checks if these are the first 5 scores then adds them to the UserIndex
				if(i < 5) {
					userIndex.add(i); // Adds index
					highest.add(lstScores.get(i)); // Adds score
					continue; // Continues
				}

				// Creates a for loop for lowest
				for(int k = 0; k <= highest.size()-1; k++) {
					
					// Sets first lowest
					if (k == 0) {
						low = highest.get(0); // Sets low value
						lowIndex = 0; // Sets low index
						
					}
					
					// Sets lowest if lower than low
					else if(highest.get(k) < low) {
						low = highest.get(k); // Sets low value
						lowIndex = k; // Sets low index
					}
				}
				
				// Checks if score is greater than low then adds
				if(lstScores.get(i) >= low) {
					
					userIndex.set(userIndex.indexOf(lstScores.indexOf(low)), i); // Sets index
					highest.set(highest.indexOf(low), lstScores.get(i)); // Sets scores
					lstScores.set((lstScores.indexOf(low)), -1); // Replaces low so it isnt reread
					
				}
			}
		
			// Creates for loop to add sums to more organized arraylists
			for(int i = 0; i <= 4; i++) {
				// Adds scores
				highestscoresUNSORTED.add(highest.get(i)); 
				highestscoresSORTED.add(highest.get(i));
				// Adds users
				highuserNames.add(userNames.get(userIndex.get(i)));
				
			}
			
			
			Collections.sort(highestscoresSORTED); // Sorts array
			
			// Creates accumalators
			int yCoords = 450; 
			int place = 5;
			
			// Creates for loop to display scores
			for (int i = 0; i <= 4; i++) {
				String names = highuserNames.get(highestscoresUNSORTED.indexOf(highestscoresSORTED.get(i))); // Gets username
				highestscoresUNSORTED.set(highestscoresUNSORTED.indexOf(highestscoresSORTED.get(i)), 0); // Sets score
				highScores = new JLabel(String.valueOf(place)+ ". "+ names + ": " + String.valueOf(highestscoresSORTED.get(i)));// Reads from txt file
				highScores.setForeground(Color.BLACK); // Sets color
				highScores.setBackground(Color.WHITE); // Sets color
				highScores.setFont(new Font("Times New Roman", Font.BOLD, 50)); // Sets style
				highScores.setBounds(100, yCoords, 1200, 200); // Sets bounds
				this.add(highScores); // Adds to jpanel
				yCoords -= 100; // Changes ycoords
				place--; // Changes Place

			
			}

		} 

		// Catches exception
		catch (IOException iox) {
			System.out.println("Error");

		}
		
	}

}
