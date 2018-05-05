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
				"@jmm96 ser� el lunes 7 de mayo de 2018",
				mulan.charlar("@mulan qu� d�a ser� dentro de 2 d�as?")
			);
		
		Assert.assertEquals(
				"@jmm96 ser� el viernes 1 de junio de 2018",
				mulan.charlar("@mulan qu� d�a ser� dentro de 3 meses?")
			);
		
		Assert.assertEquals(
				"@jmm96 ser� el mi�rcoles 1 de abril de 2020",
				mulan.charlar("@mulan qu� d�a ser� dentro de 2 a�os?")
			);
	}
	
	@Test
	public void diaHace() {
		Assert.assertEquals(
				"@jmm96 fue s�bado 31 de marzo de 2018",
				mulan.charlar("@mulan qu� d�a fue ayer?")
			);
		
		Assert.assertEquals(
				"@jmm96 fue jueves 29 de marzo de 2018",
				mulan.charlar("@mulan qu� d�a fue hace 3 d�as?")
			);
		
		Assert.assertEquals(
				"@jmm96 fue el jueves 1 de febrero de 2018",
				mulan.charlar("@mulan qu� d�a fue hace 2 meses?")
			);
		
		Assert.assertEquals(
				"@jmm96 fue el viernes 1 de abril de 2016",
				mulan.charlar("@mulan qu� d�a fue hace 2 a�os?")
			);
	}
	
	@Test
	public void tiempoDesde() {
		Assert.assertEquals(
				"@jmm96 entre el 1 de abril de 2017 y el 1 de abril de 2018 pasaron 365 d�as",
				mulan.charlar("@mulan cu�ntos d�as pasaron desde el 1 de abril de 2017?")
			);
		
		// agregar casos de prueba
	}
	
	@Test
	public void tiempoHasta() {
		Assert.assertEquals(
				"@jmm96 faltan 9 d�as",
				mulan.charlar("@mulan cu�ntos d�as faltan para el 10 de abril?")
			);
		
		// agregar casos de prueba
	}
	
}