package t;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import as.Asistente;

public class RF00Tests {

	public final static String USUARIO = "jmm96"; 
	
	Asistente mulan;
	
	@Before
	public void setup() {
		mulan = new Asistente("mulan", USUARIO);
	}
	
	@Test
	public void sinsentido() {
		String rsp = null;
		String[] mensajes = {
				"Este mensaje no tiene sentido @mulan"
		};
		for (String mensaje : mensajes) {
			Assert.assertTrue(respuestas(rsp = mulan.charlar(mensaje)));
			System.out.println(rsp);
		}
	}
	
	private boolean respuestas(String msj) {
		String[] resp =  {"No comprendo, @jmm96", "No entendi, @jmm96", "Disculpa... no entiendo el pedido, @jmm96"};
		for(int i = 0; i < resp.length; i++) {
			if(msj.equals(resp[i])) {
				return true;
			}
		}
		return false;
	}
	
}
