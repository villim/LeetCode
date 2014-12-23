package io.github.villim.medium.trains;

import java.util.Map;

public class FixedRouteDistanceAnalyser extends RouteAnalyser {

	public FixedRouteDistanceAnalyser(Map<String, Integer> townName2IdMap, int[][] railwaysMap) {
		super(townName2IdMap, railwaysMap);
	}

	/**
	 * @param fixedRoute
	 *            : input as "A-C-D" means from town A -> C -> D
	 */
	public String getFixedRouteDistance(String fixedRoute) {

		if (fixedRoute == null || "".equals(fixedRoute)) {
			throw new IllegalArgumentException("Please specifiy your Route!");
		}

		String[] fixedRouteArray = fixedRoute.split("-");

		for (String townName : fixedRouteArray) {
			if (!townName2IdMap.keySet().contains(townName)) {
				throw new IllegalArgumentException("Town name [" + townName + "] is invalid!");
			}
		}

		if (fixedRouteArray.length == 1) {
			return "0";
		}

		int totalDistence = 0;
		int previousNodeRowIndex = townName2IdMap.get(fixedRouteArray[0]);
		for (int i = 1; i < fixedRouteArray.length; i++) {
			int currentNodeRowIndex = townName2IdMap.get(fixedRouteArray[i]);
			int distanceFromPreNodeToCurrentNode = railwaysMap[previousNodeRowIndex][currentNodeRowIndex];
			if (distanceFromPreNodeToCurrentNode <= 0) {
				return "NO SUCH ROUTE";
			} else {
				totalDistence += distanceFromPreNodeToCurrentNode;
				previousNodeRowIndex = currentNodeRowIndex;
			}
		}

		return String.valueOf(totalDistence);
	}

}
