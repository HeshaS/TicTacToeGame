import java.util.Random;
import java.util.Scanner;
/**
 * This class implements the code for AIPlayer which is a child of Player class
 * 
 *
 */
public class AIPlayer extends Player {

	/**
	 * Default constructor
	 * @param gameBoard the game board
	 * @param playerName is the player name
	 * @param playerSymbol is the player symbol
	 */
	AIPlayer(Board gameBoard, String playerName, int playerSymbol) {
		//call the super class constructor to initialise the variables
		super(gameBoard, playerName, playerSymbol);
		
	}

	/**
	 * This is the overriden method of Player class which is implemented here.
	 * @param gameBoard is the gameBoard
	 */
	void play(Board gameboard) {
		
		//Initialize the super class gameBoard 
		super.gameBoard=gameboard;
		
		 
		//Declare and initialize a variable of type of boolean for the loop 
		boolean move=true ;
		
		
		do {
		
			//Create an object of Randon class
			Random r =new Random();
			
			//Get a number (0,1 or 2) and store it into row
			int row = r.nextInt(3);
			
			//Get a number (0,1 or 2) and store it into col
			int col = r.nextInt(3);
			
			//Create a temp array of temporary numbers which we get randomly (row and col)
			int[] temp= {row,col};
			
			//Make a move on the game board
			move = gameboard.makeMove(row, col,this.playerSymbol);
			
			//If move is true
			if(move)
				{
				//Print the gameboard
				gameboard.printgameBoard();
				
				//Store the recent move in temp
				Player.recentMove= temp;
				}
			
				
			
			
		}while(move==false); //Continue the loop till the move is false
		
		 
		
		
	}
	


		
}


