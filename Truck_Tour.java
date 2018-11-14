import java.io.IOException;
import java.util.Scanner;

public class Solution {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int pumps = scanner.nextInt();
		int petrol;
		int distance;

		long carry = 0;
		long sum = 0;
		long difference = 0;

		int start = 0;

		// Iterate over each petrol
		for (int index = 0; index < pumps; index++) {
			// Get next pump capacity
			petrol = scanner.nextInt();
			// Get next distance
			distance = scanner.nextInt();

			// What we achieve from petrol pump
			difference = petrol - distance;
			// Total carry till now
			sum += difference;
			// Total positive carry till now
			carry += difference;

			// If carry/petrol after refilling at current petrol pump is
			// negative
			if (carry < 0 || carry - sum < 0) {
				// Start with next petrol pump
				start = index + 1;
				// Positive carry is zero
				carry = 0;
			}
		}
		System.out.println(start);
		scanner.close();
	}
}
