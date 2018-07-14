/**
 * 
 */
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
	public static String retornarSaldo(String msj, String usr) throws FileNotFoundException  {
		
		
		ArrayList<User> usuarios = new ArrayList<User>();
		ArrayList<String> nombres = new ArrayList<String>();
		usuarios = Servidor.todosLosUsuarios();
		for (int i = 0; i < usuarios.size(); i++) {
			nombres.add(usuarios.get(i).getUser());
		}
		
		//int[][] registroAGrabar = new int[nombres.size()][nombres.size()];
		
		int[][] registro = new int[nombres.size()][nombres.size()];
		registro = leerRegistros(nombres.size());
		
		
		
		
		if (msj.contains("me debe")) {
			final String regex = "(\\w*) (?:me debe) (\\d+)";
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(msj);
			if (matcher.find()) {
				String usuarioDestino = matcher.group(1);
				if (nombres.contains(usuarioDestino)) {
					double valor = Double.parseDouble(matcher.group(2));
					registro[nombres.indexOf(usr)][nombres.indexOf(usuarioDestino)] += (int) valor;
					registro[nombres.indexOf(usuarioDestino)][nombres.indexOf(usr)] -= (int) valor;
					
//					for (int i = 0; i < registroAGrabar.length; i++) {
//						for (int j = 0; j < registroAGrabar.length; j++) {
//							registroAGrabar[i][j] = registro[i][j]; 
//						}
//					}
					
					actualizarDeudas(registro);
					return " " + usuarioDestino + " te debe " + (int) valor + " Pesos " + registro[nombres.indexOf(usr)][nombres.indexOf(usuarioDestino)];
				}
			}

		}
		
		return  "Error";
	}
	
	public static int[][] leerRegistros(int cantUsuarios) throws FileNotFoundException{
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
				salida.printf("%d",reg[i][j]);
			}
			salida.println();
		}
		salida.close();
	}
}
