/*
 * EncDeCriptaArquivo.java
 *
 * Created on 2 de Outubro de 2006, 19:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
/**
 *
 * @author igor
 */
public class EncDeCriptaArquivo {
    
    /** Creates a new instance of EncDeCriptaArquivo */
    private int num_bytes;
    private final int COMPL_BYTE = 128;
    private final int MY_BYTE_SIZE = 255;
    
    public EncDeCriptaArquivo(int _num_bytes) {
        num_bytes = _num_bytes;
    }
    
    public boolean criptaArquivo(String _in, String _out, ItemChave _chave) {
        boolean ret=false;
        try {
            
            DataOutputStream out = new DataOutputStream (new FileOutputStream (_out));
            DataInputStream in = new DataInputStream (new FileInputStream (_in));            
            
            byte buffer[] = new byte[num_bytes];
            Cripta cripta = new Cripta();
            
            while (in.read(buffer) != -1) {                   
                long l = (long)(buffer[0] + COMPL_BYTE);
                long e = cripta.encripta(_chave.getChavePublica(),_chave.getN(), l);
                long d = cripta.decripta(_chave.getChavePrivada(),_chave.getN(), e);
                out.writeLong(e);
            }
            out.close();
            in.close();
            return true;            
        } catch (Exception e) {
            
        }
        return false;
    }    
    
    public boolean deCriptaArquivo(String _in, String _out, ItemChave _chave) {
        boolean ret=false;
        try {
            
            DataOutputStream out = new DataOutputStream (new FileOutputStream (_out));
            DataInputStream in = new DataInputStream (new FileInputStream (_in));            
            
            byte buffer[] = new byte[num_bytes];
            Cripta cripta = new Cripta();
            long l =0;
            
            while (in.available() > 0) {                   
                l = in.readLong();
                long d = cripta.decripta(_chave.getChavePrivada(),_chave.getN(), l);
                long e = cripta.encripta(_chave.getChavePublica(),_chave.getN(), d);
                int bD = (int) (d - COMPL_BYTE);
                out.writeByte(bD);
            }
            out.close();
            in.close();
            return true;
        } catch (Exception e) {
            System.out.print(e);
        }
        return false;
    }  
    
    private long byteArrToLong(byte _arr[]) {
        long ret = 0;
        for (int i=0; i < num_bytes; i++) 
            ret = ret + ((_arr[i]+COMPL_BYTE) * ((long) Math.pow((double)MY_BYTE_SIZE,(double)i)));        
        return ret;
    }
    
    private byte[] longToByteArr(long _num) {
        byte arr[];        
        arr = new byte[num_bytes];        
        long resto=_num;
        for (int i=(num_bytes-1);i>-1; i--) {
            long lnum = (long)(resto/Math.pow((double)MY_BYTE_SIZE,(double)i));
            resto = (long)(resto%Math.pow((double)MY_BYTE_SIZE,(double)i));
            arr[i] = (byte) (lnum-COMPL_BYTE);
        }
        //ret = ret + ((_arr[i]+COMPL_BYTE) * ((long) Math.pow((double)MY_BYTE_SIZE,(double)i)));        
        return arr;
    }
    
    
}
