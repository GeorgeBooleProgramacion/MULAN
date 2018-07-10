package srv;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import srv.Servidor;
import java.awt.SystemColor;

public class ServidorFrame extends JFrame {
	
	private static boolean estaOnline = false;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServidorFrame frame = new ServidorFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServidorFrame() {
		setTitle("SERVIDOR");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 289, 145);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("El servidor está detenido.");
		label.setForeground(Color.RED);
		label.setBounds(69, 74, 145, 14);
		contentPane.add(label);
		
		JLabel lblCerrarParaDetener = new JLabel("Cerrar para detener el Servidor.");
		lblCerrarParaDetener.setForeground(Color.GRAY);
		lblCerrarParaDetener.setBounds(55, 91, 202, 14);
		contentPane.add(lblCerrarParaDetener);
		lblCerrarParaDetener.setVisible(false);
		
		JButton btnIniciar = new JButton("INICIAR ");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!estaOnline) {
					estaOnline = true;
					btnIniciar.setEnabled(false);
					label.setText("El servidor está online.");
					label.setForeground(Color.GREEN);
					lblCerrarParaDetener.setVisible(true);
					new Servidor(10000);
				}			
			}
		});
		btnIniciar.setIcon(new ImageIcon(ServidorFrame.class.getResource("/chrriis/dj/nativeswing/swtimpl/components/resource/nav_go.gif")));
		btnIniciar.setBackground(SystemColor.control);
		btnIniciar.setForeground(Color.BLACK);
		btnIniciar.setFont(new Font("Calibri Light", Font.BOLD, 14));
		btnIniciar.setBounds(85, 11, 115, 40);
		contentPane.add(btnIniciar);
		
		
	}
	
	public static boolean servidorEnLinea() {
		return estaOnline;
	}
	
}
