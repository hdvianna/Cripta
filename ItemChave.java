

import java.io.Serializable;

public class ItemChave implements Serializable {
	
	private long chavePrivada;
	private long chavePublica;
	private long n;
	private long inv;
	private String proprietario;
	private static final long serialVersionUID = 1;
	
	public ItemChave(long _chavePrivada, long _chavePublica, long _n, long _inv,String _proprietario) {
		chavePrivada = _chavePrivada;
		chavePublica = _chavePublica;
		n = _n;
		inv = _inv;
		proprietario = _proprietario;	
	}

	public long getChavePrivada() {
		return chavePrivada;
	}
	
	public long getChavePublica() {
		return chavePublica;
	}
	
	public long getN() {
		return n;
	}
	
	public long getInv() {
		return inv;
	}

	public String getProprietario() {
		return proprietario;
	}
	
}
