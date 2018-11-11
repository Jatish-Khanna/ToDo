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
		head = new Node(50);
		head.next = new Node(20);
		head.next.next = new Node(15);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(10);

		// Creating a loop for testing
		head.next.next.next.next.next = head.next.next;
		System.out.println("Removed loop ? " + detectAndRemoveLoop(head));
		System.out.println("Linked List after removing loop : ");
		printList();
	}

	private static int detectAndRemoveLoop(Node head2) {

		Node fast = head, slow = head;
		// Only one node
		if (fast == null || fast.next == null) {
			return -1;
		}

		slow = slow.next;
		fast = fast.next.next;
		while (fast != null && fast.next != null) {
			if (slow == fast)
				break;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (slow == fast) {
			return removeLoop(fast);
		} else {
			return -1;
		}

	}

	private static int removeLoop(Node fast) {
		Node slow = head;
		int sizeOfLoop = 0;
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
			sizeOfLoop++;
		}
		fast.next = null;

		return sizeOfLoop;
	}

}
