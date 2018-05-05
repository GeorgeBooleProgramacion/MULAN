package as;

public class Asistente {

	private String name, user;
	private String msj;

	public Asistente(String n, String u) {
		this.name = n;
		this.user = u;
	}

	private static final int DESPEDIR = 0;
	private static final int SALUDAR = 1;
	private static final int AGRADECER = 2;
	private static final int DE_NADA = 3;
	private static final int RESPUESTA_ESTADO = 4;
	private static final int RESPUESTA_FECHA = 5;
	private static final double RSP_DIADENTRODE = 5.0;
	private static final double RSP_DIAHACE = 5.1;
	private static final double RSP_TIEMPODESDE = 5.2;
	private static final double RSP_TIEMPOHASTA = 5.3;
	private static final int NO_ENTENDER = -1;

	public String charlar(String msj) {
		if (msj.contains("@" + this.name)) {
			
			this.msj = msj;
			
			if (Lenguaje.conocido(msj) == SALUDAR)
				return responderConversacion(SALUDAR);
			
			if (Lenguaje.conocido(msj) == AGRADECER)
				return responderConversacion(AGRADECER);
			
			if (Lenguaje.conocido(msj) == DE_NADA)
				return responderConversacion(DE_NADA);
			
			if (Lenguaje.conocido(msj) == RESPUESTA_ESTADO)
				return responderConversacion(RESPUESTA_ESTADO);
			
			if (Lenguaje.conocido(msj) == DESPEDIR)
				return responderConversacion(DESPEDIR);
			
			if(Lenguaje.conocido(msj) == RESPUESTA_FECHA) {
				return responderConversacion(RESPUESTA_FECHA);
			}
			
			return responderConversacion(NO_ENTENDER);
		}
		
		return null;
	}

	private String responderConversacion(int rsp) {
		if (rsp == SALUDAR) {
			return Lenguaje.saludos() + ", @" + this.user;
		}
		
		if (rsp == DESPEDIR) {
			return Lenguaje.despedidas() + ", @" + this.user;
		}

		if (rsp == AGRADECER) {
			return Lenguaje.agradecimientos() + ", @" + this.user;
		}
		
		if (rsp == DE_NADA) {
			return Lenguaje.de_nada() + ", @" + this.user;
		}
		
		if (rsp == RESPUESTA_ESTADO) {
			return Lenguaje.respuestas_estado() + ", @" + this.user;
		}
		
		if(rsp == RESPUESTA_FECHA) {
			String ddd = String.valueOf(RSP_DIADENTRODE/*0*/), dh = String.valueOf(RSP_DIAHACE/*1*/), 
				   td = String.valueOf(RSP_TIEMPODESDE/*2*/), th = String.valueOf(RSP_TIEMPOHASTA/*3*/);
			
			if(Lenguaje.getPosEncontrada() == Integer.parseInt(ddd.substring(ddd.indexOf('.') + 1))/*0*/) {   //Con eso agarro la parte decimal de la macro
				return "@" + this.user + " será el " + Lenguaje.respuesta_dia_dentro_de(msj);
			}
			
			if(Lenguaje.getPosEncontrada() == Integer.parseInt(dh.substring(dh.indexOf('.') + 1))/*1*/) {
				return Lenguaje.respuesta_dia_hace(msj);
			}
			
			if(Lenguaje.getPosEncontrada() == Integer.parseInt(td.substring(td.indexOf('.') + 1))/*2*/) {
				return Lenguaje.respuesta_tiempo_desde(msj);
			}
			
			if(Lenguaje.getPosEncontrada() == Integer.parseInt(th.substring(th.indexOf('.') + 1))/*3*/) {
				return Lenguaje.respuesta_tiempo_hasta(msj);
			}
			
		}
		
		return Lenguaje.no_entendidos() + ", @" + this.user;
	}
	
}
