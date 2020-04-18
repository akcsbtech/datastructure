package grokkingpattern;

class SortedArraySquares {

	public static int[] makeSquares(int[] arr) {
		int[] squares = new int[arr.length];
		// TODO: Write your code here
		int i = 0;
		int j = arr.length - 1;
		int count = arr.length - 1;
		while (i < j) {
			if (arr[i] * arr[i] > arr[j] * arr[j]) {
				squares[count] = arr[i] * arr[i];
				++i;
			} else {
				squares[count] = arr[j] * arr[j];
				--j;
			}
			--count;
		}
		return squares;
	}

	public static void main(String[] args) {

		int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
		for (int num : result)
			System.out.print(num + " ");
		System.out.println();

		result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2,9 });
		for (int num : result)
			System.out.print(num + " ");
		System.out.println();
	}
}