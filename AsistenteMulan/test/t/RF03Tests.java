package t;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import as.Asistente;


public class RF03Tests {
	public final static String USUARIO = "delucas";
	public final static Date FECHA_HORA = new GregorianCalendar(2018, 3, 1, 15, 15, 0).getTime();
	
	Asistente mulan;
	
	@Before
	public void setup() {
		mulan = new Asistente("mulan",USUARIO);
	}
	
	@Test
	public void hora() {
		String[] mensajes = {
				"¿qué hora es, @mulan?",
				"@mulan, la hora por favor",
				"me decís la hora @mulan?"
		};
		for (String mensaje : mensajes) {
			Assert.assertEquals(
					"@delucas son las 1:11 AM",
					mulan.charlar(mensaje)
			);
		}
	}
	
	@Test
	public void fecha() {
		String[] mensajes = {
				"¿qué día es, @mulan?",
				"@mulan, la fecha por favor",
				"me decís la fecha @mulan?"
		};
		
		for (String mensaje : mensajes) {
			Assert.assertEquals(
					"@delucas hoy es 5 de mayo de 2018",
					mulan.charlar(mensaje)
			);
		}

	}
	
	
	@Test
	public void diaDeLaSemana() {
		String[] mensajes = {
				"¿qué día de la semana es hoy, @mulan?"
		};
		for (String mensaje : mensajes) {
			Assert.assertEquals(
					"@delucas hoy es sábado",
					mulan.charlar(mensaje)
			);
		}
	}
	
}