import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Solution {
	public static void main(String[] args) {
		Integer arr[] = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 };
		SortedSet<Entry<Integer, Details>> result = sortByFrequency(arr, arr.length);

		int count = 0;
//		for (Entry<Integer, Details> process : result) {
//			count = process.getValue().getFrequency();
//			while (count > 0) {
//				System.out.print(process.getValue().getData() + " ");
//				count--;
//			}
//		}
		result.stream()
				.forEach(element -> {
					IntStream.range(0, element.getValue().getFrequency())
						.forEach(data -> System.out.print(element.getKey()+" "));
				});

	}

	private static SortedSet<Entry<Integer, Details>> sortByFrequency(Integer[] arr, int length) {

		Map<Integer, Details> freqDictionary = new HashMap<>();
		for (int index = 0; index < length; index++) {
			Details current = freqDictionary.getOrDefault(arr[index], new Details(arr[index], index));
			current.incrementFrequency();
			freqDictionary.put(arr[index], current);
		}

		SortedSet<Map.Entry<Integer, Details>> sortedDictionary = new TreeSet<>(
				new Comparator<Map.Entry<Integer, Details>>() {

					@Override
					public int compare(Map.Entry<Integer, Details> o1, Map.Entry<Integer, Details> o2) {
						if (o1.getValue().getFrequency() != o2.getValue().getFrequency()) {
							return o2.getValue().getFrequency() - o1.getValue().getFrequency();
						} else {
							return o1.getValue().getIndex() - o2.getValue().getIndex();
						}

					}

				});
		for (Entry<Integer, Details> process : freqDictionary.entrySet()) {
			sortedDictionary.add(process);
		}

		return sortedDictionary;
	}
}

class Details {
	private int index;
	int frequency;
	private int data;

	public Details(int data, int index) {
		super();
		this.index = index;
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void incrementFrequency() {
		this.frequency++;
	}

	public int getIndex() {
		return index;
	}

	public int getFrequency() {
		return frequency;
	}
}
