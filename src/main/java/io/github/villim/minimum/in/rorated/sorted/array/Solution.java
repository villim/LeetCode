package io.github.villim.minimum.in.rorated.sorted.array;

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 Find the minimum element.
 You may assume no duplicate exists in the array.
 */

public class Solution {

	public int findMin(int[] num) {

		boolean isAsn = true;

		if (num.length == 1)
			return num[0];

		if (num[0] > num[num.length - 1]) {
			isAsn = true;
		} else {
			isAsn = false;
		}

		for (int i = 0; i < num.length - 1; i++) {
			if (isAsn) {
				if (num[i] > num[i + 1]) {
					return num[i + 1];
				}
			} else {
				if (num[i] < num[i + 1]) {
					return num[i];
				}
			}
		}

		return -1;
	}

}
