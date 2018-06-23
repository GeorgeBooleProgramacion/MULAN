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
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class Meme extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static String path = null;
	private static String t = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Meme dialog = new Meme(path,t);
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
	public Meme(String path, String t) throws InterruptedException {
		setTitle(t);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Meme.class.getResource("/com/sun/java/swing/plaf/windows/icons/image-delayed.png")));
		setBounds(100, 100, 304, 205);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(path));
		//lblImage.setIcon(new ImageIcon("D:\\JuanM96\\UNLaM\\MULAN\\AsistenteMulan\\memes\\takeMyMoney.jpg"));
		lblImage.setBounds(0, 0, 300, 176);
		contentPanel.add(lblImage);
		
		this.setVisible(true);
		Thread.sleep(3000);
		this.dispose();
	}
}
