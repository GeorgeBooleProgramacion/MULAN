package t;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import as.Asistente;

public class RF01Tests {

	public final static String USUARIO = "jmm96"; 
	
	Asistente mulan;
	
	@Before
	public void setup() {
		mulan = new Asistente("mulan", USUARIO);
	}
	
	@Test
	public void saludo() {
		String rsp = null;
		String[] mensajes = {
				"¡Hola, @mulan!",
				"@mulan hola!",
				"buen día @mulan",
				"@mulan, buenas tardes",
				"hey @mulan"
		};
		for (String mensaje : mensajes) {
			Assert.assertTrue(respuestas(rsp = mulan.charlar(mensaje)));
			System.out.println(rsp);
		}
	}
	
	private boolean respuestas(String msj) {
		String[] resp = { "Hola, @jmm96", "Buenas, @jmm96", "Hey, @jmm96" };
		for(int i = 0; i < resp.length; i++) {
			if(msj.equals(resp[i])) {
				return true;
			}
		}
		return false;
	}
	
}