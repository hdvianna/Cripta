/*
 * FabricaChaves.java
 *
 * Created on 16 September 2006, 15:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author hdvianna
 */

import java.util.List;
        
public class FabricaChaves {
    
    /** Creates a new instance of FabricaChaves */
    public FabricaChaves() {
    }
    
    private static void opcoes() {
        System.out.println("Opcoes: ");
        System.out.println("R - Novo repositorio. Parametros: <p:primo> <q:primo>");
        System.out.println("C - Nova chave. Parametros: <nome:String>");
        System.out.println("V - Visualizar os 10 ultimos primos");
    }
    
    private static void visualiza() {
        ArquivoPrimo arquivoPrimo = new ArquivoPrimo("primos.txt");
        System.out.println("Carregando arquivo...");
        ConjuntoPrimos conjuntoPrimos = arquivoPrimo.carrega();
        System.out.println("Arquivo carregado.");

        System.out.println("Os dez ultimos primos serao listados ...");
        int i;
        List primos = conjuntoPrimos.getPrimos();
        for (i=1;i<11;i++ ) {
            Long primo = (Long) primos.get(primos.size()-i);
            System.out.println(primo.longValue());
        }
    }
    
    private static void repositorio(long p, long q) {        
        ArquivoPrimo arquivoPrimo = new ArquivoPrimo("primos.txt");
        System.out.println("Carregando arquivo...");
        ConjuntoPrimos conjuntoPrimos = arquivoPrimo.carrega();
        System.out.println("Arquivo carregado.");
        
        System.out.println("Criando chaveiro ...");
        Chaveiro chaveiro = new Chaveiro(p, q, conjuntoPrimos.getPrimos());
        
        SalvaChaveiro salva = new SalvaChaveiro("chaveiro.txt");
        System.out.println("Salvando chaveiro ...");
        salva.salva(chaveiro);
        System.out.println("Chaveiro salvo.");
    }
    
    private static void chave(String proprietario) {
                
        Chaveiro chaveiro;
        SalvaChaveiro salva = new SalvaChaveiro("chaveiro.txt");
        
        try {
            chaveiro = (Chaveiro) salva.carrega();            
            ItemChave chave = chaveiro.criaChave(proprietario);            
            if (chave != null) {
                System.out.println("A chave foi inserida no repositorio!");
                salva.salva(chaveiro);
            } else {
                System.out.println("Nao foi possivel inserir a chave no repositorio. Ja existe uma chave para este proprietario ou nao ha mais chaves disponiveis.");
            }
        } catch (Exception e) {
            
        }                        
        
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // TODO Auto-generated method stub
        String opc="";
        if (args.length > 0)
            opc = args[0].toLowerCase();
        
        if (opc.equals("v")) {
            visualiza();            
        } else if(opc.equals("r")) {
            if (args.length!=3)
                opcoes();
            else {
                long p = Long.parseLong(args[1]);                
                long q = Long.parseLong(args[2]);
                repositorio(p, q);
            }            
        } else if(opc.equals("c")) {
            if (args.length!=2)
                opcoes();
            else 
                chave(args[1]);            
        } else 
            opcoes();        
    }
    
}
