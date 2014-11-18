package io.github.villim.sorting;

public class Bubble2 implements Sort {

	public int[] sort(final int[] array) {
		int[] nums = array.clone();
		boolean isSwaped = true;
		do {
			isSwaped = false;
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] > nums[i + 1]) {
					int temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
					isSwaped = true;
				}
			}
		} while (isSwaped);
		return nums;
	}
}
