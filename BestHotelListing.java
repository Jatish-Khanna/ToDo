import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BestHotelListing {

	private static int[] getHotelsWithBestReviews(String keywords, int[] hotelIds, String[] reviews) {
		Set<String> findWords = Arrays.stream(keywords.split(" ")).map(String::toLowerCase).collect(Collectors.toSet());

		Map<Integer, Long> hotelMapping = new HashMap<>();

		for (int index = 0; index < hotelIds.length; index++) {
			long count = Arrays.stream(reviews[index].split(" ")).map(word -> word.replace(".,]", ""))
					.map(String::toLowerCase).filter(findWords::contains).count();
			hotelMapping.put(hotelIds[index], hotelMapping.getOrDefault(hotelIds[index], 0L) + count);
		}

		List<Hotel> hotelList = new ArrayList<>();
		for (Map.Entry<Integer, Long> entry : hotelMapping.entrySet()) {
			hotelList.add(new Hotel(entry.getKey(), entry.getValue()));
		}

		Collections.sort(hotelList);

		return hotelList.parallelStream().mapToInt(Hotel::getHotelId).toArray();
	}

	private static class Hotel implements Comparable<Hotel> {
		int hotelId;
		long wordsCount;

		Hotel(int hotelId, long wordsCount) {
			this.hotelId = hotelId;
			this.wordsCount = wordsCount;

		}

		public int getHotelId() {
			return hotelId;
		}

		public int compareTo(Hotel hotel) {
			long diff = hotel.wordsCount - this.wordsCount;
			if (diff != 0) {
				return diff > 0 ? 1 : -1;
			}
			return this.hotelId - hotel.hotelId;
		}

	}

	public static void main(String[] args) {
//		System.out.println(getHotelsWithBestReviews());
	}

}
