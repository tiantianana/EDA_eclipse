package Problema01;

public class Invertir {

	public static String invertir(String str) {
	Stack s = new Stack();
	
	/*
	for (int i = 0; i<str.length(); i++)
	{
		s.push(str.charAt(i));
	}
	*/
	
	for (char c : str.toCharArray()) {
		s.push(c);
	}
	
	String result = "";
	for (int i = 0; i<str.length(); i++)
	{
		result += s.pop();
	}
	return result;
	
	//while sin tener en cuenta str.
		
	}
	
	
	public static void main (String[] args) {
		System.out.print(invertir("ROMA"));
		System.out.print(invertir("UC3M"));
		System.out.print(invertir("EDA"));
	}
}
