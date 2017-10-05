
import java.io.*;
import java.util.Iterator;

public class PersisteChaveiro {

	private BufferedReader leArq;
	private PrintWriter escreveArq;
	private String caminhoArquivo;
	
	public PersisteChaveiro(String _caminhoArquivo) {
		caminhoArquivo = _caminhoArquivo;		
		
	}
		
	public Chaveiro carrega() throws ClassNotFoundException {            
            try {
                FileInputStream fis = new FileInputStream(caminhoArquivo);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Chaveiro chaveiro = (Chaveiro) ois.readObject();
                ois.close();
                return chaveiro;
            } catch (IOException e) {
                System.err.println(e);
                return null;
            }
            
	}
		
	public void salva(Chaveiro _chaveiro) {
            try {
                FileOutputStream fos = new FileOutputStream(caminhoArquivo);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(_chaveiro);
                oos.close();

            } catch(IOException e) {
                System.err.println(e);
            }
        }
}
