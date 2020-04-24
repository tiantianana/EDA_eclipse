package TADListaDoblementeEnlazada;

public class DList implements IList {

	DNode header;
	DNode trailer;
	int size = 0;

	public DList() {
		header = new DNode(null);
		trailer = new DNode(null);
		header.next = trailer;
		trailer.next = header;
	}

	@Override
	public void addFirst(String newElem) {
		DNode newNode = new DNode(newElem);
		newNode.next = header.next;
		header.next.prev = newNode;
		header.next = newNode;
		size++;
	}

	@Override
	public void addLast(String elem) {
		DNode newNode = new DNode(elem);
		newNode.next = trailer;
		newNode.prev = trailer.prev;
		trailer.prev.next = newNode;
		trailer.prev = newNode;
		size++;
	}

	@Override
	public void insertAt(int index, String newElem) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(String elem) {
		boolean found = false;
		for (DNode nodeIt = header.next; nodeIt != trailer && found == false; nodeIt = nodeIt.next)
			if (nodeIt.elem.equals(elem)) {
				found = true;
			}
		return found;
	}

	@Override
	public int count(String n) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndexOf(String elem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		header.next = header.next.next;
		header.next.prev = header;
		size--;
	}

	@Override
	public void removeLast() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		trailer.prev = trailer.prev.prev;
		header.prev.next = trailer;
		size--;
	}

	@Override
	public void removeLastAt(int index) {
		int i = 0;
		boolean removed=false;
		for (DNode nodeIt = header.next; nodeIt != trailer && removed==false; nodeIt = nodeIt.next) {
			if (i == index) {
				nodeIt.prev.next = nodeIt.next;
				nodeIt.next.prev = nodeIt.prev;
				removed=true;
				size--;

			}
			++i;
		}
		if (!removed) System.out.println("DList: Deletion out of bounds");
	}

	@Override
	public void removeAll(String index) {
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (nodeIt.elem.equals(index)) {
				nodeIt.prev.next = nodeIt.next;
				nodeIt.next.prev = nodeIt.prev;
				size--;

			}
		}
	}

}
