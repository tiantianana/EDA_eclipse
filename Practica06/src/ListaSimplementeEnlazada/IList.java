package ListaSimplementeEnlazada;

public interface IList {
	
	public boolean isEmpty();

	public boolean contains(SNode sublist, int n);

	public int size();

	public void insertAt(int pos, int n);

	public String toString();

	public int numOcurrence();

	public int indexOf();

}
