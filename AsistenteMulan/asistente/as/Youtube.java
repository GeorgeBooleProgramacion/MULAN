package as;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Youtube {
	
	private static String direccion = "https://www.youtube.com/results?search_query=";
	private static final String expresion = "(?i:youtube) (\\w.*)";
	private static final Pattern pattern = Pattern.compile(expresion);

	public static void acceder(String t) throws IOException {
		final Matcher matcher = pattern.matcher(t);
		if(matcher.find()) {
			String la = matcher.group(1).replace(" ", "+");
			direccion+=la;
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + direccion);
			direccion = "https://www.youtube.com/results?search_query=";
		}
	}
}
