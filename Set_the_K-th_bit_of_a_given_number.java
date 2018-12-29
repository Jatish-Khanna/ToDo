class Solution {
	private static int setKthBit(int number, int kthBit) {

		return (number | (1 << kthBit));
	}

// Driver code 
	public static void main(String arg[]) {
		int n = 10, k = 2;
		System.out.print("Kth bit set number = " + setKthBit(n, k));
	}
}
