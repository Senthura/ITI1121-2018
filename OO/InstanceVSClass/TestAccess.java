public class TestAccess {

	public static void main(String[] args){

		TestClass tc = new TestClass();

		tc.instanceMember++;
		tc.classMember++;
		tc.instanceMethod();
		tc.classMethod();

		TestClass.classMember++;
		TestClass.classMethod();
		//TestClass.instanceMember++;
		//TestClass.instanceMethod();

		TestClass tc2 = new TestClass();

		System.out.println(" For tc, instanceMember is " 
			+ tc.instanceMember + " and classMember is "
			+ tc.classMember);
		System.out.println(" For tc2, instanceMember is " 
			+ tc2.instanceMember + " and classMember is "
			+ tc2.classMember);

		tc2.instanceMember++;
		tc2.classMember++;

		System.out.println(" For tc, instanceMember is " 
			+ tc.instanceMember + " and classMember is "
			+ tc.classMember);
		System.out.println(" For tc2, instanceMember is " 
			+ tc2.instanceMember + " and classMember is "
			+ tc2.classMember);
	}
}














































/*
public class TestAccess {

	public TestAccess(){
		PublicClass pc = new PublicClass();

		PublicClass.classMember = 0;
		pc.classMember = 0; // same as PublicClass.classMember;

		//PublicClass.instanceMember = 0;  // illegal				
		pc.instanceMember = 0 ;
		
		PublicClass.classMethod();
		pc.classMethod(); // same as PublicClass.classMember;

		//PublicClass.instanceMethod();  //illegal	
		pc.instanceMethod();
	}

	public static void main(String[] args){
		PublicClass pc1 = new PublicClass();
		PublicClass pc2 = new PublicClass();

		pc1.instanceMember = 0 ;
		pc2.instanceMember = 1 ;
		PublicClass.classMember = 2;
		
		System.out.println(pc1.instanceMember);
		System.out.println(pc1.classMember);
		System.out.println(pc2.instanceMember);
		System.out.println(pc2.classMember);			
	}
}
*/
