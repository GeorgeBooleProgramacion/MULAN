package as;

import javax.swing.JOptionPane;

public class Youtube {
	private static String direccion = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
	
	public static void acceder() {
	try
	                {
	                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + direccion);
	                }
	                catch(Exception err)
	                {
	                    JOptionPane.showMessageDialog(null,"Error: "+err);
	                }
	}
}
