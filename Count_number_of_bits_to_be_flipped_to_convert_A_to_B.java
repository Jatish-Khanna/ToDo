class Solution {

	private static int flippedBitCount(int numberOne, int numberTwo) {
		int diffBits = numberOne ^ numberTwo;
		int count = 0;
		while (diffBits > 0) {
			count += diffBits & 1;
			diffBits = diffBits >> 1;
		}
		return count;
	}

	// Driver code
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.print(flippedBitCount(a, b));
	}
}
