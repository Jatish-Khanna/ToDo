class Solution {
	public static void main(String args[]) {
		int a[] = { 1, 2, 3, 5, 4 };
		int miss = getMissingNo(a, 5);
		System.out.println(miss);
	}

	/**
	 * Find the missing number starting with 1...N
	 * @param a array of N-1 integers starting between 1...N
	 * @param length Length of array
	 * @return the missing number
	 */
	private static int getMissingNo(int[] a, int length) {
		// Initialize with the first element of array
		int xorLimit = a[0];
		//  Initialize with the starting number of the range
		int xorAll = 1;
		// Loop over all the elements and xor them 
		for (int index = 1; index < length; index++) {
			xorLimit = xorLimit ^ a[index];
		}

		// Exor of all the elements starting with 1...N
		for (int index = 2; index <= length + 1; index++) {
			xorAll = xorAll ^ index;
		}

		// Final result will be xor from 1...N and 1...N (missing x) - results x
		return xorAll ^ xorLimit;
	}
}
