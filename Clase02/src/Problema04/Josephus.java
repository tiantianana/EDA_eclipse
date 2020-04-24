package Problema04;

public class Josephus {

	public static void main(String args[]) {
		solveJosephus(40,7);
		solveJosephus(50,4);
		solveJosephus(100,10);

	}
	
	public static void solveJosephus(int n, int k) {
		SQueue q = new SQueue();
		//saving the Jewish soldiers
		for (int i=1; i<=n; i++) {
			q.enqueue(i);
		}
		//kill
		while (q.getSize()>1) {
			int i=1; //count the number of soldiers
			//we have to skip k-1 soldiers
			while (i<k) {
				//we remove it from the queue, 
				//but we save it at the end again 
				//in order to keep it 
				q.enqueue(q.dequeue());
				//i+=1;
				i=i+1;
			}
			//we kill the k-th soldier
			q.dequeue();
		}
		
		int saved = q.front();
		System.out.print("For " + n + " soldiers and a step of " + k + ", ");

		System.out.println("Josephus chose the place: "+ saved);
	}
	
}
