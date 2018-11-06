import java.util.ArrayList;

class BuySellInterval {
	int buy;
	int sell;

	@Override
	public String toString() {
		return "BuySellInterval [buy=" + buy + ", sell=" + sell + "]";
	}
}

class Solution {
	public static void main(String args[]) {
		// stock prices on consecutive days
		int price[] = { 100, 180, 260, 310, 40, 535, 695 };
		int n = price.length;

		stockBuySell(price, n);
	}

	/**
	 * The list of interval when stock should be bought and sold
	 * @param price value for each day
	 * @param n number of days
	 */
	private static void stockBuySell(int[] price, int n) {
		int index = 0;
		// Stores the Buy and sell interval
		ArrayList<BuySellInterval> list = new ArrayList<>();
		// Iterate over each day
		while (index < n - 1) {
			// Move to next day until - price is lower than next day
			while (index < n - 1 && price[index] >= price[index + 1])
				index++;
			// if reverse sorted or end of prices then break
			if (index == n - 1)
				break;
			// Create new interval instance
			BuySellInterval nextInterval = new BuySellInterval();
			// Found the position when stock should be bought
			nextInterval.buy = index++;
			
			// Iterate over remaining days, until day with price is higher than previous day
			while (index < n && price[index] > price[index - 1])
				index++;
			// Last day seen has maximum price to get benefit off
			nextInterval.sell = index - 1;
			// Add interval instance and iterate over remaining days
			list.add(nextInterval);
		}
		// stream over store list and print using @Overriden toString method of class
		list.stream().forEach(System.out::println);
	}
}
