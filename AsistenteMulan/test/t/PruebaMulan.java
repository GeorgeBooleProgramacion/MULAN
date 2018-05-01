package t;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import en.BufferEntrada;
import srv.ServicioClima;
import as.Clima;
import as.Mulan;

public class PruebaMulan {
	
	@Test
	public void testSaludo() {
		BufferEntrada b;
		do{
			b = new BufferEntrada();
		}while (Mulan.charlar(b.getEntrada()));
	}
	
	//Esto deberia funcionar???
	

}
