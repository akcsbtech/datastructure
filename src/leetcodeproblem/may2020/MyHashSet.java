package leetcodeproblem.may2020;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet {

	public static void main(String [] arg) {
		MyHashSet myset=new MyHashSet();
		myset.add(1);
		myset.add(2);
		myset.contains(1);
		myset.contains(3);
		myset.add(2);
		myset.contains(2);
		myset.remove(1);
		myset.contains(2);
	}
	/** Initialize your data structure here. */
    List<Integer> hashset;
    public MyHashSet() {
        hashset=new ArrayList<Integer>();
    }
    
    public void add(int key) {
        System.out.println(key);
        if(!hashset.contains(key))
             hashset.add(key);
    }
    
    public void remove(int key) {
         if(hashset.contains(key))
                hashset.remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
       Boolean bool =hashset.contains(key);
        System.out.println(bool);
        return bool;
    }
}
