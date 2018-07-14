package as;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bd.User;
import srv.Servidor;


public class Deudas {
	
    private static int[][] regi = new int[50][50];
	
	public int[][] getReg() {
		return this.regi;
	}
	
	public void setReg(int i, int j, int v) {
		this.regi[i][j] += v;
		this.regi[j][i] -=v;
	}
	
	public static String retornarSaldo(String msj, String usr) throws FileNotFoundException {
		
		ArrayList<User> usuarios = new ArrayList<User>();
		ArrayList<String> nombres = new ArrayList<String>();
		String[] nom = { "admin", "JMM96", "usr1", "usr2", "usr3", "usr4", "juancitofornai" };

		usuarios = Servidor.todosLosUsuarios();
		for (int i = 0; i <  usuarios.size(); i++) {
			nombres.add(usuarios.get(i).getUser());
			//nombres.add(nom[i]);
		}

		

		 int[][] registro = new int[nombres.size()][nombres.size()];
		//registro = leerRegistros(nombres.size());

		if (msj.contains("me debe")) {
			final String regex = "(\\w*) (?:me debe)..(\\d+)";
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(msj);
			if (matcher.find()) {
				String usuarioDestino = matcher.group(1);

				if (nombres.contains(usuarioDestino)) {

					double valor = Double.parseDouble(matcher.group(2));
					registro[nombres.indexOf(usr)][nombres.indexOf(usuarioDestino)] += (int) valor;
					registro[nombres.indexOf(usuarioDestino)][nombres.indexOf(usr)] -= (int) valor;
				 
					actualizarDeudas(registro);
					return " anotado.";
				}
				else
					return " no existe el usuario @" + usuarioDestino;
			}
			else 
				return " Error en la peticion";
		}
		
		if(msj.contains("le debo")) {

			final String regex = "(?:le debo) .(.*).. (?:@)(\\w*)";
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(msj);
			if (matcher.find()) {
				String usuarioDestino = matcher.group(2);
				if(nombres.contains(usuarioDestino)) {
					double valor = Double.parseDouble(matcher.group(1));
					registro[nombres.indexOf(usr)][nombres.indexOf(usuarioDestino)] -= (int) valor;
					registro[nombres.indexOf(usuarioDestino)][nombres.indexOf(usr)] += (int) valor;
					actualizarDeudas(registro);
					return " anotado.";
				}
				else
					return " no existe el usuario @" + usuarioDestino;
			}
			else 
				return " Error en la peticion";
		}
		
		if(msj.contains("gastamos")) {
			final String regex = "(?:con) .(\\w*) (?:y) .(\\w*) (?:gastamos) .(\\d+) (?:y pagué|y pagó) (.*)";
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(msj);
			if (matcher.find()) {
				String usuarioDestino1 = matcher.group(1);
				String usuarioDestino2 = matcher.group(2);
				if(nombres.contains(usuarioDestino1) && nombres.contains(usuarioDestino2)) {
					double valor = Double.parseDouble(matcher.group(3));
					registro[nombres.indexOf(usr)][nombres.indexOf(usuarioDestino1)] += (int) valor/2;
					registro[nombres.indexOf(usuarioDestino1)][nombres.indexOf(usr)] -= (int) valor/2;
					registro[nombres.indexOf(usr)][nombres.indexOf(usuarioDestino2)] += (int) valor/2;
					registro[nombres.indexOf(usuarioDestino2)][nombres.indexOf(usr)] -= (int) valor/2;
					return " @" + usuarioDestino1 + " y @" + usuarioDestino2 + " te deben " + (int) valor/2 + " cada uno";
				}
			}
		}

		return " Error en la peticion";
	}

	public static int[][] leerRegistros(int cantUsuarios) throws FileNotFoundException {
		int[][] registro = new int[cantUsuarios][cantUsuarios];

		Scanner sc = new Scanner(new File("registroDeudas.txt"));

		for (int i = 0; i < registro.length; i++) {
			for (int j = 0; j < registro.length; j++) {
				registro[i][j] = sc.nextInt();
			}
		}
		sc.close();
		return registro;
	}

	public static void actualizarDeudas(int[][] reg) throws FileNotFoundException {
		PrintWriter salida = new PrintWriter(new File("registroDeudas.txt"));
		for (int i = 0; i < reg.length; i++) {
			for (int j = 0; j < reg.length; j++) {
				salida.printf("%-4d", reg[i][j]);
			}
			salida.println();
		}
		salida.close();
	}
}
