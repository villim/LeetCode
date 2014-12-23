package io.github.villim.medium.trains;

import io.github.villim.medium.trains.StopTimesLimitedRouteAnalyser.StopTimesLimitStrategy;

import java.util.Map;

/**
 * Problem: The local commuter railroad services a number of towns in Kiwiland.
 * Because of monetary concerns, all of the tracks are 'one-way.' That is, a
 * route from Kaitaia to Invercargill does not imply the existence of a route
 * from Invercargill to Kaitaia. In fact, even if both of these routes do happen
 * to exist, they are distinct and are not necessarily the same distance!
 * 
 * The purpose of this problem is to help the railroad provide its customers
 * with information about the routes. In particular, you will compute the
 * distance along a certain route, the number of different routes between two
 * towns, and the shortest route between two towns.
 * 
 * Input: A directed graph where a node represents a town and an edge represents
 * a route between two towns. The weighting of the edge represents the distance
 * between the two towns. A given route will never appear more than once, and
 * for a given route, the starting and ending town will not be the same town.
 * 
 * Output: For test input 1 through 5, if no such route exists, output 'NO SUCH
 * ROUTE'. Otherwise, follow the route as given; do not make any extra stops!
 * For example, the first problem means to start at city A, then travel directly
 * to city B (a distance of 5), then directly to city C (a distance of 4).
 * 
 * The distance of the route A-B-C. The distance of the route A-D. The distance
 * of the route A-D-C. The distance of the route A-E-B-C-D. The distance of the
 * route A-E-D. The number of trips starting at C and ending at C with a maximum
 * of 3 stops. In the sample data below, there are two such trips: C-D-C (2
 * stops). and C-E-B-C (3 stops). The number of trips starting at A and ending
 * at C with exactly 4 stops. In the sample data below, there are three such
 * trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B). The
 * length of the shortest route (in terms of distance to travel) from A to C.
 * The length of the shortest route (in terms of distance to travel) from B to
 * B. The number of different routes from C to C with a distance of less than
 * 30. In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC,
 * CEBCEBC, CEBCEBCEBC. Test Input:
 * 
 * For the test input, the towns are named using the first few letters of the
 * alphabet from A to D. A route between two towns (A to B) with a distance of 5
 * is represented as AB5.
 * 
 * Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
 * 
 * Expected Output:
 * 
 * Output #1: 9 Output #2: 5 Output #3: 13 Output #4: 22 Output #5: NO SUCH
 * ROUTE Output #6: 2 Output #7: 3 Output #8: 9 Output #9: 9
 * 
 * @author villim
 *
 */
public class KiwilandRailway {

	public static void main(String[] args) {

		Map<String, Integer> townName2IdMap = TownMapBuilder.buildTownName2IdMap(new String[] { "A", "B", "C", "D", "E" });

		// The map is seems like following:
		// A, B, C, D, E
		// [ 0, 5, 0, 5, 7 ] // row A
		// [ 0, 0, 4, 0, 0 ] // row B
		// [ 0, 0, 0, 8, 2 ] // row C
		// [ 0, 0, 8, 0, 6 ] // row D
		// [ 0, 3, 0, 0, 0 ] // row E
		int[][] railwayMap = TownMapBuilder.buildRailwayMap(townName2IdMap, new String[] { "A-B-5", "B-C-4", "C-D-8", "D-C-8", "D-E-6",
				"A-D-5", "C-E-2", "E-B-3", "A-E-7" });

		FixedRouteDistanceAnalyser fixedRouteDistanceAnalyser = new FixedRouteDistanceAnalyser(townName2IdMap, railwayMap);
		System.out.println("Output #1 : route A-B-C = " + fixedRouteDistanceAnalyser.getFixedRouteDistance("A-B-C"));
		System.out.println("Output #2 : route A-D = " + fixedRouteDistanceAnalyser.getFixedRouteDistance("A-D"));
		System.out.println("Output #3 : route A-D-C = " + fixedRouteDistanceAnalyser.getFixedRouteDistance("A-D-C"));
		System.out.println("Output #4 : route A-E-B-C-D = " + fixedRouteDistanceAnalyser.getFixedRouteDistance("A-E-B-C-D"));
		System.out.println("Output #5 : route A-E-D = " + fixedRouteDistanceAnalyser.getFixedRouteDistance("A-E-D"));

		StopTimesLimitedRouteAnalyser stopTimesLimitedRouteAnalyser = new StopTimesLimitedRouteAnalyser(townName2IdMap, railwayMap);
		System.out.println("Output #6 : C-C max 3 stop = "
				+ stopTimesLimitedRouteAnalyser.getRoutesWithStopTimesLimit("C", "C", 3, StopTimesLimitStrategy.NoMoreThan));
		System.out.println("Output #7 : A-C equals 3 stop = "
				+ stopTimesLimitedRouteAnalyser.getRoutesWithStopTimesLimit("A", "C", 4, StopTimesLimitStrategy.Equals));

		ShortestRouteAnalyser shortestRouteAnalyser = new ShortestRouteAnalyser(townName2IdMap, railwayMap);
		System.out.println("Output #8 : A-C shortest = " + shortestRouteAnalyser.getTheShortestRoute("A", "C"));
		System.out.println("Output #9 : B-B shortest = " + shortestRouteAnalyser.getTheShortestRoute("B", "B"));

		DistanceLimitedRouteAnalyser distanceLimitedRouteAnalyser = new DistanceLimitedRouteAnalyser(townName2IdMap, railwayMap);
		System.out.println("Output #10 : C-C less than 30 = "
				+ distanceLimitedRouteAnalyser.getNumberOfRoutesWhichDistanceLessThan("C", "C", 30));
	}
}
