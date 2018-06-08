package t;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Date;
import java.util.Enumeration;

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
		palabrita = "h�l� g�t�";
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
		System.out.println("Dentro de " + cantDias + " d�a/s ser�:");
		System.out.println(Fecha.mostrarFecha(Fecha.diaDentroDe(cantDias)));
		System.out.println("----------------------------------------");
	}
	
	@Test
	public void diaHace() {
		System.out.println(DIA_HOY);
		System.out.println("Hace " + cantDias + " d�a/s fue:");
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
		palabrita = palabrita.replace('�', 'a');
		palabrita.replace('�', 'e');
		palabrita.replace('�', 'i');
		palabrita.replace('�', 'o');
		palabrita.replace('�', 'u');
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
	
	@Test
	public void quieroMiIp() throws Exception {
		 try {
			 	URL whatismyip = new URL("http://checkip.amazonaws.com");
			 	BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));     
			 	String ip = in.readLine();     
			 	System.out.println("My Public ip is = "+ip);
			 	in.close();
			 	System.out.println("----------------------------------------");
	         } catch (MalformedURLException ex) {
	        	throw new Exception("URL no compatible");
	        } catch (IOException ex) {
	        	throw new Exception("Falla en la entrada");
	        }
	    }
}
