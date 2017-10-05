
import java.util.List;
import java.util.Vector;
import java.util.Iterator;
import java.io.Serializable;

public class ConjuntoPrimos implements Serializable {
		
	private long ultimoNumero;
	private List primos;
	private static final long serialVersionUID = 1;	

	public ConjuntoPrimos() {
		primos = new Vector();
		ultimoNumero = 0;
	}
	
	public void setPrimos(List _primos) {
		primos = _primos;
	}

	public List getPrimos() {
		return primos;
	}

	public void setUltimoNumero(long _ultimoNumero) {
		ultimoNumero = _ultimoNumero;
	}

	public long getUltimoNumero() {
		return ultimoNumero;
	}
	
	/*Retorna a posicao do primo mais proximo ao numero encon*/
	public long posPrimoMaisProximo(long _num) {
		Iterator iterator = primos.iterator();
		Long elem=null;		
		
		while (iterator.hasNext()) {					
			elem = (Long) iterator.next();			
			if (elem.longValue() >= _num)
				break;
		}
		return primos.indexOf((Object)elem);
	}

	public void adicionaNumero(long _numero) {
		primos.add(new Long(_numero));
		ultimoNumero = _numero;
	}

	public boolean estaNoConjunto(long _num) {
		Iterator iterator = primos.iterator();
		Long elem=null;		
		
		while (iterator.hasNext()) {					
			elem = (Long) iterator.next();			
			if (elem.longValue() ==  _num)
				return true;
		}

		return false;
		
	}
		
}
