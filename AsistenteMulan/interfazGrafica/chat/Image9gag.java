package chat;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import srv.Service9gag;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class Image9gag extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private static String path = null;
	private static String t = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Image9gag dialog = new Image9gag(path,t);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws InterruptedException 
	 */
	public Image9gag(String path, String t) throws InterruptedException {
		try {
			Service9gag srvGag = new Service9gag(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setTitle(t);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Image9gag.class.getResource("/com/sun/java/swing/plaf/windows/icons/image-delayed.png")));
		setBounds(100, 100, 304, 205);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		ImageIcon ii = new ImageIcon(path);
		lblImage.setIcon(ii);
		//lblImage.setIcon(new ImageIcon(path));
		//lblImage.setBounds(0, 0, 300, 176);
		lblImage.setBounds(0, 0, ii.getIconWidth(), ii.getIconHeight());
		contentPanel.add(lblImage);
		setBounds(100, 100, ii.getIconWidth()+5, ii.getIconHeight()+5);
		
		this.setVisible(true);
		Thread.sleep(20000);			//ESTABA EN 3000
		this.dispose();
	}

}
