import java.util.Scanner;
/**
 * This class implements the code for HumanPlayer which is a child of Player class
 * 
 *
 */
public class HumanPlayer extends Player {
	/**
	 * Default constructor
	 * @param gameBoard the game board
	 * @param playerName is the player name
	 * @param playerSymbol is the player symbol
	 */
	HumanPlayer(Board gameBoard ,String playername , int playerSymbol){
		
		//call the super class constructor to initialize the variables
		super(gameBoard,playername,playerSymbol);
	}


	/**
	 * This is the overriden method of Player class which is implemented here.
	 * @param gameBoard is the gameBoard
	 */
	void play(final Board gameboard) {
		
		//Initialize the super class gameBoard 
		super.gameBoard=gameboard;
		
		//Create an object of Scanner class 
		Scanner sc = new Scanner(System.in);
		
		//Declare and initialize a variable of type of boolean for the loop 
		boolean move=true ;
		
		do {
			
			//Get the row number and column number from the user 
			System.out.println("\nTo select particular block :\nPlease enter the row number :");
			int row = sc.nextInt();
			System.out.println("Please enter column number :");
			int col = sc.nextInt();
			
			//Make a move on the game board
			move = gameboard.makeMove(row, col,this.playerSymbol);
			
			//Print the gameboard
			gameboard.printgameBoard();
			
			//if move is false : Invalid selection
			if(!move )
				System.out.print("Invalid Row column Selected :" );
				
			
			
		}while(move==false);//Continue the loop till the move is false
		
		 
		
		 
		
		
	}
	


	
}
