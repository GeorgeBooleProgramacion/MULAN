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
		this.tiempoAnterior.add(Calendar.MINUTE, 1); // >>> SOLO PORQUE ES EL TEST ES 1 MIN

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
		this.primerLlamado = false;
		return clima;
	}

	public Boolean llevarParaguas(String ciudad, String pais) {

		Clima clima = new Clima();
		
		clima = this.obtenerClimaTest2(ciudad, pais);		// MODIFICAR A obtenerClima() PARA USAR LA API EN LUGAR DE LA SIMULACION

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
	
	
	public void guardarTiempo() {
		BufferedWriter writer = null;
        try {
            //create a temporary file
            String timeLog = new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime());
            File logFile = new File("timeLog");

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            //writer = new BufferedWriter(new FileWriter(logFile, true));		//para agregar texto
            writer.write(timeLog);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
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
		if((tan + 1) >= tac)								// ESTO VA EN 10 EN REALIDA, CAMBIALO PAPU
			return false;	
		return true;
	}
	
	public String readFile(String filename) throws IOException
	{
	    String content = null;
	    File file = new File(filename); // For example, foo.txt
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






