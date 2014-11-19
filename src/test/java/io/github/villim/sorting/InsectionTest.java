package io.github.villim.sorting;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class InsectionTest {
	private Sort classUnderTest = new Insection();

	int[] asnSortedArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	@Test
	public void testAsnSorted() {
		assertEquals(Arrays.toString(asnSortedArray),
				Arrays.toString(this.classUnderTest.sort(asnSortedArray)));
	}

	@Test
	public void testDesSorted() {
		int[] desSortedArray = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		assertEquals(Arrays.toString(asnSortedArray),
				Arrays.toString(this.classUnderTest.sort(desSortedArray)));
	}

	@Test
	public void testRamdown() {
		int[] desSortedArray = new int[] { 12, 45, 23, 9, 34, 23, 53, 45 };
		assertEquals(
				Arrays.toString(new int[] { 9, 12, 23, 23, 34, 45, 45, 53 }),
				Arrays.toString(this.classUnderTest.sort(desSortedArray)));
	}
}
