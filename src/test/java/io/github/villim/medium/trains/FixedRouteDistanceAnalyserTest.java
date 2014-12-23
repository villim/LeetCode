package io.github.villim.medium.trains;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FixedRouteDistanceAnalyserTest extends BaseRouteAnalyserTest {

	private FixedRouteDistanceAnalyser classUnderTest = null;

	@Before
	public void setup() {
		this.classUnderTest = new FixedRouteDistanceAnalyser(townName2IdMap, railwaysMap);
	}

	@Test
	public void getDistanceOfRoute() {
		assertEquals("0", classUnderTest.getFixedRouteDistance("E"));
		assertEquals("9", classUnderTest.getFixedRouteDistance("A-B-C"));
		assertEquals("5", classUnderTest.getFixedRouteDistance("A-D"));
		assertEquals("13", classUnderTest.getFixedRouteDistance("A-D-C"));
		assertEquals("22", classUnderTest.getFixedRouteDistance("A-E-B-C-D"));
		assertEquals("NO SUCH ROUTE", classUnderTest.getFixedRouteDistance("A-E-D"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowEceptionWithNullparameter() {
		this.classUnderTest.getFixedRouteDistance(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWithIllegalNodes() {
		this.classUnderTest.getFixedRouteDistance("H");
	}
}
