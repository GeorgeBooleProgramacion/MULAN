package as;

import java.util.Date;

public class Clima {

	private int id, 	//de la ciudad
				cod, 	//Internal parameter
				visibility;		//visibilidad actualmente 		>>> 	ES IMPORTANTE?
	
	private String name, 	//de la ciudad
				   base;	//Internal parameter		
	
	//private Date dt;	//Time of data calculation			>>>			BUSCAR COMO PARSEAR LOS DATOS DE FECHAS
	
	private Coord coord;
	private Weather[] weather;
	private MainData main;
	private Wind wind;
	private Clouds clouds;
	private Rain rain;
	private Snow snow;
	private Sys sys;	//						>>>				BUSCAR COMO PARSEAR LAS HORAS!!!
	
	
	private Boolean error;
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////
	
	///OBJETOS QUE USA CLIMA
	
	public class Coord {		//coordenadas de la ciudad
		float lon, 
			  lat;
	}
	
	public class Weather {
		int id;		//id de la condicion climatica
		
		String main, 	//condicion climatica
			   description, 	//descripcion de la condicion
			   icon;		//icono de la condicion

		
		public int getId() {
			return id;
		}

		public String getMain() {
			return main;
		}

		public String getDescription() {
			return description;
		}
		
		
	}
	
	public class MainData {
		float temp, 		//actual
			  temp_min, 		//variacion de la temp actual
			  temp_max; 		//variacion de la temp actual
		
		int pressure, 		//presion atmosferica en hPa
		    humidity, 		//humedad en %
		    sea_level, 		//presion atmosferica al nivel del mar
		    grnd_level;		//presion atmosferica al nivel de la tierra
		

		public float getTemp() {
			return temp;
		}

		public float getTemp_min() {
			return temp_min;
		}

		public float getTemp_max() {
			return temp_max;
		}

		public int getPressure() {
			return pressure;
		}

		public int getHumidity() {
			return humidity;
		}
	}
	
	public class Wind {
		float speed; 		//en m/s
		int deg;	//direccion del viento en grados
		
		
		public float getSpeed() {
			return speed;
		}
		public int getDeg() {
			return deg;
		}
		
	}
	
	public class Clouds {
		int all;	//cantidad de nubes en %

		public int getAll() {
			return all;
		}
	}
	
	public class Rain {
		int h3;		//volumen de lluvia en las ultimas 3 horas
	}
	
	public class Snow {
		int h3;		//volumen de nieve en las ultimas 3 horas
	}
	
	public class Sys {
		int type, 	//Internal parameter
			id; 	//Internal parameter
		float message;	//Internal parameter
		
		String country;		//Pais

		/*
		Date sunrise, 		//hora del amanecer
			 sunset;		//hora del atardecer
		*/
		
		
		public String getCountry() {
			return country;
		}
	}
	
	
	
	
	///GETTERS DE LA CLASE CLIMA

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/*
	public Date getDt() {
		return dt;
	}
	*/

	public Weather getWeather() {
		return weather[0];
	}

	public MainData getMain() {
		return main;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public Sys getSys() {
		return sys;
	}
	
	////////////////////////////////////////
	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}
	////////////////////////////////////////
	
	
	
	///METODOS DE CLIMA
	
	public String toString() {
		return "Condicion climatica actual: " + getWeather().getDescription();
	}

	
	
}
