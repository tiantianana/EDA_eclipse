package examples.junit;

public class Russian {
	public static int mult(int x, int y) {
		if(x == 0) return 0;
		if(x%2 == 0) {
			return mult(x/2, y*2);
		} else {
			return y + mult(x/2, y*2);
		}
		
	}
}
