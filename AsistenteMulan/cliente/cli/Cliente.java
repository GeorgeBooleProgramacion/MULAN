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
	
	//InputStreamReader leer = new InputStreamReader(System.in);
	//BufferedReader buffer = new BufferedReader(leer);
	
	public void escribe() throws IOException {
		//InputStreamReader leer = new InputStreamReader(System.in);
		//BufferedReader buffer = new BufferedReader(leer);
		String msj = Chat.capturarMensaje();//buffer.readLine();
		DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
		if(!msj.toLowerCase().equals("/salir")) {
			dos.writeUTF(this.user + ": " + msj);
			msj = Chat.capturarMensaje();//buffer.readLine();
			return;
		}
		cliente.close();
//		System.out.print(">: ");
//		msj = sc.nextLine();
		//sc.close();
		//return true;
	}
	
	/*public static void main(String[] args) {
		try {
			new Cliente(22, "192.168.0.12", "jmm96").escribe();
			//System.out.println("Anda a la cancha bobo");
		} catch(Exception e) {
			System.err.println("Se cerro la conexión\n");
		}
	}*/
	
	public String getUser() {
		return this.user;
	}
}
