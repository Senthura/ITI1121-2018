public  class Point {
	
	int x, y,z;
	
	public static boolean equal(Point p1, Point p2) {
		return ((p1.x==p2.x) && (p1.y == p2.y));
	}

	public static  Point sum (Point p1, Point p2) {

		Point result;

		result = new Point(p1.x+p2.x, p1.y+p2.y);

		return result;

	}
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}