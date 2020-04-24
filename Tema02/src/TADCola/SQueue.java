package TADCola;

public class SQueue implements IQueue{
	
	private SNode first;
	private SNode last;
	int size;
	
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public void enqueue(String elem) {
		SNode node = new SNode(elem);
		if (isEmpty()) {
			first = node;
		}
		else {
			last.next = node;
		}
		last = node;
		size++;
		
	}

	@Override
	public String dequeue() {
		if(isEmpty()) {
			System.out.println("Queue esta vacia");
			return null;
		}
		String firstElem = first.elem;
		first = first.next;
		if(first == null) {
			last = null;
		}
		size--;
		return firstElem;
	}

	@Override
	public String front() {
		if(isEmpty()) {
			System.out.println("Queue esta vacia");
			return null;
		}
		return first.elem;
	}

	@Override
	public int getSize() {
		return size;
	}
}
