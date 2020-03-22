package dpproblem;

import java.util.Arrays;

public class CoinStatement {

	public static int [] dynamicCoinChange(int [] coin,int k) {
		int result [] =new  int [k];
		int n=coin.length;
		
		for(int i=0;i<k;i++) {
			result[i]=Integer.MAX_VALUE;
		}
		for(int i=1;i<n+1;i++) {
			for(int j=coin[i-1];j<k;j++) {
				result[j] = Math.min(result[j - coin[i - 1]] + 1, result[j]);
			}
		}
		return result;
	}
	
	
	    public static  int coinChange(int[] coins, int amount) {
	        int count=0;
	        int clen=coins.length-1;
	        while(amount>0 &&clen>=0){
	            count=count+amount/coins[clen];
	            amount=amount%coins[clen];
	            --clen;
	        }
	        
	        if(amount==0){
	            return count;
	        }else{
	            return -1;
	        }
	    }
	    
	    public int coinChangeLeetCode2(int[] coins, int amount) {        
	        if (amount < 1) return 0;
	        return coinChangeLeetCode2(coins, amount, new int[amount]);
	    }

	    private int coinChangeLeetCode2(int[] coins, int rem, int[] count) {
	        if (rem < 0) return -1;
	        if (rem == 0) return 0;
	        if (count[rem - 1] != 0) return count[rem - 1];
	        int min = Integer.MAX_VALUE;
	        for (int coin : coins) {
	            int res = coinChangeLeetCode2(coins, rem - coin, count);
	            if (res >= 0 && res < min)
	                min = 1 + res;
	        }
	        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
	        return count[rem - 1];
	    }
	    
	    public static  int coinChangeLeet(int[] coins, int amount) {
	        return coinChange1(0, coins, amount);
	    }

	    private static  int coinChange1(int idxCoin, int[] coins, int amount) {
	        if (amount == 0)
	            return 0;
	        if (idxCoin < coins.length && amount > 0) {
	            int maxVal = amount/coins[idxCoin];
	            int minCost = Integer.MAX_VALUE;
	            for (int x = 0; x <= maxVal; x++) {
	                if (amount >= x * coins[idxCoin]) {
	                    int res = coinChange1(idxCoin + 1, coins, amount - x * coins[idxCoin]);
	                    if (res != -1)
	                        minCost = Math.min(minCost, res + x);
	                }                    
	            }	 		
	            return (minCost == Integer.MAX_VALUE)? -1: minCost;
	        }		 
	        return -1;
	    }  
	
	    public static int coinChangeLeetCOde3(int[] coins, int amount) {
	        int max = amount + 1;             
	        int[] dp = new int[amount + 1];  
	        Arrays.fill(dp, max);  
	        dp[0] = 0;   
	        for (int i = 1; i <= amount; i++) {
	            for (int j = 0; j < coins.length; j++) {
	                if (coins[j] <= i) {
	                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
	                }
	            }
	        }
	        return dp[amount] > amount ? -1 : dp[amount];
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int coin [] = {1,3,4};
		int k=6;
	//	int []result=dynamicCoinChange(coin,k);
		System.out.println(coinChange(coin,k));
		
		System.out.println(coinChangeLeet(coin,k));
	
		System.out.println(coinChangeLeetCOde3(coin,k));

		
	}

}
