package io.github.villim.medium;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * click to show clarification.
 * 
 * Clarification: What constitutes a word? A sequence of non-space characters
 * constitutes a word. Could the input string contain leading or trailing
 * spaces? Yes. However, your reversed string should not contain leading or
 * trailing spaces. How about multiple spaces between two words? Reduce them to
 * a single space in the reversed string.
 * 
 * @author villim
 *
 */
public class ReverseWordsInSentence {

	public String reverseWords(String s) {

		String[] words = s.trim().split(" ");

		StringBuffer sb = new StringBuffer();
		for (int i = words.length - 1; i >= 0; i--) {

			if (words[i].equals("")) {
				continue;
			}
			sb.append(words[i]);

			if (i > 0) {
				sb.append(" ");
			}
		}

		return sb.toString();
	}
}
