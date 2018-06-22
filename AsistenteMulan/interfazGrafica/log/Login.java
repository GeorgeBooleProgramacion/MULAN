
package log;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.Usuario;
import chat.Chat;
import cli.Cliente;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private static JTextField textFieldUsuario;
	private static JPasswordField passwordField;
	static JButton btnRegistrate;
	private JButton btnIniciar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					// frame.setVisible(true);
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
				try {
					if (!Usuario.puedoRegistrarUser(textFieldUsuario.getText()))
						new PopupUserYaReg();
					else if (passwordField.getText().equals("")) {
						new PopupIngPw();
					} else {
						Usuario.registrarUser(textFieldUsuario.getText(), passwordField.getText());
						new PopupRegConEx();
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRegistrate.setEnabled(false);
		btnRegistrate.setBounds(345, 11, 89, 23);
		contentPane.add(btnRegistrate);

		textFieldUsuario = new JTextField();
		textFieldUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					if (textFieldUsuario.getText().equals("") || textFieldUsuario.getText().contains(" ")
							|| !Usuario.puedoRegistrarUser(textFieldUsuario.getText()))
						btnRegistrate.setEnabled(false);
					else
						btnRegistrate.setEnabled(true);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}

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
		lblContrasea.setBounds(184, 107, 73, 14);
		contentPane.add(lblContrasea);

		btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Usuario.buscarUser(textFieldUsuario.getText(), passwordField.getText())) {
						// new PopupEntro();
						try {
							new Chat(new Cliente(27015, "localhost", textFieldUsuario.getText()));
							setVisible(false);
						} catch (Exception e) {
							//System.err.println("Se cerro la conexión"); -> popup fin de conexion
						}
						
					}
					else
						new PopupError();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
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
		passwordField.setBounds(107, 132, 226, 20);
		contentPane.add(passwordField);

		setVisible(true);
	}

	public static void resetTextFields() {
		textFieldUsuario.setText("");
		passwordField.setText("");
		btnRegistrate.setEnabled(false);
	}
	
	public String quieroMiIp() throws Exception {
		 try {
			 	URL whatismyip = new URL("http://checkip.amazonaws.com");
			 	BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));     
			 	String ip = in.readLine();     
			 	//System.out.println("My Public ip is = "+ip);
			 	in.close();
			 	return ip;
			 	//System.out.println("----------------------------------------");
	         } catch (MalformedURLException ex) {
	        	throw new Exception("URL no compatible");
	        } catch (IOException ex) {
	        	throw new Exception("Falla en la entrada");
	        }
	    }
}
