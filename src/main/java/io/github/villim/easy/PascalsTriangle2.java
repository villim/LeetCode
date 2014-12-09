package io.github.villim.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author villim
 *
 */
public class PascalsTriangle2 {

	public List<Integer> getRow(int rowIndex) {

		ArrayList<Integer> row = new ArrayList<Integer>();
		int i = 0;
		while (i < rowIndex + 1) {
			row = (ArrayList<Integer>) getNextRow(row);
			i++;
		}
		return row;

	}

	private ArrayList<Integer> getNextRow(List<Integer> previousRow) {

		if (previousRow == null || previousRow.size() == 0) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(1);
			return list;
		}

		if (previousRow.size() == 1) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(1);
			list.add(1);
			return list;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= previousRow.size(); i++) {
			if (i == 0) {
				list.add(previousRow.get(i));
				continue;
			}

			if (i < previousRow.size()) {
				list.add(previousRow.get(i - 1) + previousRow.get(i));
			}

			if (i == previousRow.size()) {
				list.add(previousRow.get(i - 1));
			}
		}

		return list;
	}

}
