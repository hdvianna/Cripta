/*
 * EncDeCripta.java
 *
 * Created on 21 September 2006, 20:46
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author hdvianna
 */

import java.util.List;
import java.util.Iterator;

public class EncDeCripta {
    
    private static final int NUM_BYTES = 1;
    /** Creates a new instance of EncDeCripta */    
    public EncDeCripta() {

    }
    
    private static void encripta(String _to, 
                                    String _caminho_arquivo_entrada, 
                                    String _caminho_arquivo_saida) {
                        
        Chaveiro chaveiro;
        SalvaChaveiro salva = new SalvaChaveiro("chaveiro.txt");
        
        try {
            chaveiro = (Chaveiro) salva.carrega();                                    
            ItemChave chaveTo = (ItemChave) 
                chaveiro.getRepositorio().getChaves().get(_to);
            if (chaveTo != null) {                
                ItemChave chave = (ItemChave) chaveiro.getRepositorio().getChaves().get(_to);
                EncDeCriptaArquivo cripArq = new EncDeCriptaArquivo(NUM_BYTES);
                System.out.println("Encriptando arquivo ...");                                
                cripArq.criptaArquivo(_caminho_arquivo_entrada,
                                        _caminho_arquivo_saida,chave);                                    
                System.out.println("Arquivo encriptado.");
            } else
                System.out.println("Nao foi possivel encontrar a chave do destinatario " + _to);  
        } catch (Exception e) {
            System.out.println("Ocorreu um erro na execucao do programa. " + e);            
        }
        
    }
    
    private static void decripta(String _quem, String _caminho_arquivo_entrada, 
                                    String _caminho_arquivo_saida) {
        Chaveiro chaveiro;
        SalvaChaveiro salva = new SalvaChaveiro("chaveiro.txt");
        
        try {
            chaveiro = (Chaveiro) salva.carrega();                                    
            ItemChave chaveQuem = (ItemChave) 
            chaveiro.getRepositorio().getChaves().get(_quem);
            if (chaveQuem != null) {                
                ItemChave chave = (ItemChave) chaveiro.getRepositorio().getChaves().get(_quem);
                EncDeCriptaArquivo cripArq = new EncDeCriptaArquivo(NUM_BYTES);
                System.out.println("Decriptando arquivo ...");                                
                cripArq.deCriptaArquivo(_caminho_arquivo_entrada,
                                        _caminho_arquivo_saida,chave);                                    
                System.out.println("Arquivo decriptado.");
            } else
                System.out.println("Nao foi possivel encontrar a chave do destinatario " + _quem);  
        } catch (Exception e) {
            System.out.println("Ocorreu um erro na execucao do programa. " + e);
        }
    }
    
    private static void opcoes() {
        System.out.println("Opcoes: ");
        System.out.println("E - Encripta arquivo. Parametros: <para> <caminho_arquivo_entrada> <caminho_arquivo_saida>");
        System.out.println("D - Decripta arquivo. Parametros: <nome_proprietario> <caminho_arquivo_entrada> <caminho_arquivo_saida>");        
        System.out.println("L - Lista nomes dos proprietarios de chaves.");        
    }
    
    private static void lista() {
        Chaveiro chaveiro;
        SalvaChaveiro salva = new SalvaChaveiro("chaveiro.txt");
        
        try {
            chaveiro = (Chaveiro) salva.carrega();                                    
            List proprietarios = chaveiro.getRepositorio().getProprietarios();
            Iterator iterator = proprietarios.iterator();
            while(iterator.hasNext()) 
                System.out.println((String) (iterator.next()));
        } catch (Exception e) {
            System.out.println("Ocorreu um erro na execucao do programa. " + e);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        String opc="";
        if (args.length > 0) {
            opc = args[0].toLowerCase();        
            char copc = opc.charAt(0);
            switch(copc) {
                case 'e':
                    if (args.length!=4)
                        opcoes();
                    else
                        encripta(args[1], args[2], args[3]);
                    break;
                case 'd':
                    if (args.length!=4)
                        opcoes();
                    else
                        decripta(args[1], args[2], args[3]);
                    break;
                case 'l':
                    lista();
                    break;
                default:
                    opcoes();
                    break;
            }
                
        } else 
              opcoes();
        
    }        
    
}
