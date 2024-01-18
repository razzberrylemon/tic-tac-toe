import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

	public static void main(String[] args) {
		//instructions that lay out what to do 
		//pick either X or O
		//print game board
		/*enter number to identify space (1 2 3
		 * 								  4 5 6
		 * 								  7 8 9) or 0-based might be easier for array
		 */
		//based on user input of number, print X or O
		//computer takes a turn (just do next open space)
			//maybe use an array of 9, fill with either 1 or 0, print based on that
				//maybe also use a 2-d array, might make checking winner easier
			//find open space by random number 0-8, check if that space is open, if open print number & fill space, else random again
		//start with: when array is full game is over
		//figure out: check three in a row
		
		Scanner scan = new Scanner(System.in);

		//determine each players character
		System.out.println("Enter X for X, enter O for O");
		//takes next as a String, then only uses the first character of what is entered
		char userChar = scan.next().charAt(0);
		char computerChar;
		
		if(userChar == 'X') {
			computerChar = 'O';
		} else {
			computerChar = 'X';
		}
		
		//game instructions
		System.out.println("\nTo take a turn, chose the number that corresponds to the space on the board as so:");
		System.out.println("\n1|2|3 \n-----\n4|5|6\n-----\n7|8|9");
		
		//2-d array for game board including dividers
		//ask for number that corresponds to space and fill it in 
		char[][] board = {
						  {' ', '|', ' ', '|', ' '}, 
						  {'-', '-', '-', '-', '-'}, 
						  {' ', '|', ' ', '|', ' '},
						  {'-', '-', '-', '-', '-'},
						  {' ', '|', ' ', '|', ' '}
						 }; 
	
		//spaces for players: 00, 02, 04, 20, 22, 24, 40, 42, 44		
		do {
			userTurn(board, userChar);
			computerTurn(board, computerChar);
			//should continue until all spaces for players are full (for now)	
		} while (board[0][0] == ' ' || board[0][2] == ' ' ||
				board[0][4] == ' ' || board[2][0] == ' ' || 
				board[2][2] == ' ' || board[2][4] == ' ' || 
				board[4][0] == ' ' || board[4][2] == ' ' || board[4][4] == ' ');

	}
	
	//prints out the 2-D char array that is the game board. This board updates 
	//each turn with the new characters being added as the game is played.
	private static void printBoard(char[][] board) {
		for (char[] row : board) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	//The user enters a number between 1 and 9 which corresponds to a space on 
	//the game board. Based on this number, the users character is placed in that
	//location.
	private static void userTurn(char[][] board, char character) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nEnter a number 1 - 9");
		int space = scan.nextInt();
		
		//do while loop like computer turn, with a message to enter another number
		//
		if (space == 1) {
			board[0][0] = character;
		} else if (space == 2) {
			board[0][2] = character;
		} else if (space == 3) {
			board[0][4] = character;
		} else if (space == 4) {
			board[2][0] = character;
		} else if (space == 5) {
			board[2][2] = character;
		} else if (space == 6) {
			board[2][4] = character;
		} else if (space == 7) {
			board[4][0] = character;
		} else if (space == 8) {
			board[4][2] = character;
		} else if (space == 9) {
			board[4][4] = character;
		} else {
			throw new IllegalArgumentException("input was not between 1 and 9");
		}
		printBoard(board);
	}
	
	//Prints blank lines to separate past boards. Then, picks random number
	//between 1 and 9. After checking if the corresponding space to that number
	//is open, place the character there. If the space is not open a new number
	//is picked and the process is done again. At the end a new board is printed.
	private static void computerTurn(char[][] board, char character) {
		//random number 1 - 9
		//check if that space is available 
		//if yes, put char there
		//if not do again
		//print board
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
		
		Random rand = new Random();
		boolean spaceFull = true;
		
		do {
			int space = rand.nextInt(8) + 1;
			
			if (space == 1) {
				if (board[0][0] == ' ') {
					spaceFull = false;
					board[0][0] = character;
				}
			} else if (space == 2) {
				if (board[0][2] == ' ') {
					spaceFull = false;
					board[0][2] = character;
				}
			} else if (space == 3) {
				if (board[0][4] == ' ') {
					spaceFull = false;
					board[0][4] = character;
				}
			} else if (space == 4) {
				if (board[2][0] == ' ') {
					spaceFull = false;
					board[2][0] = character;
				}
			} else if (space == 5) {
				if (board[2][2] == ' ') {
					spaceFull = false;
					board[2][2] = character;
				}
			} else if (space == 6) {
				if (board[2][4] == ' ') {
					spaceFull = false;
					board[2][4] = character;
				}
			} else if (space == 7) {
				if (board[4][0] == ' ') {
					spaceFull = false;
					board[4][0] = character;
				}
			} else if (space == 8) {
				if (board[4][2] == ' ') {
					spaceFull = false;
					board[4][2] = character;
				}
			} else if (space == 9) {
				if (board[4][4] == ' ') {
					spaceFull = false;
					board[4][4] = character;
				}
			}
		} while (spaceFull);
		
		printBoard(board);
		
	}

}
