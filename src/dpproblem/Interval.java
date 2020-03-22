package dpproblem;

public class Interval {

	int start;
	int end;
	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	public Interval() {
		super();
		this.start = 0;
		this.end = 0;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}
	
	
	
}
