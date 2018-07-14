package salas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chat.Chat;
import cli.Cliente;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearSalaPrivada extends JDialog {

	private static Cliente cli;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearSalaPrivada dialog = new CrearSalaPrivada(cli);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearSalaPrivada(Cliente cli) {
		setResizable(false);
		setBounds(100, 100, 450, 144);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 45, 424, 28);
		contentPanel.add(textPane);
		
		JLabel lblIngreseElNombre = new JLabel("Ingrese el nombre de su sala:");
		lblIngreseElNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIngreseElNombre.setBounds(10, 11, 202, 28);
		contentPanel.add(lblIngreseElNombre);
		
		JButton btnComenzar = new JButton("Comenzar!");
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cli.setSala(textPane.getText());
				new Chat(cli);
				setVisible(false);
			}
		});
		btnComenzar.setBounds(345, 81, 89, 23);
		contentPanel.add(btnComenzar);
		
		setVisible(true);
	}
}
