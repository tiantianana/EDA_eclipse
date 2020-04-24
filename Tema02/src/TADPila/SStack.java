package TADPila;

public class SStack implements IStack{

	SNode peak = null;
	int size;
	
	public boolean isEmpty() {
		return peak == null;
	}

	
	@Override
	public void push(Integer newElem) {
		SNode newNode = new SNode(newElem); //Creamos otro nodo.
		newNode.next = peak; // Podemos bajar al resto de los nodos.
		peak = newNode;
		size++;
	}

	@Override
	public Integer top() { 	//Comprobamos si esta vacio.
		if (isEmpty()) {
			System.out.println("Este stack está vacio");
		return null;
		}
		return peak.elem;
	}

	@Override
	public Integer pop() {
		if (isEmpty()) {
		System.out.println("el Stack esta vacio.");
		return null;	
		}
		Integer elem = peak.elem;
		peak = peak.next; 		// devuelve el mismo peak anterior.
		size--;					// reduce el tamaño de la estructura dinamica.
		return elem;
		
	}

	@Override
	public int getSize() {
		return size;
	}
}