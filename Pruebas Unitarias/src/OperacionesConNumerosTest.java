import static org.junit.Assert.*;

import org.junit.Test;

public class OperacionesConNumerosTest {

	@Test
	public void testInvertirNumeroEntero1() {
		assertEquals(OperacionConNumeros.invertirNumeroEntero(176),671);
	}
	
	
	@Test(expected= Exception.class)
	public void tesInvertirNumerosEntero2(){
		OperacionConNumeros.invertirNumeroEntero(-123);
	}
	@Test(expected= Exception.class)
	public void tesInvertirNumerosEntero3(){
		OperacionConNumeros.invertirNumeroEntero(1234567890);
	}
	
	@Test
	public void tesInvertirNumerosEnteroVLI(){
		assertEquals(OperacionConNumeros.invertirNumeroEntero(10),1);
	}
	
	@Test
	public void tesInvertirNumerosEnteroVLI2(){
		assertEquals(OperacionConNumeros.invertirNumeroEntero(999999999),999999999);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testInvertirNumeroEnteroVLINV() {
		OperacionConNumeros.invertirNumeroEntero(9);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvertirNumeroEnteroVLSNV() {
		OperacionConNumeros.invertirNumeroEntero(1000000000);
	}
	
}

