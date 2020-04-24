package Problema0;

import java.util.Random;

public class DList implements IList {

	DNode header;
	DNode trailer;
	int size = 0;

	public DList() {
		header = new DNode(null);
		trailer = new DNode(null);
		header.next = trailer;
		trailer.prev = header;
	}

	@Override
	public void addFirst(Integer elem) {
		DNode newNode = new DNode(elem);
		newNode.next = header.next;
		newNode.prev = header;
		header.next.prev = newNode;
		header.next = newNode;
		size++;
	}

	@Override
	public void addLast(Integer elem) {
		DNode newNode = new DNode(elem);
		newNode.next = trailer;
		newNode.prev = trailer.prev;
		trailer.prev.next = newNode;
		trailer.prev = newNode;
		size++;
	}

	@Override
	public void insertAt(int index, Integer elem) {
		int i = 0;
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (i == index) {
				DNode newNode = new DNode(elem);
				newNode.prev = nodeIt.prev;
				newNode.next = nodeIt;
				nodeIt.prev.next = newNode;
				nodeIt.prev = newNode;
				size++;
			}
			i++;
		}
	}

	@Override
	public boolean isEmpty() {
		return (header.next == trailer);
	}

	@Override
	public boolean contains(Integer elem) {
		boolean found = false;
		for (DNode nodeIt = header.next; nodeIt != trailer && found == false; nodeIt = nodeIt.next)
			if (nodeIt.elem.equals(elem)) {
				found = true;
			}
		return found;
	}

	@Override
	public int getIndexOf(Integer elem) {
		int i = 0;
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (i == elem) {
				size++;
			}
			i++;
		}
		return i;
	}

	@Override
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		header.next = header.next.next;
		header.next.prev = header;
		size--;
	}

	@Override
	public void removeLast() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		trailer.prev = trailer.prev.prev;
		trailer.prev.next = trailer;
		size--;
	}

	@Override
	public void removeAll(Integer elem) {
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next)
			if (nodeIt.elem.equals(elem)) {
				nodeIt.prev.next = nodeIt.next;
				nodeIt.next.prev = nodeIt.prev;
				size--;
			}
	}
	
	@Override
	public void removeAt(int index) {
		int i = 0;
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (i == index) {
				nodeIt.prev.next = nodeIt.next;
				nodeIt.next.prev = nodeIt.prev;
				size--;
				break;
			}
			i++;
		}
	}

	@Override
	public int getSize() {

		return size;
	}

	@Override
	public Integer getFirst() {
		Integer result = null;
		if (isEmpty()) {
			System.out.println("DList: List is empty");
		} else
			result = header.next.elem;
		return result;
	}

	@Override
	public Integer getLast() {
		Integer result = null;

		if (isEmpty()) {
			System.out.println("DList: List is empty");
		} else
			result = trailer.prev.elem;

		return result;
	}

	@Override
	public Integer getAt(int index) {
		int i = 0;
		Integer result = null;
		for (DNode nodeIt = header.next; nodeIt != trailer && result == null; nodeIt = nodeIt.next) {
			if (i == index) {
				result = nodeIt.elem;
			}
			++i;
		}
		if (result == null)
			System.out.println("DList: Get out of bounds");
		return result;
	}

	@Override
	public String toString() {
		String result = null;
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (result == null) {
				result = String.valueOf(nodeIt.elem);
			} else {
				result += "," + String.valueOf(nodeIt.elem);
			}
		}
		return result == null ? "empty" : result;
	}



	public static void main(String[] args) {
		// incomplete test
		Random rn=new Random();
		DList list = new DList();
		System.out.println(list.toString());
		System.out.println("isEmpty?" + list.isEmpty());
		for (int i=0; i<100; i++) {
			list.insertAt(i, Integer.valueOf(rn.nextInt(100)));
		}
		list.removeLast();
		list.insertAt(2, 30);
		
		System.out.println("First: " + list.getFirst());
		System.out.println("Last: " + list.getLast());
		list.removeAt(5);
		System.out.println("removed element at position 5"+list.toString());
		
		list=new DList();
	}
}