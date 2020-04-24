package Algoritmos;

public class Time {
	public static long sum(long n) {
		long startTime = System.nanoTime();
		long result = 0;
		for(long i=1; i<=n; i++) {
			result = result +i;
		}
		long endTime = System.nanoTime();
		long total = endTime - startTime;
		
		System.out.println("sum("+n+") took "+total+ "ns");
		return result;
	}
	
	public static long sumGauss(long n) {
		long startTime = System.currentTimeMillis();
		long result = n*(n+1)/n;
		long endTime = System.currentTimeMillis();
		long total = endTime - startTime;
		
		System.out.println("sum("+n+") took "+total+ "ns");
		return result;
	}
}
