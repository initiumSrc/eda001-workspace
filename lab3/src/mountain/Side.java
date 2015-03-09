package mountain;

public class Side {
	private Point a;
	private Point b;
	private Point mid;

	public Side(Point a, Point b, Point mid) {
		this.a = a;
		this.b = b;
		this.mid = mid;
	}
	
/*	public Side(Side s) {
		this.a = s.getA();
		this.b = s.getB();
		this.mid = s.getMid();
	} */
	
	public Point getMid() {
		return mid;
	}
//	public Point getMid() {
//		return new Point((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
//	}
	
	public Point getA() {
		return a;
	}
	
	public Point getB() {
		return b;
	}
	
	public boolean equals(Object s) {
		if (s instanceof Side) {
			Side side = (Side)s;

			if (this.a.equals(side.a) && this.b.equals(side.b))
				return true;
			
			
			if (this.a.equals(side.b) && this.b.equals(side.a))
				return true;
		}
		return false;
	}
}