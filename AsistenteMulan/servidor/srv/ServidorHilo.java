package srv;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import as.Asistente;
import cli.Cliente;

public class ServidorHilo extends Thread {

	private Socket cliente;
	private ArrayList<Socket> listaCli;
	private Asistente mulan;
	private static LinkedList<Cliente> clientesList = new LinkedList<Cliente>();

	public ServidorHilo(Socket cli, ArrayList<Socket> lc) {
		super();
		this.cliente = cli;
		this.listaCli = lc;
		//this.clientesList = new LinkedList<Cliente>();
	}

	public void run() {
		String msj;
		try {
			msj = new DataInputStream(cliente.getInputStream()).readUTF();
			while (!msj.toLowerCase().equals("/salir")) {
				System.out.println(msj);
				String msj2 = null;
				String usuario = "";
				if(msj.toLowerCase().contains("@mulan")) {
					Pattern pattern = Pattern.compile("(\\w*)(:?:)(.*|\\w*|\\s*)(@mulan)");
					Matcher matcher = pattern.matcher(msj.toLowerCase());
					if(matcher.find()) {
						usuario = matcher.group(1);
						mulan = new Asistente("mulan", usuario);
						msj2 = mulan.charlar(msj);
						//msj2 = mulan.charlar(matcher.group(2) + "@mulan");
						System.out.println(msj2);
					}
					
				}
				/*else {
					pattern = Pattern.compile("(\\w*)(?::)(.*|\\w*|\\s*)(?:--)(\\d)(?:--)");
					matcher = pattern.matcher(msj.toLowerCase());
					if(matcher.find()) {
						sala = matcher.group(3);
						System.out.println(sala);
						msj = msj.replace("--" + sala + "--", " ");
					}
				}*/
				else{
					String usuarioMencionado = null;
					if(msj.toLowerCase().contains("@")) {
						Pattern pattern = Pattern.compile("(?:@)(\\w)");
						Matcher matcher = pattern.matcher(msj.toLowerCase());
						if(matcher.find()) {
							usuarioMencionado = matcher.group(1);
							int j = 0;
							while(!clientesList.get(j).getUser().equals(usuarioMencionado))
								j++;
							if(clientesList.get(j).getUser().equals(usuarioMencionado) && clientesList.get(j).getConectado())
								new DataOutputStream(clientesList.get(j).getCliente().getOutputStream()).writeUTF(msj);
						}
					}
						
					
				}
				
				
				for (Socket i : listaCli) {
					new DataOutputStream(i.getOutputStream()).writeUTF(msj);
					if(msj2 != null)
						new DataOutputStream(i.getOutputStream()).writeUTF("Mulan: " + msj2);
				}
				
				

				msj = new DataInputStream(cliente.getInputStream()).readUTF();
			}
			System.out.println("El cliente se ha desconectado");
		} catch (Exception e) {
			System.out.println("El cliente se ha desconectado");
		}
	}
	
	
	
	public static void cargarCliente(Cliente nuevoCliente) {
		clientesList.add(nuevoCliente);
		System.out.println("Se conecto el usuario " + nuevoCliente.getUser());
	}
	

	public static LinkedList<Cliente> getClientesList(){
		return clientesList;
	}


}
