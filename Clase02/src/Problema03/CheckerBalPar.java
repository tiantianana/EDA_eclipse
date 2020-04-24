package Problema03; //Colas


public class CheckerBalPar {

	
	/**
	 * this method checks if the expression is balanced parenthesis
	 * sExpression can contain any type of character. We only treat the parenthesis: (,),[,],{,}
	 * @param sExpression
	 * @return
	 */
	
	public boolean parChecker(String sExpression) {
		
		if (sExpression==null) {
			System.out.println("String is empty");
			return false;
		}
		
		SStack stack = new SStack();
		
		for (int i=0; i<sExpression.length(); i++) {
			Character symbol = sExpression.charAt(i);
			
			if (symbol == '(' ||symbol == '[' ||symbol == '{') {
				stack.push(symbol);
				
			} else if (symbol == ')' ||symbol == ']' ||symbol == '}') {
				
				if (stack.isEmpty()) {
					return false;
					
				} else {
					
					Character peak=stack.pop();
					
					if (symbol==')' && peak!='(') return false;
					else if (symbol==']' && peak!='[') return false;
					else if (symbol=='}' && peak!='{') return false;
					
				}
			} else {
				//do nothing
			}

		}
		
		
		if (stack.isEmpty()) return true;
		else return false; 
		
	}
	
	public static void main(String args[]) {
		//We are going to try with several expressions.
		CheckerBalPar obj = new CheckerBalPar();
		String str="()(()){([()])}";
		System.out.println("is balanced " + str + " ?: " + obj.parChecker(str));
		
		str="([(3+5)*4]+10)";
		System.out.println("is balanced " + str + " ?: " + obj.parChecker(str));
		
		str="([(3+5)*4]+10]";
		System.out.println("is balanced " + str + " ?: " + obj.parChecker(str));
		
		str="({[])}";
		System.out.println("is balanced " + str + " ?: " + obj.parChecker(str));
		
		str="[()}";
		System.out.println("is balanced " + str + " ?: " + obj.parChecker(str));
	}
	
}
