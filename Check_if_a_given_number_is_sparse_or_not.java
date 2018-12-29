class Solution {

	private static boolean checkSparse(int number) {
		return (number & (number >> 1)) == 0;
	}

	// Driver code
	public static void main(String[] args) {
		System.out.println(checkSparse(72));
		System.out.println(checkSparse(12));
		System.out.println(checkSparse(2));
		System.out.println(checkSparse(3));

	}
}
