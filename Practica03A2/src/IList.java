public interface IList {

	public void addFirst(Libro newLibro);

	public void addLast(Libro newLibro);

	public boolean isEmpty();

	public boolean contains(Libro elem);

	public int getSize();

	public Libro getAt(int index);
	
	public Libro getAll(String Author);

	public void removeFirst();
	
	public void removeAll(String elem);

	public void removeAt(int index);
	
	public String toString();
	

}
