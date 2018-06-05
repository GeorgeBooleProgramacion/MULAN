package bd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Usuario {
	
	public static boolean buscarUser(String us, String pw) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("usuarios.txt"));
		do {
			String user = sc.nextLine();
			String pass = sc.nextLine();
			if(user.equals(us)) {
				if(pass.equals(pw))
					return true;
				else
					return false;
			}
		}while(sc.hasNext());
		sc.close();
		return false;
	}
	
	public static boolean puedoRegistrarUser(String us) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("usuarios.txt"));
		do {
			String user = sc.nextLine();
			sc.nextLine();
			if(user.equals(us))
				return false;
		}while(sc.hasNext());
		sc.close();
		return true;
	}
	
	public static void registrarUser(String us, String pw) throws IOException {
		PrintWriter p = new PrintWriter(new FileOutputStream(new File("usuarios.txt"), true /* append = true */));
		p.println(us);
		p.println(pw);
		p.close();
	}

}
