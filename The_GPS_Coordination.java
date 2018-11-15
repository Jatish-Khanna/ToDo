import java.util.Scanner;

class Solution {


	private static final int DISTANCE = 1;

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int personOneX = in.nextInt();
		int personOneY = in.nextInt();

		Point personOnePosition = new Point(personOneX, personOneY);

		int personTwoX = in.nextInt();
		int personTwoY = in.nextInt();
		Point personTwoPosition = new Point(personTwoX, personTwoY);

		char[] personOneDirection = in.next().toCharArray();
		char[] personTwoDirection = in.next().toCharArray();

		/**
		 * Find common point Assumptions: - Both person will move equal distance (length
		 * of travel is same) - Both person will meet at a point when they have traveled
		 * same distance
		 */
		int index = 0;
		for (; index <= personOneDirection.length; index++) {
			if (checkPersonsPosition(personOnePosition, personTwoPosition)) {
				break;
			}
			movenextMileInDirection(personOnePosition, personOneDirection[index]);
			movenextMileInDirection(personTwoPosition, personTwoDirection[index]);
		}
		System.out.println(personOnePosition.x + " " + personOnePosition.y + " " + index);

		in.close();
	}

	private static void movenextMileInDirection(Point personPosition, char direction) {
		switch (direction) {
		case 'U':
			moveUp(personPosition);
			break;
		case 'D':
			moveDown(personPosition);

			break;
		case 'L':
			moveLeft(personPosition);
			break;
		case 'R':
			moveRight(personPosition);
			break;
		}
	}

	private static void moveRight(Point personPosition) {
		personPosition.x = personPosition.x + DISTANCE;
	}

	private static void moveLeft(Point personPosition) {
		personPosition.x = personPosition.x - DISTANCE;
	}

	private static void moveDown(Point personPosition) {
		personPosition.y = personPosition.y - DISTANCE;
	}

	private static void moveUp(Point personPoistion) {
		personPoistion.y = personPoistion.y + DISTANCE;
	}

	private static boolean checkPersonsPosition(Point personOnePosition, Point personTwoPosition) {

		return personOnePosition.x == personTwoPosition.x && personOnePosition.y == personTwoPosition.y;
	}
}
