class Solution {
	public static void main(String[] args) {
		int arr[] = new int[] { 16, 17, 4, 3, 5, 2 };
		int n = arr.length;
		printLeaders(arr, n);
	}


	private static void printLeaders(int[] arr, int n) {
		int lastMax = Integer.MIN_VALUE;
		for (int index = n - 1; index >= 0; index--) {
			if (lastMax < arr[index]) {
				lastMax = arr[index];
				System.out.print(lastMax + " ");
			}
		}
	}
}
