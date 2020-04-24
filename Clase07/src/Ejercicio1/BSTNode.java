package Ejercicio1;

import java.util.LinkedList;
import java.util.Queue;

public class BSTNode {

	Integer key;
	String  elem;
	BSTNode parent;
	BSTNode left;
	BSTNode right;
	
	public BSTNode(Integer key, String elem) {
		this.key=key;
		this.elem=elem;
	}
		
	public int getDepth() {
		int depth=0;
		BSTNode node=this.parent;
		while (node!=null) {
			depth++;
			node=node.parent;
		}
		return depth;
	}
	
	public int getRecDepth1() {
		if (this.parent==null) return 0;
		else return this.parent.getRecDepth2();
	}
		
	
	public int getRecDepth2() {
		return getRecDepth2(this);
	}
	protected static int getRecDepth2(BSTNode node) {
		if (node==null) return 0;
		else return 1 + getRecDepth2(node.parent);
	}
	
	public int getSize() {
		return getSize(this);
	}
	protected static int getSize(BSTNode node) {
		if (node==null) return 0;
		else return 1 + getSize(node.left)+getSize(node.right);
	}
	
	public int getSize2() {
		int result;
		if (this.left==null && this.right==null) 
			result=1;
		else if (this.left!=null && this.right!=null) 
			result= 1 + this.left.getSize2()+this.right.getSize2();
		else if (this.left!=null)
			result= 1 + this.left.getSize2();
		else //(this.right!=null)
			result= 1 + this.right.getSize2();
		return result;
	}

	
	public int getHeight() {
		return getHeight(this);
	}
	protected static int getHeight(BSTNode node) {
		if (node==null) return 0;
		else return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	public void showPreOrder() {
		showPreOrder(this);
		System.out.println();
	}
	protected static void showPreOrder(BSTNode node) {
		if (node!=null) {
			System.out.print(node.key+"\t");
			showPreOrder(node.left);
			showPreOrder(node.right);
			
		}
	}
	
		public void showInOrder() {
			showInOrder(this);
			System.out.println();
		}
		protected static void showInOrder(BSTNode node) {
			if (node!=null) {
				showInOrder(node.left);
				System.out.print(node.key+"\t");
				showInOrder(node.right);
				
			}
		}

		public void showPostOrder() {
			showPostOrder(this);
			System.out.println();
		}
		protected static void showPostOrder(BSTNode node) {
			if (node!=null) {
				showPostOrder(node.left);
				showPostOrder(node.right);
				System.out.print(node.key+"\t");
			}
		}

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