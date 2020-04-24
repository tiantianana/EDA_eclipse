package phase1;

public interface IList {

	public void addFirst(Student newElem);

	public void addLast(Student newElem);

	public void removeFirst();

	public void removeLast();

	public void removeAt(int index);

	public void insertAt(int index, Student newElem);

	public boolean isEmpty();

	public boolean contains(Student elem);

	public int getSize();

	public int getIndexOf(Student elem);

	public Student getAt(int index);

}
