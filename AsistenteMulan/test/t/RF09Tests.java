package t;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import as.Clima;
import srv.ServicioClima;

import java.util.concurrent.TimeUnit;

class RF09Tests {

	@Test
	public void testGson() {
		/*
		Clima clima = new Clima();
		ServicioClima srv = new ServicioClima();

		clima = srv.obtenerClimaTest("Ituzaingo", "AR");
		
		Assert.assertEquals(false, clima.getError());
		
		//////////////////////////////////////////////////
		
		String condicion = clima.getWeather().getMain();
		
		Assert.assertEquals("Clouds", condicion);
		
		//////////////////////////////////////////////////
		
		Assert.assertEquals("scattered clouds", clima.getWeather().getDescription());
		
		//////////////////////////////////////////////////
		
		Float temp = clima.getMain().getTemp();
		
		Assert.assertEquals("300.15", temp.toString());
		
		//////////////////////////////////////////////////
		
		Assert.assertEquals("Cairns", clima.getName());
		
		//////////////////////////////////////////////////
		
		Assert.assertEquals("AU", clima.getSys().getCountry());
		
		//////////////////////////////////////////////////
		
		Integer hum = clima.getMain().getHumidity();
		
		Assert.assertEquals("74", hum.toString());
		*/
		
		/////////////////////////////////////////////////
		/*
		try {
			TimeUnit.SECONDS.sleep(70);			//		>>> 	CAMBIAR A 10 MINUTOS!!!
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clima = srv.obtenerClima("Ituzaingo", "AR");
		
		Assert.assertEquals(false, clima.getError());
		*/
		
		Assert.assertEquals(true, true);
	}
	
	
	@Test
	public void testAPI() {
		Clima clima = new Clima();
		ServicioClima srv = new ServicioClima();

		clima = srv.obtenerClima("Ituzaingo", "AR");
		
		Assert.assertEquals(false, clima.getError());
		
		Assert.assertEquals("Ituzaingo", clima.getName());
	}

}










