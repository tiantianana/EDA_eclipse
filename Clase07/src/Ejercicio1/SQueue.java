package Ejercicio1;


public class SQueue <T> {
	
	private SNode <T> first;
	private SNode <T>  last;
	int size;
	
	public boolean isEmpty() {
		return first == null;
	}

	public void enqueue(T elem) {
		SNode <T> node = new SNode <T> (elem);
		if (isEmpty()) {
			first = node;
		}
		else {
			last.next = node;
		}
		last = node;
		size++;	
	}

	public T dequeue() {
		if(isEmpty()) {
			System.out.println("Queue esta vacia");
			return null;
		}
		T firstElem = first.elem;
		first = first.next;
		if(first == null) {
			last = null;
		}
		size--;
		return firstElem;
	}

	public T front() {
		if(isEmpty()) {
			System.out.println("Queue esta vacia");
			return null;
		}
		return first.elem;
	}

	public int getSize() {
		return size;
	}
}
