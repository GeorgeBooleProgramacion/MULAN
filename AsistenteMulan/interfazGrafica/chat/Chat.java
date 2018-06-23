package chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import as.Youtube;
import cli.Cliente;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.DropMode;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.ScrollPane;
import java.awt.Font;

public class Chat extends JFrame {

	private JPanel contentPane;
	private static JTextField textFieldIn;
	private static JButton btnEnviar;
	private static Cliente cli;
	//private static String user = cli.getUser();
	private static JTextPane textPaneOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat(cli);
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
	public Chat(Cliente c) {
		cli = c;
		setResizable(false);
		setTitle("CHAT <ALPHA V.0.0.1>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 330);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*JTextPane textPaneOut = new JTextPane();
		textPaneOut.setEditable(false);
		textPaneOut.setBounds(10, 11, 387, 154);
		contentPane.add(textPaneOut);
		JScrollPane scrollPaneOut = new JScrollPane(textPaneOut);
		scrollPaneOut.setBounds(0, 97, 204, -97);
		contentPane.add(scrollPaneOut);*/
		
		textPaneOut = new JTextPane();
		textPaneOut.setEditable(false);
		JScrollPane scrollPaneOut = new JScrollPane(textPaneOut);
		scrollPaneOut.setBounds(10,11,474,189);
		contentPane.add(scrollPaneOut);
		
		
		textFieldIn = new JTextField();
		textFieldIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent k) {
				if(k.getKeyCode() == KeyEvent.VK_ENTER)
					btnEnviar.doClick();
					
			}
		});
		textFieldIn.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldIn.setBounds(10, 211, 474, 45);
		contentPane.add(textFieldIn);
		textFieldIn.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textFieldIn.getText().equals("")) {
					//textPaneOut.setText(textPaneOut.getText() + "\n" + textFieldIn.getText());
					try {
						c.escribe();
						textFieldIn.setText("");
					} catch (NullPointerException | IOException e) {
						e.printStackTrace();
						textPaneOut.setText(textPaneOut.getText() + "\n" + "<EL SERVIDOR NO SE ENCUENTRA ONLINE.>");
					}					
				}
			}
		});
		btnEnviar.setBounds(421, 267, 63, 23);
		contentPane.add(btnEnviar);
		
		setVisible(true);
		
	}
	
	public static void escribirEnChat(String msj) {
		textPaneOut.setText(textPaneOut.getText() + "\n" + msj);
	}
	
	public static String capturarMensaje() {
		String msj;
		if(!(msj = textFieldIn.getText()).equals(""))
			textFieldIn.setText("");
			return msj;
	}
	
	public static void bloquearChat() {
		textPaneOut.setEnabled(false);
		textFieldIn.setEnabled(false);
		btnEnviar.setEnabled(false);
	}
}