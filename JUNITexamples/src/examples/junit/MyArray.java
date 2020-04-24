package examples.junit;

public class MyArray {
	public int[] data;
	
	/**
	 * El constructor recibe un array y crea un nuevo array con los elementos del array 
	 * parametro
	 * @param a
	 */
	public MyArray(int[] a) {
		//Nota que data y a son arrays que contienen los mismos elementos,
		//pero son objetos distintos (tienen variables de memoria distintas)
		
		this.data=a.clone();
		
		//Nota: Si this.data=a; entonces, serían la misma variable
	}
	
	/**
	 * Implementa un método que sume todos los elementos del array
	 * y devuelva este resultado
	 * @return
	 */
	public int sumEtos() {
		int sum=0;
		
		for(int i = 0; i<data.length; i++) {
			sum += data[i];
		}
		
		return sum;
	}
	
	/**
	 * Implementa un método que devuelva el mayor de los elementos del array.
	 * Si el array está vacío, debe devolver null
	 * @return
	 */
	
	public Integer getMax() {
		//Completa
		int mayor;
		
		for(int i = 0; i<data.length; i++) {
			if(i > ) {
				
			}else {
				
			}
		}
		
		return mayor;
	}
	
	/**
	 * Implementa el algoritmo burbuja de ordenación para ordenar los 
	 * elementos del array en orden ascendente. El método no devuelve nada,
	 * el método transforma el array en otro ordenado.
	 */
	public void sortBubble() {
		//Completa
	}
	
}
