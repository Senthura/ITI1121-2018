
public class MyInteger {

	int val;

	public MyInteger (int theValue){
		val = theValue;
	}

	public static void main(String[] args){

		MyInteger i;

		i = new MyInteger(23);

		System.out.println(i.val); 

		i.val = 22;
		System.out.println(i.val); 

		i.val = i.val + 1;
		System.out.println(i.val); 

		i.val++;
		System.out.println(i.val); 

		// Comparing the behavior of references and primitive variables
		// 2 primitive variables int
		int prim1, prim2;

		// 2 reference variables MyInteger
		MyInteger ref1, ref2;

		prim1 = 34;
		prim2 = prim1;

		ref1 = new MyInteger(34);
		ref2 = ref1;

		System.out.println("prim1 = " + prim1 + ", prim2 = " + prim2);
		System.out.println("ref1 = " + ref1.val + ", ref2 = " + ref2.val);

		// modifying the first variable, and testing the side effect on the second
		prim1++;
		ref1.val++;
		System.out.println("prim1 = " + prim1 + ", prim2 = " + prim2);
		System.out.println("ref1 = " + ref1.val + ", ref2 = " + ref2.val);

	}
}

