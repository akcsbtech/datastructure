package grokkingpattern;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
		System.out.println(RemoveDuplicates.removeDuplicates(arr));

		arr = new int[] { 2, 2, 2, 11 };
		System.out.println(RemoveDuplicates.removeDuplicates(arr));
	}

	public static int removeDuplicates(int a[]) {
		int nonDup = 1;

		for (int i = 1; i < a.length; i++) {
			if (a[nonDup - 1] != a[i]) {
				a[nonDup] = a[i];
				++nonDup;
			}
		}
		return nonDup;
	}
}
