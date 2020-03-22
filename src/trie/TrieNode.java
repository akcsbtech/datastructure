/**
 * 
 */
package trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author akashgoyal
 *
 */
public class TrieNode {

	int isTerminated;
	TrieNode[] tridNodes=new TrieNode[26];

	public TrieNode next(final char c) {
		return tridNodes[c - 'a'];
	}

	public static void main(String[] arg) {
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("akash");
		list.add("piyush");

		Trie trie = new Trie();
		list.forEach(trie::insert);
		
		System.out.println(trie.query("abcd"));
		System.out.println(trie.query("pqrs"));
		
	}
}
