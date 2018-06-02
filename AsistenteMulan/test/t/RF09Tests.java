package t;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import as.Asistente;
import as.Lenguaje;

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
		String rsp = "";
		//String rsp = mulan.charlar("Necesito paraguas hoy en Ituzaingo, AR @mulan?");
		if(mulan.charlar("Necesito paraguas hoy en Ituzaingo, AR @mulan?") != null)
			System.out.println("Todo bien");
		else
			System.out.println("Todo mal :(");
		//String rsp = mulan.charlar("Necesito paraguas? ubicacion San Justo, AR @mulan");
		//String rsp = mulan.charlar("Tengo que usar paraguas hoy en Ituzaingo, AR @mulan?");
		//String rsp = mulan.charlar("Debo llevar paraguas hoy en San Justo,AR? @mulan");
		
		//Assert.assertTrue(respuestas(rsp));

		//System.out.println(rsp);
	}
	
	public Boolean respuestas(String rsp) {
		if(rsp.equals("Si deberias llevarlo") || 
				rsp.equals("Si deberias llevarlo") || 
				rsp.equals("Para no mojarte seria lo ideal") || 
				rsp.equals("No es necesario hoy") || 
				rsp.equals("Naaa") || 
				rsp.equals("Ups... Ocurrio un error en el servidor")) {
			
			return true;
		}
		return false;
	}
	
	
	/*
	@Test
	public void paraguas() throws Exception {
		try{
			Clima clima = new Clima();
			ServicioClima srv = new ServicioClima();
			//String rsp = null;
			Boolean paraguas = srv.llevarParaguas("San Justo", "AR");
		
			if(paraguas == true)
				System.out.println("Si, @" + USUARIO);
			else
				System.out.println("Naaa, esta todo piola afuera @" + USUARIO);
		}catch(Exception e) {
			System.out.println("Paciencia hermano! Espera 10 minutos antes de pedir el clima");
			throw new Exception ("Paciencia hermano! Espera 10 minutos antes de pedir el clima");
		}
	}
	*/

}










