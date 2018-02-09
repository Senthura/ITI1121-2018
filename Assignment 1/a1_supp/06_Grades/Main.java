import java.util.Random;

public class Main {

    public static final int CLASS_SIZE = 10;
    
    public static void main(String[] args) {

	Random gen;
	gen = new Random();

	Grades gs;
	gs = new Grades(CLASS_SIZE);
	
	for (int i=0; i<CLASS_SIZE; i++) {
	    gs.addGrade(gen.nextDouble() * 100.0);
	}

	System.out.println(gs);

	System.out.println("Average = " + gs.getAverage());
    }

}
