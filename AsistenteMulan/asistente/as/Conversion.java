package as;

public class Conversion {
	private static final double ONZA = 0.03527;
	
	public static String convertirUnidad(String unidadSalida, double cantidad, String unidadEntrada) {
		int entero = (int) cantidad;
		int decimal = (int) (10*(cantidad - entero));
		
		if(unidadEntrada.toUpperCase().contains("GRAMO") && unidadSalida.toUpperCase().contains("KILO")) 
			return gramoAkilo(cantidad, decimal);
		
		if(unidadEntrada.toUpperCase().contains("KILO") && unidadSalida.toUpperCase().contains("GRAMO"))
			return kiloAgramo(cantidad, decimal);
		
		if(unidadEntrada.toUpperCase().contains("GRAMO") && unidadSalida.toUpperCase().contains("ONZA"))
			return gramoAonza(cantidad, decimal);
		
		if(unidadEntrada.toUpperCase().contains("KILOMETRO") && unidadSalida.toUpperCase().contains("METRO"))
			return kilometroAmetro(cantidad, decimal);
		
		if(unidadEntrada.toUpperCase().contains("MINUTO") && unidadSalida.toUpperCase().contains("SEGUNDO"))
			return minutoAsegundo(cantidad, decimal);
		
		return "";
	}
	
	private static String gramoAkilo(double cantidad, int decimal) {
		
		if((int)cantidad == 1000)
			return " " + (int)cantidad + " gramos equivalen a " + (int)(cantidad/1000) + " " + "kilo";
		if(cantidad > 1000 && cantidad % 1000 == 0)
			return " " + cantidad + " gramos equivalen a " + cantidad/1000 + " kilos";
		if(cantidad == 1)
			return " " + cantidad + " gramo equivale a " +  cantidad/1000 + " kilos";
		if(decimal > 0)
			return " " + cantidad + " gramos equivalen a " + cantidad/1000 + " kilos" ;
		return " " + (int)cantidad + " gramos equivalen a " +  cantidad/1000 + " kilos";
		
	}
	
	private static String kiloAgramo(double cantidad, int decimal) {
		
		if(cantidad == 1)
			return " " + (int)cantidad + " kilo equivale a " + (int)(cantidad*1000) + " gramos";
		if(cantidad == 0.001)
			return " " + cantidad + " kilos equivalen a " + (int)(cantidad*1000) + " gramo";
		if(decimal > 0)
			return " " + cantidad + " kilos equivalen a " + (int)(cantidad*1000) + " gramos";
		
		return " " + (int)cantidad + " kilos equivalen a " + (int)(cantidad*1000) + " gramos";
	}
	
	private static String gramoAonza(double cantidad, int decimal) {
		
		if (cantidad == 1) 
			return " " + (int)cantidad + " gramo equivale a " + cantidad*ONZA + " onzas";
		
		if(cantidad == 1000)
			return " " + (int)cantidad + " gramos equivalen a " +  cantidad*(ONZA) + " onzas";
		if(decimal > 0)
			return " " + cantidad + " gramos equivalen a " + cantidad*ONZA + " onzas";
		
		return " " + (int)cantidad + " gramos equivalen a " + cantidad*ONZA + " onzas";
	}
	
	private static String kilometroAmetro(double cantidad, int decimal) {
		
		if(cantidad == 1)
			return " " + (int)cantidad + " kilometro equivale a " + (int)(cantidad*1000) + " metros";
		if(cantidad == 0.001)
			return " " + cantidad + " kilometros equivalen a " + (int)(cantidad*1000) + " metro";
		if(decimal > 0)
			return " " + cantidad + " kilometros equivalen a " + (int)(cantidad*1000) + " metros";
		
		return " " + (int)cantidad + " kilometros equivalen a " + (int)(cantidad*1000) + " metros";
		
	}
	
	private static String minutoAsegundo(double cantidad, int decimal) {

		if(cantidad == 1)
			return " " + (int)cantidad + " minuto equivale a " + (int)(cantidad*60) + " segundos";
		if(cantidad == 0.0166667)
			return " " + cantidad + " minutos equivalen a " + (int)(cantidad*60) + " segundo";
		if(decimal > 0)
			return " " + cantidad + " minutos equivalen a " + (int)(cantidad*60) + " segundos";
				
		return " " + (int)cantidad + " minutos equivalen a " + (int)(cantidad*60) + " segundos";
		
	}

}

