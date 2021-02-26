import java.util.Random;


import java.util.Scanner;
/*PATTERN USED
 * Controller pattern is used in Game class
 * As it controls the high level functioning like start(),instantiates board etc.
 * Advantage:
 * 		clean code,easy to understand, one can  easily relate the methods 
 * 		and can understand  the flow.
 * 
 * Creator pattern is also used in Game, as it instantiates player 
 * and takes responsibility of creating player.
 */


/**
 * This class implements global interface and used to take input from the user.
 * 
 *
 */
public class Game implements global {
	/**
	 * Declare the object of type gameboard 
	 */
	Board gameBoard;
	
	/**
	 * Declare two variables of type players which playerCross and playerZero (X or O)
	 */
	Player playerCross;
	Player playerZero;
	
	/**Declare a boolean variable of gameDone
	 */
	boolean gameDone;
	
	/**
	 * Declare a variable of type int which is used to store the turn for the players
	 */
	int turn;
	
	/**
	 * Default constructor of the Game class
	 */
	public Game(){

		/**
		 * Create an object of Scanner class
		 */
		Scanner sc = new Scanner(System.in);
		
		/**
		 * Declare string variables p1 and p2
		 */
		String p1="player1";
		String p2="player2";
		
		/**
		 * Initialize the object with the board
		 */
		this.gameBoard = new Board();
		
		/**
		 * game is not finished
		 */
		this.gameDone =false;
		
		/**
		 * Declare and initialise choice with 0 which gets the user's choice
		 */
		int choice = 0 ;
		
		/**
		 * While game is not finished
		 */
		while(!this.gameDone) {
			
			//Print out to the Screen for the user input
			System.out.println("Welcome to Tic Tac Toe Game ");
			
			System.out.println("Please select an option from below :\n[1] Human vs Human \n [2] Human vs AI  \n  [3] AI vs AI \n");
			
			//Get and store the user choice in the option
			 choice = sc.nextInt();
			
			//Choice 1 Human vs Human
			if(choice==1) {
				
				//Get players names and store them in p1 and p2 respectively
				System.out.println("Please enter name for human player X:");
				p1=sc.next().trim();
				
				System.out.println("Please enter name for human player O:");
				p2=sc.next().trim();
				
				//Set gameDone to true and continue
				this.gameDone=true;
				continue;
					
				
			}
			//Choice 2 Human vs AI
			else if(choice ==2) {
				
				//Get players names and store them in p1 and p2 is a robot here 
				System.out.println("Please enter name for human player X:");
				p1=sc.next().trim();
				
				System.out.println("Please enter name for AI player O:");
				//sc.next().trim();
				
				System.out.println("I am a Robot");
				p2="Robot";
				
				//Set gameDone to true and continue
				this.gameDone=true;
				continue;
				
			
			}
			
			//Choice 3 AI vs AI
			
			else if(choice ==3) {
				
				System.out.println("Please enter name for AI player X:");
				p1="Sofia";
				//p1=sc.next().trim();
				
				System.out.println("Please enter name for AI player O:");
				p2="Watson";
				//p2=sc.next().trim();
				
				//Set gameDone to true and continue
				this.gameDone=true;
				continue;
				
			}
			//Else invalid choice selected
			else {
				
				System.out.println("Invalid Choice ! Please select a valid option");
				continue;
				
				
			}
		}
		//If choice is 1 , assign players to HumanPlayers
		if(choice==1) {
			this.playerCross=new HumanPlayer(this.gameBoard,p1,1);
			this.playerZero=new HumanPlayer(this.gameBoard,p2,2);
		}
		
		//If choice is 2 , assign playerX to humanPlayers and player0 to AI player
		else if(choice==2)
		{
			this.playerCross=new HumanPlayer(this.gameBoard,p1,1);
			this.playerZero=new AIPlayer(this.gameBoard,p2,2);
		}
		
		//Else both are AI players
		else
		{
			this.playerCross=new AIPlayer(this.gameBoard,p1,1);
			this.playerZero=new AIPlayer(this.gameBoard,p2,2);
		}
			
		System.out.println("Select Row,Column Number accordingly from below hint \n --------------------");
		for ( int i=0 ;i < 3 ; i++) {
			
			System.out.print(" | ");
			for (int j = 0; j< 3 ; j++ ) {
				
			System.out.print(""+i + "," +j +"" + " | ");
			}
			System.out.println();
	}
		System.out.println("--------------------");
		
		
	}
	
	//Coin Toss to Select which player first
	public void  CoinTossSelectPlayer() {
		
		Random r = new Random();
		this.turn = r.nextInt(2) +1;
		if(this.turn==1) {
			System.out.println(this.playerCross.playerName + " wins the toss");
		}
		else
			System.out.println(this.playerCross.playerName + " wins the toss");

		//return this.turn;
			
	}

	//Start the game
	public void start() {
		
		//int whichPlayer=CoinTossSelectPlayer();
		
		//RandomSelection of Player using coin toss.
		Random r = new Random();
		this.turn = r.nextInt(2) +1;
		if(this.turn==1) {
			System.out.println(this.playerCross.playerName + " wins the toss");
		}
		else
			System.out.println(this.playerZero.playerName + " wins the toss");
		
		
		int i=0;
		
		//Repeat until i ==0
		while(i==0) {
			
			if(this.turn==1) {
				//Player X
				System.out.println(" Turn : Player X " + this.playerCross.playerName);
				this.playerCross.play(this.gameBoard);

				
			}
			
			else {
				//Player 0
				System.out.println(" Turn : Player 0 " + this.playerZero.playerName);
				this.playerZero.play(this.gameBoard);

			}
			
			// if gameboard status is not zero , then i is equal to 1
			if(this.gameBoard.getStatus()!=0) {
				i=1;
			}
			
			//If i is zero 	
			if(i==0) {
				
				//if turn is 1 , that is player X , then the next chance is player 0
				if(this.turn==1) {
					this.turn=2;
				}
				
				//else the turn is player X
				else
					this.turn=1;
			}
		}
		
		//Display the results by printing the gameboard
		System.out.println("Final Results is ");
		this.gameBoard.printgameBoard();
		
		//if status is 3, its a Draw
		if(this.gameBoard.getStatus()==3)
			System.out.println("ITS A DRAW.");
		
		//else if this.turn is 1 ,player X is winner
		else if (this.turn ==1)
			System.out.println(this.playerCross.playerName + " is winner");
		
		//else player 0 is winner
		else {
			System.out.println(this.playerZero.playerName + " is winner");
		}
		
		}

	
	}

	

