
public class DList implements IList {

	private DNode header;
	private DNode trailer;
	private int size = 0;

	public DNode getHeader() {
		return header;
	}

	public void setHeader(DNode header) {
		this.header = header;
	}

	public DNode getTrailer() {
		return trailer;
	}

	public void setTrailer(DNode trailer) {
		this.trailer = trailer;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public DList() {
		header = new DNode(null);
		trailer = new DNode(null);
		header.setNext(trailer);
		trailer.setPrev(header);
	}
	

	@Override
	public void addFirst(Libro libro) {
		DNode newNode = new DNode(libro);
		newNode.setNext(header.getNext());
		newNode.setPrev(header);
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
		size++;
	}

	@Override
	public void addLast(Libro libro) {
		DNode newNode = new DNode(libro);
		newNode.setNext(trailer);
		newNode.setPrev(trailer.getPrev());
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
		size++;
	}

	@Override
	public void insertAt(int index, Libro libro) {
		DNode newNode = new DNode(libro);
		int i = 0;
		boolean inserted=false;
		for (DNode nodeIt = header; nodeIt != trailer && inserted==false; nodeIt = nodeIt.getNext()) {
			if (i == index) {
				newNode.setNext(nodeIt.getNext());
				newNode.setPrev(nodeIt);
				nodeIt.getNext().setPrev(newNode);
				nodeIt.setNext(newNode);
				inserted=true;
				size++;
			}
			++i;
		}
		if (!inserted) System.out.println("DList: Insertion out of bounds");
	}

	@Override
	public boolean isEmpty() {
		return (header.getNext() == trailer);
	}

	@Override
	public boolean contains(Libro libro) {
		boolean found=false;
		for (DNode nodeIt = header.getNext(); nodeIt != trailer && found==false; nodeIt = nodeIt.getNext()) {
			if (libro.getTitle().equals(nodeIt.getlibro().getTitle())) {
				found=true;
			}
		}
		return found;
	}

	@Override
	public int count(Libro n) {
		int i = 0;
		return i;
	}
	
	@Override
	public int getIndexOf(Libro libro) {
		int index = -1;
		int pos = 0;
		for (DNode nodeIt = header.getNext(); nodeIt != trailer && index == -1; nodeIt = nodeIt.getNext()) {
			if (nodeIt.getlibro().equals(libro)) {
				index = pos;
			}
			++pos;

		}
		return index;
	}

	@Override
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		header.setNext(header.getNext().getNext());
		header.getNext().setPrev(header);
		size--;
	}

	@Override
	public void removeLast() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		trailer.setPrev(trailer.getPrev().getPrev());
		trailer.getPrev().setNext(trailer);
		size--;
	}

	
	@Override
	public void removeAll(Libro libro) {
		for (DNode nodeIt = header.getNext(); nodeIt != trailer; nodeIt = nodeIt.getNext()) {
			if (nodeIt.getlibro().equals(libro)) {
				nodeIt.getPrev().setNext(nodeIt.getNext());
				nodeIt.getNext().setPrev(nodeIt.getPrev());
				size--;

			}
		}
	}

	@Override
	public void removeAt(int index) {
		int i = 0;
		boolean removed=false;
		for (DNode nodeIt = header.getNext(); nodeIt != trailer && removed==false; nodeIt = nodeIt.getNext()) {
			if (i == index) {
				nodeIt.getPrev().setNext(nodeIt.getNext());
				nodeIt.getNext().setPrev(nodeIt.getPrev());
				removed=true;
				size--;

			}
			++i;
		}
		if (!removed) System.out.println("DList: Deletion out of bounds");
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public Libro getFirst() {
		Libro result = null;
		if (isEmpty()) {
			System.out.println("DList: List is empty");
		} else
			result = header.getNext().getlibro();
		return result;
	}

	@Override
	public Libro getLast() {
		Libro result = null;

		if (isEmpty()) {
			System.out.println("DList: List is empty");
		} else
			result = trailer.getPrev().getlibro();

		return result;
	}
	
	@Override
	public Libro getAt(int index) {
		int i = 0;
		Libro result = null;
		for (DNode nodeIt = header.getNext(); nodeIt != trailer && result == null; nodeIt = nodeIt.getNext()) {
			if (i == index) {
				result = nodeIt.getlibro();
			}
			++i;
		}
		if (result == null)
			System.out.println("DList: Get out of bounds");
		return result;
	}

	@Override
	public String toString() {
		String result = null;
		for (DNode nodeIt = header.getNext(); nodeIt != trailer; nodeIt = nodeIt.getNext()) {
			if (result == null) {
				result = String.valueOf(nodeIt.getlibro());
			} else {
				result += "," + String.valueOf(nodeIt.getlibro());
			}
		}
		return result == null ? "empty" : result;
	}

	
	public void ordenado() {
		String[] B = new String[getSize()];
		String aux;
		for (int i = 1; i <= B.length; i++) {
			for (int j = 0; j < B.length - i; j++) {
				if (B[j].compareTo(B[j + 1]) > 0) {
					aux = B[j];
					B[j] = B[j + 1];
					B[j + 1] = aux;
				}
			}
		}
		System.out.println("\n libro ordenado: ");
		for (int i = 0; i < B.length; i++) {
			System.out.println(" t[" + i + "] = " + B[i]);
		}
	}

}
