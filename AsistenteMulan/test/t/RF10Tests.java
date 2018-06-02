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
		
		Assert.assertTrue(
				respuestas(mulan.charlar("Hola, @mulan!")));
	}
	
	@Test
	public void pensandoNumero() {
		Assert.assertEquals(
				"@jmm96 ¡listo!",
				mulan.charlar("@mulan jugamos? Pensa un numero del 1 al 100")
			);
		
		MasChicoMasGrande.setValorAdivino(12);
	
		Assert.assertEquals(
				"@jmm96 más chico",
				mulan.charlar("@mulan es el 50?")
			);
		
		Assert.assertEquals(
				"@jmm96 como gustes, dejaremos de jugar",
				mulan.charlar("Basta @mulan")
			);
		
		Assert.assertEquals(
				"@jmm96 ¡listo!",
				mulan.charlar("@mulan jugamos? Pensa un numero del 1 al 100")
			);
		
		MasChicoMasGrande.setValorAdivino(12);
	
		Assert.assertEquals(
				"@jmm96 más chico",
				mulan.charlar("@mulan es el 50?")
			);
		
		Assert.assertEquals(
				"@jmm96 ¡si! Adivinaste en 2 pasos...",
				mulan.charlar("@mulan es el 12?")
			);
		
		Assert.assertTrue(
				respuestas(mulan.charlar("Hola, @mulan!")));
		
	}
	
	private boolean respuestas(String msj) {
		String[] resp = { "Hola, @jmm96", "Buen día, @jmm96", "Buenas tardes, @jmm96",
				  "Buenas noches, @jmm96", "Buenas, @jmm96", "Holanda, @jmm96", "Hey, @jmm96" };
		for(int i = 0; i < resp.length; i++) {
			if(msj.equals(resp[i])) {
				return true;
			}
		}
		return false;
	}
	/*@Test
	public void asd() throws InterruptedException {
		MasChicoMasGrande.maChiMaGra("Quiero jugar");
	}*/

}