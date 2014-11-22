package io.github.villim.sorting;

import org.junit.Test;

public class BubbleTest extends BaseSortTest {

	private Sort classUnderTest = new Bubble();

	@Test
	public void testAsnSorted() {
		super.testAsnSorted(classUnderTest);
	}

	@Test
	public void testDesSorted() {
		super.testDesSorted(classUnderTest);
	}

	@Test
	public void testRamdown() {
		super.testRamdown(classUnderTest);
	}

}
