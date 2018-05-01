package t;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import en.BufferEntrada;
import as.Mulan;
import as.Asistente;

public class PruebaMulan {
	public final static String USUARIO = "delucas"; 
	
//	@Test
//	public void testSaludo() {
//		BufferEntrada b;
//		do{
//			b = new BufferEntrada();
//		}while (Mulan.charlar(b.getEntrada()));
//	}

	Asistente jenkins;
	
	@Before
	public void setup() {
		jenkins = new Asistente("jenkins");
	}
	@Test
	public void testNombre() {
		Assert.assertEquals("jenkins",jenkins.getNombre());
	}
	
	@Test
	public void testSaludo2() {
		String[] mensajes = {
				"¡Hola, @jenkins",
				//"@jenkins hola!",
				"buen día @jenkins",
//				"@jenkins, buenas tardes",
				"hey @jenkins"
		};
		
		//String msj = "¡Hola, @jenkins";
		
		//Assert.assertEquals("¡Hola, USUARIO",jenkins.escuchar(msj));
		for (String mensaje : mensajes) {
			Assert.assertEquals("¡Hola, USUARIO",jenkins.escuchar(mensaje));
	}
	}
}

