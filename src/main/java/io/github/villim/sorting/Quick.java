package io.github.villim.sorting;

public class Quick implements Sort {

	@Override
	public int[] sort(final int[] array) {

		return quickSort(array.clone(), 0, array.length - 1);

	}

	private int[] quickSort(int[] nums, int left, int right) {

		if (nums.length == 1) {
			return nums;
		}

		if (left < right) {
			int pivot = partition(nums, left, right);
			quickSort(nums, left, pivot - 1);
			quickSort(nums, pivot + 1, right);
		}

		return nums;
	}

	private int partition(int[] nums, int left, int right) {

		int futurePivotIndex = left;

		for (int i = left; i < right; i++) {
			if (nums[i] < nums[right]) { // Using right as pivot
				swap(nums, i, futurePivotIndex++);
			}
		}
		swap(nums, futurePivotIndex, right);
		return futurePivotIndex;
	}

}
