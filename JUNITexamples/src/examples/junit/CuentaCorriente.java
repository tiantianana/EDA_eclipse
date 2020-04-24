package examples.junit;

public class CuentaCorriente {

	public String sTitular;
	public float saldo;
	public float limite_diario_gasto;
	
	public CuentaCorriente(String sTitular, float saldo, float limite_diario_gasto) {
		this.sTitular=sTitular;
		this.saldo=saldo;
		this.limite_diario_gasto=limite_diario_gasto;
	}
	
	/**
	 * ingresa una cantidad y devuelve el nuevo saldo
	 * @param s
	 * @return
	 */
	public float ingresar(float s) {
		System.out.println("antes de ingresar: "+ s +"\n"+ this.toString());
		
		if (s<0) {
			System.out.println(s + " no es posible ingresar un saldo negativo");
		} else {
			this.saldo= this.saldo + s;
			System.out.println("después de ingresar: "+ s +"\n"+ this.toString());
		}
		
		return this.saldo;


	}
	
	/**
	 * saca una cantidad y devuelve el nuevo saldo
	 * @param s
	 * @return
	 */
	public float sacar(float s) {
		System.out.println("antes de sacar: "+ s +"\n"+ this.toString());

		if (s<0) {
			System.out.println(s+ " es un saldo negativo!!!.");
		}else if (s>=this.limite_diario_gasto) {
			System.out.println(s+ " supera el límite de gasto diario " + 
						this.limite_diario_gasto);
		} else if (this.saldo<s) {
			System.out.println(s+ " supera el saldo en su de gasto diario " + 
					this.limite_diario_gasto);
		} else {
			this.saldo = this.saldo - s;
		}
		
		System.out.println("después de sacar: "+ s +"\n"+ this.toString());

		return this.saldo;
		
	}
	
	public String toString() {
		return "Titular: "+ this.sTitular+ "\n" + 
				"Saldo actual: "+ this.saldo+ "\n" + 
				"Límite diario gasto: "+ this.limite_diario_gasto+ "\n" ;
	}
}
