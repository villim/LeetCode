package io.github.villim.sorting;

public interface Sort {
	int[] sort(final int[] array);

	default void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;

	}
}
