
public interface IList {

	public void addFirst(Libro newElem);

	public void addLast(Libro newElem);

	public void insertAt(int index, Libro newElem);

	public boolean isEmpty();

	boolean contains(Libro libro);

	public int count(Libro n);

	public int getSize();

	public int getIndexOf(Libro elem);

	public Libro getFirst();

	public Libro getLast();

	public Libro getAt(int index);

	public String toString();

	public void removeFirst();

	public void removeLast();

	public void removeAt(int index);
	
	public void removeAll(Libro libro);

}
