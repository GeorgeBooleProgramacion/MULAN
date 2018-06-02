package t;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import as.Asistente;

public class RF13Tests {
	
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
				"Dime algun chuck norris fact, @mulan!",
				"@mulan cuentame un chuck norris facts",
		};
		for (String mensaje : mensajes) {
			Assert.assertTrue(respuestas(rsp = mulan.charlar(mensaje)));
			System.out.println(rsp);
		}
	}
	
	private boolean respuestas(String msj) {
		String[] resp = { "Chuck Norris puede dividir por 0, @jmm96", "Chuck Norris es la razón por la que Wally se esconde, @jmm96",		//Respuestas chuk norris
				"Chuck Norris puede quemar una hormiga con una lupa… de noche, @jmm96", "Chuck Norris no cree en Dios, Dios cree en Chuk Norris, @jmm96",
				"Cuando Chuck Norris hace flexiones, no está levantando su cuerpo, está empujando el planeta hacia abajo, @jmm96",
				  "Chuck Norris ha contado hasta el número infinito… dos veces, @jmm96"};
		for(int i = 0; i < resp.length; i++) {
			if(msj.equals(resp[i])) {
				return true;
			}
		}
		return false;
	}

}
