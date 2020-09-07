package Practice123123;

/**
 * 
 * Design of code only allows a game between a player and a computer
 * 
 */


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	
	
	ArrayList<Integer> playerposition = new ArrayList<Integer>();
	
	ArrayList<Integer> cpuposition = new ArrayList<Integer>();
	

	public TicTacToe() {
		
		
		
	//Initializing position variables where the X and O's will be drawn
	int cpupos = 0; 
	int playerpos = 0;
	
	//These variables are used to store information about who goes first and second. 
	char playerchoice = ' ';
	char cpuchoice = ' ';
	String GoesFirst = "";
	String GoesSecond = "";
	
	//Outline of the game board
	char IntroBoard[][] = {{'1','|','2','|','3'},
			{'-','+','-','+','-'},
			{'4','|','5','|','6'},
			{'-','+','-','+','-'},
			{'7','|','8','|','9'}}; 
		
	
	
	printBoard(IntroBoard);
	System.out.println("Welcome to Tic-Tac-Toe!");
	System.out.println("Begin by picking a symbol. X goes 1st and 0 goes second");
	
	
	
	Scanner Symbpicker = new Scanner(System.in);
	
	
	
	
	//User enters which symbol they want to play as. X goes first. O goes second.
	
	
	while(!(playerchoice == 'X' || playerchoice == 'O')) {
		
		System.out.println("Pick your symbol:");
		playerchoice = Symbpicker.next().charAt(0); 
		
		//To check for invalid input
		if(!(playerchoice == 'X' || playerchoice == 'O')) {
			System.out.println("Error: Invalid input. Please enter either X or O:");
		}
	
		
		
	}
	
	/*This section now assigns who goes first based on the input of the human player. If the player 
	 * chooses X, they will go first. If they choose O, they will go second after the CPU.
	 */
	if(playerchoice == 'X') {
		cpuchoice = 'O';
		GoesFirst = "player";
		
	}
	
	if(playerchoice == 'O') {
		cpuchoice = 'X';
		GoesFirst = "cpu";
		
	}
	
	
	
	/*Bulk of the Tik-Tak Toe program. The user makes a move and then the 
	 * computer makes a move.
	 */
	
	//The main board in which the program works with and manipulates
	char Board[][]= {{' ','|',' ','|',' '},
			{'-','+','-','+','-'},
			{' ','|',' ','|',' '},
			{'-','+','-','+','-'},
			{' ','|',' ','|',' '}}; 
	
		String result = "";
	
	while (result == "") { /*Control flow variable to tell the result to the player and end the current
	game.
	*/
	
		//New scanner made to receive new input after each turn
	
		
	/*This is where the code runs for each turn between the player and the CPU.
	 * After each turn, a winner gets determined and if there is a winner or a tie,
	 * the 
	 */
		
		
	if(GoesFirst == "player") { //If player goes first
		playerTurn(playerpos,Board,playerchoice); 
		result = evaluateWeen(Board);
		testResult(result); //If a win or tie occurs, the result value is changed
		
		
		if(!(result == "")){   //Allows for exit of the game. 
			break;
		}
		
		
		cpuTurn(cpupos,playerpos,Board,cpuchoice);
		result = evaluateWeen(Board);
		testResult(result);
		
		
			}
	
	
	else if (GoesFirst == "cpu") { //If cpu goes first
		cpuTurn(cpupos,playerpos,Board,cpuchoice);
		result = evaluateWeen(Board);
		testResult(result);
		
		
		if(!(result == "")){ //Exits the game.
			break;
		}
		
		playerTurn(playerpos,Board,playerchoice);
		result = evaluateWeen(Board);
		testResult(result);
		
			}
		
	
	
		}
	
	
	
	
	}
		
		
	public void printBoard(char TicTacBoard[][]) {
		
		//This essentially prints the board
		for (char x[]:TicTacBoard) {
			for(char c:x) {
			
				System.out.print(c);
				
			}
			System.out.println();
			
		
		}

	
	}
	
	
	public void playerTurn(int getplayerpos, char BoardPlayer[][], char playersymb) {
		
		List <Integer> box = Arrays.asList(1,2,3,4,5,6,7,8,9);
		boolean running = true;
		
		
		
		Scanner scanner = new Scanner(System.in); //Create object to receive input
		
		
		
		
		while (running) { /*This entire while block takes user inputs and validates their input
		to ensure incorrect valid is not provided
		*/
			
			
			//Test number 1: Check if user provided a number
			try {
				System.out.println("Enter a number from 1-9 to place your piece on the respective square:");
				getplayerpos = scanner.nextInt();
		
			}
			
			catch(InputMismatchException e) { //Without catch statement, program crashes.
				System.out.println("Invalid input. Please provide an number in between 1-9.");
				scanner.nextLine();
				continue; //Goes back to the while loop and keeps looping until user provides a number
			}
		
			//Test number 2: Check if number provided is in between 1-9
			while(!(box.contains(getplayerpos))) {
				
				
				try {
					System.out.println("The number provided does not fall in between 1-9. Please enter another number:");
					getplayerpos = scanner.nextInt();
					}
				
				catch (InputMismatchException e) {//Without catch statement, program crashes.
					System.out.println("Invalid input. Please provide a number in between 1-9.");
					scanner.nextLine();
					getplayerpos = 15; /*Essentially a number given outside of condition on purpose
					so the program can continue to flow. Don't worry, the user's input wil override 
					this number
					 */
					continue; //Goes back to the while loop
					}
				
				
		
				}
		
				
		/*Final test: To prevent the user from overriding their previous moves or a computer move
		 * 
		 *  Note 1 (Control- f purposes): playerposition and cpuposition are an ArrayList that store
		 *  all the previous moves of the user and cpu. The logic determines if the current move done 
		 *  either by human user or CPU exists in either the playerposition or cpuposition ArrayList.
		 */
		if(playerposition.contains(getplayerpos) | cpuposition.contains(getplayerpos)) {
			
			printBoard(BoardPlayer);
			
			
			System.out.println("A piece has already been placed there. Try again!:");
			//getplayerpos = scanner.nextInt();
			
		
		}
		
		/*If the above if returns false which means the final test has passed, the program exists the 
		 * entire while loop which means user input validation is complete.
		 */
		else {
			running = false;
			
		}
		
		
		
		}
	
	
		//The piece can now be played in the board
		
		placePiece(BoardPlayer,getplayerpos,"player", playersymb);
		
	}

	
	public void cpuTurn(int cpuselect, int getplayerpos, char BoardCPU[][], char cpusymb) {
		
		//starts
		
		Random rand = new Random();
		
		cpuselect = rand.nextInt(9) + 1; //Opponent chooses pieces at random
		
		
		/*One validation check for CPU to prevent it from overriding human player's moves or
		their own previous moves
		*/
		
		/*Note 1 (Control- f purposes): playerposition and cpuposition are an ArrayList that store
		  all the previous moves of the user and cpu. The logic determines if the current move done 
		  either by human user or CPU exists in either the playerposition or cpuposition ArrayList.	 
		 */
		while(cpuposition.contains(cpuselect) || playerposition.contains(cpuselect)){
			
			
			cpuselect = rand.nextInt(9) + 1;
		
			
			
		}
		
		
		
	
		
		
		placePiece(BoardCPU,cpuselect,"cpu",cpusymb); //CPU places their piece
		
	}
	
	
	public void placePiece(char Board1[][],int num, String user, char symbol) {
	
		//System.out.println("Going into the array:" + num);
		
		/*
		Note 1 (Control- f purposes): playerposition and cpuposition are an ArrayList that store
		all the previous moves of the user and cpu. The logic determines if the current move done 
		either by human user or CPU exists in either the playerposition or cpuposition ArrayList.
		*/
		
		//This block is where the moves are added to ArrayList 
		
		if(user == "player") {
			
			playerposition.add(num);
			//System.out.println("This is what is added for player: " + playerposition);
			//System.out.println("Player board size:" + playerposition.size());
		}
		
		else if(user == "cpu") {
			
			cpuposition.add(num);
			System.out.println("This is what is added for cpu: " + cpuposition);
			System.out.println("Cpu board size:" + cpuposition.size());
		}
		
		switch(num) { //num is used to add the piece. 1-9 consists of all the blocks in the game board
		case 1 : Board1[0][0] = symbol; //symbol is either "X" or "O." Depends on choice of player 
			break;
			
		case 2 : Board1[0][2] = symbol;
		break;
		
		case 3 : Board1[0][4] = symbol;
		break;
		
		case 4 : Board1[2][0] = symbol;
		break;
		
		case 5 : Board1[2][2] = symbol;
		break;
		
		case 6 : Board1[2][4] = symbol;
		break;
		
		case 7 : Board1[4][0] = symbol;
		break;
		
		case 8 : Board1[4][2] = symbol;
		break;
		
		case 9 : Board1[4][4] = symbol;
		break;
			
	}
	
		if (user == "cpu") {
			System.out.println("Computer move:");
		}
		
		if (user == "player") {
			System.out.println("Your move:");
			
		}
	
	printBoard(Board1); //Prints board with the move to showcase board state to the player
	
	}
	
	
	//All the win conditions are stored in a Linked Array List
	public String evaluateWeen(char BoardState[][]) {
		
		/*All win conditions. For example (1,2,3) is where X's or 0's lie horizontally on the top-row
		 */
		List <Integer> toprow = Arrays.asList(1,2,3);
		List <Integer> midrow = Arrays.asList(4,5,6);
		List <Integer> botrow = Arrays.asList(7,8,9);
		List <Integer> leftcol = Arrays.asList(1,4,7);
		List <Integer> midcol = Arrays.asList(2,5,8);
		List <Integer> botcol = Arrays.asList(3,6,9);
		List <Integer> diag1 = Arrays.asList(1,5,9);
		List <Integer> diag2 = Arrays.asList(3,5,7);
		
		
		
		
		List <List> winningCons = new ArrayList<List>();
		
		//Adding all win conditions to Linked List called winningCons
		winningCons.add(toprow);
		winningCons.add(midrow);
		winningCons.add(botrow);
		winningCons.add(leftcol);
		winningCons.add(midcol);
		winningCons.add(botcol);
		winningCons.add(diag1);
		winningCons.add(diag2);
		
		//Loops through all the winning conditions
		
		for (List l: winningCons) {
			if(playerposition.containsAll(l)) { /*Evaluates the player position array from Note 1
			and compares it to the winningCons LinkedList which holds all the winning positions
			*/
			return "Congratulations you won!";
			
				
			}
	

		else if (cpuposition.containsAll(l)){
			return "You lose. Sorry";
			
		}
			
		else if (playerposition.size() + cpuposition.size() == 9) {
			return "A tie! Exciting game!";
		}
			
			
	
		
		
		
		
	}
		return ""; /*Program continues to run until a win or tie is determined until return =
		any of the options above*/

}
	
	public void testResult(String statement) {
		
		System.out.println(statement);
		
		switch(statement) {
		
		case "Congratulations you won!":
			break;
			
		case "You lose. Sorry":
			break;
		
		case "A tie! Exciting game!":
			break;
		
			}
		
		
	}

	
	public static void main (String[] args) {
		
		TicTacToe t = new TicTacToe();
		
	}
	
}
