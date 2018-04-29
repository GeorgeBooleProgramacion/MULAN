package srv;

import java.util.List;

import as.Clima;
import conectores.ConectorClima;

import com.google.gson.Gson;

public class ServicioClima {
	
	private ConectorClima conector;
	
	
	public ServicioClima() {
		conector = new ConectorClima();
	}
	
	
	/*public List<Clima> obtenerPaises() {
		//Cargo el tipo "Lista de paises"
		Type tipoListaDePaises = new TypeToken<ArrayList<Clima>>(){}.getType();  

		//List<Pais> lista = new ArrayList<Pais>();

		Gson gson = new Gson();
		String jsonPaises = conector.getPaises();
		List<Pais> lista = null;
		if(!(jsonPaises==null))
			lista = gson.fromJson(jsonPaises,  tipoListaDePaises);
		
		return lista;
	}*/
	
	public Clima obtenerClima(String idCiudad) {
		
		Gson gson = new Gson();
		
		String jsonClima = conector.getClimaActualCiudad(idCiudad);
		String clima = null;
		
		if(jsonClima!=null) {
			clima = gson.fromJson(???);
		}
		
		return clima;
	}
	
}













