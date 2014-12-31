package io.github.villim.medium;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VolumeOfWaterTest {

	private VolumeOfWater classUnderTest = null;

	@Before
	public void setUp() {
		classUnderTest = new VolumeOfWater();
	}

	@Test
	public void oneValley() {
		assertEquals(6, this.classUnderTest.caculateVolume(new int[] { 4, 1, 1, 4 }));
		assertEquals(6, this.classUnderTest.caculateVolume(new int[] { 4, 1, 1, 5 }));
		assertEquals(6, this.classUnderTest.caculateVolume(new int[] { 5, 1, 1, 4 }));
	}

	@Test
	public void twoValleys() {
		assertEquals(6, this.classUnderTest.caculateVolume(new int[] { 4, 3, 2, 5, 2, 3, 4 }));
		assertEquals(2, this.classUnderTest.caculateVolume(new int[] { 3, 3, 2, 3, 2, 3, 4 }));
		assertEquals(2, this.classUnderTest.caculateVolume(new int[] { 4, 3, 2, 3, 2, 3, 3 }));
	}

	@Test
	public void threeValleys() {
		assertEquals(7, this.classUnderTest.caculateVolume(new int[] { 4, 3, 2, 5, 4, 5, 2, 3, 4 }));
		assertEquals(5, this.classUnderTest.caculateVolume(new int[] { 3, 3, 2, 5, 4, 5, 2, 3, 4 }));
		assertEquals(5, this.classUnderTest.caculateVolume(new int[] { 4, 3, 2, 5, 4, 5, 2, 3, 3 }));
		assertEquals(10, this.classUnderTest.caculateVolume(new int[] { 4, 3, 2, 3, 2, 3, 2, 3, 4 }));
	}
}
