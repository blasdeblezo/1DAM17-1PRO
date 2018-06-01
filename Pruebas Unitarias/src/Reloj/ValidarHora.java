package Reloj;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidarHora {

	@Test
	public void testhoraCorrecta() {
		assertEquals(true,EjercicioReloj.validarHora("12", "30"));
	}
	
	@Test
	public void testhoraCorrectaLimiteInferior() {
		assertEquals(true,EjercicioReloj.validarHora("00", "00"));
	}
	
	@Test
	public void testhoraCorrectaLimiteSuperior() {
		assertEquals(true,EjercicioReloj.validarHora("23", "59"));
	}

	@Test
	public void testhorainCorrectaHoraNegativa() {
		assertEquals(false,EjercicioReloj.validarHora("-6", "34"));
	}
	
	@Test
	public void testhorainCorrectaHoraSuperiorHora() {
		assertEquals(false,EjercicioReloj.validarHora("28", "34"));
	}
	
	@Test
	public void testhorainCorrectaFormatoHoraNoNumerica() {
		assertEquals(false,EjercicioReloj.validarHora("asdad", "34"));
	}
	
	@Test
	public void testhorainCorrectaMinutoNegativo() {
		assertEquals(false,EjercicioReloj.validarHora("8", "-6"));
	}
	@Test
	public void testhorainCorrectaMinutosSuperiores() {
		assertEquals(false,EjercicioReloj.validarHora("4", "78"));
	}
	@Test
	public void testhorainCorrectaMinutosDecimales() {
		assertEquals(false,EjercicioReloj.validarHora("18", "1.2223"));
	}
	
}
