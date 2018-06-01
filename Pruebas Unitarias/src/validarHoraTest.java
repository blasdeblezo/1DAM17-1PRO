import static org.junit.Assert.*;

import org.junit.Test;

import Reloj.EjercicioReloj;

public class validarHoraTest {

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
	
}
