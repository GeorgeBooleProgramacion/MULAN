package t;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.junit.*;

import as.Fecha;
import bd.Usuario;

public class GeneralTests {
	
	private static final String DIA_HOY = "5/5/2018"; //Cambiarlo a la fecha actual

	Date d;
	int cantDias;
	double numerito;
	String palabrita;
	String[] str = {"hola", "como", "estas", "|", "bien", "por", "suerte"};
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		d = new Date();
		d.setDate(10);
		d.setMonth(4);
		d.setYear(118);
		cantDias = 4;
		numerito = 5.11;
		palabrita = "hólá gátó";
	}
	
	/*@Test
	public void hoy() {
		Assert.assertEquals(DIA_HOY, Fecha.diaDeHoy());
	}*/
	
	/*@Test
	public void cantDias() {
		Assert.assertEquals(5, Fecha.tiempoHasta(d));
	}*/
	
	@Test
	public void diaDentroDe() {
		System.out.println(DIA_HOY);
		System.out.println("Dentro de " + cantDias + " día/s será:");
		System.out.println(Fecha.mostrarFecha(Fecha.diaDentroDe(cantDias)));
		System.out.println("----------------------------------------");
	}
	
	@Test
	public void diaHace() {
		System.out.println(DIA_HOY);
		System.out.println("Hace " + cantDias + " día/s fue:");
		System.out.println(Fecha.mostrarFecha(Fecha.diaHace(cantDias)));
	}
	
	@Test
	public void probandoParteEntera() {
		String num = String.valueOf(numerito);
		System.out.println("La parte decimal de " + numerito + " es: " + Integer.parseInt(num.substring(num.indexOf('.') + 1)));
		System.out.println("----------------------------------------");
	}
	
	@Test
	public void probandoSumaString() {
		String num = "";
		num += '1';
		num += '2';
		int x = Integer.valueOf(num) + 2;
		System.out.println(num);
		System.out.println(x);
	}
	
	@Test
	public void sacandoTildes() {
		palabrita = palabrita.replace('á', 'a');
		palabrita.replace('é', 'e');
		palabrita.replace('í', 'i');
		palabrita.replace('ó', 'o');
		palabrita.replace('ú', 'u');
		System.out.println(palabrita);
	}
	
	@Test
	public void probandoRecorridoHastaCaracter() {
		int i = 0;
		while(str[i] != "|") {
			System.out.println(str[i]);
			i++;
		}
		for(i++; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
	
	@Test
	public void probandoLeerUsuarios() throws FileNotFoundException {
		Assert.assertTrue(Usuario.buscarUser("usr1", "1234"));
	}
	
	@Test
	public void probandoAppendearUsers() throws IOException {
		Usuario.registrarUser("usr6", "4321");
	}
	
}
