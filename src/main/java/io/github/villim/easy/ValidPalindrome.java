package io.github.villim.easy;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example,
 * 
 * "A man, a plan, a canal: Panama" is a palindrome. <br>
 * "race a car" is not a palindrome.
 * 
 * Note: <br>
 * Have you consider that the string might be empty? This is a good question to
 * ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author villim
 *
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {

		if (s == null) {
			return false;
		}

		if (s.trim().isEmpty()) {
			return true;
		}

		char[] arr = s.trim().toLowerCase().toCharArray();

		for (int i = 0, j = arr.length - 1, z = 0; i < arr.length
				&& z < arr.length && (i + z <= arr.length);) {
			if (!isAlpha(arr[i])) {
				i++;
				continue;
			}

			if (!isAlpha(arr[j])) {
				j--;
				z++;
				continue;
			}

			if (arr[i] != arr[j]) {
				return false;
			}

			i++;
			j--;
			z++;
		}

		return true;
	}

	private boolean isAlpha(char c) {
		if ((c >= 97 && c <= 122) || (c >= 48 && c <= 57)) {
			return true;
		}
		return false;
	}
}
