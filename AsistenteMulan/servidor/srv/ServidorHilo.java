package srv;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import as.Asistente;

public class ServidorHilo extends Thread {

	private Socket cliente;
	private ArrayList<Socket> listaCli;
	private int[][] matSalasChat;
	private Asistente mulan;

	public ServidorHilo(Socket cli, ArrayList<Socket> lc) {
		super();
		this.cliente = cli;
		this.listaCli = lc;
	}

	public void run() {
		String msj;
		try {
			msj = new DataInputStream(cliente.getInputStream()).readUTF();
			while (!msj.toLowerCase().equals("/salir")) {
				System.out.println(msj);

				Pattern pattern = Pattern.compile("(\\w*)(:?:)(.*|\\w*|\\s*)(@mulan)");
				Matcher matcher = pattern.matcher(msj.toLowerCase());
				String msj2 = " ";
				String usuario = "";
				if(matcher.find()) {		
					usuario = matcher.group(1);
					mulan = new Asistente("mulan", usuario);
					msj2 = mulan.charlar(msj);
					System.out.println(msj2);
					//new DataOutputStream(cliente.getOutputStream()).writeUTF(msj2);
					//new DataOutputStream(cliente.getOutputStream()).writeUTF(msj);
				}
				//if(msj.equals("--1--"))					//Sacar primera parte del mensaje con regex (para saber a donde mandarlo) y solo pasar la segunda como mensaje
					
				for (Socket i : listaCli) {
					new DataOutputStream(i.getOutputStream()).writeUTF(msj);
					new DataOutputStream(i.getOutputStream()).writeUTF(msj2);
				}

				msj = new DataInputStream(cliente.getInputStream()).readUTF();
			}
			System.out.println("El cliente se ha desconectado");
		} catch (Exception e) {
			System.out.println("El cliente se ha desconectado");
		}
	}

}
