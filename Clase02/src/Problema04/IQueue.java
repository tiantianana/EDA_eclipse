package Problema04;

public interface IQueue {

	public boolean isEmpty();
	public void enqueue(Integer elem);
	public Integer dequeue();
	public Integer front();
	public int getSize();

}
