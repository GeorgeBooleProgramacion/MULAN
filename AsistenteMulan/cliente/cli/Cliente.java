package cli;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

import as.Youtube;
import chat.Chat;

public class Cliente {

	private Socket cliente;
	private String user;
	private String pw;
	
	public Cliente(int puerto, String ip, String u, String p) {
		try {
			this.cliente = new Socket(ip, puerto);
			this.user = u;
			this.pw = p;
			new ClienteHilo(cliente).start();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void escribe(int numSala) throws IOException {
		String msj = Chat.capturarMensaje();
		DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
		if(!msj.toLowerCase().equals("/salir")) {	//ACA ADENTRO VA LO DE YOUTUBE PORQUE SINO ME LO ABRE PARA TODOS LOS DEL CHAT
			if(msj.toLowerCase().contains("/youtube"))
				Youtube.acceder(msj);
			dos.writeUTF(this.user + ": " + msj + "--" + numSala + "--");
			msj = Chat.capturarMensaje();
			return;
		}
		cliente.close();
	}
	
	public String getUser() {
		return this.user;
	}
	
	public String getPw() {
		return this.pw;
	}
}
