class Solution {

	private static boolean isPowerOfTwo(int number) {
		return number != 0 && (number & (number - 1)) == 0;
	}

	// Driver method
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(31) ? "Yes" : "No");
		System.out.println(isPowerOfTwo(64) ? "Yes" : "No");

	}
}
