package knapsack;

import java.util.HashMap;
import java.util.Map;

public class TotalSumProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {2,3,5};
		System.out.println(targetSum(a,10));
	}

	public static Map<Integer,Integer>  targetSum(int [] a,int sum){
		Map<Integer,Integer> result=new HashMap<Integer,Integer>();
		
		int [][] sumR=new int [a.length+1][sum+1];
		for(int i=0;i<=sum;i++) {
			sumR[0][i]=0;
		}
		
		for(int i=0;i<a.length;i++)
			sumR[i][0]=0;
		
		for(int i=1;i<a.length;i++) {
		 for(int j=1;j<=sum;j++) {
			 if(j>=a[i-1]) {
				 sumR[i][j]=1+sumR[i][j-a[i-1]];
			 }else {
				 sumR[i][j]=sumR[i-1][j];
			 }
		 }
		}
		System.out.println(sumR[a.length][sum]);
		return result;
	}
}
