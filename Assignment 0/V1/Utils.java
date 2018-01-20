import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.Random;

public class Utils {

    // Usage: Utils.readAllLines(fileName)
    
    public static String[] readAllLines(String fileName) {

	String[] lines = null;

	try {
	    lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8).toArray(new String[0]);
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(1);
	}

	return lines;

    }

    private static Random generator;
     /** 
     * Randomly shuffles arrayOfChars. 
     * usage: Utils.shuffleArray(arrayOfChars)
     * 
     *   @param arrayOfChars the array of chars
     */
	public static void shuffleArray(char[] arrayOfChars){

		if( arrayOfChars == null ) {
			System.out.println("shuffleArray: wrong call");
			return ;
		}

		if(generator == null) {
			generator = new Random();
		}
		
		for(int i = arrayOfChars.length -1 ; i > 1 ; i--){
			swapItems(arrayOfChars, i, generator.nextInt(i-1));
		}
	}

	private static void swapItems(char[] arrayOfChars, int i, int j){
		char intermediate = arrayOfChars[i];
		arrayOfChars[i]=arrayOfChars[j];
		arrayOfChars[j]=intermediate;
	}

    
	/** 
     * Does a lexicographic sorting of arrayOfChars. 
     * It simply relies on the sort method
	 * of java.util.Arrays. 
	 * Usage: Utils.sortArray(arrayOfChar)
     * 
     *   @param arrayOfChars the array of char
     */
	public static void sortArray(char[] arrayOfChar){
	 	java.util.Arrays.sort(arrayOfChar);
	}

}
