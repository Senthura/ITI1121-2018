/**
 * The class  <b>LinearRegression</b> implements gradient
 * descent for multiple variables
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class LinearRegression{


	/** 
     * Number of features (usually "n" in litterature) 
     */
	private int nbreOfFeatures;

	/** 
     * Number of samples (usually "m" in litterature) 
     */
	private int nbreOfSamples;


	/** 
     * the nbreOfFeatures X nbreOfSamples Matrix of samples
     */
	private double[][] samplesMatrix;

	/** 
     * the nbreOfSamples Matrix of samples target values
     */
	private double[] samplesValues;

	/** 
     * the nbreOfFeatures Matrix theta of current hypthesis function
     */
	private double[] theta;


	/** 
     * number of samples received so far
     */
	private int currentNbreOfSamples;

	/** 
     * a place holder for theta during descent calculation
     */
	private double[] tempTheta;


	/** 
     * counts how many iterations have been performed
     */
	private int iteration;


	/** 
     * Object's contructor. The constructor initializes the instance
     * variables. The starting hypthesis is theta[i]=0.0 for all i
     * 
     * @param n the number of features that we will have
     * @param m the number of samples that we will have
	 *
     */
 	public LinearRegression(int n, int m){

 		nbreOfFeatures = n;
 		nbreOfSamples = m;
 		currentNbreOfSamples = 0;
 		iteration = 0;

 		samplesMatrix = new double[nbreOfSamples][nbreOfFeatures+1];
		samplesValues = new double[nbreOfSamples];
		theta = new double [nbreOfFeatures+1];
		tempTheta = new double [nbreOfFeatures+1];

		// we aribtrarily initialize theta to the vector [0,0,0,0,...,0];
		for(int i = 0; i < theta.length; i++){
			theta[i]=0.0;
		}
	}

	/** 
     * Add a new sample to samplesMatrix and samplesValues
     * 
     * @param x the vectors of samples
     * @param y the coresponding expected value
     *
	 */
	public void addSample(double[] x, double y){

		if(currentNbreOfSamples == nbreOfSamples) {
			System.out.println("Too many samples... ignored");
			return;
		}
		if(x.length != nbreOfFeatures) {
			System.out.println("Wrong sample size, it should have " + nbreOfFeatures + " values and it has " + x.length +". Ignored..");
			return ;
		}
		// x_0 = 1.0
		samplesMatrix[currentNbreOfSamples][0] = 1.0;
		for(int i = 0; i < nbreOfFeatures; i++){
			samplesMatrix[currentNbreOfSamples][i+1] = x[i];
		}

		samplesValues[currentNbreOfSamples]=y;
		currentNbreOfSamples++;
	}

	/** 
     * Returns the current hypothesis for the value of the input
     * @param x the input vector for which we want the current hypothesis
     * 
	 * @return h(x)
	 */

	private double hypothesis(double[] x){
		double response = 0.0;
		for (int i = 0; i <= nbreOfFeatures; i++) {
			response += theta[i]*x[i];
		}
		return response;
	}

	/** 
     * Returns a string representation of hypthesis function
     * 
	 * @return the string "theta0 x_0 + theta1 x_1 + .. thetan x_n"
	 */

	public String currentHypothesis(){
		String answer;

		answer = Double.toString(theta[0]);

		for(int i = 1; i < theta.length; i++){
			if(theta[i] < 0.0) {
				answer += " ";
			} else {
				answer += " +";
			}
			answer += theta[i]+"x_"+i;
		}

		return answer;
	}

	/** 
     * Returns the current cost
     * 
	 * @return the current value of the cost function
	 */

	public double currentCost(){
		double response = 0.0;
		for(int i =0; i < nbreOfSamples; i++) {
			double val = hypothesis(samplesMatrix[i]) - samplesValues[i];
			response += val * val;
		}
		return response/(nbreOfSamples);
	}

	/** 
     * runs several iterations of the gradient descent algorithm
     * 
     * @param alpha the learning rate
     *
     * @param numberOfSteps how many iteration of the algorithm to run
     */

	public void gradientDescent(double alpha, int numberOfSteps) {

		for(int step = 0; step < numberOfSteps; step++){
			for (int i = 0; i <= nbreOfFeatures; i++) {
			 	double sum = 0.0;
				for (int j = 0; j < nbreOfSamples; j++) {
					sum += (hypothesis(samplesMatrix[j])- samplesValues[j])*samplesMatrix[j][i];
				}	
				tempTheta[i] = theta[i]- 2*alpha*sum/nbreOfSamples;
			}
			for(int i = 0; i <= nbreOfFeatures; i++) {
				theta[i] = tempTheta[i];
			}	
			iteration++; 

		}
	}


	/** 
     * Getter for theta
     *
	 * @return theta
	 */

	public double[] getTheta(){
		return theta;
	}

	/** 
     * Getter for iteration
     *
	 * @return iteration
	 */

	public int getIteration(){
		return iteration;
	}
}
