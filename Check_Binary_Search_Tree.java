// https://www.hackerrank.com/challenges/is-binary-search-tree/editorial

class Solution {
/**
	 * 
	 * The Node class is defined as follows:
	 */
	static class Node {
		public Node(int i) {
			this.data = i;
		}

		int data;
		Node left;
		Node right;
	}

	Node top;
  	boolean checkBST(Node root) {
		if (root == null)
			return true;
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean checkBST(Node root, int min, int max) {

		if (root == null)
			return true;
		if (min > root.data || root.data > max)
			return false;
		return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
	}

	public static void main(String args[]) {
		Solution tree = new Solution();
		tree.top = new Node(4);
		tree.top.left = new Node(2);
		tree.top.right = new Node(5);
		tree.top.left.left = new Node(1);
		tree.top.left.right = new Node(3);

		if (tree.checkBST(tree.top))
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}
  }

