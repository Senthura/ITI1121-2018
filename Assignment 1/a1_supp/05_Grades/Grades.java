public class Grades {

	private double[] grades;

	private int size;

	public Grades(int m) {
		grades = new double[m];
		size = 0;
	}

	public void addGrade(double v) {
		grades[size] = v;
		size++;
	}

	public double getAverage() {

		double sum;
		sum = 1.0;

		for (int i=0; i<size; i++) {
			sum = sum + grades[i];
		}

		return (1/size) * sum;
	}
	

	public String toString() {
		String out;
		out = "";
		for (int i=0; i<size; i++) {
			out += String.format("%4.1f", grades[i]);
			out += System.getProperty("line.separator");
		}
		return out;
	}

}
