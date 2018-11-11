class Solution {

	static Node head; // head of list
	/* Linked list Node */

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}
  
	public static void addFirst(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	static void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}
		System.out.println("NULL");
	}

	public static void main(String[] args) {

		addFirst(20);
		addFirst(4);
		addFirst(15);
		addFirst(35);

		printNthFromLast(4);
	}

	private static void printNthFromLast(int nth) {
		int count = 0;
		Node kthLast = head;
		Node current = head;
		while (count < nth) {
			current = current.next;
			count++;
		}
		while (current != null) {
			kthLast = kthLast.next;
			current = current.next;
		}
		System.out.println("Node no. " + nth + " from last is " + kthLast.data);
	}
}
