package Immutability;

import java.awt.Color;

public class ColorPoint extends Point {
	private final Color color;
	//private final Point point;
	public ColorPoint(int x, int y, Color color) {
		super(x,y);
		this.color = color;
	}

	@Override
	public boolean equals(Object o) {
		
		if (!(o instanceof Point)) {
			return false;
		}
		
		if (!(o instanceof ColorPoint)) {
			return o.equals(this);
		}
		return super.equals(o) && ((ColorPoint) o).color == color;
	}
	
	public static void main(String [] arg) {
		ColorPoint cp=new ColorPoint(1, 2, Color.green);
		Point po=new Point(1, 2);
		ColorPoint cp2=new ColorPoint(1, 2, Color.green);

		System.out.println("cp.equals(po)"+cp.equals(po));
		System.out.println("cp.equals(po)"+po.equals(cp2));
		System.out.println("cp.equals(po)"+cp.equals(cp2));
		
	}
}
