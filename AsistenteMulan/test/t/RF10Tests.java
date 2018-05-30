package t;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import as.*;

public class RF10Tests {

	public final static String USUARIO = "jmm96";
	public final static int ELEGIDO = 12;

	Asistente mulan;

	@Before
	public void setup() {
		mulan = new Asistente("mulan", USUARIO);
	}
	
	@Test
	public void adivinando() {
		Assert.assertEquals(
				"@jmm96 ¡sale y vale! Pensá un número del 1 al 100",
				mulan.charlar("@mulan jugamos?")
			);
		
		Assert.assertEquals(
				"@jmm96 ¿es el 50?",
				mulan.charlar("@mulan listo")
			);
		
		Assert.assertEquals(
				"@jmm96 ¿es el 75?",
				mulan.charlar("@mulan más grande")
			);
		
		Assert.assertEquals(
				"@jmm96 ¿es el 62?",
				mulan.charlar("@mulan más chico")
			);
		
		Assert.assertEquals(
				"@jmm96 ¿es el 68?",
				mulan.charlar("@mulan más grande")
			);
		
		Assert.assertEquals(
				"@jmm96 fue divertido :)",
				mulan.charlar("@mulan si!")
			);
	}
	
	@Test
	public void pensandoNumero() {
		Assert.assertEquals(
				"@jmm96 ¡listo!",
				mulan.charlar("@mulan jugamos? Pensá un número del 1 al 100")
			);
		
		Assert.assertEquals(
				"@jmm96 más chico",
				mulan.charlar("@mulan es el 50?")
			);
		
		Assert.assertEquals(
				"@jmm96 ¡si! Adivinaste en 2 pasos...",
				mulan.charlar("@mulan es el 12?")
			);
		
	}

}