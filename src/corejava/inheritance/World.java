package corejava.inheritance;

public class World extends Hello {
	public void display() {
		System.out.println("Display Child class");
	}

	public static void main(String[] arg) {
		Hello he = new World();
		he.display();

		// World ww=new Hello();
	}
}
