package Problema01profe;


public class PalindromicNumber {

	public static void main(String args[]) {
		int n=200535; 
		System.out.println("is palindromic " + n + ": "+ isPalindromic(n));
		n=21012; 
		System.out.println("is palindromic " + n + ": "+ isPalindromic(n));
		n=210012; 
		System.out.println("is palindromic " + n + ": "+ isPalindromic(n));
		
		n=213412; 

		System.out.println("is palindromic " + n + ": "+ isPalindromic(n));
		n=5;
		System.out.println("is palindromic " + n + ": "+ isPalindromic(n));
		n=11;
		System.out.println("is palindromic " + n + ": "+ isPalindromic(n));

		
	}
	
	
	public static boolean isPalindromic(int n) {
		//create a list to store the digits
		DList list=new DList();
		while (n>=10) {
			int digit= n%10;
			list.addLast(new Integer(digit));
			n=n/10;
		}
		list.addLast(n);
		
		//now, checks
		return list.palindromic();
		
	}
	
}
