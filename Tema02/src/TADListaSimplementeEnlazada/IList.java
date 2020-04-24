package TADListaSimplementeEnlazada;

public interface IList {
	
	public void addFirst(String newElem);
	public void addLast(String newElem);
	public void insertAt(int index, String newElem);
	
	public boolean isEmpty();
	public boolean contains(String elem);
	public int count(String n);
	public int getSize();
	public int getIndexOf(String elem);
	public String getFirst();
	public String getLast();
	public String getAt(int index);
	public String toString();
	
	public void removeFirst();
	public void removeLast();
	public void removeLastAt(int index);
	public void removeAll(String index);

}
