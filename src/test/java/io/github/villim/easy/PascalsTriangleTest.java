package io.github.villim.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PascalsTriangleTest {

	private PascalsTriangle classUnderTest = new PascalsTriangle();

	@Test
	public void noRow() {
		assertEquals("[]", classUnderTest.generate(0).toString());
	}

	@Test
	public void oneRow() {
		assertEquals("[[1]]", classUnderTest.generate(1).toString());
	}

	@Test
	public void towRow() {
		assertEquals("[[1], [1, 1]]", classUnderTest.generate(2).toString());
	}

	@Test
	public void threeRow() {
		assertEquals("[[1], [1, 1], [1, 2, 1]]", classUnderTest.generate(3)
				.toString());
	}

	@Test
	public void fourRow() {
		assertEquals("[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]", classUnderTest
				.generate(4).toString());
	}

	@Test
	public void fiveRow() {
		assertEquals("[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]",
				classUnderTest.generate(5).toString());
	}

	@Test
	public void sixRow() {
		assertEquals(
				"[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1], [1, 5, 10, 10, 5, 1]]",
				classUnderTest.generate(6).toString());
	}

	@Test
	public void sevenRow() {
		assertEquals(
				"[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1], [1, 5, 10, 10, 5, 1], [1, 6, 15, 20, 15, 6, 1]]",
				classUnderTest.generate(7).toString());
	}
}
