package leetcodeproblem;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

	public static void main(String [] arg) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it56 was hit.";
		String []	banned = {"hit"};
		System.out.println(mostCommonWord(paragraph,banned));
		System.out.println(mostCommonWord1(paragraph,banned));
	}
	public static String mostCommonWord(String paragraph, String[] banned) {

		// 1). replace the punctuations with spaces,
		// and put all letters in lower case
		String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
		System.out.println(normalizedStr);
		// 2). split the string into words
		String[] words = normalizedStr.split("\\s+");

		Set<String> bannedWords = new HashSet();
		for (String word : banned)
			bannedWords.add(word);

		Map<String, Integer> wordCount = new HashMap();
		// 3). count the appearance of each word, excluding the banned words
		for (String word : words) {
			if (!bannedWords.contains(word))
				wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}

		// 4). return the word with the highest frequency
		return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
	
	 public static String mostCommonWord1(String paragraph, String[] banned) {

	        Set<String> bannedWords = new HashSet();
	        for (String word : banned)
	            bannedWords.add(word);

	        String ans = "";
	        int maxCount = 0;
	        Map<String, Integer> wordCount = new HashMap();
	        StringBuilder wordBuffer = new StringBuilder();
	        char[] chars = paragraph.toCharArray();

	        for (int p = 0; p < chars.length; ++p) {
	            char currChar = chars[p];

	            // 1). consume the characters in a word
	            if (Character.isLetter(currChar)) {
	                wordBuffer.append(Character.toLowerCase(currChar));
	                if (p != chars.length - 1)
	                    // skip the rest of the processing
	                    continue;
	            }

	            // 2). at the end of one word or at the end of paragraph
	            if (wordBuffer.length() > 0) {
	                String word = wordBuffer.toString();
	                System.out.println("  "+word);
	                // identify the maximum count while updating the wordCount table.
	                if (!bannedWords.contains(word)) {
	                    int newCount = wordCount.getOrDefault(word, 0) + 1;
	                    wordCount.put(word, newCount);
	                    if (newCount > maxCount) {
	                        ans = word;
	                        maxCount = newCount;
	                    }
	                }
	                // reset the buffer for the next word
	                wordBuffer = new StringBuilder();
	            }
	        }
	        return ans;
	    }

}
