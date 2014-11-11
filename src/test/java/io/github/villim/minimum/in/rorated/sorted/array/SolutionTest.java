package io.github.villim.minimum.in.rorated.sorted.array;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	private Solution classUnterTest;

	@Before
	public void setup() {
		this.classUnterTest = new Solution();
	}

	@Test
	public void findMinInArray() {

		int[] array = null;

		array = new int[] { 5, 6, 7, 8, 1, 2, 3, 4 };
		assertEquals(this.classUnterTest.findMin(array), 1);

		array = new int[] { 4, 3, 2, 1, 8, 7, 6, 5 };
		assertEquals(this.classUnterTest.findMin(array), 1);

		array = new int[] { 63, 71, 84, 10, 28, 37, 46, 55 };
		assertEquals(this.classUnterTest.findMin(array), 10);

	}

	@Test
	public void findMinWithOneElemenet() {
		int[] array = null;

		array = new int[] { 1 };
		assertEquals(this.classUnterTest.findMin(array), 1);
	}
}
