package Problema02;

public class Stack {

	SNode tope = null;
	int size = 0;;
	
	public void push(Character elem) {
		SNode node = new SNode(elem); 
		node.next = tope; 
		tope = node;
		size++;
	}

	
	public Character top() { 
		if (isEmpty()) {
			System.out.println("Este stack está vacio");
		return null;
		}
		return tope.elem;
	}

	
	public Character pop() {
		size--;	
		if (isEmpty()) {
		System.out.println("el Stack esta vacio.");
		return null;	
		}
		Character elem = tope.elem;
		tope = tope.next; 	
		return elem;
		
	}
	
	public boolean isEmpty() {
		return tope == null;
	}

	public int getSize() {
		return size;
	}
}