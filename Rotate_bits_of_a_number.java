class Solution {

	private static final int INT_SIZE = Integer.SIZE;

	private static int leftRotate(int number, int rotateKBits) {
		return (number << rotateKBits) | (number >> INT_SIZE - rotateKBits);
	}

	private static int rightRotate(int number, int rotateKBits) {
		return (number >> rotateKBits) | (number << INT_SIZE - rotateKBits);
	}

// Driver code 
	public static void main(String arg[]) {
		int n = 16;
		int d = 2;
		System.out.print("Left Rotation of " + n + " by " + d + " is ");
		System.out.print(leftRotate(n, d));

		System.out.print("\nRight Rotation of " + n + " by " + d + " is ");
		System.out.print(rightRotate(n, d));
	}
}
