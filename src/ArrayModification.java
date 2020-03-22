
public class ArrayModification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 3, 4 };

		int b[] = modifyArray(a);

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " " + b[i]);
		}
	}

	public static int[] modifyArray(int a[]) {
		a[0] = 3;
		return a;
	}

}
