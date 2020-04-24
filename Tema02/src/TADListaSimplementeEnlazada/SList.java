package TADListaSimplementeEnlazada;

public class SList implements IList {

	public SNode first;
	public SNode last;
	int size;

	@Override
	public void addFirst(String newElem) {
		SNode newNode = new SNode(newElem);
		newNode.next = first;
		if (first == null) {
			// igualamos last = first, pero pasando por el puntero.
			last = newNode;
			first = newNode;
			size++;
		}

	}
	/*
	 * @Override public void addLast(String newElem) { SNode node = new
	 * SNode(newElem); if (isEmpty()) { addFirst(newElem); } else { last.next =
	 * node; last = node; size++; } }
	 */

	@Override
	public void addLast(String newElem) {
		SNode node = new SNode(newElem);
		if (last == null) {
			first = node;
			last = node;
		} else {
			last.next = node;
			last = node;
		}
		size++;
	}

	@Override
	public void insertAt(int index, String newElem) {
		SNode newNode = new SNode(newElem);

		if (index == 0) {
			addFirst(newElem);
		} else if (index == size) {
			addLast(newElem);
		} else {

			int i = 0;
			boolean inserted = false;
			for (SNode nodeIt = first; nodeIt != null && inserted == false; nodeIt = nodeIt.next) {
				if (i == index) {
					newNode.next = nodeIt.next;
					nodeIt.next = nodeIt.next;
					nodeIt.next = newNode;
					inserted = true;
				}
				++i;
			}
			if (!inserted) {
				System.out.println("SList: Insertion out of bound");
			}
		}
	}

	@Override
	public boolean isEmpty() {
		return (first == null);
	}

	// Método para buscar en la lista.
	@Override
	public boolean contains(String index) {
		for (SNode node = first; node != null; node = node.next) {
			if (index.equals(node.elem)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int count(String n) {
		int i = 0;
		for (SNode node = first; node != null; node = node.next) {
			if (n.equals(node.elem)) {
				i++;
			}
		}
		return i;

	}

	@Override
	public int getSize() {
		int i = 0;
		for (SNode node = first; node != null; node = node.next) {
			++i;
		}
		return i;
	}

	@Override
	public int getIndexOf(String elem) {
		int i = 0;
		for (SNode node = first; node != null; node = node.next) {
			if (elem.equals(node.elem)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public String getFirst() {
		return null;
	}

	@Override
	public String getLast() {
		return null;
	}

	@Override
	public String getAt(int index) {
		int i = 0;
		for (SNode node = first; node != null; node = node.next) {
			if (i == index) {
				return node.elem;
			}
			i++;
		}
		return null;
	}

	@Override
	public String toString() {
		String result = "";
		for (SNode node = first; node != null; node = node.next) {
			if (node != first) {
				result += ",";
			}
			result += node.elem;
		}
		return result;

	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			first = first.next;
			if (first == null) {
				last = null;
				size--;
			}
		}
	}

	@Override
	public void removeLast() {

		if (!isEmpty()) {
			if (size == 1) {
				removeFirst();
			} else {
				SNode nodeIt = first;
				while (nodeIt.next != last) {
					nodeIt = nodeIt.next;
				}
				if (nodeIt != null) {
					nodeIt.next = null;
					last = nodeIt;
				}

				size--;
			}
		}
	}

	// Método para borrar cualquier elemento de la lista
	@Override
	public void removeLastAt(int index) {
		SNode firstNode = null;
		int i = 0;
		for (SNode node = first; node != null; node = node.next) {
			if (i == index) {
				if (firstNode == null) {
					first = node.next;
				} else {
					firstNode.next = node.next;
				}
				size--;
				if (node == last) {
					last = firstNode;
				}
				return;
			} else {
				firstNode = node;
			}
		}
		++i;
	}

	/*
	 * 
	 * // Método para borrar los elementos de la lista.
	 * 
	 * @Override public void removeAll(String index) { SNode firstNode = null; for
	 * (SNode node = first; node != null; node = node.next) { if
	 * (index.equals(node.elem)) { if (firstNode == null) { first = node.next; }
	 * else { firstNode.next = node.next; } if (node == last) { last = firstNode; }
	 * else { firstNode = node; } }
	 * 
	 * if (first != null) { if (index == 0) { SNode firstNode = first; firstNode =
	 * firstNode.next; size--; } else if (index < size) { SNode node = first; int i
	 * = 0;
	 * 
	 * while(i < (index-1)) { node = node.next; i++; } SNode nodeaux = node.next;
	 * node.next = nodeaux.next; nodeaux.next = null; size--; }
	 * 
	 * } }
	 * 
	 */

	@Override
	public void removeAll(String index) {
		System.out.println("removing all " + index);
		SNode previousNode = null;
		for (SNode nodeIt = first; nodeIt != null; nodeIt = nodeIt.next) {
			if (nodeIt.elem.equals(index)) {
				if (previousNode == null) {
					removeFirst();
				} else if (nodeIt == last) {
					removeLast();
				} else {
					previousNode.next = nodeIt.next;
					size--;
				}
			} else {
				previousNode = nodeIt;
			}
		}
	}

}
