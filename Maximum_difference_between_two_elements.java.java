class Solution {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 90, 10, 110 };
		int size = arr.length;
		System.out.println("MaximumDifference is " + maxDifferenceBetweenNumbers(arr, size));
	}

	/**
	 * Calculate the maximum difference between two numbers in list 
	 *  where is Max(a[j] - a[i])  and j > i
	 * @param arr provided list of numbers
	 * @param size number of elements in list
	 * @return maximum difference between two numbers
	 */
	private static int maxDifferenceBetweenNumbers(int[] arr, int size) {
		int maximumDifference = 0;
		// minimum number seen is first element
		int minimumNumberSeen = arr[0];
		// Iterate over all the elements in the list
		for (int index = 1; index < size; index++) {
			// Calculate the maximum difference and update
			maximumDifference = Math.max(maximumDifference, arr[index] - minimumNumberSeen);
			// Check and update if number seen is less than minimum see sofar
			minimumNumberSeen = Math.min(minimumNumberSeen, arr[index]);
		}
		return maximumDifference;
	}
}
