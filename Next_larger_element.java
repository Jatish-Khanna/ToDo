import java.util.Arrays;
import java.util.ArrayDeque;

class Solution {


	// Store Next greater element for each data
	private static int[] greaterElement;

	// Driver program
	public static void main(String[] args) {
		int arr[] = { 11, 13, 21, 3 };
		greaterElement = new int[arr.length];
		nextGreaterElement(arr, arr.length);
		Arrays.stream(greaterElement).forEach(System.out::println);
	}

	/**
	 * Find next greater element for each element
	 * 
	 * @param arr    element for which next greater element to be identified
	 * @param length number of elements
	 */
	private static void nextGreaterElement(int[] arr, int length) {

		// Stores the last seen greater element from last
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		// Iterate over each element from last to first
		for (int index = length - 1; index >= 0; index--) {
			// Pop/remove all the elements from stack until smaller than current element
			while (!stack.isEmpty() && stack.peek() <= arr[index]) {
				stack.pop();
			}
			// New element is stack top or -1 if empty
			greaterElement[index] = stack.isEmpty() ? -1 : stack.peek();
			// Add new element to stack
			stack.push(arr[index]);
		}
	}
}
