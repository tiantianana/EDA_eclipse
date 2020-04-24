package Problema02;

public class Queue {
		
	public SNode head;
	public SNode tail;
	
	public void enqueue(Character a) {
		SNode node = new SNode(a);
		if (head == null)
		{
			head = node;
			tail = node;
		}
		else 
		{
			tail.next = node;
			tail = node;
		}
	}

	public Character dequeueu() {
		Character result = head.elem;
		head = head.next;
		if (head == null)
		{
			tail = null;
		}
		return result;
	}
	
	public boolean isEmpty() {
		return head == null;
	}

}
