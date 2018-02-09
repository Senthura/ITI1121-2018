/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. It uses the
 * provided class <b>Display</b> to show the results
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class Assignment {


	/** 
     * Random generator 
     */
	private static java.util.Random generator = new java.util.Random();

	

	/** 
     * In this first method, we are simply using sample points that are
     * on a straight line, namely y = x;
     * In his method, 
     * 	1) we create an instance of LinearRegression.
     * 	2) we add 1,000 samples (from 0 to 999) from the line y=x
     *  3) We create an instance of Display
     *  4) we iterate gradient descent 5,000, updating the instance
     * of Display every 100 iteration, using a step alpha of 0.000000003
     */

	private static void setLine(){

		LinearRegression linearRegression;
		linearRegression = new LinearRegression(1000);
		for(int i = 0; i < 1000; i++) {
			linearRegression.addSample(i, i);
		}

		Display graph = new Display(linearRegression);

		System.out.println("Current hypothesis: " + linearRegression.currentHypothesis()
						+ " Current cost: " + linearRegression.currentCost());
		graph.update();

		for(int i = 0; i < 50; i++) {
			linearRegression.gradientDescent(0.000000003, 100);
			System.out.println("Current hypothesis: " + linearRegression.currentHypothesis()
							+ " Current cost: " + linearRegression.currentCost());
			graph.update();
		}
	}

	private static void fromFile(){

		LinearRegression linearRegression;
		linearRegression = new LinearRegression(100);
        java.io.File file= new java.io.File("data.csv");
        java.util.Scanner inputStream;

        try{
            inputStream = new java.util.Scanner(file);
            while(inputStream.hasNext()){
                String[] values = inputStream.next().split(",");
                linearRegression.addSample(Double.parseDouble(values[0]), Double.parseDouble(values[1]));
            }

            inputStream.close();
        }catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }

		Display graph = new Display(linearRegression);
		System.out.println("Current hypothesis: " + linearRegression.currentHypothesis()
						+ " Current cost: " + linearRegression.currentCost());
		graph.update();
		linearRegression.gradientDescent(0.000005, 2000);
		System.out.println("Current hypothesis: " + linearRegression.currentHypothesis()
						+ " Current cost: " + linearRegression.currentCost());
		graph.update();
	}

	/** 
     * In this second method, we will select a line at random.
     * 	1) we select a line y = ax + b, with a randomly selected
     * between -100 and +100 and b randomly selected between 
     * -250 and +250
     * 	2) we add 500 samples randomly selected on the line
     * between -100 and +300. For each sample we add a "noise" 
     * randomly selected between -1000 and +1000 (that is, for
     * each randomly selected x, we add the sample (x, ax+b+noise).
     * where "noise" is randomly selected between -1000 and 1000
     *  3) We create an instance of Display
     *  4) we iterate gradient descent (find a number of iterations,
     * a number of updates to the instance of Display, and a 
     * step alpha that seems to work
     */
	private static void randomLine(){

		double a,b;
		int numberOfPoints = 500;
		int noise = 1000;
		int angle = 100;
		int intersection = 250;
		int xMin = -100;
		int xMax = +300;

		LinearRegression linearRegression;
		linearRegression = new LinearRegression(numberOfPoints);

		Display graph = new Display(linearRegression);

		//randomly generate a function y = ax + b, with a and b 

		a = 2*angle*(generator.nextDouble()-0.5);
		b = 2*intersection*(generator.nextDouble()-0.5);

		graph.setTarget(a,b);

		// generate numberOfPoints between xMin and xMax, with a noise of +- noise
		for(int i = 0; i < numberOfPoints; i++) {
			double point = (xMax-xMin)*(generator.nextDouble()) + xMin;
			double delta = 2*noise*(generator.nextDouble()-0.5);
			linearRegression.addSample(point, a*point+b+delta);
		}

		System.out.println("Current hypothesis: " + linearRegression.currentHypothesis()
						+ " Current cost: " + linearRegression.currentCost());
		System.out.println("Aiming for: " + b + "+" + a +"x_1");
		graph.update();
     
		for(int i = 0; i < 1000; i++) {
			linearRegression.gradientDescent(0.000000003, 100);
			System.out.println("Current hypothesis: " + linearRegression.currentHypothesis()
							+ " Current cost: " + linearRegression.currentCost());
			System.out.println("Aiming for: " + b + "+" + a +"x_1");
			graph.update();
		}
	}

	public static void main(String[] args) {

	//StudentInfo.display();

//		System.out.println("setLine");
//		setLine();

//		System.out.println("fromFile");
//		fromFile();

		System.out.println("randomLine");
		randomLine();

	}

}
