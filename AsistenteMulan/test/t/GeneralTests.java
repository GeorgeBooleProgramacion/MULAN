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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.*;

import as.Fecha;

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
		System.out.println("----------------------------------------");
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
	
	@Test
	public void regex() throws IOException {
		System.out.println("CADENITA DE BUSQUEDA:");
		String link = "https://www.youtube.com/results?search_query=";
		String msj = "usr1: /youtube anda a la cancha bobo";
		final String expresion = "(?i:youtube) (\\w.*)";
		final Pattern pattern = Pattern.compile(expresion);
		final Matcher matcher = pattern.matcher(msj);
		
		if(matcher.find()) {
			String la = matcher.group(1).replace(" ", "+");
			System.out.println(la);
			System.out.println("LINK:");
			link+=la;
			System.out.println(link);
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + link);
		}
		else
			System.out.println("No anduvo");
		System.out.println("----------------------------------------");
	}
}
