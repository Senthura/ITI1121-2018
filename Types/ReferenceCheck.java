
public class ReferenceCheck {

	public static void main(String[] args) {
		
		// 1) Declaring reference variables
		
		// reference to a String
		String myString;

		// reference to an array of primitive variables
		int[] myIntArray;

		// reference to an array of reference variables
		String[] myStringArray;

		// reference to an object
		PrimitiveCheck myPrimitiveCheck;


		// 2) initialization of the references
		myString = "some string";

	 	myIntArray = new int[10]; // creation of an array of 10 int

		myPrimitiveCheck = new PrimitiveCheck();

		myStringArray = new String[24];


		// reference to an array of references to an object:
		PrimitiveCheck[] myPrimitiveCheckArray;
		myPrimitiveCheckArray = new PrimitiveCheck[100]; 
	}
 }
