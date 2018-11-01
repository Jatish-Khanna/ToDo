class Solution {
	public static void main(String[] args) {
		Solution arraysum = new Solution();
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int n = arr.length;
		int sum = 10;
		arraysum.subArraySum(arr, n, sum);
	}

	/**
	 * Find the indexes of subarray with total equals given sum
	 * 
	 * @param arr the elements in the array
	 * @param n   size of the array
	 * @param sum total of subset of given array
	 */
	private void subArraySum(int[] arr, int n, int sum) {
		int currentSum = 0;
		int start = 0;
		boolean hasFound = false;
		// Iterate over each element in the array
		for (int index = 0; index < n; index++) {

			// if current element is greater than required sum : reset
			if (arr[index] > sum) {
				currentSum = 0;
				start = index + 1;
				continue;
			}
			// Append the current element to the sum
			else {
				currentSum += arr[index];
			}

			// If current sum is greater than required, remove all previous appended
			// elements
			while (currentSum > sum && start < index) {
				// start is index of sub array where sum is lower than required
				currentSum -= arr[start++];
			}

			// if current sum equals required sum, display and remove first element to find
			// other subsets
			if (currentSum == sum) {
				System.out.println("Found sum starting with index: " + start + " ends at: " + index);
				currentSum -= arr[start++];
				hasFound = true;
			}
		}
		if(!hasFound) System.out.println("No subset found with required sum.");
	}
}
