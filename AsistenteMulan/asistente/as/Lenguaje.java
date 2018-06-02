package as;

import java.util.Date;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Lenguaje {
	
	private static int posEncontrada;
	private static boolean enJuego = false;

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
	
	private static final String[] REG_PC = { "Hoy deberia llevar paraguas", "Llevo paraguas", "Es necesario el paraguas", "Paraguas" }; //Preguntas sobre el clima
	
	private static final String[] REG_RCT = { "Si deberias llevarlo", "Para no mojarte seria lo ideal" }; //Respuestas a preguntas del clima
	
	private static final String[] REG_RCF = { "No es necesario hoy", "No" }; //Respuestas a preguntas del clima
	
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
	/*

	private static final String[] REG_FEC = {"Qué día es hoy", "qué día es", "Que fecha es hoy","Que hora es","En que fecha estamos",
			 "En que mes estamos","En que año estamos", "Fecha", "qué día de la semana es hoy", "Hora"};//Preguntas sobre la fecha
	*/
	
	private static final String[] REG_CG = {"Jugamos", "Mas chico mas grande", "Jugamos al mas chico mas grande"};

	private static final String[] REG_AMD = {"hoy es","La fecha de hoy es","son las","El año actual es",
			 "Nos encontramos en el mes de"};//Respuestas sobre la fecha
	
	private static final String[] REG_CONVERSION = {"cuántos gramos son", "cuántos gramos hay en", "cuántos kilos son", "cuántos kilos hay en", "cuántas onzas son", "cuántas onzas hay en"};
	
	private static final String[] REG_CHK = { "Chuck Norris puede dividir por 0", "Chuck Norris es la razón por la que Wally se esconde",		//Respuestas chuk norris
			"Chuck Norris puede quemar una hormiga con una lupa… de noche", "Chuck Norris no cree en Dios, Dios cree en Chuk Norris",
			"Cuando Chuck Norris hace flexiones, no está levantando su cuerpo, está empujando el planeta hacia abajo",
			  "Chuck Norris ha contado hasta el número infinito… dos veces"};
	
	public static final String[] REG_LYR = {"1) Un robot no hará daño a un ser humano, ni permitirá con su inacción que sufra daño.",	//Leyes de la robotica
			"2) Un robot debe cumplir las órdenes dadas por los seres humanos, a excepción de aquellas que entrasen en conflicto con la primera ley.",
			"3) Un robot debe proteger su propia existencia en la medida en que esta protección no entre en conflicto con la primera o con la segunda ley."};
	
	static final Pattern EXP_CHK = Pattern.compile("(?i:chuck norris fact)");
	static final Pattern EXP_LYR = Pattern.compile("(?i:leyes de la robotica)");
	
	public static int conocido(String msj) {
		
		if(enJuego)
			return 20;
		
		if(EXP_CHK.matcher(msj).find())
			return 15;
		
		if(EXP_LYR.matcher(msj).find())
			return 10;
		
		for (int i = 0; i < REG_CHK.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_CHK[i]).toUpperCase())) {
				posEncontrada = i;
				return 15;
			}
		}
		
		for (int i = 0; i < REG_CONVERSION.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_CONVERSION[i]).toUpperCase())) {
				//posEncontrada = i;
				return 6; // Conversion de unidades
			}
		}
		
		for (int i = 0; i < REG_SLD.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_SLD[i]).toUpperCase())) {
				posEncontrada = i;
				return 1; // Saludar
			}
		}
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

		for (int i = 0; i < REG_PC.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_PC[i]).toUpperCase())) {
				return 9; //Clima
			}
		}

		for (int i = 0; i < REG_CG.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_CG[i]).toUpperCase())) {
				posEncontrada = i;
				return 20;
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

	public static String respuestas_chuk() {
		 return REG_CHK[(int) (Math.random() * (REG_CHK.length))];
	}
	
	public static String leyes_robotica() {
		return "Las leyes de la robotica son:\n" + REG_LYR[0] + "\n" + REG_LYR[1] + "\n" + REG_LYR[2];
	}
	
	public static String conversion(String msj) {
		
		final String expresion = "(?:cuantas|cuantos|cuántos|cuántas) (\\w*) (?:son|hay en) (\\d+|.*) (\\w*)";
		// 															  Grupo 1 				Grupo 2 Grupo 3
		
		final Pattern pattern = Pattern.compile(expresion); // compila la expresion regular y la guarda en pattern
		final Matcher matcher = pattern.matcher(msj); // realiza las operaciones de coincidencia de caracteres
														// intepretando la expresion regular cargada en pattern

		if (matcher.find()) {
			int numer = Integer.parseInt(matcher.group(2));
			return Conversion.convertirUnidad(matcher.group(1), numer, matcher.group(3));
		}
		
		return "";
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
	
	public static String masChicoMasGrande(String msj) {
		Integer min, max;
		Pattern exp_stop = Pattern.compile("(?i:basta|stop|para|no juego mas)");
		Matcher stopMtc = exp_stop.matcher(msj);
		if(stopMtc.find()) {
			enJuego = false;
			MasChicoMasGrande.resetGame();
			return "como gustes, dejaremos de jugar";
		}
		if(!enJuego) {
			Pattern exp_minMax = Pattern.compile("(?i:numero|valor) (?i:del|de) (\\d+) (?i:hasta|al) (\\d+)");
			Pattern exp_yoAdi = Pattern.compile("(?i:pensa|piensa)");
			Matcher minMax = exp_minMax.matcher(sinTildes(msj));
			Matcher adivinar = exp_yoAdi.matcher(sinTildes(msj));
			
			if(adivinar.find() && minMax.find()) {
				min = Integer.parseInt(minMax.group(1));	//Capturo de donde
				max = Integer.parseInt(minMax.group(2));	//hasta donde quiero adivinar
				enJuego = true;
				return MasChicoMasGrande.yoAdivino(min,max);
			}
			
			if(!adivinar.find()) {
				enJuego = true;
				return MasChicoMasGrande.yoPienso();
			}
		}
		else {
			Pattern exp_num = Pattern.compile("(?i:es el) (\\d+)");
			Pattern exp_mcmg = Pattern.compile("(?i:mas) (\\w+)|(?i:si)|(?i:listo)");
			Pattern exp_ready = Pattern.compile("(?i:listo)");
			Pattern exp_win = Pattern.compile("(?i:si)");
			Matcher numMtc = exp_num.matcher(sinTildes(msj));
			Matcher mcmgMtc = exp_mcmg.matcher(sinTildes(msj));
			Matcher readyMtc = exp_ready.matcher(sinTildes(msj));
			Matcher winMtc = exp_win.matcher(sinTildes(msj));
			
			if(numMtc.find()) {
				Integer num = Integer.parseInt(numMtc.group(1));
				String adiRes = MasChicoMasGrande.yoAdivino(num);
				if(adiRes.contains("Adivinaste"))
					enJuego = false;
				return adiRes;
			}
			
			if(mcmgMtc.find()) {
				String pieRes = ""; 
				
				if(readyMtc.find()) {
					pieRes = MasChicoMasGrande.yoPienso(0);
					return pieRes;
				}
				
				if(mcmgMtc.group(1) != null && mcmgMtc.group(1).equals("grande")) {
					pieRes = MasChicoMasGrande.yoPienso(1);
					return pieRes;
				}
				
				if(mcmgMtc.group(1) != null && mcmgMtc.group(1).equals("chico")) {
					pieRes = MasChicoMasGrande.yoPienso(2);
					return pieRes;
				}
				
				if(winMtc.find()) {
					enJuego = false;
					pieRes = MasChicoMasGrande.yoPienso(-1);
					return pieRes;
				}
			}	
		}
		
		return no_entendidos();
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

	public static String respuestas_clima(Boolean paraguas) {
		if(paraguas != null) {
			if(paraguas)
				return REG_RCT[(int) (Math.random() * (REG_RCT.length))];
			else
				return REG_RCF[(int) (Math.random() * (REG_RCF.length))];
		}
		else
			return "Ups... Ocurrio un error en el servidor";
	}


}










