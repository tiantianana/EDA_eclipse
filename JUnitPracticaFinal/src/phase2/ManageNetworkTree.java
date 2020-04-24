package phase2;

import phase1.DNode;
import phase1.StudentsList;

public class ManageNetworkTree implements IManageNetworkTree {

	/**
	 * It takes an object of the StudentsTree class and an object of the
	 * StudentsList class (phase 1), and inserts each student from the list into the
	 * tree. The method does not return anything.
	 * 
	 * @param tree
	 * @param list
	 */
	public void copySocialNetwork(StudentsTree tree, StudentsList list) {

		if (list.isEmpty()) {
			System.out.println("La lista esta vacia");
			return;
		} else {
			for (DNode node = list.header.next; node != list.trailer; node = node.next) {
				tree.insertStudent(node.elem);
			}
		}

	}

	/**
	 * This takes an object of the StudentsTree class and returns an object of the
	 * StudentsList class containing all the students in the tree ordered by their
	 * email. Hint: You can develop an auxiliary and recursive method which takes a
	 * BSTNode object and a StudentsList object. You cannot use any sort algorithm
	 * to sort the resulting list. To obtain the list, you must traverse the tree
	 * (or subtree) in a recursive way.
	 * 
	 * @return
	 */
	
	
	public StudentsList getOrderedList(StudentsTree tree) {

		StudentsList sL = new StudentsList();
		sL = getOrderedList(tree.root, sL);
//		for (int i = 0; i<sL.getSize(); i++) {
//			System.out.println(sL.getAt(i));	
//		}
		return sL;
	}

	protected StudentsList getOrderedList(BSTNode node, StudentsList lista) {
		
		if (node != null) {
			getOrderedList(node.left, lista);
			lista.addLast(node.oStudent);
			getOrderedList(node.right, lista);
		}
	
		return lista;
	}

	/**
	 * This class has a parameter n as input and removes all students having a
	 * number of blocks equal or greater than n.
	 * 
	 * @param num
	 */

	
	public void deleteByNumberOfBlocks(StudentsTree tree,int num) {
		deleteByNumberOfBlocks(tree, tree.root, num);
	}


	protected void deleteByNumberOfBlocks(StudentsTree tree, BSTNode node, int n) {
		if(node != null){
			if(node.oStudent.blocks >= n) {
				if(node == tree.root) {
					tree.removeStudent(node.oStudent.email);
					deleteByNumberOfBlocks(tree, tree.root, n);
				} else {
					BSTNode parentNode = node.parent;
					if(node == parentNode.left) {
						tree.removeStudent(node.oStudent.email);
						deleteByNumberOfBlocks(tree, parentNode.left, n);
						}
					else{
						tree.removeStudent(node.oStudent.email);
						deleteByNumberOfBlocks(tree, parentNode.right, n);
						}
					}	
				}
//			deleteByNumberOfBlocks(tree, node.left, n);
//			deleteByNumberOfBlocks(tree, node.right, n);
		}
	}

}
