package io.github.villim.reverse.words.in.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseWordsInSentenceSolutionTest {

	private ReverseWordsInSentenceSolution classUnderTest = new ReverseWordsInSentenceSolution();

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
