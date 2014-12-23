package io.github.villim.medium.trains;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DistanceLimitedRouteAnalyser extends RouteAnalyser {

	private List<String> routes = null;
	private int maxDistance = 0;

	public DistanceLimitedRouteAnalyser(Map<String, Integer> townName2IdMap, int[][] railwaysMap) {
		super(townName2IdMap, railwaysMap);
	}

	public int getNumberOfRoutesWhichDistanceLessThan(String startTownName, String endTownName, int maxDistance) {

		validateParameter(startTownName, endTownName, maxDistance);

		this.routes = new ArrayList<String>();
		this.maxDistance = maxDistance;

		findRoutes(townName2IdMap.get(startTownName), townName2IdMap.get(endTownName), 0, "");

		return routes.size();
	}

	private void findRoutes(int start, int end, int distance, String route) {
		for (int i = 0; i < railwaysMap[start].length; i++) {
			if (railwaysMap[start][i] > 0) {
				String newRoute = route + id2TownNameMap.get(start);
				int newDistance = railwaysMap[start][i] + distance;

				if (newDistance >= maxDistance) {
					return;
				}

				if (i == end) {
					// record current route, but keep on searching
					routes.add(newRoute + id2TownNameMap.get(i) + " " + newDistance);
				}

				findRoutes(i, end, newDistance, newRoute);
			}
		}
	}

	private void validateParameter(String start, String end, int maxDistance) {
		if (start == null || end == null || maxDistance <= 0) {
			throw new IllegalArgumentException("Please specify your max limited, start and end node");
		}

		if (!townName2IdMap.keySet().contains(start) || !townName2IdMap.keySet().contains(end)) {
			throw new IllegalArgumentException("NODE CANT BE FOUND");
		}
	}

}
