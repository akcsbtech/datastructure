package topkelement;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKElement {
	public static List<Integer> findKLargestNumbers(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
		// put first 'K' numbers in the min heap
		for (int i = 0; i < k; i++)
			minHeap.add(nums[i]);

		// go through the remaining numbers of the array, if the number from the array
		// is bigger than the
		// top (smallest) number of the min-heap, remove the top number from heap and
		// add the number from array
		for (int i = k; i < nums.length; i++) {
			if (nums[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(nums[i]);
			}
		}

		// the heap has the top 'K' numbers, return them in a list
		return new ArrayList<>(minHeap);
	}

	public static List<Integer> findKSmalletNumbers(int[] nums, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);

		for (int i = 0; i < k; i++) {
			maxHeap.add(nums[i]);
		}
		for (int i = k; i < nums.length; i++) {
			if (nums[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.add(nums[i]);
			}
		}
		return new ArrayList<Integer>(maxHeap);
	}

	public static void main(String[] args) {
		List<Integer> result = TopKElement.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
		System.out.println("Here are the top K numbers: " + result);
		System.out.println(
				"Here are the min K numbers: " + TopKElement.findKSmalletNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3));

		result = TopKElement.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
		System.out.println("Here are the top K numbers: " + result);
		System.out.println(
				"Here are the min K numbers: " + TopKElement.findKSmalletNumbers(new int[] { 5, 12, 11, -1, 12 }, 3));
	}
}
