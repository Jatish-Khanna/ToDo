class Solution {


	static Node firstNumber; // head of list
	static Node secondNumber; // head of list
	static int recurssiveCarry = 0;
	static Node recurssiveResult;
	/* Linked list Node */

	private static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	static void printList(Node node) {
		Node temp = node;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		// creating first list
		firstNumber = new Node(9);
		firstNumber.next = new Node(9);
		firstNumber.next.next = new Node(9);
		firstNumber.next.next.next = new Node(4);
		firstNumber.next.next.next.next = new Node(6);
		System.out.print("First List is ");
		printList(firstNumber);

		// creating second list
		secondNumber = new Node(8);
		secondNumber.next = new Node(4);
		System.out.print("Second List is ");
		printList(secondNumber);

		// add the two lists and see the result
		Node rs = addTwoLists(firstNumber, secondNumber);
		System.out.print("Resultant List is ");
		printList(rs);

		addTwoListsLeftToRight(firstNumber, secondNumber);
		System.out.print("Resultant List is ");
		printList(recurssiveResult);

	}

	private static Node addTwoLists(Node firstNumberArg, Node secondNumberArg) {
		Node result = new Node(0);
		Node head = result;
		int sum = 0;
		int carry = 0;
		int first;
		int second;
		while (firstNumberArg != null || secondNumberArg != null || carry > 0) {

			first = firstNumberArg != null ? firstNumberArg.data : 0;
			second = secondNumberArg != null ? secondNumberArg.data : 0;

			sum = first + second + carry;
			carry = sum / 10;
			sum = sum % 10;
			result.next = new Node(sum);

			firstNumberArg = firstNumberArg != null ? firstNumberArg.next : null;
			secondNumberArg = secondNumberArg != null ? secondNumberArg.next : null;
			result = result.next;
		}

		return head.next;
	}

	// First node is Most significant digit
	private static Node addTwoListsLeftToRight(Node firstNumberArg, Node secondNumberArg) {
		if (firstNumberArg == null)
			return secondNumberArg;
		else if (secondNumberArg == null)
			return firstNumberArg;

		int sizeFirst = getSize(firstNumberArg);
		int sizeSecond = getSize(secondNumberArg);
		int difference = sizeFirst - sizeSecond;
		Node longerList = null;
		if (difference < 0) {
			longerList = secondNumberArg;
			secondNumberArg = moveLongerList(secondNumberArg, Math.abs(difference));
		} else if (difference > 0) {
			longerList = firstNumberArg;
			firstNumberArg = moveLongerList(firstNumberArg, Math.abs(difference));
		}

		addTwoListsRecusrive(firstNumberArg, secondNumberArg);
		propagateCarry(longerList, difference);
		if(recurssiveCarry > 0)
			recurssiveResult = push(recurssiveResult, 1);
		return recurssiveResult;
	}

	private static void propagateCarry(Node longerList, int difference) {
		if (recurssiveCarry == 0 || difference == 0)
			return;
		if (longerList == null) {
			recurssiveResult = push(recurssiveResult, recurssiveCarry);
			recurssiveCarry = 0;
		}
		propagateCarry(longerList.next, difference - 1);
		int sum = longerList.data + recurssiveCarry;
		recurssiveCarry = sum / 10;
		sum = sum % 10;
		recurssiveResult = push(recurssiveResult, sum);
	}

	private static void addTwoListsRecusrive(Node firstNumberArg, Node secondNumberArg) {
		if (firstNumberArg == null)
			return;
		addTwoListsRecusrive(firstNumberArg.next, secondNumberArg.next);
		int sum = firstNumberArg.data + secondNumberArg.data + recurssiveCarry;
		recurssiveCarry = sum / 10;
		sum = sum % 10;
		recurssiveResult = push(recurssiveResult, sum);
	}

	private static Node moveLongerList(Node node, int size) {
		while (size-- > 0) {
			node = node.next;
		}
		return node;
	}

	private static int getSize(Node node) {
		int size = 0;
		while (node != null) {
			node = node.next;
			size++;
		}
		return size;
	}

	private static Node push(Node node, int data) {
		Node tmp = new Node(data);
		tmp.next = node;
		return tmp;
	}
}
