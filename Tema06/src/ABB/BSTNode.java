package ABB;

import java.util.LinkedList;
import java.util.Queue;


public class BSTNode implements IBSTNode {

	Integer key;
	String elem;
	BSTNode parent;
	BSTNode left;
	BSTNode right;

	public BSTNode(Integer key, String elem) {
		this.key = key;
		this.elem = elem;
	}

	@Override
	public int getSize() {
		return getSize(this);
	}

	private static int getSize(BSTNode node) {
		if (node == null)
			return 0;
		else
			return 1 + getSize(node.left) + getSize(node.right);
	}
	
	@Override
	public int getDepth() {
		int depth = 0;
		BSTNode node = this.parent;
		while (node != null) {
			depth++;
			node = node.parent;
		}
		return depth;
	}

	@Override
	public int getHeight() {
		return getHeight(this);
	}
	
	private static int getHeight(BSTNode node) {
		if(node == null) return 0;
		else return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	@Override
	public void showInOrder() {
		showInOrder(this);
		System.out.println();
	}
	
	private static void showInOrder(BSTNode node) {
		if(node!=null) {
			showInOrder(node.left);
			System.out.println(node.key);
			showInOrder(node.right);
		}
	}
	
	@Override
	public void showPreOrder() {
		showPreOrder(this);
		System.out.println();
	}

	protected static void showPreOrder(BSTNode node) {
		if (node != null) {
			System.out.println(node.elem.toString());
			showPreOrder(node.left);
			showPreOrder(node.right);
		}
	}

	@Override
	public void showPostOrder() {
		showPostOrder(this);
		System.out.println();
	}

	private static void showPostOrder(BSTNode node) {
		if (node != null) {
			showPostOrder(node.left);
			showPostOrder(node.right);
			System.out.println(node.elem.toString());
		}
	}
	
	@Override
	public void showLevels() {
		
		Queue<BSTNode> queue = new LinkedList<BSTNode>();
		queue.add(this);
		
		while (!queue.isEmpty()) {
			BSTNode current=queue.poll();
			System.out.print(current.key+"\t");
		
			if (current.left!=null) queue.add(current.left);
			if (current.right!=null) queue.add(current.right);
			
		}
	}

}
