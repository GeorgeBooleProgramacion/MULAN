package as;

import java.util.Date;
import java.util.regex.Pattern;

public class Lenguaje {
	
	private static int posEncontrada;

	private static final String[] REG_SLD = { "Hola", "Buenas", "Hey" }; //Saludos
	
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
	
	private static final String[] REG_FCH = { "Qué día será", "Qué día fué", "Cuántos días pasaron", "Cuántos días faltan", 
											  "Qué día es", "Que fecha es hoy", "Hoy es", "Fecha",
											  "Que hora es", "Hora", "Hora", "En que mes estamos", "En que año estamos", 
											  "día de la semana"}; //Preguntas sobre fecha
	
	private static final String[] REG_MES = { "Enero" , "Febrero" , "Marzo" , "Abril" , "Mayo" , "Junio" , 
											  "Julio" , "Agosto" , "Septiembre" , "Octubre" , 
											  "Noviembre" , "Diciembre"};
	
	private static final String[] REG_DIA = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes",
											  "Sábado", "Domingo"};

	private static final String[] REG_AMD = {"hoy es","La fecha de hoy es","son las","El año actual es",
			 "Nos encontramos en el mes de"};//Respuestas sobre la fecha
	
	
	/*final String expresion = "(?:cuantas|cuantos|cuántos|cuántas) (\\w*) (?:son|hay en) (\\d+|.*) (\\w*)";
	// 															    Grupo 1 				Grupo 2 Grupo 3
	
	final Pattern pattern = Pattern.compile(expresion); // compila la expresion regular y la guarda en pattern
	final Matcher matcher = pattern.matcher(msj);       // realiza las operaciones de coincidencia de caracteres
													    // intepretando la expresion regular cargada en pattern*/
	
	private static final Pattern EXP_SLD = Pattern.compile("(?i:hola|buen dia|buen día|buenas tardes|buenas noches|buenas|hey)");
	
	public static int conocido(String msj) {
		
		if(EXP_SLD.matcher(msj).find()) {
			return 1;
		}
		
		/*for (int i = 0; i < REG_SLD.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_SLD[i]).toUpperCase())) {
				posEncontrada = i;
				return 1; // Saludar
			}
		}*/
		for (int i = 0; i < REG_DSP.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_DSP[i]).toUpperCase())) {
				posEncontrada = i;
				return 0; // Despedir
			}
		}
		for (int i = 0; i < REG_AGR.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_AGR[i]).toUpperCase())) {
				posEncontrada = i;
				return 3; // De nada
			}
		}
		for (int i = 0; i < REG_DN.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_DN[i]).toUpperCase())) {
				posEncontrada = i;
				return -2; // Si le digo de nada, no dice nada
			}
		}
		for (int i = 0; i < REG_PE.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_PE[i]).toUpperCase())) {
				posEncontrada = i;
				return 4; // Si le digo de nada, no dice nada
			}
		}
		for (int i = 0; i < REG_FCH.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_FCH[i]).toUpperCase())) {
				posEncontrada = i;
				return 5;
			}
		}
		return -1; // No entender
	}

	private static String sinTildes(String msj) {
		for (int i = 0; i < msj.length(); i++) {
			if (msj.charAt(i) == 'á')
				msj = msj.replace('á', 'a');
			if (msj.charAt(i) == 'é')
				msj = msj.replace('é', 'e');
			if (msj.charAt(i) == 'í')
				msj = msj.replace('í', 'i');
			if (msj.charAt(i) == 'ó')
				msj = msj.replace('ó', 'o');
			if (msj.charAt(i) == 'ú')
				msj = msj.replace('ú', 'u');
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
	
	public static String respuesta_dia_dentro_de(String msj) {
		
		if(sinTildes(msj).toUpperCase().contains("mes".toUpperCase()))
			return "" + Fecha.mostrarFecha(Fecha.diaDentroDe(buscarCantDMA(msj), 1));
		
		if(sinTildes(msj).toUpperCase().contains("año".toUpperCase()))
			return "" + Fecha.mostrarFecha(Fecha.diaDentroDe(buscarCantDMA(msj), 2));
		
		return "" + Fecha.mostrarFecha(Fecha.diaDentroDe(buscarCantDMA(msj)));
	}
	
	public static String respuesta_dia_hace(String msj) {
		
		if(sinTildes(msj).toUpperCase().contains("ayer".toUpperCase()))
			return "" + Fecha.mostrarFecha(Fecha.diaHace(1));
		
		if(sinTildes(msj).toUpperCase().contains("mes".toUpperCase()))
			return "" + Fecha.mostrarFecha(Fecha.diaHace(buscarCantDMA(msj), 1));
		
		if(sinTildes(msj).toUpperCase().contains("año".toUpperCase()))
			return "" + Fecha.mostrarFecha(Fecha.diaHace(buscarCantDMA(msj), 2));
		
		return "" + Fecha.mostrarFecha(Fecha.diaHace(buscarCantDMA(msj)));
	}
	
	public static String respuesta_tiempo_desde(String msj) {
		return " entre el " + Fecha.mostrarFecha(buscarFecha(msj)) + " y el " + Fecha.mostrarFecha(new Date()) + " pasaron " + Fecha.tiempoDesde(buscarFecha(msj)) + " día/s";
	}
	
	public static String respuesta_tiempo_hasta(String msj) {
		return " falta/n " + Fecha.tiempoHasta(buscarFecha(msj)) + " día/s";
	}
	
	public static String respuesta_dia_hoy() {
		return REG_AMD[0] + " " + Fecha.diaActual();
	}
	
	public static String respuesta_dia_semana() {
		return REG_AMD[0] + " " + Fecha.diaDeLaSemana() ;
	}
	
	public static String respuesta_mes_actual() {
		return REG_AMD[4] + " " + Fecha.mesActual();
	}
	
	public static String respuesta_año_actual() {
		return REG_AMD[3] + " " + Fecha.añoActual();	
	}
	
	public static String respuesta_hora_actual() {
		return REG_AMD[2] + " " + Fecha.horaActual();
	}
	
	
	public static int getPosEncontrada() {
		return posEncontrada;
	}
	
	private static int buscarCantDMA(String msj) {
		String num = "";
		for(int i = 0; i < msj.length(); i++) {
			while(i < msj.length() && (msj.charAt(i) >= '0' && msj.charAt(i) <= '9')) {
				num += msj.charAt(i);
				i++;
			}
		}
		return Integer.valueOf(num);
	}
	
	@SuppressWarnings("deprecation")
	private static Date buscarFecha(String msj) {
		boolean bandAño = false;
		Date d = new Date();
		String dia = "";
		String año = "";
		for(int i = 0; i < msj.length(); i++) {
			if(!bandAño) {
				while(i < msj.length() && (msj.charAt(i) >= '0' && msj.charAt(i) <= '9')) {
					dia += msj.charAt(i);
					i++;
					bandAño = true;
				}	
			}
			else {
				while(i < msj.length() && (msj.charAt(i) >= '0' && msj.charAt(i) <= '9')) {
					año += msj.charAt(i);
					i++;
				}
			}
		}
		d.setDate(Integer.valueOf(dia));
		if(año != "")
			d.setYear(Integer.valueOf(año)-1900);
		for(int i = 0; i < REG_MES.length; i++) {
			if(sinTildes(msj).toUpperCase().contains(REG_MES[i].toUpperCase())) {
				d.setMonth(i);
			}
		}
		
		return d;
	}

}










