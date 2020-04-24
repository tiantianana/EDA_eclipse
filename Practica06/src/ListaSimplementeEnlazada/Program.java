package ListaSimplementeEnlazada;

public class Program {

	public static void main(String[] args) {
		
		SList lista = new SList();
		lista.first = new SNode(3, new SNode(2, new SNode(5)));
		System.out.println("La lista esta compuesta por los siguientes elementos: ");
		
		lista.insertAt(1, 20);
		lista.insertAt(3, 40);
		lista.insertAt(5, 60);
		lista.insertAt(6, 20);
		lista.insertAt(7, 40);
		lista.insertAt(8, 40);
		
		System.out.println(" tamaño de la lista:");
		lista.size();
		
		lista.toString();
		System.out.println("El numero de ocurrencias es: ");
		lista.numOcurrence();
		
		lista.indexOf();
		
	}
}
