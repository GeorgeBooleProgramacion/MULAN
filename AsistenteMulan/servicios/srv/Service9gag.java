package srv;

import java.io.IOException;

public class Service9gag {

	//private String url;
	//private String savePath;
	
	
	public Service9gag(String savePath) throws IOException {
		
		//this.url = url;
		//this.savePath = savePath;
		
		String url = "";
		ImageExtractor ie = new ImageExtractor();
		url = ImageExtractor.extractImageUrl("https://9gag.com/random");
		//System.out.println(url);
		ImageExtractor.saveImage(url, savePath);
		
	}
	
	
}
