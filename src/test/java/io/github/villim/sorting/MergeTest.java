package io.github.villim.sorting;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MergeTest extends BaseSortTest {

	private Sort classUnderTest = new Merge();

	@Test
	public void testAsnSorted2() {

		int[] asnSortedArray = new int[] { 1, 2, 3 };

		assertEquals(Arrays.toString(asnSortedArray),
				Arrays.toString(classUnderTest.sort(asnSortedArray)));
	}

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
