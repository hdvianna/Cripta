
import java.io.*;
import java.util.Iterator;

public class ArquivoPrimo {

	private BufferedReader leArq;
	private PrintWriter escreveArq;
	private String caminhoArquivo;
	
	public ArquivoPrimo(String _caminhoArquivo) {
		caminhoArquivo = _caminhoArquivo;		
		
	}
		
	public ConjuntoPrimos carrega() {
		String linha;
		ConjuntoPrimos _conjuntoPrimos = new ConjuntoPrimos();		
		try {
			leArq = new BufferedReader(new FileReader(caminhoArquivo));				
			linha = leArq.readLine();			
			_conjuntoPrimos.setUltimoNumero(Long.parseLong(linha));
			while ((linha = leArq.readLine()) != null) {
				_conjuntoPrimos.adicionaNumero(Long.parseLong(linha));					
			}
			leArq.close();
      	} catch (IOException e) {
        	System.err.println(e);
      	}
      	return _conjuntoPrimos;
	}
		
	public void salva(ConjuntoPrimos _conjuntoPrimos) {
		try {
			escreveArq = new PrintWriter(new BufferedWriter(new FileWriter(caminhoArquivo)));
			escreveArq.println(_conjuntoPrimos.getUltimoNumero());		
			Iterator aiterator = _conjuntoPrimos.getPrimos().iterator();
			while (aiterator.hasNext()) {
				Long _valor = (Long) aiterator.next();
				escreveArq.println(_valor.longValue());
			}
			escreveArq.close();
		} catch(IOException e) {
			System.err.println(e);
      	}
	}
}
