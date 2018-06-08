package srv;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorHilo extends Thread {

	private Socket cliente;
	private ArrayList<Socket> listaCli;

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
				for (Socket i : listaCli)
					new DataOutputStream(i.getOutputStream()).writeUTF(msj);
				msj = new DataInputStream(cliente.getInputStream()).readUTF();
			}
			System.out.println("El cliente se ha desconectado");
		} catch (Exception e) {
			System.out.println("El cliente se ha desconectado");
		}
	}

}
