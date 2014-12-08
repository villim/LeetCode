package io.github.villim.easy;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidPalindromeTest {

	private ValidPalindrome classUnderTest = new ValidPalindrome();

	@Test
	public void palindrome() {
		assertTrue(this.classUnderTest.isPalindrome(" "));
		assertTrue(this.classUnderTest.isPalindrome("."));
		assertTrue(this.classUnderTest.isPalindrome("1A mma 1"));
		assertTrue(this.classUnderTest
				.isPalindrome("A man, a plan, a canal: Panama"));
	}

	@Test
	public void notPalindrome() {
		assertTrue(!this.classUnderTest.isPalindrome(null));
		assertTrue(!this.classUnderTest.isPalindrome("race a car"));
		assertTrue(!this.classUnderTest.isPalindrome("1A mma 2"));
	}
}
