/*
 * SalvaChaveiro.java
 *
 * Created on 18 September 2006, 21:15
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author hdvianna
 */

import java.io.*;
import java.util.Iterator;

public class SalvaChaveiro {
    
    
    private BufferedReader leArq;
    private PrintWriter escreveArq;
    private String caminhoArquivo;
    
    /** Creates a new instance of SalvaChaveiro */
    public SalvaChaveiro(String _caminhoArquivo) {
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
