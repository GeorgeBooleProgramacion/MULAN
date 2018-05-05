package t;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import as.Asistente;
import as.Clima;
import srv.ServicioClima;

//import java.util.concurrent.TimeUnit;

class RF09Tests {
	
public final static String USUARIO = "lna96"; 
	
	Asistente mulan;
	
	@Before
	public void setup() {
		mulan = new Asistente("mulan", USUARIO);
	}
	
	
	@Test
	public void paraguas() {
		String rsp = null;
		String mensaje = "Llevo paraguas @mulan";
		Assert.assertTrue(respuestas(rsp = mulan.charlar(mensaje)));

		System.out.println(rsp);

	}
	
	private boolean respuestas(String msj) {
		String[] resp = { "Si deberias llevarlo, @lna96", "Para no mojarte seria lo ideal, @lna96", "No es necesario hoy, @lna96", "No, @lna96" };
		for(int i = 0; i < resp.length; i++) {
			if(msj.equals(resp[i])) {
				return true;
			}
		}
		return false;
	}
	
	

}










