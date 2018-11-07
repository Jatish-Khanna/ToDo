import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		int[] A1 = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8, 7, 5, 6, 9, 7, 5 };
		int[] A2 = { 2, 1, 8, 3, 4 };
		ArrayList<Integer> result = sortA1ByA2Order(A1, A1.length, A2, A2.length);
		result.stream().forEach(data -> System.out.print(data + " "));

		Integer[] A3 = Arrays.stream(A1).boxed().toArray(Integer[]::new);
		System.out.println();
		sortA1ByA2Comparator(A3, A3.length, A2, A2.length);
		Arrays.stream(A3).forEach(data -> System.out.print(data + " "));
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

	/**
	 * Order the array using comparator
	 * 
	 * 1. If num1 and num2 both are in A2 then number with lower index in A2
	 * will be treated smaller than other.
	 * 
	 * 2. If only one of num1 or num2 present in A2, then that number will be
	 * treated smaller than the other which doesn’t present in A2.
	 * 
	 * 3. If both are not in A2, then natural ordering will be taken
	 * 
	 * @param a1
	 *            array of Integers to be ordered
	 * @param length
	 *            size of array
	 * @param a2
	 *            array of Integer defines the order
	 * @param length2
	 *            size of array
	 */
	private static void sortA1ByA2Comparator(Integer[] a1, int length, int[] a2, int length2) {

		// A dictionary to store the Element and Index of element
		HashMap<Integer, Integer> searchList = new HashMap<>();

		// Prepare diction to store element and index
		for (int index = 0; index < length2; index++) {
			searchList.put(a2[index], index);
		}

		// Sort the boxed arrays using Custom comparator
		Arrays.sort(a1, new Comparator<Integer>() {

			// Method to be implement in parent Interface
			@Override
			public int compare(Integer o1, Integer o2) {
				
				// If both the elements are present in prepared Map
				// Element with Lower index comes first followed by Higher Index
				if (searchList.containsKey(o1) && searchList.containsKey(o2)) {
					return searchList.get(o1) - searchList.get(o2);
				} 
				// If Only first element is present - it comes first
				else if (searchList.containsKey(o1)) {
					return -1;
				} 
				// If only second element is present, it comes first
				else if (searchList.containsKey(o2)) {
					return 1;
				} 
				// If none of element is present, choose natural order
				else {
					return o1 - o2;
				}
			}
		});
	}
}
