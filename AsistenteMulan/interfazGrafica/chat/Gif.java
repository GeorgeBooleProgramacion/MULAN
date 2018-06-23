package chat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import as.Giphy;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gif extends JDialog {
	
	 private static String api = "https://api.giphy.com/v1/gifs/search?";
	 private static String apiKey = "&api_key=dc6zaTOxFJmzC";
	 private static String query;
	 private static Gson g = new Gson();
	 private final String expresion = "(https:\\/\\/)(\\w+.)(giphy.com\\/media\\/)(\\w+\\/)(giphy.gif)";		
	 private final Pattern pattern = Pattern.compile(expresion);

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Gif dialog = new Gif(query);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public Gif(String query) throws IOException, InterruptedException {
		//JSON DE LA API DE GIPHY
		this.query = "&q=" + query;
		String urlFinal = "";
		String urlApi = api + apiKey + this.query;
		URL giphy = new URL(urlApi);
	 	BufferedReader in = new BufferedReader(new InputStreamReader(giphy.openStream()));     
	 	String json = in.readLine();   
	 	in.close();
	 	Giphy gif = g.fromJson(json, Giphy.class);
	 	
	 	int rand = (int) (Math.random()*gif.getData().length);
	 	int w = Integer.parseInt(gif.getData()[rand].getImages().getOriginal().getWidth());
	 	int h = Integer.parseInt(gif.getData()[rand].getImages().getOriginal().getHeight());
	 	setBounds(0, 0, w, h);
	 	
	 	String u = gif.getData()[rand].getImages().getOriginal().getUrl();
		final Matcher matcher = pattern.matcher(u);
		if(matcher.find()) {
			urlFinal += matcher.group(1) + "i." + matcher.group(3) + matcher.group(4) + "giphy.gif";
			//System.out.println(urlFinal);
			Icon image = new ImageIcon(new URL(urlFinal));
			JLabel label = new JLabel(image);
			label.setBounds(0, 0, w, h);
			getContentPane().add(label);
		}
		else {
			Icon image = new ImageIcon(new URL("https://i.giphy.com/media/TqiwHbFBaZ4ti/giphy.gif"));
			JLabel label = new JLabel(image);
			setBounds(100, 100, 400, 400);
			label.setBounds(0, 0, 400, 400);
			getContentPane().add(label);
		}
	 	/*System.out.println(u);
	 	URL img = new URL(u); //"https://i.giphy.com/media/JI5kawALxeLmM/200w.gif"
	 	//BufferedImage image = ImageIO.read(img);
	 	Icon image = new ImageIcon("https://media0.giphy.com/media/JI5kawALxeLmM/giphy.webp?cid=e1bb72ff5b2dcb34526e652e2e5ed40c");
	 	JLabel label = new JLabel(image);
	 	label.setBounds(0, 0, w, h);
	 	
	 	getContentPane().add(label);*/
	 	
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gif.class.getResource("/com/sun/java/swing/plaf/windows/icons/image-delayed.png")));
		setResizable(false);
		setTitle("Giphy");
		
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, w, h);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		
		setVisible(true);
	}

}
