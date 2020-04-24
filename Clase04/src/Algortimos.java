
public class Algortimos {

	public static int contarParesQueSuman(int[] array, int a) {
		int c = 0;
		// ( ; ; )
		for (int i = 1; i <= array.length; i++) {
			// ( ; ; ; ) * ? => (1; N; N-1)
			for (int j = 0; j < array.length - i; j++) {
			// 5 * ? => (N-1)+(N-2).... +0
				if(array[i] + array[j] == a) {
					c++;
				}
			}
		}
		return c;
	}
}
