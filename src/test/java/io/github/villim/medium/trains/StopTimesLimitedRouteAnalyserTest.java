package io.github.villim.medium.trains;

import static org.junit.Assert.assertEquals;
import io.github.villim.medium.trains.StopTimesLimitedRouteAnalyser.StopTimesLimitStrategy;

import org.junit.Before;
import org.junit.Test;

public class StopTimesLimitedRouteAnalyserTest extends BaseRouteAnalyserTest {

	private StopTimesLimitedRouteAnalyser classUnderTest = null;

	@Before
	public void setup() {
		this.classUnderTest = new StopTimesLimitedRouteAnalyser(townName2IdMap, railwaysMap);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWithFindRoutesNoMoreThanLimitedTimesWithNullParameter() {
		this.classUnderTest.getRoutesWithStopTimesLimit("A", null, -1, StopTimesLimitStrategy.NoMoreThan);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWithFindRoutesNoMoreThanLimitedTimesWithIllegalParameter() {
		this.classUnderTest.getRoutesWithStopTimesLimit("A", "M", -1, StopTimesLimitStrategy.NoMoreThan);
	}

	@Test
	public void getRoutesNoMoreThanStopTimes() {
		assertEquals(2, this.classUnderTest.getRoutesWithStopTimesLimit("C", "C", 3, StopTimesLimitStrategy.NoMoreThan));
		assertEquals(4, this.classUnderTest.getRoutesWithStopTimesLimit("A", "D", 4, StopTimesLimitStrategy.NoMoreThan));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForStopTimesEqualsWithNullParameter() {
		this.classUnderTest.getRoutesWithStopTimesLimit("A", null, -1, StopTimesLimitStrategy.Equals);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForStopTimesEqualsWithIllegalParameter() {
		this.classUnderTest.getRoutesWithStopTimesLimit("A", "M", -1, StopTimesLimitStrategy.Equals);
	}

	@Test
	public void getRoutesEqualsStopTimes() {
		assertEquals(1, this.classUnderTest.getRoutesWithStopTimesLimit("C", "C", 2, StopTimesLimitStrategy.Equals));
		assertEquals(3, this.classUnderTest.getRoutesWithStopTimesLimit("A", "C", 4, StopTimesLimitStrategy.Equals));
		assertEquals(2, this.classUnderTest.getRoutesWithStopTimesLimit("B", "C", 5, StopTimesLimitStrategy.Equals));
	}

}
