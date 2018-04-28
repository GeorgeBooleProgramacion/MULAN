package t;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import en.BufferEntrada;
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
