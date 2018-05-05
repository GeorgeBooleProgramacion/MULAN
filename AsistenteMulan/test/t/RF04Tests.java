package t;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import as.*;

public class RF04Tests {

	public final static String USUARIO = "jmm96";
	
	Asistente mulan;
	
	@Before
	public void setup() {
		mulan = new Asistente("mulan", USUARIO);
	}
	
	@Test
	public void diaDentroDe() {
		Assert.assertEquals(
				"@jmm96 será el lunes 7 de mayo de 2018",
				mulan.charlar("@mulan qué día será dentro de 2 días?")
			);
		
		Assert.assertEquals(
				"@jmm96 será el domingo 5 de agosto de 2018",
				mulan.charlar("@mulan qué día será dentro de 3 meses?")
			);
		
		Assert.assertEquals(
				"@jmm96 será el lunes 4 de mayo de 2020",
				mulan.charlar("@mulan qué día será dentro de 2 años?")
			);
	}
	
	@Test
	public void diaHace() {
		Assert.assertEquals(
				"@jmm96 fue viernes 4 de mayo de 2018",
				mulan.charlar("@mulan qué día fue ayer?")
			);
		
		Assert.assertEquals(
				"@jmm96 fue miércoles 2 de mayo de 2018",
				mulan.charlar("@mulan qué día fue hace 3 días?")
			);
		
		Assert.assertEquals(
				"@jmm96 fue lunes 5 de marzo de 2018",
				mulan.charlar("@mulan qué día fue hace 2 meses?")
			);
		
		Assert.assertEquals(
				"@jmm96 fue jueves 5 de mayo de 2016",
				mulan.charlar("@mulan qué día fue hace 2 años?")
			);
	}
	
	@Test
	public void tiempoDesde() {
		Assert.assertEquals(
				"@jmm96 entre el viernes 5 de mayo de 2017 y el sábado 5 de mayo de 2018 pasaron 365 día/s",
				mulan.charlar("@mulan cuántos días pasaron desde el 5 de mayo de 2017?")
			);
		
		// agregar casos de prueba
	}
	
	@Test
	public void tiempoHasta() {
		Assert.assertEquals(
				"@jmm96 falta/n 5 día/s",
				mulan.charlar("@mulan cuántos días faltan para el 10 de mayo?")
			);
		
		// agregar casos de prueba
	}
	
}