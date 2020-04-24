
public class DNode {

	private Libro libro;
	private DNode prev;
	private DNode next;

	
	public DNode getPrev() {
		return prev;
	}

	public void setPrev(DNode prev) {
		this.prev = prev;
	}

	public DNode getNext() {
		return next;
	}

	public void setNext(DNode next) {
		this.next = next;
	}

	public DNode(Libro libro) {
		this.libro = libro;
	}
	
	public Libro getlibro() {
		return libro;
	}

	public void setlibro(Libro libro) {
		this.libro = libro;
	}
	

}
