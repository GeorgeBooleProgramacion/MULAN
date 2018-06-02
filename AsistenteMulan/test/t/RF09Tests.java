package t;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import as.Asistente;
import as.Lenguaje;

import as.Clima;
import srv.ServicioClima;

//import java.util.concurrent.TimeUnit;

public class RF09Tests {
	
	public final static String USUARIO = "lna96"; 
	
	Asistente mulan;
	
	@Before
	public void setup() {
		mulan = new Asistente("mulan", USUARIO);
	}
	
	
	@Test
	public void paraguas() {
		String rsp = mulan.charlar("Necesito paraguas hoy en Ituzaingo, AR @mulan?");
		//String rsp = mulan.charlar("Necesito paraguas? ubicacion San Justo, AR @mulan");
		//String rsp = mulan.charlar("Tengo que usar paraguas hoy en Ituzaingo, AR @mulan?");
		//String rsp = mulan.charlar("Debo llevar paraguas hoy en San Justo,AR? @mulan");
		
		System.out.println(rsp);
		
		Assert.assertTrue(respuestas(rsp));
	}
	
	public Boolean respuestas(String rsp) {
		if(rsp.equals("Si deberias llevarlo, @lna96") || 
				rsp.equals("Si deberias llevarlo, @lna96") || 
				rsp.equals("Para no mojarte seria lo ideal, @lna96") || 
				rsp.equals("No es necesario hoy, @lna96") || 
				rsp.equals("Naaa, @lna96") || 
				rsp.equals("Error del servidor... Espera 10 minutos antes de consultar el clima de nuevo, @lna96")) {
			
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










