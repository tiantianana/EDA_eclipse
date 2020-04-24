package RecLista;

import TADListaSimplementeEnlazada.SNode;

public class SList {

	public SNode first;
	public SNode last;
	int size;

	public boolean contains(SNode sublist, int n) {
		if(sublist == null) return false;
		else if(sublist.next ==) return true;
		else {
			return contains(sublist.next, n);
		}
	}
	
	// obtener el tamaño de la lista
	public int getsize() {
		return size;
	}
	private int getsize(SNode sublist) {
		if(sublist == null) return 0;
		else {
			return 1 + getsize(sublist.next);
		}
	}
	
	public void insertAt(int pos, int n) {
		first = insertAt(first, pos, n);
	}
	
	private SNode insertAt(SNode sublist, int pos, int n) {
		if(pos==0) {
			SNode newNode = new SNode(n);
			newNode.next = sublist;
		}
		else {
			sublist.next = insertAt(sublist.next, pos-1, n);
			return sublist;
		}
	}
	

