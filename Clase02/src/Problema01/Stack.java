package Problema01;

public class Stack {

	SNode top = null;
	int size = 0;;
	
	public void push(Character elem) {
		SNode node = new SNode(elem); 
		node.next = top; 
		top = node;
		size++;
	}

	
	public Character top() { 
		if (isEmpty()) {
			System.out.println("Este stack está vacio");
		return null;
		}
		return top.elem;
	}

	
	public Character pop() {
		size--;	
		if (isEmpty()) {
		System.out.println("el Stack esta vacio.");
		return null;	
		}
		Character elem = top.elem;
		top = top.next; 	
		return elem;
		
	}
	
	public boolean isEmpty() {
		return top == null;
	}

	public int getSize() {
		return size;
	}
}
