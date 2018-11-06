import java.util.Deque;
import java.util.LinkedList;

class Solution {
	public static void main(String[] args) {
		int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
		int k = 2;
		maxInWindowsKSize(arr, arr.length, k);
	}

	/**
	 * Get the maximum of current window size 
	 * @param arr list to be processed on
	 * @param length of list
	 * @param k the window size for which maximum to be identified
	 */
	private static void maxInWindowsKSize(int[] arr, int length, int k) {
		
		// Store the index in queue which is max of its all left
		Deque<Integer> windowMax = new LinkedList<>();
		int index = 0;
		// Process until first window
		while (index < k) {
			// Current element is maximum of all elements to its left
			removeLastWindow(windowMax, arr, index);
			index++;
		}

		// Next element until end of list
		while (index < length) {
			// The front/head of list store maximum 
			System.out.println(arr[windowMax.peek()] + " ");
			// If head of list is out of Window (remove head)
			if (windowMax.peekFirst() <= index - k)
				windowMax.removeFirst();
			// Current element is maximum of all elements to its left
			removeLastWindow(windowMax, arr, index);
			index++;
		}
		// Off By one - element to be printed for last windows
		System.out.println(arr[windowMax.peek()]);
	}

	/**
	 * Remove the index from back/tail of list storing max till now
	 * @param queue stores maximum till now 
	 * @param arr original list of elements
	 * @param index current location to process
	 */
	public static void removeLastWindow(Deque<Integer> queue, int[] arr, int index) {
		// Remove all the elements at index stored in queue, smaller than element at current index
		while (!queue.isEmpty() && arr[index] >= arr[queue.peekLast()])
			queue.removeLast();
		// Add current element at end
		queue.add(index);
	}

}
