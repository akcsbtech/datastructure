/**
 * 
 */
package dpproblem;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author akashgoyal
 *
 */
public class MeetingRoomProblem {

	/**
	 * @param args
	 */
	
	public static int minMeetingRoom(Interval [] intervals) {
		
		if(intervals==null || intervals.length==0) {
			return 0;
		}
		
		Arrays.sort(intervals,(a,b)->a.start-b.start);
		PriorityQueue<Interval> minHeap=new PriorityQueue<>((a,b)->a.end-b.end);
		minHeap.add(intervals[0]);
		
		System.out.println(intervals[0]);
		for(int i=1;i<intervals.length;i++) {
			//System.out.println(intervals[i]);
			Interval current=intervals[i];
			Interval earliest=minHeap.remove();
			
			System.out.println("Current |"+intervals[i] +"| earliest |"+earliest); 
			if(current.start >=earliest.end) {
				earliest.end=current.end;
			}else {
				minHeap.add(current);
			}
			minHeap.add(earliest);
		}
		System.out.println("Min Heap |"+minHeap);
		return minHeap.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Interval [] aa=new Interval[5];
		aa[0]=new Interval(1,15);
		aa[1]=new Interval(3,5);
		aa[2]=new Interval(6,9);
		aa[3]=new Interval(10,14);
		aa[4]=new Interval(1,5);
		
		System.out.println(minMeetingRoom(aa));
	}

}
