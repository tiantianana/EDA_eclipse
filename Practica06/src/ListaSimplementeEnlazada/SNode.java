package ListaSimplementeEnlazada;

public class SNode {
	int elem;
	SNode next;

	public SNode(Integer elem) {
		this.elem = elem;
	}

	public SNode(Integer elem, SNode next) {
		this.elem = elem;
		this.next = next;
	}

}
