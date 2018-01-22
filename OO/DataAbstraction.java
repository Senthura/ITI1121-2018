public class DataAbstraction {
	


    public static void main(String[] args){

    	// first point
    	Point p1;

    	p1 = new Point(0,0);


    	// second point
	    Point p2;

	    p2 = new Point(1,1);

    	if(equal(p1,p2)) {
    		System.out.print("equal");
    	}

    }
}
































/*
    public static boolean equal(int x1,int y1,int x2,int y2){
		return (x1==x2 && y1==y2);
	}

	public static void main(String[] args){

		// first point
		int x1=0;
		int y1=0;

		// second point
		int x2=1;
		int y2=1;
		System.out.println(equal(x1,y1,x2,y2));
	}

}
*/
