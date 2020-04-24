
public class SNode {

	private Libro libro;
	private SNode next;

	public SNode(Libro libro) {
		this.libro = libro;
	}

	public Libro getlibro() {
		return libro;
	}

	public void setlibro(Libro libro) {
		this.libro = libro;
	}

	public SNode getNext() {
		return next;
	}

	public void setNext(SNode next) {
		this.next = next;
	}
	
}