class Solution {

	private static int maxConsecutiveOnes(int number) {

		int count = 0;
		while (number > 0) {
			number = (number & (number >> 1));
			count++;
		}

		return count;
	}

	// Driver code
	public static void main(String strings[]) {
		System.out.println(maxConsecutiveOnes(14));
		System.out.println(maxConsecutiveOnes(222));
	}
}
