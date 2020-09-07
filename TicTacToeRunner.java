package Practice123123;

import java.util.Scanner;

public class TicTacToeRunner {

	TicTacToe program;
	
	
	public TicTacToeRunner() {
		
	boolean running = true; /*The running variable is used to control flow of the program.
	It will remain true until the user decides to stop playing the game.
	*/
	
	while(running) {
		
		program = new TicTacToe(); /*Creates a new instance of the program every time a player
		wants to play the game again. This is where the actual Tic-Tac-Toe code lies
		 */
		
		
		while(true) { //Keeps asking question to user until they provide exact input or they enter "No"
			
			System.out.println("Do you want to play again? Please say Yes or No:");
			Scanner playagain = new Scanner(System.in); //Scanner created to gather input from user
			String test = playagain.next();
			
			//System.out.println(test);
			
			if(!(test.equals("Yes") || test.equals("No"))){
			
			System.out.println("Invalid response. Please right again.");
				
			}
			
			if(test.equals("No")) {
				running = false;	//This will ensure the program doesn't again
				break;
				}
			
			
			if(test.equals("Yes")) {
				break;
			}
			
		}
			
		
		
		
	}
		
		
	}
	
	
		
	
	
	public static void main(String[] args) {
		
	TicTacToeRunner s = new TicTacToeRunner();

	}
	
	
}
