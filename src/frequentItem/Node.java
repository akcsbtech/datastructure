package frequentItem;

import java.util.HashSet;

class Node {
	int value;
	Node prev;
	Node next;
	HashSet<Integer> set;
 
	public Node(int v){
		value = v;
		set = new HashSet<Integer>();
	}
 
	public String toString(){
		return value + ":" + set.toString();
	}
}