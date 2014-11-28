package io.github.villim.reverse.words.in.string;

public class ReverseWordsInSentenceSolution {

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
