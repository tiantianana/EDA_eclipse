package phase1;


public class StudentsList implements IList {

	public DNode header;
	public DNode trailer;
	int size = 0;

	public StudentsList() {
		header = new DNode(null);
		trailer = new DNode(null);
		header.next = trailer;
		trailer.prev = header;
	}

	public boolean isEmpty() {
		return (header.next == trailer);
	}

	public int getSize() {
		return size;
	}

	public boolean contains(Student elem) {
		boolean found = false;
		for (DNode nodeIt = header.next; nodeIt != trailer && found == false; nodeIt = nodeIt.next) {
			Student current = nodeIt.elem;
			if (elem.email.compareTo(current.email) == 0) {
				found = true;
			}
		}
		return found;
	}

	public void addFirst(Student elem) {
		if (this.contains(elem)) {
			System.out.println(elem.email + " already exists into the social network. You cannot added it!!!");
			return;
		}
		DNode newNode = new DNode(elem);
		newNode.next = header.next;
		newNode.prev = header;
		header.next.prev = newNode;
		header.next = newNode;
		size++;
	}

	public void addLast(Student elem) {
		if (this.contains(elem)) {
			System.out.println(elem.email + " already exists into the social network. You cannot added it!!!");
			return;
		}
		DNode newNode = new DNode(elem);
		newNode.next = trailer;
		newNode.prev = trailer.prev;
		trailer.prev.next = newNode;
		trailer.prev = newNode;
		size++;
	}

	public void insertAt(int index, Student elem) {
		if (this.contains(elem)) {
			System.out.println(elem.email + " already exists into the social network. You cannot added it!!!");
			return;
		}
		DNode newNode = new DNode(elem);
		int i = 0;
		boolean inserted = false;
		for (DNode nodeIt = header; nodeIt != trailer && inserted == false; nodeIt = nodeIt.next) {
			if (i == index) {
				newNode.next = nodeIt.next;
				newNode.prev = nodeIt;
				nodeIt.next.prev = newNode;
				nodeIt.next = newNode;
				inserted = true;
				size++;
			}
			++i;
		}
		if (!inserted)
			System.out.println("DList: Insertion out of bounds");
	}

	public int getIndexOf(Student elem) {
		int index = -1;
		int pos = 0;
		for (DNode nodeIt = header.next; nodeIt != trailer && index == -1; nodeIt = nodeIt.next) {
			if (nodeIt.elem.equals(elem)) {
				index = pos;
			}
			++pos;

		}
		return index;
	}

	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		header.next = header.next.next;
		header.next.prev = header;
		size--;
	}

	public void removeLast() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		trailer.prev = trailer.prev.prev;
		trailer.prev.next = trailer;
		size--;
	}

	public void removeAt(int index) {
		int i = 0;
		boolean removed = false;
		for (DNode nodeIt = header.next; nodeIt != trailer && removed == false; nodeIt = nodeIt.next) {
			if (i == index) {
				nodeIt.prev.next = nodeIt.next;
				nodeIt.next.prev = nodeIt.prev;
				removed = true;
				size--;

			}
			++i;
		}
		if (!removed)
			System.out.println("DList: Deletion out of bounds");
	}

	public Student getAt(int index) {
		int i = 0;
		Student result = null;
		for (DNode nodeIt = header.next; nodeIt != trailer && result == null; nodeIt = nodeIt.next) {
			if (i == index) {
				result = nodeIt.elem;
			}
			++i;
		}
		if (result == null)
			System.out.println("DList: Get out of bounds");
		return result;
	}

	public String toString() {
		String result = null;
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			Student oStudent = nodeIt.elem;
			if (result == null)
				result = "";
			result = result + oStudent.toString() + "\n";
		}
		return result == null ? "empty" : result;
	}

	public boolean equals(StudentsList list) {

		if (list == this)
			return true;
		if (list == null)
			return false;

		if (list.getSize() != this.getSize())
			return false;

		for (int i = 0; i < this.getSize(); i++) {
			Student s1 = this.getAt(i);
			Student s2 = list.getAt(i);
			if (!s1.equals(s2))
				return false;
		}
		return true;
	}

}