package TADCola;

public interface IQueue {

	public boolean isEmpty();
	public void enqueue(String elem);
	public String dequeue();
	public String front();
	public int getSize();
	
	// Definimos la cola como String aunque este puede ser otro tipo de dato.	
}
