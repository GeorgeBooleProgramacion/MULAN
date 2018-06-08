package srv;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
	
	private ArrayList<Socket> clientes;
	
	public Servidor(int puerto) {
		int i = 0;
		this.clientes = new ArrayList<Socket>();
		
		try {
			ServerSocket servidor = new ServerSocket(puerto);
			System.out.println("Skynet online...");
			while(i < 999) {
				Socket cliente = servidor.accept();
				clientes.add(cliente);
				new ServidorHilo(cliente, clientes).start();
				i++;
			}
			servidor.close();
			System.out.println("Skynet offline.");
		}catch(Exception e) {
			System.err.println("Skynet isn't ready for the human's annihilation");
		}
	}
	
	public static void main(String[] args) {
		new Servidor(27015);
	}
	
}
