package as;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Fecha {
	
	private static final int PREGUNTAXMES = 1;
	private static final int PREGUNTAXAÑO = 2;
	
	private static final Date HOY = new Date();
	private static final Calendar C1 = Calendar.getInstance();
	private static final String DI = Integer.toString(C1.get(Calendar.DATE));
	private static final String ME = Integer.toString(C1.get(Calendar.MONTH)+1);
	private static final String AN = Integer.toString(C1.get(Calendar.YEAR));
	private static final String DAYOFWEEK = C1.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("es","ES"));
	private static final String MONTH = C1.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("es","ES"));
	private static final Integer HOUR = (C1.get(Calendar.HOUR));
	private static final int HORANORMAL = C1.get(Calendar.HOUR_OF_DAY);
	private static final String MIN = Integer.toString(C1.get(Calendar.MINUTE));
	private static final String TIME = String.format("%s:%s",HOUR,MIN);
	private static final String TIMEMEDIODIA = String.format("%d:%s",HORANORMAL,MIN);
	
	private static final String[] DIAS_SEMANA = { "domingo", "lunes", "martes", "miércoles", "jueves",
			 							  "viernes", "sábado"};
	
	private static final String[] MESES_AÑO = { "enero" , "febrero" , "marzo" , "abril" , "mayo" , "junio" , 
			  							  "julio" , "agosto" , "septiembre" , "octubre" , 
			  							  "noviembre" , "diciembre"};
	
	@SuppressWarnings("deprecation")
	public static String diaDeHoy() {
		return "" + HOY.getDate() + "/" + (HOY.getMonth()+1) + "/" + (HOY.getYear()+1900); 
	}
	
	@SuppressWarnings("deprecation")
	public static Date diaHace(int cant) {
		Date dh = new Date();
		int diasM;
	    dh.setDate(dh.getDate() - cant);//fec.di-=nro;
	    while(dh.getDate()<1){
	        dh.setMonth(dh.getMonth()-1);//fec.me--;
	        diasM = cantDiaMes(dh.getMonth(),(dh.getYear()+1900));
	        dh.setDate(dh.getDate() + diasM);//fec.di+=cantD;
		    if(dh.getMonth() < 1)
	        {
	            dh.setMonth(12);//fec.me=12;
	            dh.setYear(dh.getYear()-1);//fec.an--;
		    }
		}
		return dh;	
	}
	
	public static Date diaHace(int cant, int ma) {
		if(ma == PREGUNTAXMES) {
			int meses = cant;
			cant = 0;
			for(int i = 0; i < meses; i++) {
				cant += cantDiaMes(HOY.getMonth()+i, HOY.getYear()+1900);
			}
		}
		if(ma == PREGUNTAXAÑO) {
			int años = cant;
			cant = 0;
			for(int i = 0; i < años; i++) {
				cant += 365 + esBisiesto(HOY.getYear()+1900+i);
			}
		}  
		return Fecha.diaHace(cant);
	}
	
	@SuppressWarnings("deprecation")
	public static Date diaDentroDe(int cant) {
		Date ddd = new Date();
		int diasM;
	    ddd.setDate((ddd.getDate())+cant);
	    while(ddd.getDate()>(diasM=cantDiaMes(ddd.getMonth(),(ddd.getYear()+1900)))){
	    	ddd.setMonth(ddd.getMonth()+1);
		    ddd.setDate(ddd.getDate() - diasM);
	        if(ddd.getMonth() > 12) {	
	        	ddd.setMonth(0); 
	        	ddd.setYear(ddd.getYear()+1); 
	        }
		}  
		return ddd;
	}
	
	@SuppressWarnings("deprecation")
	public static Date diaDentroDe(int cant, int ma) {
		if(ma == PREGUNTAXMES) {
			int meses = cant;
			cant = 0;
			for(int i = 0; i < meses; i++) {
				cant += cantDiaMes(HOY.getMonth()+i, HOY.getYear()+1900);
			}
		}
		if(ma == PREGUNTAXAÑO) {
			int años = cant;
			cant = 0;
			for(int i = 0; i < años; i++) {
				cant += 365 + esBisiesto(HOY.getYear()+1900+i);
			}
		}  
		return Fecha.diaDentroDe(cant);
	}
	
	@SuppressWarnings("deprecation")
	public static int tiempoHasta(Date d) {
		int acum= - aJuliano(HOY) + aJuliano(d), ciclo = HOY.getYear()+1900;

	    while(ciclo < (d.getYear()+1900))
	    {
	        acum += 365 + esBisiesto(ciclo);
	        ciclo++;
	    }
	    return acum;
	}
	
	@SuppressWarnings("deprecation")
	public static int tiempoDesde(Date d) {
		int acum = -aJuliano(d) + aJuliano(HOY), ciclo = d.getYear()+1900;
		
		while(ciclo < (HOY.getYear()+1900)) {
			acum += 365 + esBisiesto(ciclo);
			ciclo++;
		}
		return acum;
	}
	
	@SuppressWarnings("deprecation")
	private static int aJuliano(Date d)
	{
	    short[][] dias ={{0,31,59,90,120,151,181,212,243,273,304,334},
	                     {0,31,60,91,121,152,182,213,244,274,305,335}};
	    return d.getDate() + dias[esBisiesto(d.getYear()+1900)][d.getMonth()+1];
	}
	
	private static int esBisiesto(int a) {
		return ((a%4 == 0 && a%100!=0) || (a%400 == 0) ? 1:0);
	}
	
	private static int cantDiaMes(int m, int a)
	{
	    int[] d={31,28,31,30,31,30,31,31,30,31,30,31};
	    if(m == 2 && esBisiesto(a) == 1)
	        return 29;
	    else
	        return d[m];
	}
	
	public static String mostrarFecha(Date d) {
		return "" + DIAS_SEMANA[d.getDay()] + " " + d.getDate() + " de " + MESES_AÑO[d.getMonth()] + " de " + (d.getYear()+1900);
	}
	
	public static String diaDeLaSemana() {
		return DAYOFWEEK ;
	}
	
	public static String mesActual() {
		return MONTH;
	}
	
	public static String diaActual() {
		return DI + " de" + " " + MONTH + " de" + " " + AN;
	}
	
	public static String añoActual() {
		return AN;	
	}
	
	public static String horaActual() {
		if(HORANORMAL == 12) 
			return TIMEMEDIODIA + " PM";
//		La hora de las doce del mediodía se expresa mejor como 12:00 m. (con punto),
//		como indica el Diccionario panhispánico de dudas. 
//		La razón es que el mediodía marca la frontera entre la mañana y la tarde, 
//		y a la inversa en la medianoche, por lo que 12:00 p. m. (y 12:00 a. m.) 
//		podría interpretarse de ambos modos.
		if(HORANORMAL > 12)
			return TIME + " PM";
		else
			return TIME + " AM";
		
	 }	

}
