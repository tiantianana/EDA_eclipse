package phase2;

//these packages are used to implement the showLevel method
//the interface for a queue
import java.util.Queue;

import phase1.Student;

//the implementation of a Queue
import java.util.LinkedList;

public class BSTNode implements IBSTNode {

	String key;
	Student oStudent;
	BSTNode parent;
	BSTNode left;
	BSTNode right;

	public BSTNode(Student oStudent) {
		this.key = oStudent.email;
		this.oStudent = oStudent;
	}

	public int getDepth() {
		int depth = 0;
		BSTNode node = this.parent;
		while (node != null) {
			depth++;
			node = node.parent;
		}
		return depth;
	}

	public int getSize() {
		return getSize(this);
	}

	protected static int getSize(BSTNode node) {
		if (node == null)
			return 0;
		else
			return 1 + getSize(node.left) + getSize(node.right);
	}

	public int getHeight() {
		return getHeight(this);
	}

	protected static int getHeight(BSTNode node) {
		if (node == null)
			return 0;
		else
			return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	public void showPreOrder() {
		showPreOrder(this);
		System.out.println();
	}

	protected static void showPreOrder(BSTNode node) {
		if (node != null) {
			System.out.print(node.oStudent.toString() + "\t");
			showPreOrder(node.left);
			showPreOrder(node.right);

		}
	}

	public void showInOrder() {
		showInOrder(this);
		System.out.println();
	}

	protected static void showInOrder(BSTNode node) {
		if (node != null) {
			showInOrder(node.left);
			System.out.println(node.oStudent.toString());
			showInOrder(node.right);

		}
	}

	public void showPostOrder() {
		showPostOrder(this);
		System.out.println();
	}

	protected static void showPostOrder(BSTNode node) {
		if (node != null) {
			showPostOrder(node.left);
			showPostOrder(node.right);
			System.out.println(node.oStudent.toString());
		}
	}

	@Override
	public void showLevels() {
		Queue<BSTNode> queue = new LinkedList<BSTNode>();
		queue.add(this);

		while (!queue.isEmpty()) {
			BSTNode current = queue.poll();
			System.out.println(current.oStudent.toString());
			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);

		}
	}

	public boolean equals(BSTNode obj) {
		return equals(this, obj);
	}

	private static boolean equals(BSTNode obj1, BSTNode obj2) {
		if (obj1 == null && obj2 == null)
			return true;
		if ((obj1 == null && obj2 != null) || (obj1 != null && obj2 == null))
			return false;

		Student s1 = obj1.oStudent;
		Student s2 = obj2.oStudent;
		if ((s1 == null && s2 != null) || (s1 != null && s2 == null))
			return false;

		if (s1 != null && s2 != null) {
			if (!s1.equals(s2))
				return false;
		}
		return equals(obj1.left, obj2.left) && equals(obj1.right, obj2.right);
	}

}
