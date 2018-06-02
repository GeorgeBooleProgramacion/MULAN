package t;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import as.Asistente;
import as.Conversion;
import as.Lenguaje;

public class RF11Tests {

	public final static String USUARIO = "delucas";

	Asistente jenkins;

	@Before
	public void setup() {
		jenkins = new Asistente("jenkins",USUARIO);
	}
	

	@Test
	public void unidadesDeMasa() {
		Assert.assertEquals(
				"@delucas 1 kilo equivale a 1000 gramos",
				jenkins.charlar("@jenkins cuántos gramos son 1 kilo")
			);
		
		Assert.assertEquals(
				"@delucas 1000 gramos equivalen a 1 kilo",
				jenkins.charlar("@jenkins cuántos kilos son 1000 gramos")
			);
		
		Assert.assertEquals(
				"@delucas 1000 gramos equivalen a 35.27 onzas",
				jenkins.charlar("@jenkins cuántas onzas son 1000 gramos")
			);		
	}
	
	

}