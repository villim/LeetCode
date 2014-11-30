package io.github.villim.medium;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 * 
 * @author villim
 *
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {

		int max = nums[0];
		int product = 1;
		for (int i : nums) {
			product *= i;
			max = max > product ? max : product;
			if (product == 0) {
				product = 1;
			}
		}

		product = 1;
		for (int i = nums.length - 1; i > 0; i--) {
			product *= nums[i];
			max = max > product ? max : product;
			if (product == 0) {
				product = 1;
			}
		}

		return max;
	}
}
