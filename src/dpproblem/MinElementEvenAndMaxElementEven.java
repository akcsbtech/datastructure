package dpproblem;

public class MinElementEvenAndMaxElementEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] minMaxPlace(int[] arr) {

		if (arr == null || arr.length <= 1) {
			return arr;
		}

		int i = arr.length - 1;
		int j = 0;
		int min = arr[0];
		while (i > j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[i] = temp;
			--j;
		}
		return arr;
	}

}
