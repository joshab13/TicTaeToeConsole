package Practice123123;

import java.util.Scanner;

public class TicTacToeRunner {

	TicTacToe program;
	
	
	public TicTacToeRunner() {
		
	boolean running = true;
	
	
	while(running) {
		
		program = new TicTacToe(); /*Creates a new instance of the program every time a player
		wants to play the game again.
		 */
		
		
		while(true) {
			
			System.out.println("Do you want to play again? Please say Yes or No:");
			Scanner playagain = new Scanner(System.in);
			String test = playagain.next();
			System.out.println(test);
			
			if(!(test.equals("Yes") || test.equals("No"))){
			
			System.out.println("Invalid response. Please right again.");
				
			}
			
			if(test.equals("No")) {
				running = false;	
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
