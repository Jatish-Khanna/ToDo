import java.util.ArrayList;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		int A1[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8, 7, 5, 6, 9, 7, 5 };

		int A2[] = { 2, 1, 8, 3, 4 };
		ArrayList<Integer> result = sortA1ByA2Order(A1, A1.length, A2, A2.length);
		result.stream().forEach(System.out::println);
	}

	/**
	 * Given two arrays A1[] and A2[], sort A1 in such a way that the relative
	 * order among the elements will be same as those are in A2. For the
	 * elements not present in A2, append them at last in sorted order.
	 * 
	 * @param a1
	 *            stored data to be ordered as per A2 and natural order for
	 *            remaining elements
	 * @param length
	 *            number of elements in a1
	 * @param a2
	 *            elements provides the order for A1
	 * @param length2
	 *            number of elements in a2
	 * @return final list of ordered elements as per requirement
	 */
	private static ArrayList<Integer> sortA1ByA2Order(int[] a1, int length, int[] a2, int length2) {

		// Stores the elements in list
		ArrayList<Integer> result = new ArrayList<>();
		// A dictionary to store the frequency of each element
		TreeMap<Integer, Integer> preparedDictionary = new TreeMap<>();

		// Iterate over each element and prepare a dictionary of frequencies
		for (int index = 0; index < length; index++) {
			preparedDictionary.put(a1[index], preparedDictionary.getOrDefault(a1[index], 0) + 1);
		}

		// Iterate over set defines the order for A1
		for (int element : a2) {
			// Append the element up to its frequency stored in dictionary
			appendElement(element, result, preparedDictionary.getOrDefault(element, 0));
			// Remove the element from dictionary, as it is already visited
			preparedDictionary.remove(element);
		}
		// Iterate over remaining elements in dictionary not present in A2
		for (Integer element : preparedDictionary.keySet()) {
			// Append each element to count of its frequency present in A1
			appendElement(element, result, preparedDictionary.getOrDefault(element, 0));
		}
		// result list
		return result;
	}

	/**
	 * Append each element upto it frequency
	 * 
	 * @param element
	 *            data to be appended
	 * @param result
	 *            element will be appended to reference list
	 * @param count
	 *            number of times element to be appended
	 */
	private static void appendElement(int element, ArrayList<Integer> result, Integer count) {
		// Append element upto count
		while (count > 0) {
			result.add(element);
			count--;
		}
	}

}
