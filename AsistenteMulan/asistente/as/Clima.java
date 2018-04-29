package as;

import java.util.Date;

public class Clima {

	private int id, 	//de la ciudad
				cod, 	//Internal parameter
				visibility;		//visibilidad actualmente 		>>> 	REVISAR SI PONERLO!!!
	
	private String name, 	//de la ciudad
				   base;	//Internal parameter		
	
	private Date dt;	//Time of data calculation
	
	private Coord coodenadas;
	private Weather climaActual;
	private MainData datosPrincipales;
	private Wind viento;
	private Clouds nubes;
	private Rain lluvia;
	private Snow nieve;
	private Sys datosSys;
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////
	
	///Objetos que usa Clima
	
	public class Coord {		//coordenadas de la ciudad
		int lon, 
			lat;
	}
	
	public class Weather {
		int id;		//id de la condicion climatica
		
		String main, 	//condicion climatica
			   description, 	//descripcion de la condicion
			   icon;		//icono de la condicion
	}
	
	public class MainData {
		int temp, 		//actual
		    pressure, 		//presion atmosferica en hPa
		    humidity, 		//humedad en %
		    temp_min, 		//variacion de la temp actual
		    temp_max, 		//variacion de la temp actual
		    sea_level, 		//presion atmosferica al nivel del mar
		    grnd_level;		//presion atmosferica al nivel de la tierra
	}
	
	public class Wind {
		int speed, 		//en m/s
			deg;	//direccion del viento en grados
	}
	
	public class Clouds {
		int all;	//cantidad de nubes en %
	}
	
	public class Rain {
		int h3;		//volumen de lluvia en las ultimas 3 horas
	}
	
	public class Snow {
		int h3;		//volumen de nieve en las ultimas 3 horas
	}
	
	public class Sys {
		int type, 	//Internal parameter
			id, 	//Internal parameter
			message;	//Internal parameter
		
		String country;		//Pais
		
		Date sunrise, 		//hora del amanecer
			 sunset;		//hora del atardecer
	}
	
}
