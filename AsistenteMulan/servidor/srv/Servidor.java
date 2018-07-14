package srv;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bd.User;
import cli.Cliente;

public class Servidor extends Thread {

	private ArrayList<Socket> clientes;
	private int puerto;
	private static Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	private static SessionFactory factory = cfg.buildSessionFactory();
	private static Session session = factory.openSession();

	public Servidor(int puerto) {
		this.clientes = new ArrayList<Socket>();
		this.puerto = puerto;
		this.start();
	}

	public void run() {
		int i = 0;
		ServerSocket servidor = null;
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Skynet online...");
			while (i < 999) {
				Socket cliente = servidor.accept();
				
				clientes.add(cliente);
				new ServidorHilo(cliente, clientes).start();
				i++;
			}
		} catch (Exception e) {
			System.err.println("Skynet isn't ready for the human's annihilation");
		} finally {
			try {
				servidor.close();
				System.out.println("Skynet offline.");
			} catch (IOException e) {
				e.printStackTrace();
			}
			;
			factory.close();
			session.close();

		}
	}

	public static boolean loguearUser(User cli) {
		Transaction tx = session.beginTransaction();
		try {
			tx.commit();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> rp = cq.from(User.class);
			cq.select(rp).where(cb.like(rp.get("user"), cli.getUser()));
			User ue = session.createQuery(cq).getSingleResult();
			if (ue.getPass().equals(cli.getPass()))
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean puedoRegistrarUser(User cli) {
		Transaction tx = session.beginTransaction();
		try {
			tx.commit();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> rp = cq.from(User.class);
			cq.select(rp).where(cb.like(rp.get("user"), cli.getUser()));
			User ue = session.createQuery(cq).getSingleResult();
			if (!ue.getUser().equals(cli.getUser()))
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}

	public static void registrarUser(User cli) {
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(new User(cli.getUser(), cli.getPass()));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	public static ArrayList<User> todosLosUsuarios() {
		Transaction tx = session.beginTransaction();
		ArrayList<User> list = new ArrayList<User>();
		try {
			tx.commit();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> rp = cq.from(User.class);
			list = (ArrayList<User>) session.createQuery(cq).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		new Servidor(10000);
	}

}
