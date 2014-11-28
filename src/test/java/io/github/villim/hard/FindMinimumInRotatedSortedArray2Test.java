package io.github.villim.hard;

import static org.junit.Assert.assertEquals;
import io.github.villim.hard.FindMinimumInRotatedSortedArray2;

import org.junit.Before;
import org.junit.Test;

public class FindMinimumInRotatedSortedArray2Test {

	private FindMinimumInRotatedSortedArray2 classUnterTest;

	@Before
	public void setup() {
		this.classUnterTest = new FindMinimumInRotatedSortedArray2();
	}

	@Test
	public void oneElement() {
		int[] array = new int[] { 1 };
		assertEquals(this.classUnterTest.findMin(array), 1);

		array = new int[] { 1, 1 };
		assertEquals(this.classUnterTest.findMin(array), 1);
	}

	@Test
	public void twoElements() {
		int[] array = null;

		array = new int[] { 2, 1 };
		assertEquals(1, this.classUnterTest.findMin(array));

		array = new int[] { 2, 1, 1, 1, 1 };
		assertEquals(this.classUnterTest.findMin(array), 1);

		array = new int[] { 3, 3, 3, 1 };
		assertEquals(1, this.classUnterTest.findMin(array));

		array = new int[] { 4, 4, 2, 2 };
		assertEquals(2, this.classUnterTest.findMin(array));

		array = new int[] { 1, 2 };
		assertEquals(1, this.classUnterTest.findMin(array));

		array = new int[] { 1, 1, 1, 2, 2, 2 };
		assertEquals(1, this.classUnterTest.findMin(array));

	}

	@Test
	public void moreElements() {

		int[] array = null;

		array = new int[] { 3, 1, 2 };
		assertEquals(1, this.classUnterTest.findMin(array));

		array = new int[] { 3, 1, 2, 3 };
		assertEquals(1, this.classUnterTest.findMin(array));

		array = new int[] { 3, 3, 1, 1, 2, 2, 3, 3 };
		assertEquals(1, this.classUnterTest.findMin(array));

	}
}