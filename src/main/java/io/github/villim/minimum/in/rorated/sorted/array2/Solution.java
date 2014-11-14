package io.github.villim.minimum.in.rorated.sorted.array2;

/**
 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why? Suppose a sorted
 * array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 *
 */

public class Solution {

	public int findMin(int[] num) {

		// Best solution provide by LeetCode:
		// int L = 0, R = num.length - 1;
		// while (L < R && num[L] >= num[R]) {
		// int M = (L + R) / 2;
		// if (num[M] > num[R]) {
		// L = M + 1;
		// } else if (num[M] < num[L]) {
		// R = M;
		// } else { // num[L] == num[M] == num[R]
		// L = L + 1;
		// }
		// }
		// return num[L];

		if (num.length == 1) {
			return num[0];
		}

		if (num[0] < num[num.length - 1]) {
			return num[0];
		}

		for (int i = 0; i < num.length - 1; i++) {

			if (num[i] > num[i + 1]
					|| (num[i] == num[i + 1] && i + 1 == num.length - 1)) {
				return num[i + 1];
			}

		}

		return -1;

	}
}