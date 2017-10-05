import java.util.List;
import java.lang.Math;

public class Numero {
		
	boolean ehPrimo(long _numero, ConjuntoPrimos _primos) {
		long raiz = Math.round(Math.sqrt((double) _numero));
		long i = _primos.posPrimoMaisProximo(raiz);
		List lprimos = _primos.getPrimos();
		
		while(i > -1 ) {			
			long primo = ((Long) lprimos.get((int) i)).longValue();
			if ((_numero%primo) == 0)
				return false;
			i--;
		}
		
		return true;		
	}	
	
}