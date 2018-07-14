package as;

import java.io.FileNotFoundException;

import as.Asistente;
import as.Clima;
import srv.ServicioClima;


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
	private static final double RSP_FCHHOY = 5.4;
	private static final double RSP_HORACTUAL = 5.8;
	private static final double RSP_MESACTUAL = 5.11;
	private static final double RSP_A�OACTUAL = 5.12;
	private static final double RSP_DIASEMAN = 5.13;
	private static final int CLIMA = 9;
	private static final int MASCHICOMASGRANDE = 20;
	private static final int NO_ENTENDER = -1;
	private static final int CONVERSION = 6;
	private static final int RESPUESTA_CHUCK = 15;
	private static final int LEYES_ROBOTICA = 10;
	private static final int DEUDA = 21;

	public String charlar(String msj) throws FileNotFoundException {
		if (msj.contains("@" + this.name)) {
			
			this.msj = msj;
			
			if(Lenguaje.conocido(msj) == DEUDA)
				return responderConversacion(DEUDA);
			
			if(Lenguaje.conocido(msj) == CONVERSION)
				return responderConversacion(CONVERSION);
			
			if (Lenguaje.conocido(msj) == SALUDAR)
				return responderConversacion(SALUDAR);
			
			if (Lenguaje.conocido(msj) == AGRADECER)
				return responderConversacion(AGRADECER);
			
			if (Lenguaje.conocido(msj) == DE_NADA)
				return responderConversacion(DE_NADA);
			
			if (Lenguaje.conocido(msj) == RESPUESTA_ESTADO)
				return responderConversacion(RESPUESTA_ESTADO);

			if (Lenguaje.conocido(msj) == CLIMA)
				return responderConversacion(CLIMA);
			
			if (Lenguaje.conocido(msj) == DESPEDIR)
				return responderConversacion(DESPEDIR);
			
			if(Lenguaje.conocido(msj) == RESPUESTA_FECHA) {
				return responderConversacion(RESPUESTA_FECHA);
			}
			
			if(Lenguaje.conocido(msj) == MASCHICOMASGRANDE) {
				return responderConversacion(MASCHICOMASGRANDE);
			}
			
			if(Lenguaje.conocido(msj) == RESPUESTA_CHUCK) {
				return responderConversacion(RESPUESTA_CHUCK);
			}
			
			if (Lenguaje.conocido(msj) == LEYES_ROBOTICA)
				return responderConversacion(LEYES_ROBOTICA);
			
			return responderConversacion(NO_ENTENDER);
		}
		
		return null;
	}

	private String responderConversacion(int rsp) throws FileNotFoundException {
		int i;
		
		if(rsp == DEUDA) {
			return "@" + this.user + Lenguaje.deuda(msj, this.user);
		}
		
		if (rsp == CONVERSION) {
			return "@" + this.user + Lenguaje.conversion(msj);
		}
		
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
		
		if(rsp == MASCHICOMASGRANDE) {
			return "@" + this.user + " " + Lenguaje.masChicoMasGrande(this.msj);
		}
		
		if (rsp == RESPUESTA_CHUCK) {
			return Lenguaje.respuestas_chuk() + ", @" + this.user;
		}
		
		if(rsp == LEYES_ROBOTICA) {
			return "@" + this.user + ", " + Lenguaje.leyes_robotica();
		}

		
		if(rsp == RESPUESTA_FECHA) {
			String ddd = String.valueOf(RSP_DIADENTRODE/*0*/), dh = String.valueOf(RSP_DIAHACE/*1*/), 
				   td = String.valueOf(RSP_TIEMPODESDE/*2*/), th = String.valueOf(RSP_TIEMPOHASTA/*3*/),
				   diaHoy = String.valueOf(RSP_FCHHOY/*4*/), horact = String.valueOf(RSP_HORACTUAL/*8*/),
				   mesAct = String.valueOf(RSP_MESACTUAL/*11*/), a�oAct = String.valueOf(RSP_A�OACTUAL/*12*/), 
				   diaSem = String.valueOf(RSP_DIASEMAN/*13*/);
			
			if(Lenguaje.getPosEncontrada() == Integer.parseInt(ddd.substring(ddd.indexOf('.') + 1))/*0*/) {   //Con eso agarro la parte decimal de la macro
				return "@" + this.user + " ser� el " + Lenguaje.respuesta_dia_dentro_de(msj);
			}
			
			if(Lenguaje.getPosEncontrada() == Integer.parseInt(dh.substring(dh.indexOf('.') + 1))/*1*/) {
				return "@" + this.user + " fue " + Lenguaje.respuesta_dia_hace(msj);
			}
			
			if(Lenguaje.getPosEncontrada() == Integer.parseInt(td.substring(td.indexOf('.') + 1))/*2*/) {
				return "@" + this.user + Lenguaje.respuesta_tiempo_desde(msj);
			}
			
			if(Lenguaje.getPosEncontrada() == Integer.parseInt(th.substring(th.indexOf('.') + 1))/*3*/) {
				return "@" + this.user + Lenguaje.respuesta_tiempo_hasta(msj);
			}
			
			i = Integer.parseInt(diaHoy.substring(diaHoy.indexOf('.') + 1));
			while(i < Integer.parseInt(horact.substring(horact.indexOf('.') + 1))) {
				if(Lenguaje.getPosEncontrada() == i/*4,5,6,7*/) {
					return "@" + this.user + " " + Lenguaje.respuesta_dia_hoy();
				}
				i++;
			}
			
			i = Integer.parseInt(horact.substring(horact.indexOf('.') + 1));
			while(i < Integer.parseInt(mesAct.substring(mesAct.indexOf('.') + 1))) {
				if(Lenguaje.getPosEncontrada() == i/*8,9,10*/) {
					return "@" + this.user + " " + Lenguaje.respuesta_hora_actual();
				}
				i++;
			}
			if(Lenguaje.getPosEncontrada() == Integer.parseInt(mesAct.substring(mesAct.indexOf('.') + 1))/*11*/) {
				return "@" + this.user + " " + Lenguaje.respuesta_mes_actual();
			}
			
			if(Lenguaje.getPosEncontrada() == Integer.parseInt(a�oAct.substring(a�oAct.indexOf('.') + 1))/*12*/) {
				return "@" + this.user + " " + Lenguaje.respuesta_a�o_actual();
			}
			
			if(Lenguaje.getPosEncontrada() == Integer.parseInt(diaSem.substring(diaSem.indexOf('.') + 1))/*13*/) {
				return "@" + this.user + " " + Lenguaje.respuesta_dia_semana();
			}
			
		}

		if (rsp == CLIMA) {
			Clima clima = new Clima();
			ServicioClima srv = new ServicioClima();
			if(Lenguaje.preguntaClima(msj, srv)) {
				int paraguas = srv.llevarParaguas(srv.getCity(), srv.getCountry());
				return Lenguaje.respuestas_clima(paraguas) + ", @" + this.user;
			}
		}
		return Lenguaje.no_entendidos() + ", @" + this.user;
	}
	
}
