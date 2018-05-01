package t;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import en.BufferEntrada;
import srv.ServicioClima;
import as.Clima;
import as.Mulan;

public class PruebaMulan {
	
	/*@Test
	public void testSaludo() {
		BufferEntrada b;
		do{
			b = new BufferEntrada();
		}while (Mulan.charlar(b.getEntrada()));
	}*/
	
	//Esto deberia funcionar???
	
	
	
	
	@Test
	public void testGson() {
		Clima clima = new Clima();
		ServicioClima srv = new ServicioClima();
		clima = srv.obtenerClima2("3433359");
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
	}

}
