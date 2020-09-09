package leetcodeproblem.may2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoggleSolution {

	static final String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GUQ", "EE" };
	static final int n = dictionary.length;
	static final int M = 3, N = 3;

	static boolean isWord(String str) {
		// Linearly search all words
		for (int i = 0; i < n; i++)
			if (str.equals(dictionary[i]))
				return true;
		return false;
	}

	// A recursive function to print all words present on boggle
	static void findWordsUtil(char boggle[][], boolean visited[][], int i, int j, String str) {
		// Mark current cell as visited and append current character
		// to str
		visited[i][j] = true;
		str = str + boggle[i][j];

		// If str is present in dictionary, then print it
		if (isWord(str))
			System.out.println(str);

		// Traverse 8 adjacent cells of boggle[i][j]
		for (int row = i - 1; row <= i + 1 && row < M; row++)
			for (int col = j - 1; col <= j + 1 && col < N; col++)
				if (row >= 0 && col >= 0 && !visited[row][col])
					findWordsUtil(boggle, visited, row, col, str);

		// Erase current character from string and mark visited
		// of current cell as false
		str = "" + str.charAt(str.length() - 1);
		visited[i][j] = false;
	}

	// Prints all words present in dictionary.
	static void findWords(char boggle[][]) {
		// Mark all characters as not visited
		boolean visited[][] = new boolean[M][N];

		// Initialize current string
		String str = "";

		// Consider every character and look for all words
		// starting with this character
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				findWordsUtil(boggle, visited, i, j, str);
	}

	// Driver program to test above function
	public static void main(String args[]) {
		char boggle[][] = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };

		System.out.println("Following words of dictionary are present");
		findWords(boggle);
	}
}

/*
 * public class Cordinate { public int x1; public int y1;
 * 
 * public Cordinate(int x1, int y1) { super(); this.x1 = x1; this.y1 = y1; }
 * 
 * }
 * 
 * public List<Boolean> findBoggle(char[][] board, String[] word) {
 * List<Boolean> result = new ArrayList<>(); dictionary = new HashMap<>();
 * 
 * fillCordinate(board);
 * 
 * for (int i = 0; i < word.length; i++) { Boolean[][] isVisited = new
 * Boolean[board.length][board[0].length];
 * 
 * Cordinate current = null; int currentPos = 0; int prevPos = 0; Cordinate prev
 * = null;
 * 
 * for (int j = 0; j < word[i].length(); j++) { if (j == 0) { current =
 * dictionary.get(word[i].charAt(j) - 'A').get(0);
 * 
 * } List<Cordinate> list = dictionary.get(word[i].charAt(j) - 'A');
 * 
 * } } return result;
 * 
 * }
 * 
 * public void fillCordinate(char[][] board) {
 * 
 * for (int i = 0; i < board.length; i++) { for (int j = 0; j < board[i].length;
 * j++) { List<Cordinate> list = dictionary.get(board[i][j] - 'A'); if (list ==
 * null) { list = new ArrayList<>(); } list.add(new Cordinate(i, j));
 * dictionary.put(board[i][j] - 'A', list); } } }
 */
