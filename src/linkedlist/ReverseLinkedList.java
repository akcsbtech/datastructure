/**
 * 
 */
package linkedlist;

/**
 * @author akashgoyal
 *
 */
public class ReverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(10, null);
		ListNode l2 = new ListNode(20, l1);
		ListNode l3 = new ListNode(30, l2);
		ListNode l4 = new ListNode(40, l3);
		ListNode head = l4;

		/*
		 * ListNode temp; temp = head; while (temp.nextListNode != null) {
		 * System.out.print(temp.data + ">>>> "); temp = temp.nextListNode; }
		 * System.out.print(temp.data); System.out.println();
		 */
		ListNode newHead = reverseLinkedList(head);
		ListNode temp = newHead;
		while (temp.nextListNode != null) {
			System.out.println(temp.data + ">>>> ");
			temp = temp.nextListNode;
		}
		System.out.println(temp.data);
	}

	public static ListNode reverseLinkedList(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;
		while (current != null) {
			next = current.nextListNode;
			current.nextListNode = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

}
