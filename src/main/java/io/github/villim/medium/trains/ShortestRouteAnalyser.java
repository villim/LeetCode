package io.github.villim.medium.trains;

import java.util.Map;

public class ShortestRouteAnalyser extends RouteAnalyser {

	private int shortestDistence = 0;
	private String shortestRoute = "";

	public ShortestRouteAnalyser(Map<String, Integer> townName2IdMap, int[][] railwaysMap) {
		super(townName2IdMap, railwaysMap);
	}

	public int getTheShortestRoute(String startTownName, String endTownName) {
		validateParameter(startTownName, endTownName);

		shortestDistence = 0;
		shortestRoute = "";

		int start = townName2IdMap.get(startTownName);
		int end = townName2IdMap.get(endTownName);
		getShortestRoute(start, end, 0, startTownName);
		return shortestDistence;
	}

	private void getShortestRoute(int start, int end, int distance, String route) {

		for (int i = 0; i < railwaysMap[start].length; i++) {
			if (railwaysMap[start][i] > 0) {

				if (i != end && route.contains(id2TownNameMap.get(i))) {
					// Watch out! No need to come back to a traveled node
					continue;
				}

				int newDistance = distance + railwaysMap[start][i];
				String newRoute = route + id2TownNameMap.get(i);

				if (shortestDistence > 0 && newDistance >= shortestDistence) {
					continue;
				}

				if (i == end) {
					if (shortestDistence == 0 || shortestDistence > newDistance) {
						shortestDistence = newDistance;
						shortestRoute = newRoute;
					}
					continue;
				}

				getShortestRoute(i, end, newDistance, newRoute);
			}
		}
	}

	private void validateParameter(String startTownName, String endTownName) {
		if (startTownName == null || endTownName == null) {
			throw new IllegalArgumentException("Please specify your startTownName and endTownName");
		}

		if (!townName2IdMap.keySet().contains(startTownName) || !townName2IdMap.keySet().contains(endTownName)) {
			throw new IllegalArgumentException("TOWN NAME CAN'T BE FOUND");
		}
	}

}
