package io.github.villim.sorting;

import org.junit.Test;

public class InsectionTest extends BaseSortTest {
	private Sort classUnderTest = new Insection2();

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
