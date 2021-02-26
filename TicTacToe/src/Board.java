

/*PATTERN USED
 * Information Expert pattern

	Determines valid moves of players and have all information about all possible 	moves.
	It has  information needed to decide moves. 
	Advantages:
			ease of access to all cells we have in tictactoe board
			and improves code understandability
	
 */



/**
 * This class implements the code for Board of the Tic Tac Toe game.
 *
 *
 */

public class Board {
	
	/**
	 * Creating a gameBoard of type Block
	 */
	public static Block [][] gameBoard;

	/**
	 * Declare a variable to store the status of the Block
	 */
	public int cellStatus;
	
	/**
	 * Calling the constructor of the class to initialize the gameBoard
	 */
	public Board(){
		
		/**
		 * Initialise status to zero
		 */
		this.cellStatus=0;
		
		/**
		 * Initializing the 2D array
		 */
		gameBoard = new Block[3][3];
		 
		/**
		 * Initializing the array with empty 
		 */
		for ( int i=0 ;i < 3 ; i++) {
			
			for (int j = 0; j< 3 ; j++ ) {
				
				gameBoard[i][j]=new Block() ;
				//System.out.println(gameBoard[i][j]);
			}
		}
		
	}
	
	/**
	 * Get method of Status
	 * @return the value of status
	 */
	public int getStatus() {
		return this.updateCellStatus();
	}
	
	/**
	 * This method will update the cell status
	 * @return the value of the  cell status
	 */
	public int updateCellStatus() {
		
		/**
		 * Store the value of all status in one and add them
		 */
		final int newcellStatus = this.checkRows(0) + this.checkRows(1)+ this.checkRows(2)+this.checkColumns(0)+this.checkColumns(1)+this.checkColumns(2)+this.checkDiagonal();
		
		/**
		 * If cell status is not equal to zero ,Update the status of the cell to new cell status.
		 */
		if (newcellStatus!=0) {
			
			this.cellStatus = newcellStatus;
		}
		/**
		 * Else check for Draw.
		 */
		else {
			this.cellStatus= this.checkforDraw();
		}
		return this.cellStatus;
	}
	
	
	/**
	 * This method will check the status of row 
	 * @param row the row number of 2d array
	 * @return the value of the status
	 */
	private int checkRows(final int row) {
		
		/**
		 * If  three row's status value matches and none are 0 , then return the status
		 */
			if (this.gameBoard[row][0].getStatus()!=0 && this.gameBoard[row][0].getStatus()== this.gameBoard[row][1].getStatus() && this.gameBoard[row][1].getStatus() == this.gameBoard[row][2].getStatus()) {
				return this.gameBoard[row][0].getStatus();
		}
			/**
			 * else return 0
			 */
			else
				return 0;
		
	}
	
	
	/**
	 * This method will check the status of column
	 * @param col the column number of 2D array
	 * @return the value of Status 
	 */
		private int checkColumns(final int col) {
			
			
			/**
			 * If  three column's status value matches and none are 0 , then return the status
			 */
				if(this.gameBoard[0][col].getStatus()!=0 && this.gameBoard[0][col].getStatus()==this.gameBoard[1][col].getStatus() &&this.gameBoard[1][col].getStatus()==this.gameBoard[2][col].getStatus())
					return this.gameBoard[0][col].getStatus();
				/**
				 * else return 0
				 */
				else 
					return 0;
			
		}
	
		
	
		/**
		 * This method will check the status of blocks diagonally
		 * @return the value of Status 
		 */
		public int checkDiagonal() {

			/**
			 * If gameboard[0][0] ,gameboard[1][1], gameboard[2][2] have same status value  and none are 0 , then return the status
			 */
		if(this.gameBoard[0][0].getStatus()!=0 && this.gameBoard[0][0].getStatus()==this.gameBoard[1][1].getStatus() &&this.gameBoard[1][1].getStatus()==this.gameBoard[2][2].getStatus())
			return this.gameBoard[0][0].getStatus();
		
		
		/**
		 * If gameboard[0][2] ,gameboard[1][1], gameboard[2][0] have same status value  and none are 0 , then return the status
		 */
		if(this.gameBoard[0][2].getStatus()!=0 && this.gameBoard[0][2].getStatus()==this.gameBoard[1][1].getStatus() &&this.gameBoard[1][1].getStatus()==this.gameBoard[2][0].getStatus())
			return this.gameBoard[0][2].getStatus();
		
		
		
		/**
		 * else return 0
		 */
		else 
			return 0;
		}
	
	
	
	
	/**
	 * This method is used to display the gameBoard
	 */
	public  void printgameBoard() {
		
		/**
		 * Print the 2D array with 2 loops 
		 */
		System.out.println("---------------");
		for ( int i=0 ;i < 3 ; i++) {
			
			System.out.print(" | ");
			for (int j = 0; j< 3 ; j++ ) {
				
			System.out.print(gameBoard[i][j] + " | ");
			}
			System.out.println();
	}
		System.out.println("---------------");
		
	}
	
	/**
	 * this method is used to locate and setting the status of the block in gameboard
	 * @param row row of the gameboard
	 * @param col column of the gameboard
	 * @param status status of the block
	 * @return whether it is located and sets the new status.
	 */
	public boolean makeMove(int row , int col, final int status)
	
	{
//		//If the current place  is not valid 
//		if(row >=2 && col >=2) {
//			
//			return false;
//		}
//		
//		else {
//			//if Current place in the array is empty
//			if (gameBoard[row][col]==EMPTY) {
//				
//				gameBoard[row][col]=CurrentPlayer;
//				return true;
//			}
//			//IF the current place is occupied by another player 
//			else 
//				return false;
//				
//			
//		
//		}
		
	
		
		/**
		 * If row OR col is less than zero or greater than 2 , return false
		 */
		if(row < 0 || row >2 && col <0 || col>2) {
			return false;
		}
	
		/**
		 * If the status of a block in a gameboard is zero then set the status and return true
		 */
	        if (this.gameBoard[row][col].getStatus() == 0) {
	            this.gameBoard[row][col].setStatus(status);
	            return true;
	        }
	        /**
	         * else return false
	         */
	        return false;
		
	}
	
	/**
	 * This method is used to check draw for the game
	 * @return the status 0 if its empty and 3 if its draw
	 */
	
private int checkforDraw() {
	
	for(int i=0; i<3;++i) {
		for(int j=0;j<3;++j) {
			if(this.gameBoard[i][j].getStatus()==0) {
				return 0;
			}
		}
	}
	return 3;
}
//	public static void main(String args[]) {
//		
//		Board b = new Board();
//		 b.printgameBoard();
//		
//	}
	
}
