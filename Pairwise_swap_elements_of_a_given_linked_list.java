class Solution {

	static Node head; // head of list
	/* Linked list Node */

	private static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	static void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		/* Created Linked List 1->2->3->4->5 */
		push(6);
		push(5);
		push(4);
		push(3);
		push(2);
		push(1);

		System.out.println("Linked List before calling pairWiseSwap() ");
		printList();

		pairWiseSwap();

		System.out.println("Linked List after calling pairWiseSwap() ");
		printList();
	}

	/* Utility functions */

	private static void pairWiseSwap() {
		if (head == null)
			return;

		Node first = head, second = head.next;
		while (first != null && second != null) {
			swapNodes(first, second);
			first = second.next;
			second = first == null ? null : first.next;
		}
	}

	private static void swapNodes(Node first, Node second) {
		int tmp = first.data;
		first.data = second.data;
		second.data = tmp;
	}

	/* Inserts a new Node at front of the list. */
	static public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}
}
