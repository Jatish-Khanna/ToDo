class Solution {

	static Node head; // head of list
	/* Linked list Node */

	static class Node {
		int data;
		Node right, down;

		Node(int data) {
			this.data = data;
			right = null;
			down = null;
		}
	}
  
	static void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + "->");
			current = current.down;
		}
		System.out.println("NULL");
	}

	static Node push(Node head_ref, int data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(data);

		/* 3. Make next of new Node as head */
		new_node.down = head_ref;

		/* 4. Move the head to point to new Node */
		head_ref = new_node;

		/* 5. return to link it back */
		return head_ref;
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {

		head = push(head, 30);
		head = push(head, 8);
		head = push(head, 7);
		head = push(head, 5);

		head.right = push(head.right, 20);
		head.right = push(head.right, 10);

		head.right.right = push(head.right.right, 50);
		head.right.right = push(head.right.right, 22);
		head.right.right = push(head.right.right, 19);

		head.right.right.right = push(head.right.right.right, 45);
		head.right.right.right = push(head.right.right.right, 40);
		head.right.right.right = push(head.right.right.right, 35);
		head.right.right.right = push(head.right.right.right, 28);

		// flatten the list
		head = flattenLinkedList(head);
		printList();
	}

	private static Node flattenLinkedList(Node current) {
		if (current == null || current.right == null)
			return current;

		current.right = flattenLinkedList(current.right);
		current = merge(current, current.right);
		return current;
	}

	// Logic to merge two Linked list
	private static Node merge(Node current, Node right) {
		if (right == null)
			return current;
		else if (current == null)
			return right;

		Node newHead;
		Node node;
		if (current.data < right.data) {
			node = current;
			current = current.down;
		} else {
			node = right;
			right = right.down;
		}
		newHead = new Node(node.data);
		node = newHead;

		while (current != null && right != null) {
			if (current.data < right.data) {
				node.down = new Node(current.data);
				current = current.down;
			} else {
				node.down = new Node(right.data);
				right = right.down;
			}
			node = node.down;
		}
		if (current != null)
			node.down = current;
		if (right != null)
			node.down = right;

		return newHead;
	}

}
