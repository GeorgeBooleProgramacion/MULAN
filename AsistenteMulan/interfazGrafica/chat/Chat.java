package chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

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
import java.awt.ScrollPane;
import java.awt.Font;

public class Chat extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIn;
	private JButton btnEnviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat();
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
	public Chat() {
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
		
		JTextPane textPaneOut = new JTextPane();
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
					textPaneOut.setText(textPaneOut.getText() + "\n" + textFieldIn.getText());
					
					textFieldIn.setText("");					
				}
			}
		});
		btnEnviar.setBounds(421, 267, 63, 23);
		contentPane.add(btnEnviar);
		
		setVisible(true);
		
	}
}