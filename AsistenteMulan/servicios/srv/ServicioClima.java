package srv;

import as.Clima;
import conectores.ConectorClima;

//import java.lang.reflect.Type;
import com.google.gson.Gson;
//import com.google.gson.*;
//import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.xml.bind.DatatypeConverter;

public class ServicioClima {

	private Calendar tiempoActual;
	private Calendar tiempoAnterior;
	// SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	// String horaActual = sdf.format(cal.getTime());
	// private Date tiempoActual = cal.getTime();
	// private final Calendar limiteTiempo =
	// DatatypeConverter.parseDateTime("00-00-00T00:10:00-00:00");

	private ConectorClima conector;

	private Boolean primerLlamado;

	public ServicioClima() {
		conector = new ConectorClima();
		tiempoAnterior = Calendar.getInstance();
		primerLlamado = true;
	}

	public Clima obtenerClima(String ciudad, String pais) {

		this.tiempoActual = Calendar.getInstance();
		this.tiempoAnterior.add(Calendar.MINUTE, 10);

		Clima clima = new Clima();

		clima.setError(true);

		if (pais == null)
			pais = "";

		if (this.primerLlamado || tiempoActual.after(tiempoAnterior)) {

			String jsonClima = conector.getClimaActualCiudad(ciudad, pais);

			if (jsonClima != null) {
				clima = new Gson().fromJson(jsonClima, Clima.class);
				clima.setError(false);
			}

			this.tiempoAnterior = Calendar.getInstance();
		}
		this.primerLlamado = false;
		return clima;
	}

	public Clima obtenerClimaTest(String ciudad, String pais) {

		this.tiempoActual = Calendar.getInstance();
		this.tiempoAnterior.add(Calendar.MINUTE, 1); // >>> CAMBIAR A 10 MINUTOS!!!

		Clima clima = new Clima();

		clima.setError(true);

		if (this.primerLlamado || tiempoActual.after(tiempoAnterior)) {

			// String jsonClima = conector.getClimaActualCiudad(ciudad, pais);

			/// json para el test
			String jsonClima = "{\"coord\":{\"lon\":145.77,\"lat\":-16.92},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"base\":\"stations\",\"main\":{\"temp\":300.15,\"pressure\":1007,\"humidity\":74,\"temp_min\":300.15,\"temp_max\":300.15},\"visibility\":10000,\"wind\":{\"speed\":3.6,\"deg\":160},\"clouds\":{\"all\":40},\"dt\":1485790200,\"sys\":{\"type\":1,\"id\":8166,\"message\":0.2064,\"country\":\"AU\",\"sunrise\":1485720272,\"sunset\":1485766550},\"id\":2172797,\"name\":\"Cairns\",\"cod\":200}";

			if (jsonClima != null) {
				clima = new Gson().fromJson(jsonClima, Clima.class);
				clima.setError(false);
			}

			this.tiempoAnterior = Calendar.getInstance();
		}
		this.primerLlamado = false;
		return clima;
	}

	public Boolean llevarParaguas(String ciudad, String pais) {

		Clima clima = new Clima();
		
		clima = this.obtenerClima(ciudad, pais);

		String condicion = clima.getWeather().getMain();

		if (!clima.getError()) {
			switch (condicion) {

			case "Rain":
				return true;
			case "Drizzle":
				return true;
			case "Clouds": 
				if ((clima.getWeather().getDescription().equals("overcast clouds")) || (clima.getClouds().getAll() > 70))
					return true;
				else
					return false;
			case "Thunderstorm":
				return true;
			case "Snow":
				return true;
			}
		} else
			return null;		//Cuando dio error el pedido a la API o no se espero el suficiente tiempo (10 min)

		return false;		//Cuando el clima no tiene nada de lluvia
	}

}
