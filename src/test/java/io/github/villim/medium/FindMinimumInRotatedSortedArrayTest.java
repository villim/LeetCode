package io.github.villim.medium;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FindMinimumInRotatedSortedArrayTest {

	private FindMinimumInRotatedSortedArray classUnterTest;

	@Before
	public void setup() {
		this.classUnterTest = new FindMinimumInRotatedSortedArray();
	}

	@Test
	public void oneElement() {
		int[] array = new int[] { 1 };
		assertEquals(this.classUnterTest.findMin(array), 1);
	}

	@Test
	public void twoElements() {
		int[] array = new int[] { 2, 1 };
		assertEquals(this.classUnterTest.findMin(array), 1);

		array = new int[] { 1, 2 };
		assertEquals(this.classUnterTest.findMin(array), 1);
	}

	@Test
	public void moreElements() {
		int[] array = null;

		array = new int[] { 3, 1, 2 };
		assertEquals(this.classUnterTest.findMin(array), 1);

		array = new int[] { 1, 2, 3, 4, 5 };
		assertEquals(1, this.classUnterTest.findMin(array));

		array = new int[] { 5, 6, 7, 8, 1, 2, 3, 4 };
		assertEquals(1, this.classUnterTest.findMin(array));

		array = new int[] { 63, 71, 84, 10, 28, 37, 46, 55 };
		assertEquals(10, this.classUnterTest.findMin(array));

	}
}
