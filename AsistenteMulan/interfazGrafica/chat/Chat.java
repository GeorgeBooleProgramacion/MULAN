package chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import as.Youtube;
import cli.Cliente;
import srv.ImageExtractor;
import srv.Service9gag;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.ScrollPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class Chat extends JFrame {

	private JPanel contentPane;
	private static JTextField textFieldIn;
	private static JButton btnEnviar;
	private static Cliente cli;
	//private static String user = cli.getUser();
	private static JTextPane textPaneOut;
	private JLabel lblSalaN;
	//private int numSala = 0;
	//private String[] nombresSalas;
	//private ArrayList<String> listaSalas;

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
		
		textPaneOut = new JTextPane();
		textPaneOut.setText("Bienvenido al Chat!");
		textPaneOut.setFont(new Font("Calibri", Font.PLAIN, 12));
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
		
		lblSalaN = new JLabel("Sala: " + cli.getSala());
		lblSalaN.setBounds(20, 270, 375, 14);
		contentPane.add(lblSalaN);
		
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

	public static void ponerMeme(int m) throws IOException, InterruptedException {
		ImageIcon im = null;
		String path = "memes\\";
		String t = null;
		if(m == 0) {
			path += "trollFace.jpg";
			t = "Trolololololo lololo loloo";
		}
		if(m == 1) {
			path += "takeMyMoney.jpg";
			t = "Take my money!!!";
		}
		if(m == 2) {
			path += "itsATrap.jpg";
			t = "IT'S A TRAAAAP!!";
		}
		if(m == 3) {
			path += "foreverAlone.jpg";
			t = "Forever alone :'(";
		}
		if(m == 4) {
			path += "challengeAccepted.jpg";
			t = "Challange accepted =.=";
		}
		Meme me = new Meme(path,t);

	}
	
	public static void buscarGif(String t) throws IOException, InterruptedException {
		final String expresion = "(?i:gif) (\\w.*)";
		final Pattern pattern = Pattern.compile(expresion);
		final Matcher matcher = pattern.matcher(t);
		if(matcher.find()) {
			String q = matcher.group(1);
			new Gif(q);
		}
	}
	
	public static void ponerImg9gag() throws IOException, InterruptedException {
		ImageIcon im = null;
		String path = "imagenes\\img01.jpg";
		String url = null;
		String t = "9GAG Random Post!";
		
		Image9gag imgGag = new Image9gag(path,t);
	}
	
	public static void bloquearChat() {
		textPaneOut.setEnabled(false);
		textFieldIn.setEnabled(false);
		btnEnviar.setEnabled(false);
	}
}



