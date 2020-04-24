package Ejercicio1;

public class BSTree {

	BSTNode root;
	
	public String find(Integer key) {
		return find(root, key);
	}
	
	private static String find(BSTNode currentNode, Integer key) {
		String result=null;
		if (currentNode == null) {
			System.out.println(key + " does not exist!");
		} else {
			if (key.equals(currentNode.key))
				result= currentNode.elem;
			else if (key.compareTo(currentNode.key) < 0)
				result=find(currentNode.left, key);
			else
				result=find(currentNode.right, key);
		}
		return result;
	}
	
	public void insert(Integer key, String element) {
		BSTNode newNode=new BSTNode(key, element);
		if (root==null) root=newNode;
		else insert(newNode, root);
	}
	
	protected static void insert(BSTNode newNode, BSTNode currentNode) {
		if (currentNode==null) return;
		Integer key=newNode.key;
		if (key.compareTo(currentNode.key)==0) {
			System.out.println(key + " already exists. Duplicates are not allowed!!!.");
			return;
		}
		if (key.compareTo(currentNode.key)<0) {
			if (currentNode.left==null) {
				currentNode.left=newNode;
				newNode.parent=currentNode;
			} else {
				insert(newNode,currentNode.left);
			}
		} else {
			if (currentNode.right==null) {
				currentNode.right=newNode;
				newNode.parent=currentNode;
			} else {
				insert(newNode,currentNode.right);
			}
		}
		
	}
	
	public void remove(Integer key) {
		root=remove(key,root);
	}

	private BSTNode remove(Integer key, BSTNode currentNode) {
		if (currentNode == null) {
			System.out.println("Cannot remove: The key doesn't exist");
			return null;
		}
		
		if (key.compareTo(currentNode.key)<0) {
			currentNode.left=remove(key,currentNode.left);
			return currentNode;
		}
		
		if (key.compareTo(currentNode.key)>0) {
			currentNode.right=remove(key,currentNode.right);
			return currentNode;

		}
		
		if (currentNode.left==null && currentNode.right==null) {
			return null;
		}

		if (currentNode.left==null)  {
			currentNode.right.parent = currentNode.parent;
			return currentNode.right;
		}
		
		if (currentNode.right==null) {
			currentNode.left.parent = currentNode.parent;
			return currentNode.left;
		}
		

		BSTNode successorNode = currentNode.right;
		while (successorNode.left!=null) {
			successorNode=successorNode.left;
		}
	
		currentNode.elem=successorNode.elem;
		currentNode.key=successorNode.key;
		
		currentNode.right=remove(successorNode.key,currentNode.right);
		return currentNode;

		 
		
	}


		 
	public void showPreorder() {
		if (root!=null) root.showPreOrder();
		else System.out.println("tree is empty");
	}

	public void showInorder() {
		 if (root!=null) root.showInOrder();
		else System.out.println("tree is empty");
	}
	
	public void showPostorder() {
		if (root!=null) root.showPostOrder();
		else System.out.println("tree is empty");
	}
	
	
	public int getSize() {
		return BSTNode.getSize(root);
	}

	public int getHeight() {
		return BSTNode.getHeight(root);
	}

	
	public void showByLevel() {
		if (root!=null) {
			root.showLevels();
		}
	}
	
	

	
	
}