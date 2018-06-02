package srv;

import as.Clima;
import conectores.ConectorClima;

//import java.lang.reflect.Type;
import com.google.gson.Gson;
//import com.google.gson.*;
//import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.xml.bind.DatatypeConverter;

public class ServicioClima {

	private ConectorClima conector;
	private String city;
	private String country;
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	

	public ServicioClima() {
		conector = new ConectorClima();
	}

	public Clima obtenerClima(String ciudad, String pais) {

		String tiempoActual = new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime());

		Clima clima = new Clima();

		clima.setError(true);

		if (pais == null)
			pais = "";

		if (compararTiempos(tiempoActual)) {

			String jsonClima = conector.getClimaActualCiudad(ciudad, pais);

			if (jsonClima != null) {
				clima = new Gson().fromJson(jsonClima, Clima.class);
				clima.setError(false);
			}

			guardarTiempo();
		}

		return clima;
	}

	public Clima obtenerClimaTest(String ciudad, String pais) {

		String tiempoActual = new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime());

		Clima clima = new Clima();

		clima.setError(true);

		if (compararTiempos(tiempoActual)) {

			// String jsonClima = conector.getClimaActualCiudad(ciudad, pais);

			/// json para el test
			String jsonClima = "{\"coord\":{\"lon\":145.77,\"lat\":-16.92},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"base\":\"stations\",\"main\":{\"temp\":300.15,\"pressure\":1007,\"humidity\":74,\"temp_min\":300.15,\"temp_max\":300.15},\"visibility\":10000,\"wind\":{\"speed\":3.6,\"deg\":160},\"clouds\":{\"all\":40},\"dt\":1485790200,\"sys\":{\"type\":1,\"id\":8166,\"message\":0.2064,\"country\":\"AU\",\"sunrise\":1485720272,\"sunset\":1485766550},\"id\":2172797,\"name\":\"Cairns\",\"cod\":200}";

			if (jsonClima != null) {
				clima = new Gson().fromJson(jsonClima, Clima.class);
				clima.setError(false);
			}

			guardarTiempo();
		}

		return clima;
	}

	/*
	public Clima obtenerClimaTest2(String ciudad, String pais) {

		String tiempoActual = new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime());

		Clima clima = new Clima();

		clima.setError(true);

		if (compararTiempos(tiempoActual)) {

			// String jsonClima = conector.getClimaActualCiudad(ciudad, pais);

			/// json para el test
			String jsonClima = "{\"coord\":{\"lon\":145.77,\"lat\":-16.92},\"weather\":[{\"id\":802,\"main\":\"Rain\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"base\":\"stations\",\"main\":{\"temp\":300.15,\"pressure\":1007,\"humidity\":74,\"temp_min\":300.15,\"temp_max\":300.15},\"visibility\":10000,\"wind\":{\"speed\":3.6,\"deg\":160},\"clouds\":{\"all\":40},\"dt\":1485790200,\"sys\":{\"type\":1,\"id\":8166,\"message\":0.2064,\"country\":\"AU\",\"sunrise\":1485720272,\"sunset\":1485766550},\"id\":2172797,\"name\":\"Cairns\",\"cod\":200}";

			if (jsonClima != null) {
				clima = new Gson().fromJson(jsonClima, Clima.class);
				clima.setError(false);
			}

			guardarTiempo();
		}

		return clima;
	}
	*/
	public int llevarParaguas(String ciudad, String pais) {

		Clima clima = new Clima();
		
		clima = this.obtenerClima(ciudad, pais);		// MODIFICAR A obtenerClima() PARA USAR LA API EN LUGAR DE LA SIMULACION
														// PARA LA SIMULACION DEJAR obtenerClimaTest()
		String condicion = "";
		
		try {
			condicion = clima.getWeather().getMain();
		} catch (Exception e) {
			return -1;
		}

		if (clima.getError() == false) {
			switch (condicion) {

			case "Rain":
				return 1;
			case "Drizzle":
				return 1;
			case "Clouds": 
				if ((clima.getWeather().getDescription().equals("overcast clouds")) || (clima.getClouds().getAll() > 70))
					return 1;
				else
					return 0;
			case "Thunderstorm":
				return 1;
			case "Snow":
				return 1;
			}
		} else
			return -1;		//Cuando dio error el pedido a la API o no se espero el suficiente tiempo (10 min)

		return 0;		//Cuando el clima no tiene nada de lluvia
	}
	
	
	public void guardarTiempo() {
		BufferedWriter writer = null;
        try {
            String timeLog = new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime());
            File logFile = new File("timeLog");

            //System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            //writer = new BufferedWriter(new FileWriter(logFile, true));		//para agregar texto
            writer.write(timeLog);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
	}
	
	public Boolean compararTiempos(String tiempoActual) {
		String tiempoAnterior = null;
		try {
			tiempoAnterior = readFile("timeLog");
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		int tac = Integer.parseInt(tiempoActual);
		int tan = Integer.parseInt(tiempoAnterior);
		if((tan + 10) >= tac)								// PARA LOS TEST SE PUEDE CAMBIAR A (tan + 1) ASI SOLO PASA 1 MIN
			return false;	
		return true;
	}
	
	public String readFile(String filename) throws IOException
	{
	    String content = null;
	    File file = new File(filename);
	    FileReader reader = null;
	    try {
	        reader = new FileReader(file);
	        char[] chars = new char[(int) file.length()];
	        reader.read(chars);
	        content = new String(chars);
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if(reader != null){
	            reader.close();
	        }
	    }
	    return content;
	}

}






