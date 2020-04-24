package Problema02;

public class SStack implements IStack {

	SNode peak = null;
	int size;

	@Override
	public boolean isEmpty() {
		return peak == null;
	}

	@Override
	public void push(Integer elem) {
		SNode newNode = new SNode(elem);
		newNode.next = peak;
		peak = newNode;
		size++;
	}

	@Override
	public Integer pop() {
		if (isEmpty()) {
			System.out.println("el Stack esta vacio.");
			return null;
		}
		Integer elem = peak.elem;
		peak = peak.next;
		size--;
		return elem;
	}

	public int ICount(Integer elem) {
		SStack aux = new SStack();
		int contador = 0;

		while (!this.isEmpty()) {
			if (peak.elem != null) {
				if (this.peak.elem == elem) {
					contador++;
				}
				aux.push(this.pop());
			}
		}
		while (!aux.isEmpty()) {
			this.push(aux.pop());
		}
		return contador;
	}

	public boolean isSorted() {
		boolean ordenado = true;
		SStack stack = new SStack();

		while (!this.isEmpty()) {
			if (this.peak.elem > this.peak.next.elem) {
				ordenado = false;
				break;
			}
			stack.push(this.pop());
		}

		while (!stack.isEmpty()) {
			this.push(stack.pop());
		}

		return ordenado;
	}

}