/*PATTERN USED
 *  Polymorphism pattern is used here
 *  As there can be different types of players, we won't need
 *  to create different methods for all of them,we can just override the method.
 *  
 *  Advantage:
 *  		single play method can be used for any new type of player 
 *  		added in future.
 *  Disadvantage:
 *  		we cannot create Player's object directly as its an abstract class.
 *  		we need to use references which increases code complexity.
 */

/**
 * This is an abstract class for players
 * 
 */
public abstract class Player {
		
	//Declaring an object of Board named gameBoard
	public Board gameBoard;
	
	//Declaring a string variable named playerName
	public String playerName;
	
	//Declaring a int variable named playerSymbol
	public int  playerSymbol;
	//Recent move is a 2 element array which stores the recent move in 0th row and 1st col
	static int[] recentMove=new int[2];
	/**
	 * Default constructor
	 * @param gameBoard the game board
	 * @param playerName is the player name
	 * @param playerSymbol is the player symbol
	 */
	Player(final Board gameBoard ,final String playerName , final int playerSymbol ) {
		
		//Initialize the variables
		this.gameBoard=gameBoard;
		this.playerName = playerName;
		this.playerSymbol = playerSymbol;
	}
	
	//Declare an abstract method
	abstract void play(final Board gameboard);
	
	/** this method prints the player name
	 * @return The player name
	 */
	public String toString() {
		return playerName ;
	}
	
	
	
}
