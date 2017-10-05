
import java.util.List;
import java.util.Vector;
import java.io.Serializable;

public class Semente implements Serializable {

	private long p;
	private long q;
	private long inv;
        private long euler;
	private long n;
	private List conjuntoEuler;
	private static final long serialVersionUID = 1;

	public Semente (long _p, long _q) {
            p = _p;
            q = _q;
            euler = (p-1)*(q-1);
            n = p*q;                
	}
        
        public long getP() {
            return p;
        }
        
        public long getQ() {
            return q;
        }
	
	public long getN() {
		return n;
	}
	
        public void setInv(long _inv) {
            inv = _inv;
        }
        
	public long getInv() {
		return inv;
	}
        
        public long getEuler() {
		return euler;
	}

	public List getConjuntoEuler() {
		return conjuntoEuler;
	}        
        
        //Forma o conjunto de euler apenas com n�meros primos        
	public void setConjuntoEuler(List _primos) {		            
            Long primo;
            long valor_primo=0;            
            int i=0;
            
            conjuntoEuler = new Vector();
            primo = (Long) _primos.get(i);
            valor_primo = primo.longValue();
            i++;

            while((i < _primos.size()) && (valor_primo <= n)) {            
                if( (valor_primo%p!=0) && (valor_primo%q!=0))
                    conjuntoEuler.add(new Long(valor_primo));
                primo = (Long) _primos.get(i);
                valor_primo = primo.longValue();
                i++;
            } 
            
	}

}
