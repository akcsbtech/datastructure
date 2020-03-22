
public class MethodOverloading {

	public static void add(int a, int b) {
		System.out.println("int");
	}

	public static void add(double a, double b) {
		System.out.println("double");
	}

	public static void main(String[] arg) {
		add(1, 2);
	}

}
