package examples.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaCorrienteTest {

	
	private CuentaCorriente cuenta;
	private float saldo_original=10000;
	private float limite=1500;
	
	@BeforeEach
	void setUp() throws Exception {
		//se este objeto antes de ejecutar cada uno de los métodos test
		cuenta=new CuentaCorriente("FLORA TRISTÁN", saldo_original, limite);
	}

	@Test
	void testIngresar() {
		
		//Caso 1: saldo negativo, el saldo debe ser el mismo
		float saldo=-3000;
		float res=cuenta.ingresar(saldo);
		float saldoesperado=saldo_original;
		
		assertEquals(res,saldoesperado,"Ingreso en cuenta con saldo negativo");
		
		
		//Caso 2: saldo positivo
		saldo=3000;
		res=cuenta.ingresar(saldo);
		saldoesperado=saldo_original + saldo;
		
		assertEquals(res,saldoesperado,"Ingreso en cuenta, saldo positivo");
		
	}

	@Test
	void testSacar() {

		//Caso 2: intentas sacar un saldo negativo
		float saldo=-3000;
		float res=cuenta.sacar(saldo);
		float saldoesperado=saldo_original;

		assertEquals(res,saldo_original,"sacar un saldo negativo");

				
		//Caso 2: intentas sacar un saldo superior al límite
		saldo=3000;
		res=cuenta.sacar(saldo);
		saldoesperado=saldo_original;

		assertEquals(res,saldo_original,"sacar un saldo superior al límite");
	
		//Segundo caso: intentas sacar un saldo superior al saldo de la cuenta
		saldo=11000;
		res=cuenta.sacar(saldo);
		saldoesperado=saldo_original;

		assertEquals(res,saldoesperado,"sacar un saldo superior al saldo original");
	
		//Tercer caso: sacar saldo menor que el saldo original y el límite
		saldo=1000;
		res=cuenta.sacar(saldo);
		saldoesperado=saldo_original - saldo;

		assertEquals(res,saldoesperado,"sacar un saldo superior al saldo original");
			
	}

}
