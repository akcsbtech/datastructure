package corejava;

class GFG {

// Function to return the maximum xor for a 
// subset of size k from the given array 
	static int Max_Xor(int arr[], int n, int k) {

		// Initialize result
		int maxXor = Integer.MIN_VALUE;

		// Traverse all subsets of the array
		System.out.println("Left Shift value :"+(1 << n));
		for (int i = 0; i < (1 << n); i++) {

			// __builtin_popcount() returns the number
			// of sets bits in an integer
			System.out.println("Bit Count  i: "+i+" Count :"+Integer.bitCount(i));
			if (Integer.bitCount(i) == k) {

				// Initialize current xor as 0
				int cur_xor = 0;
				for (int j = 0; j < n; j++) {

					// If jth bit is set in i then include
					// jth element in the current xor
					if ((i & (1 << j)) == 0)
						cur_xor = cur_xor ^ arr[j];
				}

				// Update maximum xor so far
				maxXor = Math.max(maxXor, cur_xor);
			}
		}
		return maxXor;
	}

// Driver code 
	public static void main(String[] args) {
		int arr[] = { 2, 5, 4, 1, 3, 7, 6, 8 };
		int n = arr.length;
		int k = 3;

		System.out.println(Max_Xor(arr, n, k));
	}
}

// This code is contributed by PrinciRaj1992 
