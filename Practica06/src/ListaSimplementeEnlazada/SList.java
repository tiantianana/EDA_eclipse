package ListaSimplementeEnlazada;

public class SList implements IList {

	public SNode first;

	@Override
	public boolean isEmpty() {
		return (first == null);
	}

	@Override
	public boolean contains(SNode sublist, int n) {
		if (sublist == null) {
			return false;
		} else if (sublist.elem == n) {
			return true;
		} else {
			return contains(sublist.next, n);
		}
	}

	@Override
	public int size() {
		return size(first);
	}

	private int size(SNode sublist) {
		if (sublist == null) {
			return 0;
		} else {
			return size(sublist.next) + 1;
		}
	}

	@Override
	public void insertAt(int pos, int n) {
		first = insertAt(first, pos, n);
	}

	private SNode insertAt(SNode sublist, int pos, int n) {
		if (pos == 0) {
			SNode newNode = new SNode(n);
			newNode.next = sublist;
			return newNode;
		} else {
			sublist.next = insertAt(sublist.next, pos - 1, n);
			return sublist;
		}
	}

	@Override
	public String toString() {
		return "[ " + toString(first) + " ]";
	}

	private String toString(SNode sublist) {
		if (sublist == null) {
			return "";
		} else {
			return sublist.elem + " " + toString(sublist.next);
		}
	}

	// contar las veces que aparece n en la lista.
	@Override
	public int numOcurrence() {
		return numOcurrence(first);
	}

	private int numOcurrence(SNode sublist) {
		int n = 0;
		if (sublist == null) {
			return 0;
		} else {
			if (sublist.elem == n)
				return 1 + numOcurrence(sublist.next);
			else
				return 0 + numOcurrence(sublist.next);
		}

	}

	@Override
	public int indexOf() {
		return indexOf(first);
	}

	public int indexOf(SNode sublist) {
		int n = 0;
		if (sublist.elem == n)
			return 0;
		else
			return 1 + indexOf(sublist.next);
	}

	public void ShowFinalLibrary() {
		for (SNode node = first; node != null; node = node.next) {
			if (isEmpty()) {
				System.out.println("num: " + node.elem);
				System.out.println("");
			} else {
				System.out.println("Esta libreria se encuentra vacia");
			}
		}
	}
}
