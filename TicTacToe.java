package Practice123123;

/**
 * 
 *
 * 
 * 
 * 
 * 
 * 
 * 
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
		
		//Outline of the game board
		
		
		int cpupos = 0;
		int playerpos = 0;
	
		
	char IntroBoard[][] = {{'1','|','2','|','3'},
			{'-','+','-','+','-'},
			{'4','|','5','|','6'},
			{'-','+','-','+','-'},
			{'7','|','8','|','9'}}; 
		
	
	
	printBoard(IntroBoard);
	System.out.println("Welcome to Tic-Tac-Toe!");
	System.out.println("Begin by picking a symbol. X goes 1st and 0 goes second");
	
	//playerposition = new ArrayList<Integer>();
	//cpuposition = new ArrayList<Integer>();
	
	Scanner Symbpicker = new Scanner(System.in);
	
	char playerchoice = ' ';
	char cpuchoice = ' ';
	String GoesFirst = "";
	String GoesSecond = "";
	
	//User enters which symbol they want to play as. X goes first. O goes second.
	
	
	while(!(playerchoice == 'X' || playerchoice == 'O')) {
		
		System.out.println("Pick your symbol:");
		playerchoice = Symbpicker.next().charAt(0);
		
		//Error checking
		if(!(playerchoice == 'X' || playerchoice == 'O')) {
			System.out.println("Error: Invalid input. Please enter either X or O:");
		}
	
		
		
	}
	
	/*This code allows the program to know who goes first. It needs
	 * to know who goes first so it can assign "X" to that human/AI
	 * 
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
	 * 
	 * 
	 */
	
	//The main board in which the program works with and manipulates
	char Board[][]= {{' ','|',' ','|',' '},
			{'-','+','-','+','-'},
			{' ','|',' ','|',' '},
			{'-','+','-','+','-'},
			{' ','|',' ','|',' '}}; 
	
		String result = "";
	
	while (result == "") {
	
		//New scanner made to receive new input after each turn
	
		
		/*This is where the code runs for each turn between the player and the CPU.
		 * After each turn, a winner gets determined.  
		 * 
		 * 
		 */
	if(GoesFirst == "player") {
		playerTurn(playerpos,Board,playerchoice);
		result = evaluateWeen(Board);
		testResult(result);
		
		if(!(result == "")){
			break;
		}
		
		
		cpuTurn(cpupos,playerpos,Board,cpuchoice);
		result = evaluateWeen(Board);
		testResult(result);
		
		
			}
	
	
	else if (GoesFirst == "cpu") {
		cpuTurn(cpupos,playerpos,Board,cpuchoice);
		result = evaluateWeen(Board);
		testResult(result);
		
		
		if(!(result == "")){
			break;
		}
		
		playerTurn(playerpos,Board,playerchoice);
		result = evaluateWeen(Board);
		testResult(result);
		
			}
		
	
	
		}
	
	
	
	
	}
		
		
	public void printBoard(char TicTacBoard[][]) {
		
		//This is how to go through each column
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
		
		
		
		
		while (running) {
			
			
			try {
				System.out.println("Enter a number from 1-9 to place your piece on the respective square:");
				getplayerpos = scanner.nextInt();
		
			}
			
			catch(InputMismatchException e) {
				System.out.println("Invalid input. Please provide an number in between 1-9.");
				scanner.nextLine();
				continue; //Goes back to the while loop and keeps looping until user provides a number
			}
		
			//While number provided is not in between 1-9
			while(!(box.contains(getplayerpos))) {
				
				
				try {
					System.out.println("The number provided does not fall in between 1-9. Please enter another number:");
					getplayerpos = scanner.nextInt();
					}
				
				catch (InputMismatchException e) {
					System.out.println("Invalid input. Please provide a number in between 1-9.");
					scanner.nextLine();
					getplayerpos = 15; /*Essentially a number given outside of condition on purpose
					so user can input the valid input
					 */
					continue;
					}
				
				
		
				}
		
				
		
		if(playerposition.contains(getplayerpos) | cpuposition.contains(getplayerpos)) {
			
			printBoard(BoardPlayer);
			
			
			System.out.println("A piece has already been placed there. Try again!:");
			//getplayerpos = scanner.nextInt();
			
		
		}
		
		/*If the above if returns false, the program exists the entire while loop 
		 * which means user input validation is complete
		 */
		else {
			running = false;
			
		}
		
		
		
		}
	
	
		
		
		placePiece(BoardPlayer,getplayerpos,"player", playersymb);
		
	}

	
	public void cpuTurn(int cpuselect, int getplayerpos, char BoardCPU[][], char cpusymb) {
		
		//starts
		
		Random rand = new Random();
		
		cpuselect = rand.nextInt(9) + 1;
		
		while(cpuposition.contains(cpuselect) || playerposition.contains(cpuselect)){
			
			
			cpuselect = rand.nextInt(9) + 1;
		
			
			
		}
		
		//ends
		
	
		
		
		placePiece(BoardCPU,cpuselect,"cpu",cpusymb);
		
	}
	
	
	public void placePiece(char Board1[][],int num, String user, char symbol) {
	
		System.out.println("Going into the array:" + num);
		
		if(user == "player") {
			
			playerposition.add(num);
			System.out.println("This is what is added for player: " + playerposition);
			System.out.println("Player board size:" + playerposition.size());
		}
		
		else if(user == "cpu") {
			
			cpuposition.add(num);
			System.out.println("This is what is added for cpu: " + cpuposition);
			System.out.println("Cpu board size:" + cpuposition.size());
		}
		
		switch(num) {
		case 1 : Board1[0][0] = symbol;
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
	
	printBoard(Board1);
	
	}
	
	
	public String evaluateWeen(char BoardState[][]) {
		
		
		List <Integer> toprow = Arrays.asList(1,2,3);
		List <Integer> midrow = Arrays.asList(4,5,6);
		List <Integer> botrow = Arrays.asList(7,8,9);
		List <Integer> leftcol = Arrays.asList(1,4,7);
		List <Integer> midcol = Arrays.asList(2,5,8);
		List <Integer> botcol = Arrays.asList(3,6,9);
		List <Integer> diag1 = Arrays.asList(1,5,9);
		List <Integer> diag2 = Arrays.asList(3,5,7);
		
		
		
		
		List <List> winningCons = new ArrayList<List>();
		
		winningCons.add(toprow);
		winningCons.add(midrow);
		winningCons.add(botrow);
		winningCons.add(leftcol);
		winningCons.add(midcol);
		winningCons.add(botcol);
		winningCons.add(diag1);
		winningCons.add(diag2);
		
		
		for (List l: winningCons) {
			if(playerposition.containsAll(l)) {
			return "Congratulations you won!";
			
				
			}
	

		else if (cpuposition.containsAll(l)){
			return "You lose. Sorry";
			
		}
			
		else if (playerposition.size() + cpuposition.size() == 9) {
			return "A tie! Exciting game!";
		}
			
			
	
		
		
		
		
	}
		return "";

}
	
	public void testResult(String statement) {
		
		System.out.println(statement);
		
		switch(statement) {
		
		case "Congratulations you won!":
			//System.exit(1);
			break;
			
		case "You lose. Sorry":
			//System.exit(1);
			break;
		
		case "A tie! Exciting game!":
			//System.exit(1);
			break;
		
			}
		
		
	}

	
	public static void main (String[] args) {
		
		TicTacToe t = new TicTacToe();
		
	}
	
}
