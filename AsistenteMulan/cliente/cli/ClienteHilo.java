package cli;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import as.Youtube;
import chat.Chat;
import chat.Image9gag;

public class ClienteHilo extends Thread {

	private Socket cliente;
	private static final Pattern PTR = Pattern.compile("(\\w.+)(?:;:)(\\w.+)(?::;)");
	
	public ClienteHilo(Socket cliente) {
		this.cliente = cliente;
	}

	public void run() {
		String texto;
		try {
			while (true) {
				texto = new DataInputStream(cliente.getInputStream()).readUTF();
				//Matcher msj = PTR.matcher(texto);
				if (esComando(texto/*msj.group(1)*/) >= 0)
					comandos(esComando(texto/*msj.group(1)*/), texto/*msj.group(1)*/);
				Chat.escribirEnChat(texto/*msj.group(1)*/);
			}
		} catch (Exception e) {
			Chat.escribirEnChat("Te has desconectado del chat. Hasta luego!");
			Chat.bloquearChat();
		}
	}

	private int esComando(String t) {
		if (t.toLowerCase().contains("/trollface"))
			return 0;
		if (t.toLowerCase().contains("/takemymoney"))
			return 1;
		if (t.toLowerCase().contains("/itsatrap"))
			return 2;
		if (t.toLowerCase().contains("/foreveralone"))
			return 3;
		if (t.toLowerCase().contains("/challangeaccepted"))
			return 4;
		if (t.toLowerCase().contains("/gif"))
			return 6;
		/*
		 * if(t.toLowerCase().contains("/youtube")) return 5;
		 */
		if (t.toLowerCase().contains("/9gag"))
			return 16;
		return -1;
	}

	private void comandos(int c, String t) throws IOException, InterruptedException {

		if (c == 0)
			Chat.ponerMeme(0);
		if (c == 1)
			Chat.ponerMeme(1);
		if (c == 2)
			Chat.ponerMeme(2);
		if (c == 3)
			Chat.ponerMeme(3);
		if (c == 4)
			Chat.ponerMeme(4);
		if (c == 6)
			Chat.buscarGif(t);
		/*
		 * if(c == 5) Youtube.acceder(t);
		 */
		if (c == 16) {
			Chat.ponerImg9gag();
			// Image9gag imgGag = new Image9gag("imagenes\\img01.jpg","9GAG Random Post!");
		}

	}

}
