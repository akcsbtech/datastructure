package corejava;

public class MyArray {

	public static void main(String[] arg) {
		int a[] = { 1, 2, 3, 4 };
		int b[] = array(a);

		for (int i = 0; i < a.length; i++) {
			System.out.println(" a :" + a[i] + "  b:" + b[i]);
		}
	}

	public static int[] array(int[] c) {
		c[3] = 10;
		return c;
	}
}
