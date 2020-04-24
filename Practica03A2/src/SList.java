public class SList implements IList {

	private SNode first;
	private SNode last;
	private int size;

	public SList() {
	}

	public SNode getfirst() {
		return first;
	}

	public void setfirst(SNode first) {
		this.first = first;
	}

	public SNode getlast() {
		return last;
	}

	public void setlast(SNode last) {
		this.last = last;
	}

	public int getsize() {
		return size;
	}

	public void setsize(int size) {
		this.size = size;
	}

	@Override
	public void addFirst(Libro newLibro) {
		SNode newNode = new SNode(newLibro);
		newNode.setlibro(first.getlibro());
		if (first == null) {
			last = newNode;
			first = newNode;
			size++;
		}
	}

	@Override
	public void addLast(Libro newLibro) {
		SNode node = new SNode(newLibro);
		if (last == null) {
			first = node;
			last = node;
		} else {
			last.setNext(node);
			last = node;
		}
		size++;
	}

	@Override
	public boolean isEmpty() {
		return (first == null);
	}

	@Override
	public boolean contains(Libro elem) {
		for (SNode node = first; node != null; node = node.getNext()) {
			if (elem.getTitle().equals(node.getlibro().getTitle())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getSize() {
		int i = 0;
		for (SNode node = first; node != null; node = node.getNext()) {
			++i;
		}
		return i;
	}

	@Override
	public Libro getAt(int index) {
		int i = 0;
		for (SNode node = first; node != null; node = node.getNext()) {
			if (i == index) {
				return node.getlibro();
			}
			i++;
		}
		return null;
	}

	@Override
	public Libro getAll(String Author) {
		for (SNode node = first; node != null; node = node.getNext()) {
			if (node.getlibro().getAuthor() == Author) {
				return node.getlibro();
			}
		}
		return null;
	}

	
	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			first = first.getNext();
			if (first == null) {
				last = null;
				size--;
			}
		}
	}

	public void removeLast() {
		if (!isEmpty()) {
			if (size == 1)
				removeFirst();
			else {
				for (SNode nodeIt = first; nodeIt.getNext()!= last; nodeIt.getNext()) {
				nodeIt.setNext(null);
					if(nodeIt != null ) {
						nodeIt.setNext(null);
						last = nodeIt;
						size--;
					}
				}
			}

		}
	}

	
	@Override
	public void removeAll(String elem) {
		System.out.println("removing all " + elem);
		SNode previousNode = null;
		for (SNode nodeIt = first; nodeIt != null; nodeIt = nodeIt.getNext()) {
			if (nodeIt.getlibro().getGenre().equals(elem)) {
				if (previousNode == null) {
					removeFirst();
				} else if (nodeIt == last) {
					removeLast();
				} else {
					previousNode.setNext(nodeIt.getNext());
					size--;
				}
			} else {
				previousNode = nodeIt;
			}
		}
	}

	@Override
	public void removeAt(int index) {
		
		System.out.println("removing at position: " + index);
		if (index==0) removeFirst();
		else if (index==size-1) removeLast();
		else {
			int i = 0;
			SNode previousNode = null;
			boolean removed=false;
			for (SNode nodeIt = first; nodeIt != null && removed==false; nodeIt = nodeIt.getNext()) {
				if (i == index) {
					previousNode.setNext(nodeIt.getNext());
					removed=true;
					size--;
				}
				++i;
				previousNode = nodeIt;
			}
			if (!removed) System.out.println("SList: Deletion out of bounds");
		}
	}

	public String toString() {
		String result = null;
		for (SNode nodeIt = first; nodeIt != null; nodeIt = nodeIt.getNext()) {
			if (result == null) {
				result = nodeIt.getlibro().toString();
				System.out.println();
			} else {
				result += "," + nodeIt.getlibro().toString();
			}
		}
		return result == null ? "empty" : result;
	}


	public Libro ShowLibro(Libro l) {
		for (SNode nodeIt = first; nodeIt != null; nodeIt = nodeIt.getNext()) {
		System.out.println("Titulo: " + l.getTitle());
		System.out.println("Autor: " + l.getAuthor());
		System.out.println("Género: " + l.getGenre());
		}
		return l;
	}
	
	
}
