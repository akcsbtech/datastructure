/**
 * 
 */
package trie;

/**
 * @author akashgoyal
 *
 */
public class Trie {

	final TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public int query(String s) {
		TrieNode current = root;
		for (int i = 0; i < s.length(); i++) {
			if (current == null) {
				return 0;
			}
			current = current.tridNodes[s.charAt(i) -'a'];
		}
		return current.isTerminated;
	}

	public void insert(String s) {
		TrieNode current = root;
		System.out.println(current);
		for (int i = 0; i < s.length(); i++) {
			if (current.tridNodes[s.charAt(i) - 'a'] == null) {
				current.tridNodes[s.charAt(i) - 'a'] = new TrieNode();
			}
			current = current.next(s.charAt(i));
		}
		current.isTerminated++;
	}

	public void delete(String s) {
		TrieNode current = root;

		for (int i = 0; i < s.length(); ++i) {
			if (current.tridNodes[s.charAt(i) - 'a'] == null) {
				throw new RuntimeException("String not found");
			}
			current = current.next(s.charAt(i));
		}
		if (current.isTerminated != 0)
			--current.isTerminated;
	}

	public void update(final String old_string, final String new_string) {
		delete(old_string);
		insert(new_string);
	}
}
