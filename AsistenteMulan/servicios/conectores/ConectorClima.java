package conectores;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ConectorClima {

	//Key para conectarse a la api
		private String apiKey = "b30a54d63d819402d8d43fbcddd0642e";
		
		
		//Se conecta a la API y le manda la uri con los datos que se agregan en las funciones de abajo
		private String conectarAPI(String uri) {
			String res = "";
			URL url;
			HttpsURLConnection con;
			BufferedReader br;
			try {
				url = new URL(uri);
				con = (HttpsURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("Accept", "application/json");
				if (con.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
				}

				br = new BufferedReader(new InputStreamReader((con.getInputStream())));

				String output = "";

				while ((output = br.readLine()) != null) {
					res += output;
				}

				con.disconnect();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return res;
		}
		
		
		
		//Mandando el id de la ciudad te devuelve el clima en este momento
		public String getClimaActualId(String id) {
			return conectarAPI("https://api.openweathermap.org/data/2.5/weather?id=" + id + "&units=metric" + "&APPID=" + apiKey);
		}
		
		
		//Igual que el anterior pero mandando la ciudad directamente (q={city name},{country code})
		public String getClimaActualCiudad(String ciudad, String pais) {
			ciudad = ciudad.toLowerCase();
			pais = pais.toLowerCase();
			return conectarAPI("https://api.openweathermap.org/data/2.5/weather?q=" + ciudad + "," + pais + "&units=metric" + "&APPID=" + apiKey );
		}
		
	
}
