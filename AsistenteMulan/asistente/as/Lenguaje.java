package as;

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
	
	private static final String[] REG_PC = { "Hoy deberia llevar paraguas", "Llevo paraguas", "Es necesario el paraguas", "Paraguas" }; //Preguntas sobre el clima
	
	private static final String[] REG_RCT = { "Si deberias llevarlo", "Para no mojarte seria lo ideal" }; //Respuestas a preguntas del clima
	
	private static final String[] REG_RCF = { "No es necesario hoy", "No" }; //Respuestas a preguntas del clima
	
	private static final String[] REG_RSB = { "Si", "No", "Por supuesto", "Claro que no" }; // Respuestas booleanas

	public static int conocido(String msj) {
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
				return 4; // Si le digo de nada, no dice nada
			}
		}
		for (int i = 0; i < REG_PC.length; i++) {
			if (sinTildes(msj).toUpperCase().contains(sinTildes(REG_PC[i]).toUpperCase())) {
				return 9; //Clima
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
