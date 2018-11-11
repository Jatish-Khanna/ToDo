class Solution {


	static Node head; // head of list
	static Node current; // head of list
	static int number;
	static int count;
	/* Linked list Node */

	private static class Node {
		char data;
		Node next;

		Node(char d) {
			data = d;
			next = null;
		}
	}

	public static void push(char new_data) {
		/*
		 * Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* link the old list off the new one */
		new_node.next = head;

		/* Move the head to point to new Node */
		head = new_node;
		count++;
	}

	// A utility function to print a given linked list
	static void printList(Node ptr) {
		while (ptr != null) {
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		}
		System.out.println("NULL");
	}

	/* Driver program to test the above functions */
	public static void main(String[] args) {
		char str[] = { 'a', 'b', 'd', 'c', 'd', 'b', 'a' };
		for (int i = 0; i < 7; i++) {
			push(str[i]);
			printList(head);
			if (isPalindrome(head) != false) {
				System.out.println("Is Palindrome");
			} else {
				System.out.println("Not Palindrome");
			}
		}
	}

	private static boolean isPalindrome(Node node) {
		if (node == null) {
			current = head;
			number = 0;
			return true;
		}
		boolean isSame = isPalindrome(node.next);
		if (!isSame)
			return false;
		if (number > (count / 2))
			return isSame;
		isSame = current.data == node.data;
		number++;
		current = current.next;
		return isSame;
	}
}
