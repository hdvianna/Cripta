
import java.util.List;
import java.util.Iterator;
import java.io.Serializable;

public class Chaveiro implements Serializable {
	
	private Repositorio repositorio;
	private Semente semente;
	private int ultPrimoUsado;
	private static final long serialVersionUID = 1;
        
        public Chaveiro() {
            /*Apenas para carregar do arquivo*/            
        }
        
	public Chaveiro(long _p, long _q, List _primos) {
            semente = new Semente(_p, _q);
            repositorio  = new Repositorio(semente);           
            semente.setConjuntoEuler(_primos);
            ultPrimoUsado = semente.getConjuntoEuler().size();
	}

	public ItemChave criaChave(String _proprietario) {		
            
            long inverso;
            
            if (!repositorio.proprietarioTemChave(_proprietario)) {			
                long primoRelativo = getProxPrimo();
                if (primoRelativo > -1) {
                    
                    inverso = getInversoMultiplicativo(primoRelativo, semente.getEuler());                                                                
                    long chavePublica = primoRelativo;
                    long chavePrivada = inverso;
                    semente.setInv(inverso);
                    
                    ItemChave itemChave = new ItemChave(chavePrivada, chavePublica, semente.getN(), semente.getInv(), _proprietario);
                    repositorio.adicionaChave(itemChave);
                    
                    //apenas para testar
                    //long e = modpow(7, chavePublica, semente.getN());
                    //long d = modpow(e, chavePrivada, semente.getN());                    
                    
                    return itemChave;
                }                
            }
            return null;
	}
        
        public Repositorio getRepositorio() {
            return repositorio;
        }

	private long getProxPrimo() {
            if (ultPrimoUsado > 0) {
                ultPrimoUsado--;
                Long primo = (Long) semente.getConjuntoEuler().get(ultPrimoUsado);
                return (primo.longValue());
            } else
                return -1;
        }
        
	private long modpow(long b, long e, long m) {
		long result = 1;
		
		while (e > 0) {
			if ((e & 1) > 0) 
				result = (result * b) % m;
			e >>= 1;
			b = (b * b) % m;
		}
		
		return result;
	}
        
        private long getInversoMultiplicativo(long _primo, long mod) {                        
                                  
            long i;
            
            for (i=0; i<semente.getN();i++) {
                if((i%semente.getP()!=0) && (i%semente.getQ()!=0) && (((i*_primo)%mod)==1)) {
                    return i;
                }                    
            }
            
            return -1;                        
        }
        
}
