import java.util.ArrayList;

public class Encoding {

	private static final int ESCAPE_TOKEN = -128;
	private static final int DIFFERENCE_ALLOWED = 127;

	private static ArrayList<Integer> encoding(int[] list) {
		if (list == null || list.length < 1) {
			return null;
		}

		int prev = list[0];
		int diff = 0;
		ArrayList<Integer> encodedList = new ArrayList<>();
		encodedList.add(prev);

		for (int index = 1; index < list.length; index++) {
			diff = list[index] - prev;
			if (Math.abs(diff) > DIFFERENCE_ALLOWED) {
				encodedList.add(ESCAPE_TOKEN);
			}

			encodedList.add(diff);
			prev = list[index];
		}
		return encodedList;
	}

	public static void main(String[] args) {
		int[] list = { 25626, 25757, 24367, 24267, 16, 100, 2, 7277 };
		System.out.println(encoding(list));
	}
}
