package as;

import java.util.Calendar;
import java.util.Locale;

public class Lenguaje {

	private static final String[] REG_SLD = { "Hola", "Buen día", "Buenas tardes", // Saludos
											  "Buenas noches", "Buenas", "Holanda", "Hey" };
	
	private static final String[] REG_DSP = { "Chau", "Hasta luego", "Nos vemos", // Despedidas
											  "Hasta la proxima", "Adios" };
	
	private static final String[] REG_NE =  { "No comprendo", "No entendi",
											  "Disculpa... no entiendo el pedido" }; // Respuestas ante un mensaje no comprendido
																													
	private static final String[] REG_AGR = { "Gracias", "Te lo agradezco", "Muchas gracias", // Agradecimientos
											  "Te agradezco" };
	
	private static final String[] REG_DN = {  "De nada", "Por nada", "Fue un placer", "No es nada" }; // Respuestas a agradecimientos

	private static final String[] REG_PE = { "Como estas", "Como te va", "Como andas", // Preguntas sobre su estado
											 "Como te encuentras" };
	
	private static final String[] REG_RSE = { "Bien", "Muy bien", "Mal", "Pesimo", "Masomenos", "Perfecto", // Respuestas a las preguntas de estado																			
											  "Excelente", "No podria estar mejor" };
	
	private static final String[] REG_RSB = { "Si", "No", "Por supuesto", "Claro que no" }; // Respuestas booleanas

	private static final String[] REG_FEC = {"Qué día es hoy", "qué día es", "Que fecha es hoy","Que hora es","En que fecha estamos",
			 "En que mes estamos","En que año estamos", "Fecha", "qué día de la semana es hoy", "Hora"};//Preguntas sobre la fecha

	private static final String[] REG_AMD = {"hoy es","La fecha de hoy es","son las","El año actual es",
			 "Nos encontramos en el mes de"};//Respuestas sobre la fecha
	
	public static int conocido(String msj) {
		
		for(int i = 0; i < REG_FEC.length; i++) {
			if(sinTildes(msj).toUpperCase().contains(sinTildes(REG_FEC[i]).toUpperCase())) {
					return 5; 
			}
		}
		
		for (int i = 0; i < REG_SLD.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_SLD[i]).toUpperCase())) {
				return 1; // Saludar
			}
		}
		for (int i = 0; i < REG_DSP.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_DSP[i]).toUpperCase())) {
				return 0; // Despedir
			}
		}
		for (int i = 0; i < REG_AGR.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_AGR[i]).toUpperCase())) {
				return 3; // De nada
			}
		}
		for (int i = 0; i < REG_DN.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_DN[i]).toUpperCase())) {
				return -2; // Si le digo de nada, no dice nada
			}
		}
		for (int i = 0; i < REG_PE.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_PE[i]).toUpperCase())) {
				return 4; 
			}
		}
		
		return -1; // No entender
	}

	private static String sinTildes(String msj) {
		for (int i = 0; i < msj.length(); i++) {
			if (msj.charAt(i) == 'á')
				msj.replace('á', 'a');
			if (msj.charAt(i) == 'é')
				msj.replace('é', 'e');
			if (msj.charAt(i) == 'í')
				msj.replace('í', 'i');
			if (msj.charAt(i) == 'ó')
				msj.replace('ó', 'o');
			if (msj.charAt(i) == 'ú')
				msj.replace('ú', 'u');
		}
		return msj;
	}

	public static String saludos() {
		return REG_SLD[(int) (Math.random() * (REG_SLD.length))];
	}

	public static String despedidas() {
		return REG_DSP[(int) (Math.random() * (REG_DSP.length))];
	}

	public static String agradecimientos() {
		return REG_AGR[(int) (Math.random() * (REG_AGR.length))];
	}

	public static String de_nada() {
		return REG_DN[(int) (Math.random() * (REG_DN.length))];
	}

	public static String no_entendidos() {
		return REG_NE[(int) (Math.random() * (REG_NE.length))];
	}

	public static String respuestas_estado() {
		return REG_RSE[(int) (Math.random() * (REG_RSE.length))];
	}
	
	public static String respuestas_fecha(String msj) {
		Calendar c1 = Calendar.getInstance();
		String dia = Integer.toString(c1.get(Calendar.DATE));
		String mes = Integer.toString(c1.get(Calendar.MONTH)+1);
		String anio = Integer.toString(c1.get(Calendar.YEAR));
		String dayOfWeek = c1.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("es","ES"));
		String month = c1.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("es","ES"));
		Integer hour = (c1.get(Calendar.HOUR));
		int horaNormal = c1.get(Calendar.HOUR_OF_DAY);
		String min = Integer.toString(c1.get(Calendar.MINUTE));
		String time = String.format("%s:%s",hour,min);
		String timeMediodia = String.format("%d:%s",horaNormal,min);
		if(msj.toUpperCase().contains("Dia de la semana") || msj.toUpperCase().contains("HOY")) {
			return REG_AMD[0] + " " + dayOfWeek ;		
		}
		if(msj.toUpperCase().contains("EN QUE MES ESTAMOS")) {
			return REG_AMD[4] + " " + month;		
		}
		if(msj.toUpperCase().contains("QUÉ DÍA ES") || msj.toUpperCase().contains("FECHA")) {
			return REG_AMD[0] + " " + dia + " de" + " " + month + " de" + " " + anio ;		
		}
		if(msj.toUpperCase().contains("EN QUE AÑO ESTAMOS")) {
			return REG_AMD[3] + " " + anio;		
		}
		else {
				if(horaNormal == 12) 
					return REG_AMD[2] + " " + timeMediodia + " M.";
//				La hora de las doce del mediodía se expresa mejor como 12:00 m. (con punto),
//				como indica el Diccionario panhispánico de dudas. 
//				La razón es que el mediodía marca la frontera entre la mañana y la tarde, 
//				y a la inversa en la medianoche, por lo que 12:00 p. m. (y 12:00 a. m.) 
//				podría interpretarse de ambos modos.
				
				if(horaNormal > 12)
					return REG_AMD[2] + " " + time + " PM";
				else
					return REG_AMD[2] + " " + time + " AM";
				
			 }	
		
	}

}
