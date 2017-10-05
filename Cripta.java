/*
 * Cripta.java
 *
 * Created on 21 September 2006, 21:09
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author hdvianna
 */
public class Cripta {
    
    /** Creates a new instance of Cripta */
    public Cripta() {
    
    }
    
    public long encripta(long _chave_publica, long _n, long _msg) {
        return modpow(_msg, _chave_publica, _n);
    }
    
    public long decripta(long _chave_privada, long _n, long _msg) {
        return modpow(_msg, _chave_privada, _n);
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
    
}
