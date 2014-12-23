package io.github.villim.medium.trains;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DistanceLimitedRouteAnalyserTest extends BaseRouteAnalyserTest {

	private DistanceLimitedRouteAnalyser classUnderTest = null;

	@Before
	public void setup() {
		this.classUnderTest = new DistanceLimitedRouteAnalyser(townName2IdMap, railwaysMap);
	}

	@Test
	public void countRoutesWithDistanceLessThan() {
		assertEquals(7, this.classUnderTest.getNumberOfRoutesWhichDistanceLessThan("C", "C", 30));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenParameterIsNull() {
		this.classUnderTest.getNumberOfRoutesWhichDistanceLessThan(null, null, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenNodeInvalid() {
		this.classUnderTest.getNumberOfRoutesWhichDistanceLessThan("H", "C", 10);
	}

}
