class Solution {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 2, 4, 4, 5, 5, 6, 6, 7 };
		int index = searchInSortedArrayWithFrequencyOne(arr, 0, arr.length - 1);
		if (index >= 0)
			System.out.println("Element found: " + arr[index] + " at index: " + index);
		else
			System.out.println("No such element found!");
	}

	/**
	 * All elements appear twice (one after one) and one element appears only once.
	 * Find that element in O(log n) complexity
	 * 
	 * @param arr   stored elements
	 * @param start start of sublist for binary search
	 * @param end   end of sublist for binary search
	 * @return index at which element is found, else -1
	 */
	private static int searchInSortedArrayWithFrequencyOne(int[] arr, int start, int end) {
		// Bounds overlapped no such element found
		if (start > end)
			return -1;
		// Element found - return index
		if (start == end) {
			return start;
		}

		// Calculate mid for binary search technique
		int mid = start + (end - start) / 2;

		// If mid is even 0, 2, 4 ...
		if (mid % 2 == 0) {
			// Element at mid and next to mid are same (recurse over right subarray)
			if (arr[mid] == arr[mid + 1]) {
				return searchInSortedArrayWithFrequencyOne(arr, mid + 2, end);
			}
			// Element at mid and next to mid are not same (recurse over left subarray)
			else {
				return searchInSortedArrayWithFrequencyOne(arr, start, mid);
			}
		}
		// if mid is odd 1, 3, 5 ...
		else {
			// Element at mid and previous to mid are same (recurse over right subarray)
			if (arr[mid] == arr[mid - 1]) {
				return searchInSortedArrayWithFrequencyOne(arr, mid + 1, end);
			}
			// Element at mid and previous to mid are not same (recurse over left subarray)
			else {
				return searchInSortedArrayWithFrequencyOne(arr, start, mid - 1);
			}
		}
	}

}
