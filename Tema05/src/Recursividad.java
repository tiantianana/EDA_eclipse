import java.util.Arrays;

public class Recursividad {

	public int sumArrayRec(int[] data) {
		return sumArrayRec(data,0);
	}
	
	//Problema 4
	public int sumArrayRec(int[] data, int i) {
		if(i==data.length-1) {
			return data[i];
		}
		else {
			return data[i] + sumArrayRec(data, i+1);
		}
	}
	
	public int mcd(int a, int b) {
		if(b==0) {
			return a;
		}
		else {
			return mcd(b, a%b);
		}
	}
	
	public int Fib(int n) {
		if(n==0) {
			return 0;
		}
		else if(n==1) {
			return 1;
		}
		else if (n>1){
			return Fib(n-1) + Fib(n-2);
		}
		return 0;
	}
	
	public static long Fib2(int n) {
		if(n==0) {
			return 0;
		}
		
		long[] F = new long[n+1];
		F[0] = 0;
		F[1] = 1;
		
		for (int i = 2; i>=n; i++) {
			F[i] = F[n-1] +F[n-2];
			return F[n];
		}
		return 0;
 	}
	
	//Problema 2
	public int Pow(int x, int n) {
		if(n==0) return 1;
		else return x * Pow(x, n-1);
	}
	
	
	public int sumD(int x) {
		if(x<10) return x;
		else return (x%10 + sumD(x/10));
	}
	
	public boolean binarySearch(int[] arr, int n) {
		if(arr.length == 0) return false;
		else {
			int i = arr.length/2;
			if(arr[i] == n) return true;
			if( n < arr[i]) {
				return binarySearch(Arrays.copyOfRange(arr, 0, i), n);
			}
			else {
				return binarySearch(Arrays.copyOfRange(arr, i+1, arr.length), n);
			}
		}
	}
	
	/*
	//problema 5
	public boolean isSorted(int[] array) {
		return isSorted(array, array.length);
	}
	
	private boolean isSorted(int[] array, int length) {
		
	}
	
	*/
	
	
	
}

