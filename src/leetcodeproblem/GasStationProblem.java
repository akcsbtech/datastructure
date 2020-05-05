package leetcodeproblem;

public class GasStationProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };

		System.out.println(canCompleteCircuit(gas, cost));
		int[] gas1 = { 2,3,4 };
		int[] cost1 = {3,4,3};
		
		System.out.println(canCompleteCircuit(gas1, cost1));
	
	}

	/*
	 * public static int canCompleteCircuit(int[] gas, int[] cost) {
	 * 
	 * int totalGas = 0; int start = 0; int i = 0; int count = 0; while (count <
	 * gas.length) { try{ Thread.sleep(5000); }catch(Exception ex) {
	 * 
	 * } System.out.println(count +"  "+i+"  "+start); if (gas[i] + totalGas >=
	 * cost[i]) { totalGas = totalGas + gas[i] - cost[i]; ++count; } else {
	 * if(count+i==gas.length) { return -1; } start = i; count=0; } ++i; if (i ==
	 * gas.length && count == 0) { return -1; } else if(i == gas.length){ i = 0; } }
	 * if (totalGas >= 0) { return start+1; } return -1; }
	 */
	
	public  static int canCompleteCircuit(int[] gas, int[] cost) {

		int totalGas = 0;
		int deficit = 0;
		int start=0;
       
       for(int i=0;i<gas.length;i++){
        totalGas=totalGas-cost[i]+gas[i];
           if(totalGas<0){
               start=i+1;
               deficit+=totalGas;
               totalGas=0;
           }
       }
       
       return totalGas+deficit >=0 ?start :-1;
      
	}
}
