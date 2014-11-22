package io.github.villim.sorting;

public class Insection2 implements Sort {

	@Override
	public int[] sort(final int[] array) {

		int[] nums = array.clone();

		for (int i = 1; i < nums.length; i++) {
			for (int j = i; j > 0; j--) {
				if (nums[j] < nums[j - 1]) {
					swap(nums, j, j - 1);
				}
			}
		}
		return nums;
	}

}
