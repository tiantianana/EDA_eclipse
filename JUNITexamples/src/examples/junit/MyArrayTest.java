package examples.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyArrayTest {

		MyArray mEmpty;
		MyArray m1;
		MyArray m2;
		MyArray m3;


		int[] dataEmpty= {};
		int[] data1= {1};
		int[] data2= {1,5,-1,9,0,2};
		int[] data3= {1,5,-1,2,9,0,9,2};

	@BeforeEach
	void setUp() throws Exception {
		mEmpty=new MyArray(dataEmpty);
		m1=new MyArray(data1);
		m2=new MyArray(data2);
		m3=new MyArray(data3);
		
	}

	//@Test
	void testSortBubble() {
		//Caso array vacío
		Arrays.sort(dataEmpty);
		mEmpty.sortBubble();
		assertArrayEquals(mEmpty.data,dataEmpty,"Ordenar array vacío");

		//Primer caso, array con un elemento
		Arrays.sort(data1);
		m1.sortBubble();
		assertArrayEquals(m1.data,data1,"Ordenar array con un elemento");
		
		//Segundo caso, array con varios elementos y no repetidos
		Arrays.sort(data2);
		m2.sortBubble();
		assertArrayEquals(m2.data,data2,"ordenar array de tamaño >1 y elementos no repetidos");
		
		//Segundo caso, array con varios elementos y no repetidos
		Arrays.sort(data3);
		m3.sortBubble();
		assertArrayEquals(m3.data,data3,"ordenar array de tamaño >1 y con repeticiones");

	}
	
	
	@Test
	void testSumEtos() {
		//Primer caso, array vacío
		int res=mEmpty.sumEtos();
		int esperado=0;
		assertEquals(esperado, res,"Sumar los elementos de un array con un único elemento");
		
		//Segundo caso, array con un elemento
		res=m1.sumEtos();
		esperado=data1[0];
		assertEquals(esperado, res,"Sumar los elementos de un array con un único elemento");
		
		//Tercer caso, array con varios elementos 
		res=m2.sumEtos();
		esperado=16;
		assertEquals(esperado, res,"Sumar los elementos de un array varios elementos");	
	}
	
	@Test
	void testGetMax() {
		//Primer caso, array vacío
		Integer res=mEmpty.getMax();
		assertNull(res,"Máximo de un array vacío");
		
		//Segundo caso, array con un elemento
		res=m1.getMax();
		Integer esperado=data1[0];
		assertEquals(esperado, res,"Máximo de un array con un único elemento");
		
		//Tercer caso, array con varios elementos 
		res=m2.getMax();
		esperado=9;
		assertEquals(esperado, res,"Máximo  de un array varios elementos");
		
	}


}
