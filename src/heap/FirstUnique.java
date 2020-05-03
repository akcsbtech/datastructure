package heap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FirstUnique {
	
	    
	    LinkedHashMap<Integer,Integer> map;
	   PriorityQueue<Map.Entry<Integer, Integer>> firstUnique = new PriorityQueue<Map.Entry<Integer, Integer>>(
					(e1, e2) -> e1.getValue() - e2.getValue());
	    public FirstUnique(int[] nums) {
	        map=new LinkedHashMap<Integer,Integer>();
	        for(int i=0;i<nums.length;i++){
	            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
	        }
	        
	        
	        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				firstUnique.add(entry);
			}
	    }
	    
	    public int showFirstUnique() {
	        return   firstUnique.peek().getValue()>1?-1:firstUnique.peek().getKey();  
	    }
	    
	    public void add(int value) {
	          map.put(value,map.getOrDefault(value,0)+1);
	       
	        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if(entry.getKey()==value){
	                if(entry.getValue()>1){
	                    firstUnique.remove(entry);
	                }
	                firstUnique.add(entry);
	                break;
	            }
			}
	           // firstUnique.clear();
	          //for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			//	firstUnique.add(entry);
			//}
	    }
	}
	
	/**
	 * Your FirstUnique object will be instantiated and called as such:
	 * FirstUnique obj = new FirstUnique(nums);
	 * int param_1 = obj.showFirstUnique();
	 * obj.add(value);
	 */


