package cli;

import java.io.DataInputStream;
import java.net.Socket;

import as.Youtube;
import chat.Chat;

public class ClienteHilo extends Thread {
	
	private Socket cliente;
	
	public ClienteHilo(Socket cliente) {
		this.cliente = cliente;
	}
	
	public void run() {
		String texto;
		try {
			while(true) {
				texto = new DataInputStream(cliente.getInputStream()).readUTF();
				if(texto.toLowerCase().contains("/youtube"))
					Youtube.acceder(texto);
				Chat.escribirEnChat(texto);//System.out.println(texto + "\n");
			}
		} catch(Exception e) {
			Chat.escribirEnChat("Te has desconectado del chat. Hasta luego!");
			Chat.bloquearChat();
		}
	}

}
