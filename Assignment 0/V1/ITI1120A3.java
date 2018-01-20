
import java.util.Scanner;

/**
 * The class <b>ITI1120A3</b> is an implementation of the
 * ``Concentration'' card game, based on the Python implementation
 * given in ITI1020
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class ITI1120A3{

	/**
	* Since the original assignment called for NO ``global variables''
	* we are going to implement this without any class or instance variables
	*/


 


	/** 
     * Creates a new board of size sizeBoard, which should be
     * an even integer between 2 and 52
     * 
     *   @param sizeBoard the size of the board to be created
	 *
	 *   @return a reference to the newly created board
	 */
	private static char[] createBoard(int sizeBoard){
		
		char[] board;
		if( sizeBoard < 1 || sizeBoard > 52 || sizeBoard%2 == 1 ) {
			System.out.println("createBoard: wrong size: " + sizeBoard
				+". It should be an even integer between 2 and 52");
			return null;
		}

		board = new char[sizeBoard];

    	int currentASCII = (int)'A';

    	for(int i =0; i < sizeBoard/2; i++){
    	  board[i]=(char)currentASCII;
          board[i+sizeBoard/2]=(char)currentASCII;
          currentASCII++;
      	}
      	return board;
    }

	/** 
     * nicely print the current board, and indicates indexes underneath.
     * To avoid losing information, we will print 10 items per lines
     * 
     *   @param board  character array to be printed
     */
	private static void printBoard(char[] board){

		int numberOfLines;
		int lineLength;

		lineLength = 10;

		numberOfLines = board.length/lineLength;

		for(int l=0; l < numberOfLines; l++){
			for(int i =  0 ; i < lineLength; i++){
				System.out.print("\t"+ board[l*lineLength+i]);
			}
			System.out.println();
			for(int i = 0 ; i < lineLength; i++){
				System.out.print("\t" + (l*lineLength+i+1));
			}
			System.out.println();
		}
		// last line
		for(int i =  0 ; i < board.length%lineLength; i++){
			System.out.print("\t" + board[numberOfLines*lineLength+i]);
		}
		System.out.println();
		for(int i = 0 ; i < board.length%lineLength; i++){
			System.out.print("\t" + (numberOfLines*lineLength+i+1));
		}
		System.out.println();
	}

	/** 
     * Waits for user input
     *
     * @param sc An instance of java.util.Scanner, which will get input from the
	 * standard input
     */
	private static void waitForPlayer(Scanner sc){
		System.out.println("Press enter to continue...");
		sc.nextLine();
	}


	/** 
     * Prints a series of newlines to clear the scren
     */
	private static void clearScreen(){
		for(int i = 0; i < 50 ; i++) {
			System.out.println();
		}
	}

	/** 
     * Displays the revealed cards, with 2 new ones revealed
     *
     *   @param discovered the array of discovered cards
     *   @param p1 new position to reveal, 0<= p1 <  discovered.length
     *   @param p2 new position to reveal, 0<= p2 <  discovered.length
     *   @param board the orginal array of  cards
     */

	private static void printRevealed(char[] discovered, int p1, int p2, char[] board){

    	discovered[p1 - 1] = board[p1 - 1];
    	discovered[p2 - 1] = board[p2 - 1];
    
   	 	printBoard(discovered);
    }
	

	/** 
     * Reads the boad from a file. The file is assumed to contain the correct information
	 *
     *   @param fileName the file name
     *	 @return the board
     */
 	private static char[] readRawBoard(String fileName){

        char[] board;
        String[] allLines;
        allLines = Utils.readAllLines(fileName);

		board = new char[allLines.length];
		for(int i = 0; i < allLines.length; i++){
			board[i]=allLines[i].charAt(0);
		}
        return board;
	}



	/** 
     * ``cleans up'' the board, that is, removes `*` and only keeps an even number of 
     * occurence of the other characters
     *
     *   @param board the board to clean the file name
     *	 @return a clean, sorted board
     */

 	private static char[] cleanUpBoard(char[] board){

	    System.out.println("Removing one of each cards that appears odd number of times and removing all stars ...");
	    
	    char[] intermediate, answer;


	    Utils.sortArray(board);
	    intermediate = new char[board.length];
	    int currentIndex = 0;
	    char first, second;
	    for(int i = 0; i < board.length - 1; i++) {
	    	first = board[i];
	    	second = board[i+1];
	    	if((first == second) && (first != '*')) {
	    		intermediate[currentIndex++] = first;
	    		intermediate[currentIndex++] = second;
	    		i++;
	    	}
	    }

	    // intermediate had the correct elements, but the wrong size.
	    answer = new char[currentIndex];
	    for(int i = 0; i < currentIndex; i++) {
	    	answer[i] = intermediate[i];
	    }
	    return answer;
	}


	/** 
     * Checks if the board is "rigorous", that is, every 
     * element in the list appears exactly 2 times or the list is empty
     *
     *   @param board the board to check
     *	 @return true if and only if the board is rigorous. Warning: calling
     *			this methos will sort the parameter board as a side effect!
     *	
     */

 	private static boolean isRigorous(char[] board){


	    if (board.length == 0) {
	    	return true;
	    }

	    Utils.sortArray(board);
	    int i = 0;
	    while(i < board.length - 2) {
	    	if((board[i] != board[i+1]) || (board[i] == board[i+2])) {
	    		return false;
	    	}
	    	i = i + 2;
	    }
	    return true;
	}


	/** 
     * Plays the concentration game
     *
     *   @param board a char array representing a playable deck of cards
     *   @param sc An instance of java.util.Scanner, which will get input from the
	 * standard input
 	 *
     */
	private static void playGame(char[] board, Scanner sc) {

    	System.out.println("Ready to play ...");

    	// board of uncovered cards, initialized to '*'
    	char[] discovered;
    	discovered = new char[board.length];

    	for(int i = 0; i  < discovered.length; i++) {
    		discovered[i]='*';
    	}
    
    	// while discovered != board: // doesn't work in Java!
    	int guesses, numberUncovered, p1, p2;
    	boolean ok;

    	guesses = 0;
    	numberUncovered = 0;

    	while(numberUncovered != discovered.length) {

        	printBoard(discovered);
  
        	p1 = p2 = 0;      	
        	ok = false;
        	while(!ok) {
 	            System.out.println("\nEnter two distinct positions on the board that you want revealed."
    	        	+ "\ni.e two integers in the range [1, " + discovered.length + "]");
    	        System.out.println("Enter position 1: ");
				p1 = sc.nextInt();
    	        System.out.println("Enter position 2: ");
				p2 = sc.nextInt();
				//empty buffer
 		    	sc.nextLine();
 
				ok = true;
				if(p1 < 1 || p2 < 1 || p1 > discovered.length || p2 > discovered.length){
	                System.out.println("One of both of your chosen positions is out of range.");
	                ok = false;
				} else if (discovered[p1-1]!='*' || discovered[p2-1]!='*') {
	                System.out.println("One or both of your chosen positions has already been paired.");
	                ok = false;					
				} else if (p1 == p2) {
	                System.out.println("You chose the same positions.");
	                ok = false;										
				}
 
 				if(!ok) {
 					System.out.println("Please try again. This guess did not count."
 						+"Your current number of guesses is " + guesses + ".");
 				}
        	}
        
	        printRevealed(discovered, p1, p2, board);
	        waitForPlayer(sc);
	        clearScreen();
	        if(discovered[p1 - 1] != discovered[p2 - 1]) {
	            discovered[p1 - 1] = '*';
    	        discovered[p2 - 1] = '*';
	        } else {
	        	numberUncovered +=2;
	        }
	        guesses++;
		}
    	
    	System.out.println("Congratulations! You completed the game with " 
    		+ guesses + " guesses. That is " + (guesses - discovered.length/2)  
    		+ " more than the best possible.");

	}


	/** 
     * Constructor of the class. Creates the full deck of cards and initiates the game
     */

 	public  ITI1120A3(){
		
		Scanner sc = new Scanner(System.in);
		char[] board;


		System.out.println("Welcome to my Concentration game");

		System.out.println("Would you like (enter 1 or 2 to indicate your choice):");
		System.out.println("(1) me to generate a rigorous deck of cards for you");
		System.out.println("(2) or, would you like me to read a deck from a file?");

		int choice;
		choice = sc.nextInt();
		while (choice!=1 && choice!=2) {
		    System.out.println("" + choice + " is not an existing option. Please try again. Enter 1 or 2 to indicate your choice");
			choice = sc.nextInt();
		}

		if(choice == 1) {
	    	System.out.println("You chose to have a rigorous deck generated for you");
	 		int size;
			size = -1;
			while(size%2 != 0  || size < 1 || size > 52){
				System.out.print("How many cards do you want to play with?\nEnter an even number between 1 and 52: ");
				size = sc.nextInt();
	 
			}
			board = createBoard(size);
		} else {
			//empty buffer
 		    sc.nextLine();
 
			System.out.println("You chose to load a deck of cards from a file.");
			System.out.print("Enter the name of the file: ");
			String fileName = sc.nextLine();

			board = readRawBoard(fileName);
			board = cleanUpBoard(board);
			if (isRigorous(board)){
				System.out.println("This deck is now playable and rigorous and it has "+board.length+" cards.");
			} else {
				System.out.println("This deck is now playable but is NOT rigorous and it has "+board.length+" cards.");

			}
		}
		Utils.shuffleArray(board);
		playGame(board,sc);
	}


	/**
     * The main method of this program. Creates the game object
     * and calls the playGame method on it.
     * @param args ignored
	 */    

 
	public static void main(String[] args){
	
		StudentInfo.display();
		ITI1120A3 game = new ITI1120A3();		
		
	}
}