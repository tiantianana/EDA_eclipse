package Ejercicio1;

public class Program {

	public void showByLevels(BSTree tree) {
		SQueue<BSTNode> queue = new SQueue<BSTNode>();
		if (tree.root == null) {
			queue.enqueue(tree.root);

			while (!queue.isEmpty()) {
				BSTNode aux = queue.dequeue();
				System.out.println(aux.key);
				queue.enqueue(aux.left);
				queue.enqueue(aux.right);
			}
		}
	}

	public static void abuelo10(BSTree tree) {
		abuelo10(tree.root);
	}

	private static void abuelo10(BSTNode node) {
		if (node != null) {
			abuelo10(node.left);
			if (node.parent != null) {
				if (node.parent.parent != null) {
					if (node.parent.parent.key % 10 == 0) {
						System.out.println(node.key);
					}
				}
			}
			abuelo10(node.right);
		}
	}

	public static int suma(BSTree tree) {
		return suma(tree.root);
	}

	private static int suma(BSTNode node) {
		if (node != null) {
			return node.key + suma(node.left) + suma(node.right);
		} else {
			return 0;
		}
	}

	// otra forma de hacerlo

	public static int suma2(BSTNode node) {
		int result = 0;
		if (node != null) {
			result += node.key;
		}
		if (node.left != null) {
			result += suma2(node.left);
		}
		if (node.right != null) {
			result += suma2(node.right);
		}
		return result;
	}

	/**
	 * Sucesor ITERATIVO
	 * 
	 * 
	 */

	public BSTNode sucesor(BSTNode node) {
		if (node.right != null) {
			node = node.right;

			while (node.left != null) {
				node = node.left;
			}
			return node;
		}

		while (node.parent != null) {
			if (node.parent.left == node) {
				return node.parent;
			} else {
				node = node.parent;
			}
		}
		return null;
	}
}
