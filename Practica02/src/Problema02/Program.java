package Problema02;

public class Program {
	
	public static void main(String[] args) {
	
	SStack pila = new SStack();
	
	int num1 = 12;
	int num2 = 30;
	int num3 = 40;
	int num4 = 60;
	
	pila.push(num1);
	pila.push(num2);
	pila.push(num3);
	pila.push(num4);
	
	
	System.out.println("El numero " + num3 + " aparece " + pila.ICount(num3)+ " veces ");
	System.out.println("Los elementos están ordenados: " + pila.isSorted());
		

	}
}
