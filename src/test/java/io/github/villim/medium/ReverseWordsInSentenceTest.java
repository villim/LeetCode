package io.github.villim.medium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseWordsInSentenceTest {

	private ReverseWordsInSentence classUnderTest = new ReverseWordsInSentence();

	@Test
	public void reverseWords() {
		String sentence = "the sky is blue";
		assertEquals("blue is sky the", classUnderTest.reverseWords(sentence));
	}

	@Test
	public void reverseWordsWithLeadingSpace() {
		String sentence = " the sky is blue  ";
		assertEquals("blue is sky the", classUnderTest.reverseWords(sentence));
	}

	@Test
	public void reverseWordsWithSpacesBetween() {
		String sentence = "the sky  is    blue";
		assertEquals("blue is sky the", classUnderTest.reverseWords(sentence));
	}
}
