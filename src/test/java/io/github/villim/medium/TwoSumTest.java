package io.github.villim.medium;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TwoSumTest {
	private TwoSum classUnderTest = new TwoSum();

	@Before
	public void setup() {

	}

	@Test
	public void testOrderedArray() {
		int[] numbers = new int[] { 2, 4, 5, 7 };
		int[] indexs = this.classUnderTest.twoSum(numbers, 7);
		assertEquals(1, indexs[0]);
		assertEquals(3, indexs[1]);

		indexs = this.classUnderTest.twoSum(numbers, 11);
		assertEquals(2, indexs[0]);
		assertEquals(4, indexs[1]);
	}

	@Test
	public void testZero() {
		int[] numbers = new int[] { 0, 4, 5, 0 };
		int[] indexs = this.classUnderTest.twoSum(numbers, 0);
		assertEquals(1, indexs[0]);
		assertEquals(4, indexs[1]);
	}
}
