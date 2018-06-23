package as;

public class Giphy {

	private Data[] data;
	
	public class Data{
		private Images images;
		
		public class Images{
			private Original original;
			
			public class Original{
				private String url;
				private String width;
				private String height;
				
				public String getUrl() {
					return this.url;
				}
				
				public String getWidth() {
					return this.width;
				}
				
				public String getHeight() {
					return this.height;
				}
			}
			
			public Original getOriginal() {
				return this.original;
			}
		}
		
		public Images getImages() {
			return this.images;
		}
		
	}
	
	public Data[] getData() {
		return this.data;
	}
}
