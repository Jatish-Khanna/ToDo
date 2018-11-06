class Solution {
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int k = 3;

		int n = arr.length;

		reverseSubArrayKSize(arr, n, k);

		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
	/**
	 * 
	 * Reverse K size subarrays in the original list O(N)
	 * @param arr original list to be reversed
	 * @param n size of list
	 * @param k size of sublist to be reversed
	 */
	private static void reverseSubArrayKSize(int[] arr, int n, int k) {
		// for swapping elements
		int tmp;
		// Iterate over the complete list
		for (int index = 0; index < n; index += k) {
			// Left of K-size sublist (no overlapping)
			// 1 2 3 4 5 (k == 2 means [1 2] [3 4] [5])
			int left = index;
			// Minimum of end of list /or next K elements
			int right = Math.min(left + k - 1, n - 1);
			// till left is smaller than right
			while (left < right) {
				// Swap the elements
				tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
				left++;
				right--;
			}
		}

	}
}
