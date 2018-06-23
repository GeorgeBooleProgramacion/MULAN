package cli;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

import chat.Chat;

public class Cliente {

	private Socket cliente;
	private String user;
	
	public Cliente(int puerto, String ip, String u) {
		try {
			this.cliente = new Socket(ip, puerto);
			this.user = u;
			new ClienteHilo(cliente).start();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void escribe() throws IOException {
		String msj = Chat.capturarMensaje();
		DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
		if(!msj.toLowerCase().equals("/salir")) {
			dos.writeUTF(this.user + ": " + msj);
			msj = Chat.capturarMensaje();
			return;
		}
		cliente.close();
	}
	
	public String getUser() {
		return this.user;
	}
}
