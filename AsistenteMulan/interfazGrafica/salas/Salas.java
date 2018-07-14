package salas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import bd.User;
import chat.Chat;
import cli.Cliente;
import srv.Servidor;
import srv.ServidorHilo;

import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Salas extends JFrame {

	private JPanel contentPane;
	private JLabel lblSalas;
	private static Cliente cli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salas frame = new Salas(cli);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Salas(Cliente cli) {
		setTitle("SALAS");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList listSalas = new JList();
		listSalas.setVisibleRowCount(5);
		listSalas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listSalas.setBackground(UIManager.getColor("Button.background"));
		listSalas.setForeground(Color.BLACK);
		listSalas.setFont(new Font("Calibri", Font.BOLD, 34));
		listSalas.setModel(new AbstractListModel() {
			String[] values = new String[] {"SALA G", "SALA 1", "SALA 2", "SALA 3", "SALA 4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listSalas.setBounds(98, 36, 108, 225);
		contentPane.add(listSalas);
		
		ArrayList<User> us = Servidor.todosLosUsuarios();
		String[] clis = new String[us.size()];
		for(int i = 0; i < clis.length; i++)
			clis[i] = us.get(i).getUser();
		JList listUsers = new JList();
		listUsers.setModel(new AbstractListModel() {
			//String[] values = new String[] {};
			String[] values = clis;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listUsers.setForeground(Color.BLACK);
		listUsers.setFont(new Font("Calibri", Font.PLAIN, 14));
		listUsers.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listUsers.setBackground(SystemColor.menu);
		listUsers.setBounds(259, 36, 103, 225);
		contentPane.add(listUsers);
		
		lblSalas = new JLabel("Salas");
		lblSalas.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblSalas.setBounds(98, 11, 83, 14);
		contentPane.add(lblSalas);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblUsuarios.setBounds(261, 11, 83, 14);
		contentPane.add(lblUsuarios);
		
		JButton btnEntrarSala = new JButton("Entrar a la Sala");
		btnEntrarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cli.setSala((String)listSalas.getSelectedValue());
				new Chat(cli);
				setVisible(false);
			}
		});
		btnEntrarSala.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnEntrarSala.setBounds(442, 54, 116, 33);
		contentPane.add(btnEntrarSala);
		
		JButton btnHablarConUser = new JButton("Hablar con el User");
		btnHablarConUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Chat(cli);
				setVisible(false);
			}
		});
		btnHablarConUser.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnHablarConUser.setBounds(442, 128, 116, 33);
		contentPane.add(btnHablarConUser);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<User> us = Servidor.todosLosUsuarios();
				String[] clis = new String[us.size()];
				for(int i = 0; i < clis.length; i++)
					clis[i] = us.get(i).getUser();
				
				listUsers.setModel(new AbstractListModel() {
					//String[] values = new String[] {};
					String[] values = clis;
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnRefresh.setBounds(332, 8, 66, 23);
		contentPane.add(btnRefresh);
		
		JButton btnEntrarASala = new JButton("Entrar Sala Privada");
		btnEntrarASala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CrearSalaPrivada(cli);
				setVisible(false);
			}
		});
		btnEntrarASala.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnEntrarASala.setBounds(442, 197, 116, 33);
		contentPane.add(btnEntrarASala);
		
		setVisible(true);
	}
	
}
