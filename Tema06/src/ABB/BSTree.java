package ABB;

public class BSTree implements IBSTree {

	BSTNode root;

	public BSTree(BSTNode root) {
		this.root = root;
	}

	// Version Iterativa
	public String find1(Integer key) {
		BSTNode searchNode = root;
		while (searchNode != null) {
			int keyVisit = searchNode.key;
			if (key == keyVisit) {
				return searchNode.elem;
			} else if (key < keyVisit) {
				searchNode = searchNode.left;
			} else {
				searchNode = searchNode.right;
			}
		}
		System.out.println(key + "doesnt exist");
		return null;
	}

	// Forma recursiva
	public String findIt(Integer key) {
		BSTNode searchNode = root;
		while (searchNode != null) {
			int keyVisit = searchNode.key;
			if (key == keyVisit) {
				// found it
				return searchNode.elem;
			} else if (key < keyVisit) {
				searchNode = searchNode.left;
			} else {
				searchNode = searchNode.right;
			}
		}
		System.out.println(key + "doesnt exist");
		return null;
	}

	public String find(Integer key) {
		return find(root, key);
	}

	private static String find(BSTNode node, Integer key) {
		String result = null;
		if (node == null) {
			if (key.compareTo(node.key) == 0) {
				result = node.elem;
			} else if (key.compareTo(node.key) < 0) {
				result = find(node.left, key);
			} else if (key.compareTo(node.key) > 0) {
				result = find(node.right, key);
			}
		}
		return result;
	}

	@Override
	public void insert(int key, String elem) {
		BSTNode newNode = new BSTNode(key, elem);
		if (root == null)
			root = newNode;
		else
			insert(newNode, root);
	}

	private void insert(BSTNode newNode, BSTNode node) {
		int key = newNode.key;
		if (key == node.key) {
			System.out.println(key + "already exist");
			return;
		}

		// insertar a la izquierda
		else if (key < node.key) {
			if (node.left == null) {
				node.left = newNode;
				newNode.parent = node;
			} else
				insert(newNode, node.left);
		}

		// insertar a la derecha
		else {
			if (node.right == null) {
				node.right = newNode;
				newNode.parent = node;
			} else
				insert(newNode, node.right);
		}
	}

	@Override
	public void remove(Integer key) {
		if (root == null) {
			System.out.println("Cannot remove");
			return;
		}
		// eliminar la raiz
		else if (key == root.key)
			removeRoot();
		else
			remove(key, root);
	}

	// eleminar la raiz
	private void removeRoot() {
		if (root.left == null && root.right == null)
			root = null;
		else if (root.left == null || root == root.right) {
			if (root.left == null)
				root = root.right;
			else
				root = root.left;
		} else {
			remove(root.key, root);
		}
	}

	private boolean remove(int key, BSTNode node) {
		if (node == null) {
			System.out.println("Cannot remove");
			return false;
		}
		if (key < node.key)
			return remove(key, node.left);
		if (key > node.key)
			return remove(key, node.right);

		// PRIMER CASO: el nodo a borrar es una hoja
		if (node.left == null && node.right == null) {
			BSTNode parent = node.parent;

			if (parent.left == node)
				parent.left = null;
			else
				parent.right = null;
			return true;
		}

		// SEGUNDO CASO: el nodo a borrar tiene un unico hijo
		if (node.left == null || node.right == null) {
			BSTNode grandChild = null;

			if (node.left == null)
				grandChild = node.right;
			else
				grandChild = node.left;

			BSTNode grandParent = node.parent;
			if (grandParent.left == node)
				grandParent.left = grandParent;
			else
				grandParent.right = grandChild;
			grandChild.parent = grandParent;
			return false;
		}

		// TERCER CASO: el nodo a borrar tiene dos hijos.
		BSTNode sucesorNode = findMin(node.right);
		node.elem = sucesorNode.elem;
		node.key = sucesorNode.key;
		remove(sucesorNode.key, node.right);
		return true;
	}

	private BSTNode findMin(BSTNode node) {
		if (node == null)
			return null;
		BSTNode minNode = node;
		while (minNode.left != null) {
			minNode = minNode.left;
		}
		return minNode;
	}

}
