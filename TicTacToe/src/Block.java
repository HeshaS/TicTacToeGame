
/*PATTERN USED
 * Information expert
 * Because it contains information about cells, which is used 
 * to make a move.
 */

/**
 * 
 * This class implements the global interface.
 * This class is considered as one block of 2D board
 *
 */
public class Block implements global {

	/**
	 * Declare a private variable named status of type int which stores the status of the block
	 */
	 private int status;
	
	 /**
	  * Default constructor which allocates 0 to a block (when the gameboard is empty)
	  */
	public Block(){
	
		
		this.status=0;		
	}
	
	/**
	 * SetStatus is settor method which sets the status of the cell
	 * @param c is the argument given as input to method(symbol).
	 * @return if the status is set or not (true or false).
	 */
	 public boolean setStatus(int c){
		 
		 /**
		  * If state of the status is valid
		  */
		if(this.checkValidState(c)) {
			
			/**
			 * set status to C
			 */
			this.status=c;
			
			/**
			 * return true 
			 */
			return true;
			
		}
		
		/**
		 * else return false
		 */
		else 
			return false;
		
	}
	 
	 /**
	  * This method checks the state of the block is valid or not
	  * @param c is the argument (symbol)
	  * @return true or false if the state is valid or not (1 or 2)
	  */
	 public boolean checkValidState(int c) {
		 
		 /**
		  * Check if the status is 1 or 2
		  */
			 return c==1 || c ==2;
				
		
	 }
	
	 /**
	  * Get method of status ( getStatus)
	  * @return the int value of status
	  */
	public int getStatus(){
		return this.status;
	}
	
	
	/**
	 * Displays the status in the form of X or O
	 * @return String  X ,O or nothing
	 */
	public String toString() {
		/**
		 * If the status is 1 ,display X
		 */
		if(this.status == 1)
			return "X";
		
		/**
		 * else if status is 2 , display O
		 */
		else if (this.status==2)
			return "O";
		
		/**
		 * else if status anything else, display SPACE
		 */
		else
			return " ";
		
					
	}
	
	
	
}
