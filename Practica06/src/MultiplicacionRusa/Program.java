package MultiplicacionRusa;


public class Program {
	public static void main(String[] args) {
		int a, b;
		a = 146;
		b = 37;
		
		Calculo parcial = new Calculo();
		parcial.multRusa(a, b);
		System.out.println(parcial.multRusa(a, b));
	}
}
