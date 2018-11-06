import java.util.Arrays;

class Solution {
	public static void main(String[] args) {
		int arr[] = { 12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50 };

		int m = 7; // Number of students

		int n = arr.length;
		System.out.println("Minimum difference is " + minDif2ferenceArraySubsequenceMSize(arr, n, m));

	}

	/**
	 * distribute chocolate packets such that:
	 * 
	 * Each student gets one packet. The difference between the number of chocolates
	 * in packet with maximum chocolates and packet with minimum chocolates given to
	 * the students is minimum.
	 * 
	 * @param arr packets of different size
	 * @param n number of packets
	 * @param m number of students
	 * @return minimum difference between packet with max chocolate and min chocolate
	 */
	private static int minDif2ferenceArraySubsequenceMSize(int[] arr, int n, int m) {
		int minimumDiff = Integer.MAX_VALUE;
		// Sort the packets
		Arrays.sort(arr);
		int indexStudents = m - 1;
		// For each packet - calculate difference in range (index+m, index)
		for (int index = indexStudents; index < n; index++) {
			minimumDiff = Math.min(minimumDiff, arr[index] - arr[index - indexStudents]);
		}
		// Minimum difference found till now
		return minimumDiff;
	}

}
