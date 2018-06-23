package t;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

import org.junit.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import as.Giphy;

public class RF19Tests {
	
	String api;
	String apiKey;
	String query;
	Gson g;
	Properties p;
	
	@Before
	public void setUp() {
		 api = "https://api.giphy.com/v1/gifs/search?";
		 apiKey = "&api_key=dc6zaTOxFJmzC";
		 query = "&q=vegeta";
		 g = new Gson();
	}
	
	@Test
	public void pruebaApi() throws IOException {
		String url = api + apiKey + query;
		//Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
		//System.out.println(url);
		URL giphy = new URL(api + apiKey + query);
	 	BufferedReader in = new BufferedReader(new InputStreamReader(giphy.openStream()));     
	 	String json = in.readLine();   
	 	//System.out.println("RESULTADO" + "\n" + json);
	 	in.close();
	 	Giphy gif = g.fromJson(json, Giphy.class);
	 	
	 	//System.out.println(gif.getData()[0].getImages().getOriginal().getUrl());
	 	int rand = (int) (Math.random()*gif.getData().length);
	 	Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + gif.getData()[rand].getImages().getOriginal().getUrl());
	 	
	 	//p.getProperty("\"data\"");
		
	}
	

}
