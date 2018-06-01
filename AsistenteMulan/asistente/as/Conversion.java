package as;

public class Conversion {
	private static final double ONZA = 0.03527;
	
	public static String convertirUnidad(String unidadSalida, int cantidad, String unidadEntrada) {
		
		if(unidadEntrada.toUpperCase().contains("GRAMO") && unidadSalida.toUpperCase().contains("KILO")) 
			return gramoAkilo(cantidad);
		
		if(unidadEntrada.toUpperCase().contains("KILO") && unidadSalida.toUpperCase().contains("GRAMO"))
			return kiloAgramo(cantidad);
		
		if(unidadEntrada.toUpperCase().contains("GRAMO") && unidadSalida.toUpperCase().contains("ONZA"))
			return gramoAonza(cantidad);
		
		
		return "";
	}
	
	private static String gramoAkilo(int cantidad) {
		
		if(cantidad == 1000)
			return " " + cantidad + " gramos equivalen a " + cantidad/1000 + " " + "kilo";
		if(cantidad > 1000 && cantidad % 1000 == 0)
			return " " + cantidad + " gramos equivalen a " + cantidad/1000 + " " + "kilos";
		if(cantidad == 1)
			return " " + cantidad + " gramo equivale a " + (double) cantidad/1000 + " " + "kilos";
		
		return " " + cantidad + " gramos equivalen a " + (double) cantidad/1000 + " " + "kilos";
		
	}
	
	private static String kiloAgramo(int cantidad) {
		if(cantidad == 1)
			return " " + cantidad + " kilo equivale a " + cantidad*1000 + " gramos";
		return "";
	}
	
	private static String gramoAonza(int cantidad) {
		
		return " " + cantidad + " gramos equivalen a " +  cantidad*(ONZA) + " onzas";
	}

}

