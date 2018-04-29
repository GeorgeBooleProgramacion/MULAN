package srv;

import as.Clima;
import conectores.ConectorClima;

import java.lang.reflect.Type;
import com.google.gson.Gson;
//import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class ServicioClima {
	
	/*private ConectorClima conector;
	
	
	public ServicioClima() {
		conector = new ConectorClima();
	}
	*/
	
	public Clima obtenerClima(String idCiudad) {
		
		Gson gson = new Gson();
		
		Type tipoClima = new TypeToken<Clima>(){}.getType();
		
		//String jsonClima = conector.getClimaActualCiudad(idCiudad);
		String jsonClima = "{\"coord\":{\"lon\":145.77,\"lat\":-16.92},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"base\":\"stations\",\"main\":{\"temp\":300.15,\"pressure\":1007,\"humidity\":74,\"temp_min\":300.15,\"temp_max\":300.15},\"visibility\":10000,\"wind\":{\"speed\":3.6,\"deg\":160},\"clouds\":{\"all\":40},\"dt\":1485790200,\"sys\":{\"type\":1,\"id\":8166,\"message\":0.2064,\"country\":\"AU\",\"sunrise\":1485720272,\"sunset\":1485766550},\"id\":2172797,\"name\":\"Cairns\",\"cod\":200}";
		//String clima = null;
		Clima clima = new Clima();
		
		if(jsonClima!=null) {
			clima = gson.fromJson(jsonClima, tipoClima);
		}
		
		return clima;
	}
	
}













