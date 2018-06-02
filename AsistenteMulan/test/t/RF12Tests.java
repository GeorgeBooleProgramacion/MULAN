package t;

import org.junit.*;

import as.Asistente;

public class RF12Tests {

public final static String USUARIO = "jmm96"; 
	
	Asistente mulan;
	
	@Before
	public void setup() {
		mulan = new Asistente("mulan", USUARIO);
	}
	
	@Test
	public void LeyesRoboticaTest() {
		System.out.println(mulan.charlar("@mulan dime las 3 leyes de la robotica"));
	}
	
	@Test
	public void LeyesRoboticaAssert() {
		Assert.assertEquals(
				"@jmm96, Las leyes de la robotica son:\n" + 
				"1) Un robot no hará daño a un ser humano, ni permitirá con su inacción que sufra daño.\n" + 
				"2) Un robot debe cumplir las órdenes dadas por los seres humanos, a excepción de aquellas que entrasen en conflicto con la primera ley.\n" + 
				"3) Un robot debe proteger su propia existencia en la medida en que esta protección no entre en conflicto con la primera o con la segunda ley."
				, mulan.charlar("@mulan dime las 3 leyes de la robotica"));
	}
	
}
