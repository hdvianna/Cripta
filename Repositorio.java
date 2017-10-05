
import java.util.Map;
import java.util.List;
import java.util.Hashtable;
import java.util.Vector;
import java.io.Serializable;

public class Repositorio implements Serializable {
	
	private Map chaves;
        private Vector proprietarios;
	private Semente semente;
	private static final long serialVersionUID = 1;
	
	public Repositorio(Semente _semente) {								
		chaves = new Hashtable();
                proprietarios = new Vector();
		semente = _semente;
	}

	public void adicionaChave(ItemChave _itemChave) {		
            proprietarios.add(_itemChave.getProprietario());
            chaves.put(_itemChave.getProprietario(), _itemChave);	
	}
	
	public boolean proprietarioTemChave(String _proprietario) {
		return (chaves.get(_proprietario) != null);
	}
        
        public Map getChaves() {
            return chaves;
        }
        
        public List getProprietarios() {
            return proprietarios;
        }
	
	
}
