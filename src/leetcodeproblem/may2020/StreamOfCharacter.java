/**
 * 
 */
package leetcodeproblem.may2020;

import java.util.ArrayList;
import java.util.List;

/**
 * @author b0218163
 *
 */
public class StreamOfCharacter {
	class TrieNode {
		boolean isEnd;
		TrieNode[] next = new TrieNode[26];
	}

	TrieNode root = new TrieNode();
	List<TrieNode> checkers = new ArrayList<>();

	public StreamOfCharacter(String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (char letter : word.toCharArray()) {
                int digit = letter - 'a';
                if (node.next[digit] == null) {
                    node.next[digit] = new TrieNode(); 
                }
                node = node.next[digit];
            }
            node.isEnd = true;
        }
    }

	public boolean query(char letter) {
		boolean match = false;
		checkers.add(root);

		List<TrieNode> newCheckers = new ArrayList<>();
		for (TrieNode node : checkers) {
			node = node.next[letter - 'a'];
			if (node != null) {
				newCheckers.add(node);
				if (node.isEnd) {
					match = true;
				}
			}
		}
		checkers = newCheckers;
		return match;
	}

}
