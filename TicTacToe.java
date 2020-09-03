package Practice123123;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> playerposition = new ArrayList<Integer>();
	
	static ArrayList<Integer> cpuposition = new ArrayList<Integer>();
	

	public static void main(String[] args) {
		
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
	
	for (;;) {
	
		//New scanner made to receive new input after each turn
	
		
	if(GoesFirst == "player") {
		playerTurn(playerpos,Board);
		cpuTurn(cpupos,playerpos,Board);
		
	}
	
	else if (GoesFirst == "cpu") {
		cpuTurn(cpupos,playerpos,Board);
		playerTurn(playerpos,Board);
		
	}
		
	
	String result = evaluateWeen(Board);
	
	System.out.println(result);
	
	switch(result) {
	
	case "Congratulations you won!":
		System.exit(1);
		break;
		
	case "You lose. Sorry":
		System.exit(1);
		break;
	
	case "CAT!":
		System.exit(1);
		break;
	
		}
	
	}
	
	
	}
		
		
	public static void printBoard(char TicTacBoard[][]) {
		
		//This is how to go through each column
		for (char x[]:TicTacBoard) {
			for(char c:x) {
			
				System.out.print(c);
				
			}
			System.out.println();
			
		
		}

	
	}
	
	
	public static void playerTurn(int getplayerpos, char BoardPlayer[][]) {
		
		Scanner scanner = new Scanner(System.in); //Create object to receive input
		
		
		System.out.println("Enter a number from 1-9 to place your piece on the respective square:");
		
		getplayerpos = scanner.nextInt(); //Reads an integer from user input
		
		System.out.println(getplayerpos); //Just used to test output
		
		
		
		/*Error checking to ensure player doesn't place their symbol on a square
		 * that has already been claimed by the player or the AI
		 */
		while(playerposition.contains(getplayerpos) || cpuposition.contains(getplayerpos)) {
			
			printBoard(BoardPlayer);
			System.out.println("A piece has already been placed there. Try again!:");
			getplayerpos = scanner.nextInt();
			
		}
	
		
		placePiece(BoardPlayer,getplayerpos,"player", 'X');
		
	}

	
	public static void cpuTurn(int cpuselect, int getplayerpos, char BoardCPU[][]) {
		
		Random rand = new Random();
		
		cpuselect = rand.nextInt(9) + 1;
		
		for(;;) {
			//Keeps running until cpu decision is not equal to the player of the game
		if (cpuselect == getplayerpos) {
		
			cpuselect = rand.nextInt(9) + 1;
		
		
		}
		
		break;
		}
		
		placePiece(BoardCPU,cpuselect,"cpu",'O');
		
	}
	
	
	public static void placePiece(char Board1[][],int num, String user, char symbol) {
	
		System.out.println("Going into the array:" + num);
		
		if(user == "player") {
			
			playerposition.add(num);
			System.out.println("This is what is added for player: " + playerposition);
		}
		
		else if(user == "cpu") {
			
			cpuposition.add(num);
			System.out.println("This is what is added for cpu: " + cpuposition);
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
	
	
	public static String evaluateWeen(char BoardState[][]) {
		
		
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
			return "CAT!";
		}
			
			
	
		
		
		
		
	}
		return "";

}
	
}
