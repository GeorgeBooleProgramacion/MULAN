package t;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import as.Asistente;

public class RF02Tests {

	public final static String USUARIO = "jmm96"; 
	
	Asistente mulan;
	
	@Before
	public void setup() {
		mulan = new Asistente("mulan", USUARIO);
	}
	
	@Test
	public void agradecimiento() {
		String rsp = null;
		String[] mensajes = {
				"¡Muchas gracias, @mulan!",
				"@mulan gracias",
				"gracias @mulan, de verdad te lo agradezco"
		};
		for (String mensaje : mensajes) {
			Assert.assertTrue(respuestas(rsp = mulan.charlar(mensaje)));
			System.out.println(rsp);
		}
	}
	
	private boolean respuestas(String msj) {
		String[] resp = {"De nada, @jmm96", "Por nada, @jmm96", "Fue un placer, @jmm96", "No es nada, @jmm96" };
		for(int i = 0; i < resp.length; i++) {
			if(msj.equals(resp[i])) {
				return true;
			}
		}
		return false;
	}
	
}