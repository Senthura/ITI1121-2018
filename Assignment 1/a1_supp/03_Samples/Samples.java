public class Samples {

  private double[][] matrix;

  private int size;

  public Samples(int m, int n) {
    matrix = new double[m][n];
    size = 0;
  }

  public void addSample(double[] vs) {

    for (int j=0; j<vs.length; j++) {
      matrix[size][j] = vs[j];
    }

    size++;
  }

  public double[] getSample(int i) {

    double[] v;
    v = new double[matrix[i].length];

    for (int j=0; j<matrix[i].length; j++) {
      v[j] = matrix[i][j];
    }

    return v;
  }

  public String toString() {
    String out;
    out = "";
    for (int i=0; i<size; i++) {
      for (int j=0; j<matrix[i].length; j++) {
        if (j>0) {
          out += ", ";
        }
        out += String.format("%4.1f", matrix[i][j]);
      }
      out += System.getProperty("line.separator");
    }
    return out;
  }

}
