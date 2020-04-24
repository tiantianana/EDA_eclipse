package MultiplicacionRusa;

public class Calculo {

	int a, b;

	public int multRusa(int a, int b) {
		if (a == 0)
			return 0;
		else if(a % 2 == 0) {
			return multRusa(a/2, b*2);
		}
		else {
			return b + multRusa(a/2, b*2);
		}
	}
	
	
}
