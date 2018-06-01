package Ejercico3;

import static org.junit.Assert.*;

import org.junit.Test;



public class VectorNumerosTest {

	@Test
	public void testEstaEnElVecor() {
		assertEquals(VectorNumeros.buscarValor(new int [] {0,1,4,3,8,5,2,7}, "4"), 3);
	}
	
	@Test
	public void testEstaEnElVecor2() {
		assertEquals(VectorNumeros.buscarValor(new int [] {0,1,4,3,8,5,2,7}, "8"), 5);
	}
	
	@Test
	public void testNoEstaEnElVector() {
		assertEquals(VectorNumeros.buscarValor(new int [] {0,1,4,3,8,5,2,7}, "20"), -1);
	}
	
	@Test (expected = NumberFormatException.class)
	public void testDecimal() {
		VectorNumeros.buscarValor(new int [] {0,1,4,3,8,5,2,7}, "2.3");
	}
	
	@Test (expected = NumberFormatException.class)
	public void testNoEntero() {
		VectorNumeros.buscarValor(new int [] {0,1,4,3,8,5,2,7}, "zzz");
	}
	
	@Test (expected = NumberFormatException.class)
	public void testNoEntero2() {
		VectorNumeros.buscarValor(new int [] {0,1,4,3,8,5,2,7}, "+");
	}
	
	
}
  