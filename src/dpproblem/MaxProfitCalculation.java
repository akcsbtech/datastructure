package dpproblem;

public class MaxProfitCalculation {
	
	public int maxProfit(int [] prices) {
		if(prices.length==0 ) {
			return -1;
		}
		if(prices.length==1) {
			return 0;
		}
		
		
		int maxprofit=0;
		int currentBuy=prices[0];
		int currentSell=prices[0];
		
		for(int i=0;i<prices.length;i++) {
			
			if(prices[i]<currentBuy) {
				currentBuy=prices[i];
				currentSell=prices[i+1];
				
				if(currentSell-currentBuy>maxprofit) {
					maxprofit=currentSell-currentBuy;
				}
			}else if(prices[i]>currentSell) {
				currentSell=prices[i];
				if(currentSell-currentBuy>maxprofit) {
					maxprofit=currentSell-currentBuy;
				}
			}
		}
		return maxprofit;
		
	}
	
	public static void main(String [] arg) {
		MaxProfitCalculation maxProfitCalculation=new MaxProfitCalculation();
		int [] prices= {2,11,1,4,12,15};
		System.out.println(maxProfitCalculation.maxProfit(prices)+"| length |"+prices.length);
	}

}
