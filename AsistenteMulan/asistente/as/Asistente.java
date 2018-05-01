package as;

public class Asistente {
	
	private static final String[] REG_SALUDO = {"¡Hola, ", "Buen dia", "Buenas Tardes", "Hola", 
												"hey ", "buen día ", " hola", ", buenas tardes"};
	private static final String[] REG_SALU2 = {"¡Hola, ", "buen día ", "hey "};
	private String nombre;
	
	public Asistente(String name) {
		this.nombre = name;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String escuchar(String saludo) {
		for(int i=0; i < REG_SALU2.length; i++) {
			if((REG_SALU2[i]+"@"+this.nombre).equals(saludo) )
				return "¡Hola, USUARIO"; 
		}
//		for(int i=0; i < REG_SALUDO.length; i++) {
//			if((REG_SALUDO[i].toUpperCase()+"@"+this.nombre).equals(saludo.toUpperCase()) )
//				return "Hola, "+"USUARIO"; 
//		}
//		for(int i=0; i < REG_SALUDO.length; i++) {
//			if(("@"+this.nombre+REG_SALUDO[i].toUpperCase()).equals(saludo.toUpperCase()) )
//				return "Hola, "+"USUARIO"; 
//		}
		return "No entiendo";
	}
	
	
	
}
