import java.util.ArrayList;
import java.util.Comparator;


public class PlatformCounter {

	private static int countRequiredPlatforms(int[][] timetable) {

		ArrayList<Integer> sortedTimetable = new ArrayList<>();
		int maxPlatforms = 0;
		int currentPlatforms = 0;
		for (int[] timing : timetable) {
			sortedTimetable.add(timing[0]);
			sortedTimetable.add(-timing[1]);
		}

		sortedTimetable.sort(new Comparator<Integer>() {
			public int compare(Integer num1, Integer num2) {
				int diff = Math.abs(num1) - Math.abs(num2);
				if (diff == 0) {
					return num2 - num1;
				}
				return diff;
			}
		});

		for (Integer time : sortedTimetable) {
			if(time > 0) {
				currentPlatforms++;
			} else {
				currentPlatforms--;
			}
			if(currentPlatforms > maxPlatforms) {
				maxPlatforms = currentPlatforms;
			}
		}
		
		return maxPlatforms;
	}

	public static void main(String[] args) {
		int[][] timetable = { { 1481122000, 1481122020 }, { 1481122000, 1481122040 }, { 1481122030, 1481122035 } };
		System.out.println(countRequiredPlatforms(timetable));
	}
}
