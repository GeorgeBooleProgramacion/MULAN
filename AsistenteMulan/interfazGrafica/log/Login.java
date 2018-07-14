
package log;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.User;
import chat.Chat;
import cli.Cliente;
import srv.Servidor;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textFieldUsuario;
	private static JPasswordField passwordField;
	static JButton btnRegistrate;
	private JButton btnIniciar;
	private static JTextField textFieldHost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setTitle("Login <ALPHA V.0.0.1>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnRegistrate = new JButton("Reg\u00EDstrate!");
		btnRegistrate.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRegistrate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User cli = new User(textFieldUsuario.getText(), passwordField.getText());
				if(!Servidor.puedoRegistrarUser(cli))
					new PopupUserYaReg();
				else if (passwordField.getText().equals("")) {
					new PopupIngPw();
				} else {
					Servidor.registrarUser(cli);
					new PopupRegConEx();
				}
			}
		});
		btnRegistrate.setBounds(345, 11, 89, 23);
		contentPane.add(btnRegistrate);

		textFieldUsuario = new JTextField();
		textFieldUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent k) {
				if (k.getKeyCode() == KeyEvent.VK_ENTER)
					btnIniciar.doClick();
			}
		});
		textFieldUsuario.setBounds(107, 60, 226, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(195, 35, 46, 14);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(184, 91, 73, 14);
		contentPane.add(lblContrasea);

		btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				User cli = new User(textFieldUsuario.getText(), passwordField.getText());

				if(Servidor.loguearUser(cli)) {
					try {
						if(textFieldHost.getText().equals("") || textFieldHost.getText().contains(" "))
							new Chat(new Cliente(10000, "localhost", cli.getUser(), cli.getPass()));
						else
							new Chat(new Cliente(10000, textFieldHost.getText(), cli.getUser(), cli.getPass()));
						setVisible(false);
					} catch (Exception e) {
					}
					
				}
				else
					new PopupError();
			}
		});
		btnIniciar.setBounds(172, 237, 89, 23);
		contentPane.add(btnIniciar);

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent k) {
				if (k.getKeyCode() == KeyEvent.VK_ENTER)
					btnIniciar.doClick();
			}
		});
		passwordField.setBounds(107, 116, 226, 20);
		contentPane.add(passwordField);
		
		JLabel lblHost = new JLabel("Host");
		lblHost.setBounds(201, 147, 29, 14);
		contentPane.add(lblHost);
		
		textFieldHost = new JTextField();
		textFieldHost.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent k) {
				if (k.getKeyCode() == KeyEvent.VK_ENTER)
					btnIniciar.doClick();
			}
		});
		textFieldHost.setBounds(107, 172, 226, 20);
		contentPane.add(textFieldHost);
		textFieldHost.setColumns(10);

		setVisible(true);
	}

	public static void resetTextFields() {
		textFieldUsuario.setText("");
		passwordField.setText("");
		textFieldHost.setText("");
		btnRegistrate.setEnabled(false);
	}
}
