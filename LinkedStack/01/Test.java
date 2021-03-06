/** ITI 1121/1521 Introduction to computer science II
 *
 *  This test program illustrates some of the advantages of Generics
 *  over the traditional Java implementation of a Stack.
 *
 *  @author Marcel Turcotte (turcotte@site.uottawa.ca>
 */



public class Test {

	public static void main( String[] args ) {


		System.out.println("LinkedStack, with Integer");
		Stack num11;
		num11 = new LinkedStack();

		num11.push( new Integer( 1 ) );
		num11.push( new Integer( 2 ) );
		num11.push( new Integer( 3 ) );

		while ( ! num11.isEmpty() ) {
			Integer num;
			num =  (Integer)num11.pop();
			System.out.println( num );
		}

		System.out.println("ArrayStack, with Integer");
		num11 = new ArrayStack(10);

		num11.push( new Integer( 1 ) );
		num11.push( new Integer( 2 ) );
		num11.push( new Integer( 3 ) );

		while ( ! num11.isEmpty() ) {
			Integer num;
			num =  (Integer)num11.pop();
			System.out.println( num );
		}



		System.out.println("LinkedStack, with String");
		Stack op1;
		op1 = new LinkedStack();

		op1.push( "plus" );
		op1.push( "mult" );
		op1.push( "div" );

		while ( ! op1.isEmpty() ) {
			String op;
			op = (String) op1.pop();
			System.out.println( op );
		}

		op1.push( new Integer( 4 ) ); 


		System.out.println("ArrayStack, with String");
		op1 = new ArrayStack( 10 );

		op1.push( "plus" );
		op1.push( "mult" );
		op1.push( "div" );

		while ( ! op1.isEmpty() ) {
			String op;
			op = (String) op1.pop();
			System.out.println( op );
		}

		op1.push( new Integer( 4 ) ); 


	}
}
