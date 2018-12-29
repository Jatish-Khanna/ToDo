class Solution {

	private final static int ODD_BITS = 0xAAAAAAAA;
	private final static int EVEN_BITS = 0x55555555;

	// Even bits to be right shifted whereas ODD to be left shifted
	private static int swapBits(int number) {
		return ((number & EVEN_BITS) >> 1) | ((number & ODD_BITS) << 1);
	}

	// Driver program to test above function
	public static void main(String[] args) {
		int x = 1; // 00010111

		// Output is 43 (00101011)
		System.out.println(swapBits(x));
	}
}
