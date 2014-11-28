package io.github.villim.medium;

import java.util.Arrays;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author villim
 *
 */
public class FindMinimumInRotatedSortedArray {

	public int findMin(int[] num) {

		if (num.length == 1)
			return num[0];

		int index = num.length / 2 - 1;

		if (num[index] > num[index + 1]) {
			return num[index + 1];
		} else if (num[index] < num[index + 1]
				&& num[index] < num[num.length - 1]) {
			int[] newnum = Arrays.copyOfRange(num, 0, index + 1);
			return findMin(newnum);
		} else {
			int[] newnum = Arrays.copyOfRange(num, index + 1, num.length);
			return findMin(newnum);
		}

	}

}
