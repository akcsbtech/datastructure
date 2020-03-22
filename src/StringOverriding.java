
public class StringOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		Integer i = new Integer(10);
		A(i);
		System.out.println("Stirng method call " + i);
	}

	public static void A(int a) {
		System.out.println("Stirng method call " + a);
	}

	public static void A(Integer a) {
		a = a + 10;
		System.out.println("Object method call " + a);
	}
}
