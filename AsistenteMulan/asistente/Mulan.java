package as;

public class Mulan {
	
	private static final int DESPEDIR = 0;
	private static final int SALUDAR = 1;
	private static final int AGRADECER = 2;
	private static final int DE_NADA = 3;
	private static final int RESPUESTA_ESTADO = 4;
	private static final int NO_ENTENDER = -1;
	
	public static boolean charlar(String msj) {
		if(Lenguaje.conocido(msj) == SALUDAR)
			Mulan.responder(SALUDAR);
		if(Lenguaje.conocido(msj) == AGRADECER)
			Mulan.responder(AGRADECER);
		if(Lenguaje.conocido(msj) == DE_NADA)
			Mulan.responder(DE_NADA);
		if(Lenguaje.conocido(msj) == NO_ENTENDER)
			Mulan.responder(NO_ENTENDER);
		if(Lenguaje.conocido(msj) == RESPUESTA_ESTADO)
			Mulan.responder(RESPUESTA_ESTADO);
		if(Lenguaje.conocido(msj) == DESPEDIR) {
			Mulan.responder(DESPEDIR);
			return false;
		}
		return true;
	}
	
	private static void responder(int rsp) {
		if(rsp == SALUDAR) {
			System.out.println(Lenguaje.saludos());
		}
		if(rsp == DESPEDIR) {
			System.out.println(Lenguaje.despedidas());
		}
		if(rsp == NO_ENTENDER) {
			System.out.println(Lenguaje.no_entendidos());
		}
		if(rsp == AGRADECER) {
			System.out.println(Lenguaje.agradecimientos());
		}
		if(rsp == DE_NADA) {
			System.out.println(Lenguaje.de_nada());
		}
		if(rsp == RESPUESTA_ESTADO){
			System.out.println(Lenguaje.respuestas_estado());
		}
	}

	
}
