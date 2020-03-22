package slidingwindow;

public class SmalletLengthArrayGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = SmalletLengthArrayGivenSum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
		System.out.println("Smallest subarray length: " + result);
		result = SmalletLengthArrayGivenSum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
		System.out.println("Smallest subarray length: " + result);
		result = SmalletLengthArrayGivenSum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
		System.out.println("Smallest subarray length: " + result);
	}

	public static int findMinSubArray(int K, int[] num) {
		int minLength = Integer.MAX_VALUE;
		int startWindow = 0;
		int s = 0;
		for (int endWindow = 0; endWindow < num.length; endWindow++) {
			s = s + num[endWindow];

			while (s >= K) {
				minLength = Math.min(minLength, endWindow - startWindow + 1);
				s = s - num[startWindow++];
			}
		}
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
}
