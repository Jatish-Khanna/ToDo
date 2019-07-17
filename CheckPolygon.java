enum POLYGON {
	SQUARE, RECTANGLE, OTHERS
}

public class CheckPolygon {

	private static int checkPolygon(int[] sides) {
		if (isInvalidInput(sides)) {
			return POLYGON.OTHERS.ordinal();
		} else if (isSqaure(sides)) {
			return POLYGON.SQUARE.ordinal();
		} else if (isRectangle(sides)) {
			return POLYGON.RECTANGLE.ordinal();
		}
		return POLYGON.OTHERS.ordinal();
	}

	private static boolean isRectangle(int[] sides) {
		if (sides[0] == sides[2] && sides[1] == sides[3]) {
			return true;
		}
		return false;
	}

	private static boolean isSqaure(int[] sides) {
		if (isRectangle(sides) && sides[0] == sides[3]) {
			return true;
		}
		return false;
	}

	private static boolean isInvalidInput(int[] sides) {
		if (sides[0] < 0 || sides[1] < 0 || sides[2] < 0 || sides[3] < 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] sides = { 10, 10, 10, -10 };
		System.out.println(checkPolygon(sides));
	}
}
