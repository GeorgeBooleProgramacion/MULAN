package t;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import as.Asistente;


public class RF11Tests {

	public final static String USUARIO = "delucas";

	Asistente jenkins;

	@Before
	public void setup() {
		jenkins = new Asistente("jenkins",USUARIO);
	}
	

	@Test
	public void unidadesDeMasa() {
		
		
		//System.out.println(jenkins.charlar("@jenkins cuántos kilos son 1000 gramos"));
		//System.out.println(jenkins.charlar("@jenkins cuántos metros son 3.4 kilometros"));
		Assert.assertEquals(
				"@delucas 2 kilos equivalen a 2000 gramos",
				jenkins.charlar("@jenkins cuántos gramos son 2 kilos")
			);
		
//		Assert.assertEquals(
//				"@delucas 1000 gramos equivalen a 1 kilo",
//				jenkins.charlar("@jenkins cuántos kilos son 1000 gramos")
//			);
		
//		Assert.assertEquals(
//				"@delucas 0.5 gramos equivalen a 0.017635 onzas",
//				jenkins.charlar("@jenkins cuántas onzas son 0.5 gramos")
//			);	
//		Assert.assertEquals(
//				"@delucas 1000 gramos equivalen a 35.27 onzas",
//				jenkins.charlar("@jenkins cuántas onzas son 1000 gramos")
//			);
//		
//		Assert.assertEquals(
//				"@delucas 2 gramos equivalen a 0.0705479 onzas",
//				jenkins.charlar("@jenkins cuántas onzas son 2 gramos")
//			);
		
//		Assert.assertEquals(
//				"@delucas 3.4 kilometros equivalen a 3400 metros",
//				jenkins.charlar("@jenkins cuántos metros son 3.4 kilometros")
//			);	
		
		//0.0705479
	}
	
	

}