package as;

public class MasChicoMasGrande {
	
	private static final int MAX = 100;
	private static final int MIN = 1;
	
	private static int minimo_pienso = MIN;
	private static int maximo_pienso = MAX;
	private static int minimo_adivino;
	private static int maximo_adivino;
	private static int valor_adivino;
	private static int valor_pienso = 0;
	private static int cont = 0;
	
	public static void setValorAdivino(int n) {
		valor_adivino = n;
	}
	
	public static int getValorAdivino() {
		return valor_adivino;
	}
	
	public static String yoAdivino(int min, int max) {
		minimo_adivino = min;
		maximo_adivino = max;
		valor_adivino = (int) (Math.random() * maximo_adivino + minimo_adivino);
		return "¡listo!";
	}

	public static String yoAdivino(int num) {
		cont++;
		if(num > valor_adivino) 
			return "más chico";
		if(num < valor_adivino) 
			return "más grande";			
	
		return "¡si! Adivinaste en " + cont + " pasos...";
		
	}
	
	public static String yoPienso() {
		return "¡sale y vale! Pensá un número del 1 al 100";
	}
	
	public static String yoPienso(int CG) {
		if(CG == 0) {
			valor_pienso = ((maximo_pienso - minimo_pienso) / 2) + minimo_pienso;
			return "¿es el " + valor_pienso + "?";
		}
		
		if(CG == 1) {
			minimo_pienso = valor_pienso;
			valor_pienso = ((maximo_pienso - minimo_pienso) / 2) + minimo_pienso;
			return "¿es el " + valor_pienso + "?";
		}
		if(CG == 2) {
			maximo_pienso = valor_pienso;
			valor_pienso = ((maximo_pienso - minimo_pienso) / 2) + minimo_pienso;
			return "¿es el " + valor_pienso + "?";
		}
		minimo_pienso = MIN;
		maximo_pienso = MAX;
		return "fue divertido :)";
	}

	/*public static void maChiMaGra(String msj) throws InterruptedException {
		
		if (msj.matches(".*\\d+.*")) { // si encuentra un numero
			adivinador(msj);
		} else {
			adivinado(msj);
		}
	}

	public static void adivinador(String msj) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		boolean acierto = false;
		int cant = 0;
		
		System.out.println(("Bueno, tenes que adivinar el numero que estoy pensando. "
				+ "Tenes intentos ilimitados asi que es imposible que pierdas.").toUpperCase());
		System.out.println(("vos podes campeon, maquina, titan, crack, fiera").toUpperCase());
		TimeUnit.SECONDS.sleep(3);
		String[] a = msj.split("[^-?0-9]+");
		int min = Integer.parseInt(a[1]);
		int max = Integer.parseInt(a[2]);
		int num = random.nextInt(max - min + 1) + min;
		System.out.println("Ya lo pensé, a ver si sos tan pillo y lo sacas");
		while (acierto == false) {
			System.out.println("Tirá un numero");
			String resp = sc.nextLine();
			Matcher match = Pattern.compile("\\d+").matcher(resp);
			match.find(); // con esto me da el numero que puse, sino el match.group() tira basura
			if (Integer.valueOf(match.group()) == num) {
				acierto = true;
			} else if (Integer.valueOf(match.group()) < num) {
				System.out.println("Que lastima eh. MAS GRANDEEEEEEEE");
			} else {
				System.out.println("Ufff, te cebaste. Mas chiquitititito");
			}
			cant++;
		}
		System.out.println("Estuvo muy copado eh. Lo sacaste al " + cant + " intento. ");
		if (cant < 5) {
			System.out.println("Eres el Rey de Reyes");
		} else {
			System.out.println("Ta dificilito man");
		}
	}
	
	
	
	public static void adivinado(String msj) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		boolean acierto = false;
		int cant = 0;
		
		System.out.println(("A mandarle caña tio, te voy a tirar un numero, si es si deci si, "
				+ "si es no deberas decir mas grande o mas chico, dependiendo sea el caso").toUpperCase());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Dime el menor numero");
		int min = sc.nextInt();
		System.out.println("Dime el mayor numero");
		int max = sc.nextInt();
		System.out.println("Piensalo bieen....");
		TimeUnit.SECONDS.sleep(2);
		System.out.println("Espero que estes listo");
		TimeUnit.SECONDS.sleep(2);
		while (acierto == false) {
			int num = random.nextInt(max - min + 1) + min;
			System.out.println("¿El numero es " + num + "?");
			if (cant == 0)
				sc.nextLine(); // Negrada, si no la primera vez se pasa por el orto el nextLine
			String resp = sc.nextLine();
			if (resp.toUpperCase().contains("GRANDE")) {
				min = num + 1;
			} else if (resp.toUpperCase().contains("CHICO")) {
				max = num - 1;
			} else if (resp.toUpperCase().contains("SI")) {
				acierto = true;
			}
			cant++;
		}
		System.out.println("Fue requete recontra divertido, lo saque al " + cant + " intento. ");
		if (cant < 5) {
			System.out.println("Dentro de todo bastante bien eh ;)");
		} else {
			System.out.println("Costo pero salio :)");
		}
	}*/
}
