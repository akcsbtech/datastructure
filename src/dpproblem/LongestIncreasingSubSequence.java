package dpproblem;

public class LongestIncreasingSubSequence {
	
	public static void main(String [] arg) {
		int A[]= {2,1,3,1,6,2};
		int n=6;
		int [] output=longestIncreaseSubSequence(A,n);
		
		for(int i=0;i<output.length;i++) {
			System.out.print(output[i]+"  ");
		}
		/*
		 * System.out.println(); output=longestIncreaseSubSequence1(A,n); for(int
		 * i=0;i<output.length;i++) { System.out.print(output[i]+"  "); }
		 */
	}
	public static int [] longestIncreaseSubSequence(int [] A,int n) {
		
		int []output= new int[n];
		for(int i=0;i<n;i++) {
			output[i]=1;
		}
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<i;j++) {
				if(A[i]>=A[j] && output[i]<output[j]+1) {
					output[i]=output[j]+1;
				}
			}
		}
		return output;
	}
	
public static int [] longestIncreaseSubSequence1(int [] A,int n) {
		
		int []output= new int[n];
		for(int i=0;i<n;i++) {
			output[i]=1;
		}
		
		for(int i=n-1;i>=0;--i) {
			for(int j=i+1;j<n;j++) {
				if(A[i]<=A[j] && output[i]<output[j]+1) {
					output[i]=output[j]+1;
				}
			}
		}
		return output;
	}


}
