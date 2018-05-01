package as;

public class Asistente {

	private String name, user;

	public Asistente(String n, String u) {
		this.name = n;
		this.user = u;
	}

	private static final int DESPEDIR = 0;
	private static final int SALUDAR = 1;
	private static final int AGRADECER = 2;
	private static final int DE_NADA = 3;
	private static final int RESPUESTA_ESTADO = 4;
	private static final int NO_ENTENDER = -1;

	public String charlar(String msj) {
		if (msj.contains("@" + this.name)) {
			if (Lenguaje.conocido(msj) == SALUDAR)
				return responder(SALUDAR);
			if (Lenguaje.conocido(msj) == AGRADECER)
				return responder(AGRADECER);
			if (Lenguaje.conocido(msj) == DE_NADA)
				return responder(DE_NADA);
			if (Lenguaje.conocido(msj) == RESPUESTA_ESTADO)
				return responder(RESPUESTA_ESTADO);
			if (Lenguaje.conocido(msj) == DESPEDIR)
				return responder(DESPEDIR);
			return responder(NO_ENTENDER);
		}
		return null;
	}

	private String responder(int rsp) {
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
		return Lenguaje.no_entendidos() + ", @" + this.user;
	}

}
