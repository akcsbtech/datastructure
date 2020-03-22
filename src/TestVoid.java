
public class TestVoid {

	public static void main(String [] arg) {
		TestVoid testVoid=new TestVoid();
		testVoid.abc();
	}
	public void abc() {
		System.out.println("abc call");
		xyz();
		System.out.println("xyz call and finish");
	}
	public void xyz() {
		System.out.println("Xyx call");
		return;
	}
}
