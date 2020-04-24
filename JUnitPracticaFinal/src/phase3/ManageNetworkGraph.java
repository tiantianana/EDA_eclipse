package phase3;

import java.util.LinkedList;

public class ManageNetworkGraph implements IManageNetworkGraph {

	public LinkedList<String> students;
	LinkedList<LinkedList<Integer>> lst_of_lstAdjacents;

	public ManageNetworkGraph(String[] students) {
		this.students = new LinkedList<String>();
		for (int k = 0; k < students.length; k++) {
			this.students.add(students[k]);
		}

		// we must initialize each Integer list
		// each index i corresponds to a student, the function
		// getIndex is used to obtain the correspondence
		lst_of_lstAdjacents = new LinkedList<LinkedList<Integer>>();
		int num = this.students.size();
		for (int i = 0; i < num; i++) {
			lst_of_lstAdjacents.addLast(new LinkedList<Integer>());
		}
	}

	// searches the student and returns its index
	public int getIndex(String student) {
		int index = -1;
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).equals(student)) {
				index = i;
				break;
			} // if
		} // for
		return index;
	}

	// checks if index is right and returns its associated city
	public String checkVertex(int index) {
		// to complete
		return null;
	}

	/**
	 * It takes taking two students (emails) as input and creates a friendship
	 * relation between them. Keep in mind that friendship relation is a symmetric
	 * relationship.
	 */
	public void addStudent(String student) {

		if (student != null && student != "") {
			students.addLast(student);
			lst_of_lstAdjacents.addLast(new LinkedList<Integer>());
		}

	}

	/**
	 * It takes two students (emails) as input and creates a friendship relation
	 * between them. Keep in mind that friendship relation is a symmetric
	 * relationship.
	 * 
	 * @param studentA
	 * @param studentB
	 */
	public void areFriends(String studentA, String studentB) {

		if (studentA != null && studentB != null && students != null) {
				if (students.contains(studentA) && students.contains(studentB)) {
					int IA = getIndex(studentA);
					int IB = getIndex(studentB);
					lst_of_lstAdjacents.get(IA).add(IB);
					lst_of_lstAdjacents.get(IB).add(IA);
				} 
			}
	}

	/**
	 * This takes a student (email), and returns an object of LinkedList<String>,
	 * which contains the emails of his/her direct friends.
	 * 
	 * @param studentA
	 * @return
	 */
	public LinkedList<String> getDirectFriends(String studentA) {

		LinkedList<String> lDirectFriends = new LinkedList<String>();
		if (studentA != null && students != null && studentA != "" && students.contains(studentA)) {
			int[] arrayDirectFriends = getAdjacents(getIndex(studentA));
			for (int i = 0; i < arrayDirectFriends.length; i++) {
				lDirectFriends.addLast(students.get(arrayDirectFriends[i]));
			}
		}

		return lDirectFriends;
	}

	// SI NO TIENE ADYACENTES DEVUELVE NULL

	public int[] getAdjacents(int i) {
		if (i >= 0 && i < students.size()) {
			LinkedList<Integer> listFriends = lst_of_lstAdjacents.get(i);
			if (listFriends.size() > 0) {
				int[] arrayFriends = new int[listFriends.size()];
				for (int j = 0; j < listFriends.size(); j++) {
					arrayFriends[j] = listFriends.get(j);
				}
				return arrayFriends;
			}
		}
		return null;
	}

	public LinkedList<String> suggestedFriends(String studentA) {
		LinkedList<String> lSuggestedFriends = new LinkedList<String>();
		boolean[] visited = new boolean[students.size()];

		if (studentA != null && studentA != "" && students.contains(studentA)) {
			LinkedList<Integer> lSuggestedFriendsInteger = depth(getIndex(studentA), visited);
			if (lSuggestedFriendsInteger != null && lSuggestedFriendsInteger.size() > 0) {
				for (int j = 0; j < lSuggestedFriendsInteger.size(); j++) {
					lSuggestedFriends.add(students.get(lSuggestedFriendsInteger.get(j)));
				}
			}
		}
		// Si el estudiante no existe o no tiene amigos sugeridos, el método devuelve
		// null;
		return lSuggestedFriends;
	}

	public LinkedList<Integer> depth(int i, boolean[] visited) {
		LinkedList<Integer> path = new LinkedList<Integer>();
		path = depth(i, visited, path);
		// Por lo menos i tiene que estar en el completePath, independientemente de que
		// tenga o no amigos (ya comprobamos en el anterior método que el estudiante que
		// pasan existe)
		// borrar el vértice original y sus adyacentes (amigos directos)
		int k = path.indexOf(i);
		path.remove(k);

		int[] adjacents = getAdjacents(i); // devuelve null si i no tiene amigos
		if (adjacents != null && adjacents.length > 0) {
			for (int j = 0; j < adjacents.length; j++) {
				int directFriend = path.indexOf(adjacents[j]);
				path.remove(directFriend);
			}
		}

		return path;
	}

	protected LinkedList<Integer> depth(int i, boolean[] visited, LinkedList<Integer> path) {

		path.add(i);
		visited[i] = true;

		int[] adjacents = getAdjacents(i);
		for (int j = 0; j < adjacents.length; j++) {
			if (!visited[adjacents[j]]) {
				depth(adjacents[j], visited, path);
			}
		}

		return path;
	}

	public void show() {
		// to complate
	}

	public static void main(String args[]) {

	}

}
