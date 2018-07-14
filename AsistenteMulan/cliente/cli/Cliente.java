package cli;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

import as.Youtube;
import chat.Chat;
import msj.Mensaje;
import srv.ServidorHilo;

public class Cliente {

	private Socket cliente;
	private String user;
	private String pw;
	private String sala;
	private Boolean conectado;
	
	public Cliente(int puerto, String ip, String u, String p) {
		try {
			this.cliente = new Socket(ip, puerto);
			this.user = u;
			this.pw = p;
			this.sala = "General";
			this.conectado = true;
			new ClienteHilo(cliente).start();
			//ServidorHilo.cargarCliente(this);
			//new DataOutputStream(cliente.getOutputStream()).writeUTF(this.cliente + "--" + this.user + "--" + this.pw + "--" + this.sala);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void escribe() throws IOException {
		//Mensaje msj = Chat.capturarMensaje();
		String msj = Chat.capturarMensaje();
		DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
		if(!msj/*.getMsj()*/.toLowerCase().equals("/salir")) {	//ACA ADENTRO VA LO DE YOUTUBE PORQUE SINO ME LO ABRE PARA TODOS LOS DEL CHAT
			if(msj/*.getMsj()*/.toLowerCase().contains("/youtube"))
				Youtube.acceder(msj/*.getMsj()*/);
			dos.writeUTF(this.user + ": " + msj);
			//dos.writeUTF(msj.getUser() + ": " + msj.getMsj() + ";:" + msj.getSala() + ":;");
			msj = Chat.capturarMensaje();
			return;
		}
		cliente.close();
		conectado = false;
	}
	
	public Socket getCliente() {
		return cliente;
	}

	public String getUser() {
		return this.user;
	}
	
	public String getPw() {
		return this.pw;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public Boolean getConectado() {
		return conectado;
	}

	public void setConectado(Boolean conectado) {
		this.conectado = conectado;
	}

	
}
