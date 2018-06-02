package t;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import as.Asistente;
import as.Conversion;


public class RF11Tests {

	public final static String USUARIO = "delucas";

	Asistente jenkins;

	@Before
	public void setup() {
		jenkins = new Asistente("jenkins",USUARIO);
	}
	

	@Test
	public void unidadesDeMasa() {
		
		// TEST DEL PROFE
		Assert.assertEquals(
				"@delucas 1000 gramos equivalen a 1 kilo",
				jenkins.charlar("@jenkins cuántos kilos son 1000 gramos")
			);
		
		Assert.assertEquals(
				"@delucas 1 kilo equivale a 1000 gramos",
				jenkins.charlar("@jenkins cuántos gramos son 1 kilo")
			);
		
		Assert.assertEquals(
				"@delucas 1000 gramos equivalen a 35.27 onzas",
				jenkins.charlar("@jenkins cuántas onzas son 1000 gramos")
			);
		
		// KILOS A GRAMOS
		Assert.assertEquals(
				"@delucas 0.5 kilos equivalen a 500 gramos",
				jenkins.charlar("@jenkins cuántos gramos hay en 0.5 kilos")
			);
		
		Assert.assertEquals(
				"@delucas 1.53 kilos equivalen a 1530 gramos",
				jenkins.charlar("@jenkins cuántos gramos son 1.53 kilos")
			);
		
		// GRAMOS A KILOS
		Assert.assertEquals(
				"@delucas 2.5 gramos equivalen a 0.0025 kilos",
				jenkins.charlar("@jenkins cuántos kilos son 2.5 gramos")
			);
		
		Assert.assertEquals(
				"@delucas 2 gramos equivalen a 0.002 kilos",
				jenkins.charlar("@jenkins cuántos kilos son 2 gramos")
			);
		
		
		// GRAMOS A ONZAS
		Assert.assertEquals(
				"@delucas 0.5 gramos equivalen a 0.017635 onzas",
				jenkins.charlar("@jenkins cuántas onzas son 0.5 gramos")
			);	
		
		Assert.assertEquals(
				"@delucas 2 gramos equivalen a 0.07054 onzas",
				jenkins.charlar("@jenkins cuántas onzas son 2 gramos")
			);
		
		Assert.assertEquals(
				"@delucas 1 gramo equivale a 0.03527 onzas",
				jenkins.charlar("@jenkins cuántas onzas son 1 gramo")
			);
		
		// KILOMETROS A METROS
		Assert.assertEquals(
				"@delucas 3.4 kilometros equivalen a 3400 metros",
				jenkins.charlar("@jenkins cuántos metros son 3.4 kilometros")
			);	
		
		Assert.assertEquals(
				"@delucas 0.001 kilometros equivalen a 1 metro",
				jenkins.charlar("@jenkins cuántos metros son 0.001 kilometros")
			);	
		
		Assert.assertEquals(
				"@delucas 1 kilometro equivale a 1000 metros",
				jenkins.charlar("@jenkins cuántos metros son 1 kilometro")
			);
		
		Assert.assertEquals(
				"@delucas 2 kilometros equivalen a 2000 metros",
				jenkins.charlar("@jenkins cuántos metros hay en 2 kilometros")
			);
		
		//MINUTOS A SEGUNDOS
		Assert.assertEquals(
				"@delucas 1 minuto equivale a 60 segundos",
				jenkins.charlar("@jenkins cuántos segundos son 1 minuto")
			);
		
		Assert.assertEquals(
				"@delucas 0.0166667 minutos equivalen a 1 segundo",
				jenkins.charlar("@jenkins cuántos segundos son 0.0166667 minutos")
			);
		
		Assert.assertEquals(
				"@delucas 1.2 minutos equivalen a 72 segundos",
				jenkins.charlar("@jenkins cuántos segundos son 1.2 minutos")
			);
	
		Assert.assertEquals(
				"@delucas 2 minutos equivalen a 120 segundos",
				jenkins.charlar("@jenkins cuántos segundos hay en 2 minutos")
			);
	}
	
	

}