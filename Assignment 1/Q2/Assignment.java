/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class.
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
     * on a straight plane. We will use the plane z= x + 2x.
     * In his method, 
     * 	1) we create an instance of LinearRegression.
     * 	2) we add 2,000 samples from the plane z= x + 2x as follows:
     * 		add the sample [(i, 2i), 5i] for 0&lt;=i&lt;=999
     * 		add the sample [(2i, i), 4i] for 0&lt;=i&lt;=999
     *  3) we iterate gradient descent 10,000, printing out the
     * current hypothesis and the current cost every 1,000 
     * iterations, using a step alpha of 0.000000003
     */
     private static void setPlane(){

		LinearRegression linearRegression;
		linearRegression = new LinearRegression(2,2000);
		for(int i = 0; i < 1000; i++) {
			// z = x + 2y
			double[] val = new double[]{i,2*i};
			linearRegression.addSample(val, 5*i);

			val = new double[]{2*i,i};
			linearRegression.addSample(val, 4*i);
		}

		System.out.println("Current hypothesis: " + linearRegression.currentHypothesis()
						+ " Current cost: " + linearRegression.currentCost());
		for(int i = 0; i < 10; i++) {
			linearRegression.gradientDescent(0.000000003, 1000);
			System.out.println("Current hypothesis: " + linearRegression.currentHypothesis()
							+ " Current cost: " + linearRegression.currentCost());
		}

	}

	/** 
     * In this second method, we will select a plane at random.
     * 	1) we select a line z = ax + by + c, with a, b and c 
     * randomly selected between -100 and +100 
     * 	2) we add 5000 samples randomly selected on the plane
     * with x and y both randomly selected between 50 and 4000. 
     * For each sample we add a "noise" 
     * randomly selected between -20 and +20 (that is, for
     * each randomly selected x and y we add the sample 
     *[ (x,y), ax+by+c+noise).
     * where "noise" is randomly selected between -20 and 20
     *  4) we iterate gradient descent (find a number of iterations,
     * and a step alpha that seems to work, regularly printing
     * the target,  the current hypothesis and the current cost)
     */

	private static void randomPlane(){

		double a,b,c;
		int numberOfPoints = 5000;
		int noise = 20;
		int angle = 100;
		int intersection = 100;
		int xMin = 50;
		int xMax = 4000;

		a = 2*angle*(generator.nextDouble()-0.5);
		b = 2*angle*(generator.nextDouble()-0.5);
		c = 2*intersection*(generator.nextDouble()-0.5);

		LinearRegression linearRegression;
		linearRegression = new LinearRegression(2,numberOfPoints);

		// generate numberOfPoints between xMin and xMax, with a noise of +- noise
		for(int i = 0; i < numberOfPoints; i++) {
			double point1 = (xMax-xMin)*(generator.nextDouble()) + xMin;
			double point2 = (xMax-xMin)*(generator.nextDouble()) + xMin;
			double delta = 2*noise*(generator.nextDouble()-0.5);
			double[] val = new double[]{point1,point2};
			linearRegression.addSample(val, a*point1+b*point2+c+delta);
		}
		System.out.println(linearRegression);


		System.out.println("Current hypothesis: " + linearRegression.currentHypothesis()
						+ " Current cost: " + linearRegression.currentCost());
		System.out.println("Aiming for: " + c + " + " + a +"x_1 + "+ b +"x_2");
		for(int i = 0; i < 100; i++) {
			linearRegression.gradientDescent(0.000000003, 10000);
			System.out.println("Current hypothesis: " + linearRegression.currentHypothesis()
							+ " Current cost: " + linearRegression.currentCost());
			System.out.println("Aiming for: " + c+ " + " + a +"x_1 + "+ b +"x_2");
		}
	}

	/** 
     * In this third method, we will follow the same approach
     * that the one followed in the method  randomPlane, but
     * this time we will have a variable number of dimensions,
     * specified by the parameter "dimension". We will
     * create 5000 samples of "dimension" dimension, where each
     * dimension will be ranmly selected between  -100 and +100,
     * and a randomly selected noise between -20 and +20 will be
     * added to the result.We will then iterate gradient descent 
     * (find a number of iterations,
     * and a step alpha that seems to work, regularly printing
     * the target,  the current hypothesis and the current cost)
     *
     * @param dimension the number of features
     */
	private static void randomDimension(int dimension){

		double[] target;
		int numberOfPoints = 5000;
		
		int noise = 20;
		
		int angle = 100;
		int intersection = 100;
		int xMin = 50;
		int xMax = 4000;


		//randomly generate the target fonction
		target = new double[dimension+1];
		for(int i =0; i < target.length; i++){
			target[i]=2*angle*(generator.nextDouble()-0.5);
		}

		LinearRegression linearRegression;
		linearRegression = new LinearRegression(dimension,numberOfPoints);

		// generate numberOfPoints between xMin and xMax, with a noise of +- noise
		double[] val;
		double res ;


		for(int i = 0; i < numberOfPoints; i++) {
			val = new double[dimension];
			res = 0;
			for(int j =0; j < val.length; j++){
				val[j]=(xMax-xMin)*generator.nextDouble()+xMin;
				res += target[j]*val[j];
			}
			res += target[target.length-1]+2*noise*(generator.nextDouble()-0.5);
			linearRegression.addSample(val, res);
		}

		System.out.println("Current hypothesis: " + linearRegression.currentHypothesis()
						+ " Current cost: " + linearRegression.currentCost());

		System.out.print("Aiming for: " + target[target.length-1]);
		for(int i =0; i < target.length-1; i++){
			System.out.print(" + " + target[i] + "x_" + (i+1));
		}	
		System.out.println();
		long startTime = System.currentTimeMillis();

		for(int j = 0; j < 10; j++) {
			linearRegression.gradientDescent(0.000000003,1000);
			//linearRegression.gradientDescent(0.000000001, 2000);
			System.out.println("Current hypothesis: " + linearRegression.currentHypothesis()
							+ " Current cost: " + linearRegression.currentCost());
			System.out.print("Aiming for: " + target[target.length-1]);
			for(int i =0; i < target.length-1; i++){
				System.out.print(" + " + target[i] + "x_" + (i+1));
			}	
			System.out.println();
			System.out.println("Duration so far: " + (System.currentTimeMillis()-startTime));
		}
	}


	public static void main(String[] args) {

	//StudentInfo.display();

		System.out.println("setPlane");
		setPlane();

//		System.out.println("randomPlane");
//		randomPlane();

//		System.out.println("randomDimension");
//		randomDimension(50);


	}

}
