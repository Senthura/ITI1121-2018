public class Main {

  public static final int NUMBER_OF_FEATURES = 5;
  public static final int NUMBER_OF_SAMPLES = 10;

  public static void main(String[] args) {

    double[] sample;

    double value;
    value = 0.0;

    Samples training;
    training = new Samples(NUMBER_OF_SAMPLES, NUMBER_OF_FEATURES);

    for (int i=0; i<NUMBER_OF_SAMPLES; i++) {

	      sample = new double[NUMBER_OF_FEATURES];

        for (int j=0; j<NUMBER_OF_FEATURES; j++) {
          sample[j] = value;
          value = value + 1.0;
        }
        training.addSample(sample);
    }

    System.out.print(training);
  }

}
